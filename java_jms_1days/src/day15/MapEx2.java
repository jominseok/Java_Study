package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	/* 회원을 관리하는 프로그램을 작성하세요.
	 * 메뉴
	 * 1. 회원가입
	 * 	 - 아이디와 비번만 입력
	 * 	 - 이미 가입된 회원인지 체크(containsKey)이용
	 * 2. 회원검색
	 * 	 - 아이디를 입력해서 회원 정보를 조회
	 * 3. 종료
	 */
	
	static Scanner scan = new Scanner(System.in);
	
	//맵 생성
	static Map<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		
		int menu = 0;
		
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();//잘못 입력된 값을 문자열로 가져와서 버림
			}
		} while (menu != 3);
		
		
	}
	
	private static void runMenu(int menu) {
		
		switch (menu) {
		case 1: {
			//회원 가입
			System.out.print("아이디를 입력해주세요 : ");
			String id = scan.next();
			System.out.print("비밀번호를 입력해 주세요 : ");
			String pw = scan.next();
			if(map.containsKey(id)) {
				System.out.println("중복된 아이디입니다.");
				return;
			}
			map.put(id, pw);
			System.out.println("회원가입에 성공하였습니다.");
			break;
		}
		case 2: {
			//회원 검색
			System.out.print("회원 아이디를 입력해주세요 : ");
			String member = scan.next();
			for(String tmp : map.keySet()) {
				if(tmp.equals(member)) {
					System.out.println(tmp + " 회원이 검색되었습니다.");
					return;
				}
			}
			System.out.println("검색된 회원이 없습니다.");
			break;
		}
		case 3: {
			System.out.println("종료");
			break;
		}
	
		default:
			throw new InputMismatchException();
		}
	}

	private static void printMenu() {
		
		System.out.println("--------------------");
		System.out.println("메뉴");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴선택 : ");
		
	}
}
