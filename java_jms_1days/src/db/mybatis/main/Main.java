package db.mybatis.main;

import java.util.Scanner;

import db.mybatis.controller.MemberController;


public class Main {

	private static MemberController memberController = new MemberController();
	public static void main(String[] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		} while (menu != 5);
	}
	
	private static void runMenu(int menu) {
		switch (menu) {
		case 1: {
			memberController.run();
			break;
		}
		case 2: {
			System.out.println("프로그램 종료");
			break;
		}

		default:
			System.out.println("잘못된 메뉴입니다.");
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
	}
	
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 회원가입");
		System.out.println("2. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
	}
}


