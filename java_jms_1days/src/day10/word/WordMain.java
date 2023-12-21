package day10.word;

import java.util.Scanner;
/* 영어 단어장 프로그램을 만드세요
 * 1. 기능 정리
 * 	0부터 10까지 스펠링을 알려주는 영어 단어장
 * 	zero, one, tow, three, four, five, six, seven, eight, nine, ten
 *  만약 단어를 추가 하고 싶다면 추가 할 수 있음. 
 *  삭제도 할 수 있음
 *  단어 등록 형식은 (영어 => 한글)등록됨
 *  단어의 목록을 조회할 때는 영어만 나오고 상세조회를 하면 한글도 같이 나오게 한다.
 *  
 * 2. 틀 작성
 *  -----메뉴------
 *  1. 단어 목록 조회
 *  2. 단어 등록
 *  3. 프로그램 종료
 *  메뉴선택 : 1
 *  
 *  ---단어 목록 조회---
 *  
 *  단어 목록
 *  1. one
 *  2. two
 *  ...
 *  10. ten
 *  
 *  1. 단어 상세 정보
 *  2. 단어 삭제
 *  3. 뒤로가기
 *  메뉴 선택 : 1
 *  
 *  one => 일
 *  
 *   ---단어 목록 조회---
 *  
 *  단어 목록
 *  1. one
 *  2. two
 *  ...
 *  10. ten
 *  
 *  1. 단어 상세 정보
 *  2. 단어 삭제
 *  3. 뒤로가기
 *  메뉴 선택 : 2
 *  
 *  삭제 할 단어를 선택해 주세요 : 2
 *  1. one
 *  2. three
 *  3. ...
 *  9. ten
 *  
 *  -----메뉴------
 *  1. 단어 목록 조회
 *  2. 단어 등록
 *  3. 프로그램 종료
 *  메뉴선택 : 2
 *  
 *  -- 단어 등록 --
 *  영어 : dog
 *  한글 : 강아지
 *  
 * 3. 필요한 메서드 구현
 * */

/* 영어 단어장 프로그램을 만드세요
 * 
 * */
public class WordMain {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu;
		do {
			//메뉴 출력
			PrintMenu();
			//메뉴입력
			menu = scan.nextInt();
			switch (menu) {
			case 1: {
				//단어 목록 조회
				printListMenu();
				int Listmenu = scan.nextInt(); 
				runMenuList(Listmenu);
				break;
			}
			case 2: {
				//단어 등록
				
				break;
			}
			case 3:{
				//프로그램 종료
				break;
			}
			default:
				System.out.println("잘못된 메뉴 선택입니다.");
			}
			
		} while (menu != 3);
	}

	private static void runMenuList(int menu) {
		
		switch (menu) {
		case 1: {
			// 단어 목록 
			// 단어 상세 정보
			break;
		}
		case 2:{
			//단어 삭제
			break;
		}
		case 3:{
			//뒤로가기
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
			break;
		}
	}

	private static void printListMenu() {
		
		System.out.println("---단어 목록 조회---");
		//단어 목록 클래스 만들어서 가져와야함!!
		System.out.println("1. 단어 상세 정보");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 뒤로가기");
		System.out.print("메뉴 선택 : ");
	}

	public static void PrintMenu() {
		System.out.println("\n-----메뉴------");
		System.out.println("1. 단어 목록 조회");
		System.out.println("2. 단어 등록");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴선택 : ");
	}
	


}
