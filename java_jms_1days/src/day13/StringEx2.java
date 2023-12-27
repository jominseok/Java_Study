package day13;

import java.util.Scanner;

public class StringEx2 {
	/**
	 * 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가 있는 문장들을 
	 * 출력하는 프로그램을 작성하세요
	 * 메뉴
	 * 1. 문장 추가
	 * 2. 검색
	 * 3. 종료
	 */
	
	/* 안녕하세요
	 * 테스트
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * 
	 * "나"로 검색
	 * 
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 */
	static Scanner scan = new Scanner(System.in);
	static int count;
	static String[] words = new String[10];
	
	public static void main(String[] args) {
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
			
		} while (menu != 3);
	}
	
	
	private static void runMenu(int menu) {
		switch (menu) {
		case 1: {
			//문장 추가
			insetSentence();
			break;
		}
		case 2: {
			//검색
			serchWord();
			break;
		}
		case 3: {
			System.out.println("프로그램 종료");
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
		}
		
	}


	public static void serchWord() {
		scan.nextLine();
		//입력된 문장 출력
		for(int i = 0; i < count; i++) {
			System.out.println(words[i]);
		}
		System.out.print("검색할 단어을 입력해주세요 : ");
		String word = scan.nextLine();
		
		//향상된 for문
		for(String tmp : words) {
			if(tmp != null && tmp.contains(word)) {
				System.out.println(tmp);
			}
			if(tmp != null && tmp.indexOf(word) >=0) {
				System.out.println(tmp);
			}
		}
		for(int i = 0; i < count; i++) {
			if(words[i].contains(word)) {
				System.out.println(words[i]);
			}
		}
	}


	public static void insetSentence() {
		//문장 입력
		System.out.print("추가할 문장을 입력해주세요 : ");
		scan.nextLine();
		String sentence = scan.nextLine();
		//문장 추가
		words[count++] = sentence;
		// 배열이 다 차면 늘려주기
		if(words.length == count) {
			expandList();
		}
	}


	public static void expandList() {
		String[] tmp = new String[words.length + 10];
		System.arraycopy(words, 0, tmp, 0, count);
		words = tmp;
	}


	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
