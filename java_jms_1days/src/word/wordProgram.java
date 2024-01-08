package word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;
import word.service.PrintService;
import word.service.PrintServiceImp;

public class wordProgram implements Program {
	
	private final int EXIT = 5;
	private final int WORD_EXIT = 4;
	private final int MEAN_EXIT = 4;
	private final int PRINT_EXIT = 4;
	private final int GAME_EXIT = 4;
	private Scanner scan = new Scanner(System.in);
	private PrintService printService = new PrintServiceImp();
	private FileService fileService = new FlieServiceImp();
	
	private Vocabulary vocabulary = new Vocabulary(null);
	private List<word> wrongList = new ArrayList<word>(); //오답 리스트
	private String fileName;
	
	@Override
	public void run() {
		int menu = 0;
		//불러오기
		List<word> list = fileService.load("src/word/wordList.txt");
		vocabulary = new Vocabulary(list);
		do {
			
			try {
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				runMenu(menu);
				// 런
			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입니다.");
				//메뉴를 잘못 입력하면 입력 버퍼에 잘못된 메뉴가 남아 있어서 
				//비워줘야함 비워주지 않으면 무한 루프 발생
				scan.nextLine();
			}
			
		} while (menu != EXIT);
		
		//저장하기
		if(fileService.save(fileName, vocabulary.getList())) {
			System.out.println("저장이 완료 되었습니다.");
		}else {
			System.out.println("저장에 실패했습니다.");
		}
	}

	@Override
	public void printMenu() {
		
		printService.printMainMenu();
	}

	@Override
	public void runMenu(int Menu) {
		switch (Menu) {
		case 1: {
			// 단어 관리
			wordManage();
			break;
		}
		case 2: {
			// 뜻관리
			meanManage();
			break;
		}
		case 3: {
			//조회
			printManage();
			break;
		}
		case 4: {
			//게임
			gameManage();
			break;
		}
		case 5: {
			System.out.println("종료 되었습니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
		
	}

	private void gameManage() {
		int menu;
		do {
			//메뉴출력
			printService.printGameMenu();
			//메뉴선택
			menu = scan.nextInt();
			//메뉴실행
			runGameMenu(menu);
		} while (menu != GAME_EXIT);
	}

	private void runGameMenu(int menu) {
		
		switch (menu) {
		case 1: {
			play();
			break;
		}
		case 2: {
			printWrongList();
			break;
		}
		case 3: {
			initWrongList();
			break;
		}
		case 4: {
			System.out.println("종료 되었습니다.");
			break;
		}
		default:{
			throw new InputMismatchException();}}
	}

	private void initWrongList() {
		if(wrongList == null) {
			wrongList = new ArrayList<word>();
		}
		wrongList.clear();
	}

	private void printWrongList() {
		if(wrongList.size() == 0){
			System.out.println("오답이 없습니다.");
			return;
		}
		wrongList.stream().forEach(w->w.printWord());
	}

	private void play() {
		List<word> gameList = new ArrayList<word>(vocabulary.getList());
		int win = 0;
		int lose = 0;
		if(gameList.size() == 0) {
			System.out.println("등록된 단어가 없습니다.");
			return;
		}
		//랜덤으로 섞어 줌
		Collections.shuffle(gameList);
		
		//반복문 : 최대 리스트 크기만큼
		while (gameList.size() != 0) {
			//0번지에 있는 단어를 꺼냄
			word word = gameList.remove(0);
			//단어의 뜻 중에서 랜덤으로 하나 선택
			String mean = word.getRandomMean();
			
			//뜻이 등록되지 않은 경우
			if(mean == null) {
				continue;
			}
			//뜻 출력
			System.out.println("의미 : " + mean);
			
			// 정답을 입력
			System.out.print("단어 : ");
			scan.nextLine();
			String userMean = scan.nextLine();
			
			// 맞았는지 틀렸는지 확인 및 알림
		
			
			// 맞았으면 오답에서 제거
			if(word.getWord().equals(userMean)) {
				System.out.println("정답입니다.");
				win++;
				wrongList.remove(word);
			}
			// 틀렸으면 오답에 추가
			else {
				System.out.println("오답입니다.");
				lose++;
				wrongList.add(word);
			}
			//계속 할건지 말건지 출력
			System.out.println("더 하시겠습니다까? (y/n");
			String isContinue = scan.next();
			//이어 하기 여부를 입력
			
			//종료하면 반복문 종료
			if(isContinue.equals("n")) {
				break;
			}
			
			
		}

		//결과를 출력
		System.out.println(win + "승 " + lose + "패");
	}

	private void meanManage() {
		
		int menu;
		do {
			//뜻 관리 메뉴 출력
			printService.printMeanMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runMeanMenu(menu);
		} while (menu != MEAN_EXIT);
		
	}

	private void runMeanMenu(int menu) {
		
		switch (menu) {
		case 1: {
			addMean();
			
			break;
		}
		case 2: {
			setMean();
			break;
		}
		case 3: {
			removeMean();
			break;
		}
		case 4: {
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}

	private void printManage() {
		int menu;
		
		do {
			//조회 메뉴 출력
			printService.printPrintMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runPrintMenu(menu);
		} while (menu != PRINT_EXIT);
	}

	private void runPrintMenu(int menu) {
		
		switch (menu) {
		case 1: {
			printAll();
			break;
		}
		case 2: {
			printSearch();
			break;
		}
		case 3: {
			printAllByViews();
			break;
		}
		case 4: {
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}

	private void printAllByViews() {
		
		vocabulary.printByViews();
	}

	private void printSearch() {
		//검색할 단어 입력
		System.out.print("검색어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		//단어장에 검색어를 주면서 검색어를 포함하는 단어들을 출력하라고 요청
		vocabulary.print(word);
		//
	}

	private void printAll() {
		vocabulary.print();
	}

	private void removeMean() {
		//단어를 입력
		System.out.println("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		word selecWord = vocabulary.getWord(word);
		//없는 단어이면 알림
		if(selecWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		//단어가 있으면 단어와 뜻을 출력
		selecWord.printWord();
		
		//삭제할 의미의 번호를 입력
		System.out.println("삭제할 의미 번호 : ");
		int index = scan.nextInt();
		//해당 단어의 의미를 삭제 후 알림
		if(selecWord.removeMean(index)) {
			System.out.println("의미를 삭제했습니다.");
		}else {
			System.out.println("의미를 삭제하지 못했습니다.");
		}
		
	}

	private void setMean() {
		//단어 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		word selectedWord = vocabulary.getWord(word);
		
		//없는 단어이면
		if(selectedWord == vocabulary.getWord(word)) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		//입력할 단어의 뜻을 출력
		selectedWord.printWord();
		//수정할 뜻 선택
		int index = scan.nextInt()-1;
		
		//수정할 품사, 뜻을 입력
		System.out.print("수정할 품사 : ");
		String parString = scan.next();
		System.out.println("수정할 의미 : ");
		scan.nextLine();
		String mean = scan.nextLine();
		//뜻을 수정
		if(selectedWord.setMean(index, parString, mean)) {
			System.out.println("의미를 수정했습니다.");
		}else {
			System.out.println("의미를 수정하지 못했습니다.");
		}
		System.out.println(vocabulary);
		
		
	}

	private void addMean() {
		//뜻을 추가할 단어 입력 품사, 뜻 입력
		System.out.print("단어 : ");
		scan.nextLine();//엔터 처리
		String word = scan.nextLine();
		System.out.print("품사 : ");
		String partOfSpeech = scan.next();
		System.out.print("의미 : ");
		scan.nextLine();//엔터 처리
		String mean = scan.nextLine();
		
		//뜻 추가 
		if(vocabulary.addMean(word, partOfSpeech, mean)) {
			System.out.println("새 의미를 추가 했습니다.");
		}else {
			System.out.println("새 의미를 추가하지 못했습니다.");
		}
	}

	private void wordManage() {
		int menu;
		do {
			//단어 관리 메뉴 출력
			printService.printWordMenu();
			
			//메뉴 선택
			menu = scan.nextInt();
			
			//메뉴 실행
			runWordMenu(menu);
		} while (menu != WORD_EXIT);
	}

	private void runWordMenu(int menu) {
		
		switch (menu) {
		case 1: {
			addWord();
			break;
		}
		case 2: {
			setWord();
			break;
		}
		case 3: {
			removeWord();
			break;
		}
		case 4: {
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}

	private void removeWord() {
		//삭제할 단어 입력
		System.out.print("삭제할 단어 : ");
		scan.nextLine();//입력버퍼 엔터 처리
		String word = scan.nextLine();
		//단어 삭제
		if(vocabulary.removeWord(word)) {
			System.out.println("단어를 삭제했습니다.");
		}else {
			System.out.println("없는 단어입니다.");
		}
		
	}

	private void setWord() {
		// 수정할 단어와 새 단어를 입력
		System.out.print("수정할 단어 : ");
		scan.nextLine();//이전에 입력한 엔터 처리
		String oldWord = scan.nextLine();
		System.out.print("새 단어 : ");
		String newWord = scan.nextLine();
		
		
		//단어를 수정
		if(vocabulary.setWord(oldWord, newWord)) {
			System.out.println("단어를 수정했습니다.");
		}else {
			//없는 단어를 수정 하려고했거나 이미 등록괸 단어로 수정하려고 할때
			System.out.println("단어를 수정하지 못하였습니다.");
		}
		
		
	}

	private void addWord() {
		// 단어, 품사, 뜻을 입력
		System.out.print("단어 : ");
		scan.nextLine();//이전에 입력한 엔터 처리
		String word = scan.nextLine();
		
		//뜻들을 저장할 리스트
		List<Mean> meanList = new ArrayList<Mean>();
		char isContinue = 'n';
		do {
			// 단어장에 추가
			System.out.print("품사 : ");
			String partOftring = scan.next();
			System.out.print("의미 : ");
			scan.nextLine();//이전에 입력한 엔터 처리
			String mean = scan.nextLine();
			
			meanList.add(new Mean(partOftring, mean));
			System.out.println("의미를 더 추가 하시겠습니까?(y/n) : ");
			isContinue = scan.next().charAt(0);
		} while (isContinue == 'y');
		
		
		//단어장이 비어 있으면
		if(vocabulary == null){
			System.out.println("단어장이 없습니다.");
			return;
		}
	
		//단어장에 추가
		if(vocabulary.addWord(word, meanList)) {
			System.out.println("단어를 추가 했습니다.");
		}else {
			System.out.println("뜻과 단어가 이미 등록 된 상태입니다.");
		}
		System.out.println();
	}

}










