package day15.homework;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class HomeworkProgram implements Program{
	static Scanner scan=new Scanner(System.in);
	static List<Homework> wordList=new ArrayList<Homework>();
	
	// 실행부분
	@Override
	public void run() {
		int menu=0;
		System.out.println("-----------------");
		do {
			//메뉴출력
			printMenu();
			try {
				//단어,뜻,조회 선택
				menu=scan.nextInt();
				System.out.println("-----------------");
				//메뉴 기능
				runMenu(menu);
			}catch (InputMismatchException e) {
				System.out.println("입력오류");
				scan.nextLine();//입력오류방지
			}
		}while(menu!=4);
	}
	
	// 화면 출력
	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.단어(추가,수정,삭제)");
		System.out.println("2.뜻(추가,수정,삭제)");
		System.out.println("3.단어조회");
		System.out.println("4.종료");
		System.out.println("-----------------");
		System.out.print("메뉴선택:");
	}

	//메뉴실행
	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1: 
			//단어 
			wordMenu();
			System.out.println("-----------------");
			break;
		case 2: 
			//뜻
			defMenu();
			System.out.println("-----------------");
			break;
		case 3: 
			//조회
			selectMenu();
			System.out.println("-----------------");
			break;
		case 4: 
			//종료
			System.out.println("종료합니다");
			System.out.println("-----------------");
			break;
		default:
			throw new InputMismatchException();
		}	
	}
	
	//---------------------------------조회기능-------------------------------------//
	
	
	
	//조회 메뉴
	/** num을 0(flase)과 1(true)로 바꿔가며 num이 0이면 리스트의 뜻만 보여주고 1이라면 뜻과 품사 단어를 보여줌
	 * 
	 */
	private void selectMenu() {
		//단어 리스트가 0이면 단어가 없다고 출력
		if(wordList.size()==0) {
			System.out.println("조회할 단어가 없음");
			return;
		}
		//조회되는 단어를 보여줌
		boolean tf=true; //만약 num이 1아니여도 출력하기위한 장치 
		for(Homework tmp:wordList) {
			if(tmp.getNum()==1) {
				System.out.println("단어:"+tmp.getWord());
				tf=false;
			}
		}
		//태스트
		if(tf) {
			for(Homework tmp:wordList) {
				if(tmp.getNum()==0) {
					System.out.println("단어:"+tmp.getWord());
					break;
				}
			}
		}
		//조회할 단어 선택 
		System.out.println("-----------------");
		System.out.print("조회 할 단어:");
		//조회할 단어 입력
		String word=scan.next();
		System.out.println("-----------------");
		//단어 품사 뜻을 보여줌
		for(Homework tmp:wordList) {
			if(tmp.getNum()==1&&tmp.getWord().equals(word)) {
				System.out.println("단어:"+tmp.getWord()+" 품사:"+tmp.getWdclass());
				System.out.println("뜻:"+tmp.getDef());
			}
		}
		//뜻만 보여줌
		for(Homework tmp:wordList) {
			if(tmp.getNum()==0&&tmp.getWord().equals(word)) {
				if(tf) {
					System.out.println("단어:"+tmp.getWord()+" 품사:"+tmp.getWdclass());
					tf=false;
				}
				System.out.println("뜻:"+tmp.getDef());
			}
		}
	}

	//---------------------------------뜻 기능-------------------------------------//
	//뜻 기능 메뉴
	private void defMenu() {
		printDefMenu();
		int subMenu=scan.nextInt();
		runDefMenu(subMenu);
	}

	//뜻 메뉴 출력
	private void printDefMenu() {
		System.out.println("1.뜻 추가");
		System.out.println("2.뜻 수정");
		System.out.println("3.뜻 삭제");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}

	//뜻 메뉴 실행
	private void runDefMenu(int subMenu) {
		switch (subMenu) {
		case 1:
			//추가
			insertDef();
			break;
		case 2:
			//수정
			updateDef();
			break;
		case 3:
			//삭제
			deleteDef();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	//추가
	private void insertDef() {
		System.out.print("뜻을 추가할 단어:");
		String word=scan.next();
		for(Homework tmp:wordList) {
			if(tmp.getWord().equals(word)) {
				System.out.print("추가할 뜻:");
				String def=scan.next();
				//중복 시 메세지출력
				if(tmp.getDef().equals(def)) {
					System.out.println("같은 뜻이 있습니다");
					return;
				}
				wordList.add(new Homework(word, tmp.getWdclass(), def,0));
//				System.out.println(wordList); //테스트
				return;
			}
		}
		System.out.println("없는 단어입니다");	
	}

	//수정 /중복이됨
	private void updateDef() {
		//수정할 단어와 뜻을 입력받음
		System.out.print("뜻을 수정할 단어:");
		String word=scan.next();
		System.out.print("기존 뜻:");
		String def=scan.next();
		//일치하면 수정함
		for(Homework tmp:wordList) {
			if((tmp.getWord().equals(word))&&(tmp.getDef().equals(def))) {
				System.out.print("수정할 뜻:");
				def=scan.next();
				//수정하는 뜻이 존재하면 메세지 출력
				for(Homework stmp:wordList) {
					if(stmp.getDef().equals(def)) {
						System.out.println("수정하는 뜻과 같은 뜻이 있습니다");
						return;
					}
				}
				//같은 뜻이 없으면 수정
				tmp.setDef(def);
				return;
			}
		}
		//일치하는 뜻이 없으면 메세지 출력
		System.out.println("없는 단어");
	}

	//삭제 /한개만 삭제
	private void deleteDef() {
		System.out.print("삭제할 단어:");
		String word=scan.next();
		System.out.print("삭제할 뜻:");
		String def=scan.next();
		for(Homework tmp:wordList) {
			//단어와 뜻이 일치 하면 삭제
			if((tmp.getWord().equals(word))&&(tmp.getDef().equals(def))) {
				int index=wordList.indexOf(tmp); //인덱스를 가져옴
				wordList.remove(index);
				return;
			}
		}
		System.out.println("없는 단어");
	}

	
	//---------------------------------단어기능-------------------------------------//
	//단어 추가 삭제 수정기능 메뉴
	private void wordMenu() {
		printWordMenu();
		int subMenu=scan.nextInt();
		runWord(subMenu);
	}
	
	//단어 추가 삭제 수정기능 메뉴 출력
	private void printWordMenu() {
		System.out.println("1.단어 추가");
		System.out.println("2.단어 수정");
		System.out.println("3.단어 삭제");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}

	//단어 서브메뉴
	private void runWord(int subMenu) {
		switch (subMenu) {
		case 1:
			//추가
			insertWord();
			break;
		case 2:
			//수정
			updateWord();
			break;
		case 3:
			//삭제
			deleteWord();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	//단어 추가기능
	private void insertWord() {
		System.out.println("단어를 입력해주세요");
		String word=scan.next();
		//같은 단어가 있으면 메세지를 출력후 종료
		for(Homework tmp:wordList) {
			if(tmp.getWord().equals(word)) {
				System.out.println("같은 단어가 있습니다");
				return;
			}
		}
		System.out.println("품사를 입력해주세요");
		scan.nextLine();
		String wdclass=scan.nextLine();
		System.out.println("뜻를 입력해주세요");
		String def=scan.next();
		wordList.add(new Homework(word, wdclass, def, 1));
		//System.out.println(wordList); //테스트
	}

	//단어 수정기능
	private void updateWord() {
		System.out.print("기존 단어:");
		String word=scan.next();
		int index=-1;
		//인덱스번호를가져옴
		for(Homework tmp:wordList) {
			if(tmp.getWord().equals(word)) {
				index=wordList.indexOf(tmp);
			}
		}
		//인덱스 번호가 있으면 단어랑 품사를 수정
		if(index!=-1) {
			System.out.print("수정 단어:");
			word=scan.next();
			System.out.print("수정 품사:");
			scan.nextLine();
			String wdclass=scan.nextLine();
			wordList.get(index).setWord(word);
			wordList.get(index).setWdclass(wdclass);
			return;
		}
		System.out.println("수정할 단어가 없습니다");
	}
	
	//단어 삭제 /해당 단어의 다른 뜻도 삭제함
	private void deleteWord() {
		System.out.print("삭제할 단어:");
		String word=scan.next();
		//삭제 확인용
		boolean t=false;
		//해당 단어를 전부삭제 
		Iterator<Homework> it=wordList.iterator();
		while(it.hasNext()) {
			String n=(String)it.next().getWord();
			if(n.equals(word)) {
				it.remove();
				t=true;
			}
		}
		//삭제
		if(t) {
			System.out.println("단어,뜻을 삭제했습니다");
			return;
		}
		System.out.println("삭제할 단어가 없습니다");
	}
	
	
}
=======
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeworkProgram {
	static Scanner scan = new Scanner(System.in);	
	static Map<String, List<String>> map = new HashMap<String, List<String>>();
	static ArrayList<String> list = new ArrayList<String>();
	public void runMenu(int menu) {
		switch (menu) {
		case 1: {
			//단어 추가
			insertWord();
			
			break;
		}
		case 2: {
			//단어 수정
			System.out.print("수정할 단어를 입력해주세요 : ");
			scan.nextLine();
			String wrod = scan.nextLine();
			if(map.keySet().contains(wrod)) {
				map.put(wrod, map.remove(wrod));
				System.out.println("단어가 수정 되었습니다.");
				return;
			}
			System.out.println("등록된 단어가 없습니다.");
			
			break;
		}
		case 3: {
			// 단어 삭제
			System.out.print("삭제할 단어를 입력해주세요 : ");
			scan.nextLine();
			String wrod = scan.nextLine();
			if(map.keySet().contains(wrod)) {
				map.remove(wrod);
				System.out.println("단어가 삭제되었습니다.");
				return;
			}
			System.out.println("등록된 단어가 없습니다.");
			break;
		}
		case 4: {
			//뜻 추가
			System.out.println();
			break;
		}
		case 5: {
			//뜻 수정
			
			break;
		}
		case 6: {
			//뜻 삭제
			
			break;
		}
		case 7: {
			//단어 조회
			
			break;
		}
		case 8: {
			System.out.println("프로그램 종료");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	};
	private void insertWord() {
		scan.nextLine();
		System.out.print("단어를 입력해주세요 : ");
		String word = scan.nextLine();
		System.out.print("의미를 입력해주세요 : ");
		String meaning = scan.nextLine();
		list.add(meaning);
		if(!map.containsKey(word)) {
			map.put(word, list);
			System.out.println("단어가 추가되었습니다.");
			return;
		}
		System.out.println("이미 단어가 있습니다.");
	}
	public void printMenu() {
		System.out.println("-----메뉴선택-----");
		System.out.println("1. 단어추가");
		System.out.println("2. 단어수정");
		System.out.println("3. 단어삭제");
		System.out.println("4. 의미(뜻) 추가");
		System.out.println("5. 뜻 수정");
		System.out.println("6. 뜻 삭제");
		System.out.println("7. 단어조회");
		System.out.println("8. 종료");
		System.out.println("--------------");
		System.out.print("메뉴선택 : ");
	}
	
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("예외 발생");
			}
			
		} while (menu !=8);
	};
}
>>>>>>> e79d8a860772b264d83e73290b95a1f1492e428b
