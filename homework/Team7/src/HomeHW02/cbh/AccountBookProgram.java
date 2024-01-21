package HomeHW02.cbh;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import HomeHW02.cbh.service.AccountPrint;
import HomeHW02.cbh.service.AccountPrintImp;

public class AccountBookProgram implements Program {
	private Scanner scan=new Scanner(System.in);
	private AccountBook accountbook=new AccountBook(null);//가계부
	private AccountPrint Aprint=new AccountPrintImp();//메뉴출력
	
	//시작
	@Override
	public void run() {
		int menu=0;
		do {
			printMenu();
			try {
				menu=scan.nextInt();
				System.out.println("-----------------");
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력");
				scan.nextLine(); 
			}	
		}while(menu!=3);
	}

	//메뉴출력
	@Override
	public void printMenu() {
		Aprint.printMenu();
	}

	//메뉴실행
	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1:
			//입력메뉴
			insertMenu();
			System.out.println("-----------------");
			break;
		case 2:
			//조회메뉴
			selectMenu();
			System.out.println("-----------------");
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}	
	}
	
	//--------------조회기능-------------
	private void selectMenu() {
		Aprint.selectMenu(); //조회메뉴 출력
		int menu=scan.nextInt();
		runSelectMenu(menu); //조회기능 실행
	}
	
	//조회기능 실행
	private void runSelectMenu(int menu) {
		switch (menu) {
		case 1:
			monthPrint();//월 조회
			break;
		case 2: 
			dayPrint(); //일 조회
			break;
		default:
			throw new InputMismatchException();
		}	
	}

	//날짜 조회
	private void dayPrint() {
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		accountbook.dayPrint(month,day);//가계부에 월,일을 보냄
	}

	//월 조회
	private void monthPrint() {
		System.out.print("월 입력:");
		int month=scan.nextInt();
		accountbook.monthPrint(month);
	}

	//--------------입력기능-------------
	private void insertMenu() {
		Aprint.printInsertMenu(); //입력 메뉴 출력
		int subMenu=scan.nextInt();
		runInsertMenu(subMenu); //입력 기능 실행
	}

	//입력기능 실행
	private void runInsertMenu(int subMenu) {
		switch (subMenu) {
		case 1: 
			//수입입력
			insertMoney();
			break;
		case 2:
			//지출 지출내역 작성
			addOutMoney();
			break;
		case 3: 
			//지출 수정
			updateOutMoney();
			break;
		default:
			throw new InputMismatchException();
		}	
	}
	
	//수입 작성
	private void insertMoney() {
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("수입:");
		int money=scan.nextInt();
		if(accountbook.addMoney_in(month, money)) {
			System.out.println("등록 완료");
		}else {
			System.out.println("중복으로 인해 등록이 안됩니다");
		}
//		accountbook.print(); //확인용
	}
	
	//지출 추가
	private void addOutMoney() {
		List<itemList> ml=new ArrayList<itemList>(); //리스트생성
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		System.out.print("지출 비용:");
		int money=scan.nextInt();
		System.out.print("지출 내용:");
		scan.nextLine();
		String memo=scan.nextLine();
		//리스트에 넣어둠
		ml.add(new itemList(day, memo, money));
		//월, 리스트를 가지고 비교해서 추가/중복 안내
		if(accountbook.addMoney_out(month,ml)) {
			System.out.println("추가 되었습니다");
		}else {
			System.out.println("날이 중복됩니다");
		}
//		accountbook.print(); //테스트
	}
	
	//지출 수정
	private void updateOutMoney() {
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		System.out.print("지출 비용:");
		int money=scan.nextInt();
		System.out.print("지출 내용:");
		scan.nextLine();
		String memo=scan.nextLine();
		//지출 수정후 안내문구 출력
		if(accountbook.setMoney_Out(month,day,money,memo)) {
			System.out.println("수정완료");
		}else {
			System.out.println("없는 내용입니다");
		}
//		accountbook.print();//테스트
	}
}
