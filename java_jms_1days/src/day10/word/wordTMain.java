package day10.word;

import java.util.Scanner;

public class wordTMain {
	/* 영어 단어장 프로그램을 만드세요
	 * 1. 기능 정리
	 * - 단어는 영어 단어와 한글 뜻으로 구성
	 * - 영어 단어는 영어이고, 공백이 없는 단어
	 * - 한글 뜻은 한글이고, 한 문장으로 되어 있다.
	 * - 한 단어에 뜻이 한개만 있다고 가정
	 * - 기능
	 * 	 - 단어 등록
	 *   - 단어 검색
	 *   - 단어 수정
	 *   - 단어 삭제
	 * - Word클래스
	 * 	 - word : 영단어
	 * 	 - meaning : 뜻
	 *   - 단어 출력, 단어 수정, 단어 확인 : 주어진 문자열과 같은 단어인지 확인
	 * 2. 를 작성
	 * 
	 * 3. 필요한 메서드
	 * */
	private static Scanner scan = new Scanner(System.in);
	
	private static WordT[] List = new WordT[10]; //단어장
	private static int count = 0;//저장된 단어의 개수
	private static int index = -1;
	public static void main(String[] args) {
		
		int menu;
		//반복문
		do {
			//메뉴출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 맞는 기능 실행
			runMenu(menu);
		} while (menu != 5);
			
		
	}
	
	
	
	private static void runMenu(int menu) {
		switch (menu) {
		case 1: {
			//단어등록
			insertWord();
			break;
		}
		case 2: {
			//단어검색
			serchString();
			break;
		}
		case 3: {
			//단어수정
			update();
			break;
		}
		case 4: {
			//단어 삭제
			System.out.println("단어 삭제");
			System.out.print("삭제할 단어를 입력해주세요 : ");
			String delWord = scan.next();
			
			//삭제할 단어의 번지 찾기
			for(int i = 0; i < count; i++) {
				if(List[i].equals(delWord)) {
					index = i;
				}
			}
			//단어장의 개수를 줄임
			count--;
			WordT [] tmpList = new WordT[List.length];
			System.arraycopy(List, 0, tmpList, 0, List.length);
			//
			System.arraycopy(tmpList, index+1, List, index, count -index);
			break;
		}
		case 5: {
			System.out.println("프로그램 종료");
			break;
		}
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}	
	}


	private static void update() {
		System.out.println("단어 수정");
		System.out.print("수정할 단어를 입력해주세요 : ");
		String word = scan.next();
		for(int i = 0; i < count; i++) {
			if(List[i].equals(word)) {
				System.out.print("수정할 의미를 입력해주세요 : ");
				String meaning = scan.next();
				List[i].update(meaning);
				System.out.println("영단어가 수정되었습니다.");
				return;
			}
			else {
				System.out.println("저장된단어가 없습니다.");
				break;
			}
		}
	}

	private static void serchString() {
		System.out.println("단어 검색");
		//검색 단어 입력
		System.out.print("검색할 단어를 입력해주세요 : ");
		String word = scan.next();
		//단어장에서 검색해서 결과를 출력
		for(int i = 0; i < count; i++) {
			if(List[i].equals(word)) {
				List[i].print();
				return;
			}
		}
		System.out.println("저장된 단어가 없습니다.");
	}

	private static void insertWord() {
		//단어와뜻 입력
		System.out.println("-----단어 등록------");
		System.out.print("등록할 단어를 입력해 주세요 : ");
		String word = scan.next();
		System.out.print("등록할 의미를 입력해 주세요 : ");
		scan.nextLine();//엔터 처리
		String meaning = scan.nextLine();
		//단어와 뜻을 이용하여 word의 인스턴스를 생성
		WordT wordL = new WordT(word, meaning);
		//위에서 생성한 인스턴스를 단어장에 저장
		List[count] = wordL;
		//저장된 단어의 개수를 1증가
		count++;
		
		//테스트용 단어장목록출력
//		for(int i = 0; i < count; i++) {
//			List[i].print();
//		}
		
		//배열이 꽉차면(단어장이 꽉 차면 단어장 크기를 늘림)
		if(count == List.length) {
			expandWordList();
		}
	}

	public static void expandWordList() {
		//기존 단어장보다 큰 새 단어장 생성
		WordT[] tmp = new WordT[List.length + 10];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(List, 0, tmp, 0, count);
		// 새 단어장을 내 단어장이라고 선언
		List = tmp;
	}

	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

}
