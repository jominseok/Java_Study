package fancafe.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import fancafe.controller.FanCafeController;

public class FanCafeMain {
	static FanCafeController fanCafeController=new FanCafeController();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("kh 팬카페에 오신걸 환영합니다.");
		int menu=0;
		do {
			fanCafeController.printMenu();
			try {
				menu=scan.nextInt();
				fanCafeController.runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				scan.next();
			}
		}while(menu!=3);
	}
}
