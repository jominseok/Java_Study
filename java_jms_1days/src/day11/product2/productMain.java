package day11.product2;

import java.util.Scanner;

import day11.product2.Product;

public class productMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static Product[] list = new Product[10];
	private static int count = 0;
	private static Product[] saleList = new Product[10];
	private static int saleCount = 0;
	
	/* 제품을 관리하는 프로그램을 구현하세요
	 * 
	 * 메뉴 
	 * 1. 제품 입고(추가랑 수정이 섞여있는 느낌)
	 *  - 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 * 2. 제품 판매
	 *  - 입고된 제품을 판매
	 * 3. 제품 수정[가격]
	 * 4. 매출 내역 조회
	 * 5. 종료
	 */
	
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		} while (menu !=5);

	}
	
	private static void runMenu(int menu) {

		switch (menu) {
		case 1: {
			// 제품 입교
			storeProduct();
			break;
		}
		case 2: {
			//제품 판매
			seleProduct();
			break;
		}
		case 3: {
			updateProduct();
			break;
		}
		case 4: {
			printSaleList();
			break;
		}
		case 5: {
			System.out.println("프로그램 종료");
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
		}
		
	}

	private static void printSaleList() {
		//매출 내역조회
		// 반복문 : 전체 매출 내역 조회
		for(int i = 0; i<saleCount; i++) {
			//판매 제품 정보 출력
			saleList[i].print();
		}
	}

	private static void updateProduct() {
		// 제품명 입력
		System.out.print("제품명 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//제품 할인가격 입력
		System.out.print("금액 : ");
		int salePrice = scan.nextInt();
		//일치하는 제품의 할인 금액을 수정
		//반복문 : 등록된 제품 전체
		for(int i = 0; i<count; i++) {
			//제품의 이름과 제품명이 같으면
			if(list[i].equals(name)) {
				//제품의 할인 금액을 후정후 종료
				list[i].updateSalePrice(salePrice);
				return;
			}
			
		}
		//일치하는 제품이 없다고 출력
		System.out.println("일치하는 제품이 없습니다.");
		
			
	}

	private static void seleProduct() {
		// 등록 제품 목록을 출력
		//반복문 : 등록된 제품 전체
		for(int i = 0; i<count; i++) {
			// 제품 정보를 출력
			list[i].print();
		}
		//제품명 입력
		System.out.println("제품명 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//판매 개수를 입력
		System.out.println("수량 : ");
		int amount = scan.nextInt();
		//기존 제품 수량 변경
		//반복문 : 등록된 제품 전체
		//제품의 제품명돠 판매한 제품명이 같으면
		int index = -1;
		for(int i = 0; i < count; i++) {
			//제품 수량이 입력한 제품 수량보다 크거나 같으면
			if(list[i].equals(name)) {
				//번지를 index에저장
				index = i;
			}
			//일치하는 제품이 없으면 
			if(index == -1) {
				System.out.println("일치하는 제품이 없습니다.");
				return;
			}
			//제품 수량이 입력한 제품 수량보다 적으면 
			if(list[i].getAmount() <amount) {
				//수량이 잘못됐다고 출력
				System.err.println("수량을 확인하세요. ");
				//메서드 종료
				return;
			}
			//제품 수량을 변경
			list[index].updateAmount(-amount);
			
			//매출 내역을 위해 판매 제품 리스트에 추가
			//제품 명과 입력된 제품수량을 이용하여 인스턴스를 생성
			Product tmp = new Product(name, amount, 
					list[index].getBuyPrice(),
					list[index].getSalePrice());
			//생성된 인스턴스를 판매 제품 리스트에 추가
			saleList[saleCount] = tmp;
			//판매횟수를 증가
			saleCount++;
			System.out.println("판매가 등록되었습니다.");
		}
	}

	public static void storeProduct() {
		//제품 정보 입력
		System.out.print("제품명 : ");
		scan.nextLine();
		String name = scan.nextLine();
		
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		
		System.out.print("구매가격 : ");
		int buyPrice = scan.nextInt();
		
		System.out.print("판매가격 : ");
		int price = scan.nextInt();
		
		//일치하는 제품 정보가 있으면 수량을 변경
		for(int i = 0; i < count; i++) {
			if(list[i].equals(name)) {
				list[i].updateAmount(amount);
				return;
			}
		}
		
		//없으면 추가
		list[count] = new Product(name, amount, buyPrice, price);
		count++;
		
		//배열이 다 차면 확장
		if(count == list.length) {
			expendList(list);
		}
		
	}
	
	
	
	/**
	 * 주어진 list 확장하는 메서드
	 * @param list 확장할 메서드
	 * @return 주어진 list에 크기 10만큼 늘어난 배열을 반환
	 */
	private static Product[] expendList(Product[] list) {
		// 만약 가격리스트랑 제품 리스트가 제품과 같아지게 되면 증량시켜줌
			Product [] temList = new Product[list.length + 10];
			System.arraycopy(list, 0, temList, 0, list.length);
			return temList;
		
	}
	
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");//가격만 수정하기
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
}
