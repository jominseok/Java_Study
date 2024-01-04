package day15.homework;

import java.util.ArrayList;
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