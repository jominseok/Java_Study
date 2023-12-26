package day12.product;

import java.util.Scanner;

public class productMain {
	/* 제품을 추가하는 프로그램을 작성하세요
	 * 제품은 TV, 에어컨, 컴퓨터만 추가 가능
	 * 공통 : 브랜드, 제품코드, 제품명
	 * TV : 화면크기
	 * 에어컨 : 냉방면적
	 * 노트북 : CPU, RAM
	 * 
	 * TV클래스, 에어컨 클래스, 노트북 클래스
	 * Product 클래스
	 * 
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * ---------------
	 * 추가할 제품 
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 1
	 * 브랜드 : 삼성
	 * 제품코드 : KQ75QE1-W1
	 * 제품명 : 2023 QLED 4K QCE1 (189cm) 풀 모션 슬림핏 벽걸이형
	 * 화면크기(cm) : 189
	 * 등록이 완료되었습니다.
	 * 
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * --------------- 
	 * 추가할 제품 
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 2
	 * 브랜드 : 삼성
	 * 제품코드 : AF17B6474WSRT
	 * 제품명 : 2023 QLED 4K QCE1 (189cm) 풀 모션 슬림핏 벽걸이형
	 * 냉방면적(m2) : 56.9
	 * 등록이 완료되었습니다.
	 * 
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 2
	 * --------------- 
	 * */
	public static Scanner scan = new Scanner(System.in);
	public static product [] list = new product[30];
	public static int count = 0;
	
	
	public static void main(String[] args) {
		
		int menu;
		do {
			//메뉴 출력
			printmenu();
			//메뉴 선택
			menu = scan.nextInt();
			System.out.println("------------------");
			//기능 실행
			runmenu(menu);
		} while (menu != 3);
		
	}

	public static void runmenu(int menu) {
		switch (menu) {
		case 1: {
			//제품 추가
			insertProduct();
			break;
		}
		case 2: {
			//제품 확인
			printProduct();
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
	
	public static void insertProduct() {
		//제품 목록 출력
		printSubPrint();
		//공통 정보
		int select = scan.nextInt();
		System.out.print("브랜드 : ");
		scan.nextLine();//위에서 입력한 엔터 처리
		String brand = scan.nextLine();
		System.out.println("제품명 : ");
		String title = scan.nextLine();
		System.out.println("제품 코드 : ");
		String code = scan.nextLine();
		// 제품마다 추가정보 입력 후 인스턴스 생성 후 추가
		switch (select) {
		case 1: {
			//Tv추가
			System.out.println("화면 사이즈 : ");
			int size = scan.nextInt();
			list[count++]= new TV(brand, code, title, size);
			break;
		}
		case 2: {
			//에어컨 추가
			System.out.println("냉방 면적 : ");
			double area = scan.nextDouble();
			list[count++]  = new Aircon(brand, code, title, area);
			break;
		}
		case 3: {
			//노트북 추가
			scan.nextLine();
			System.out.println("CPU : ");
			double cpu = scan.nextDouble();
			System.out.println("RAM : ");
			int ram = scan.nextInt();
			list[count++] = new Laptop(brand, code, title, cpu, ram);
			break;
		}
		default:
			System.out.println("잘못된 제품입니다.");
		}
		System.out.println("등록이 완료 되었습니다.");
	}

	private static void printProduct() {
		// TODO Auto-generated method stub
		if(count == 0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		for(int i = 0; i < count; i++) {
			list[i].print();
		}
	}

	

	public static void printSubPrint() {
		System.out.println("추가할 제품");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.print("메뉴 선택 : ");
	}

	public static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
		
	}

}
