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
	
	private static void runMenu(int menu) {//throws를 생략해도 되는가? RuntimeException일 경우 <---저기에 throws를 생략 가능하다 
		switch (menu) {	         		   //InputMismatchException의 경우 RuntimeException의 자식 클래스이기 때문에 생략 가능
		case 1: {
			//회원 가입
			insertMember();
			break;
		}
		case 2: {
			//회원 검색
			serchMember();
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

	private static void serchMember() {
		System.out.print("회원 아이디를 입력해주세요 : ");
		String id = scan.next();
		
		//아이디, 비번을 출력
		//비번을 가지고 옴
		String pw = map.get(id);
		
		//가져온 비번이 null이면 없는 회원이라고 출력
		if(pw == null) {
			System.out.println("등록되지 않은 아이디입니다.");
		}
		//아니면 id, pw를 출력
		System.out.println("아이디 : " + id + "비밀번호 : " + pw);
	}

	private static void insertMember() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = scan.next();
		if(map.containsKey(id)) {//if(map.get(id) != null)
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.print("비밀번호를 입력해 주세요 : ");
		String pw = scan.next();
		map.put(id, pw);
		System.out.println("회원가입에 성공하였습니다.");
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
