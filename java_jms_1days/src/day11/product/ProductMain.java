package day11.product;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProductMain {

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
	
	
	public static Scanner scan = new Scanner(System.in).useLocale(Locale.KOREAN);
	
	//입고된 제품 리스트
	public static Product[] storeList = new Product[10];
	//판매된 제품 리스트
	public static Product[] saleList = new Product[10];
	
	public static int storecount = 0;// 입고된 제품 개수
	public static int salecount = 0;// 판매된 제품 개수
	public static int pricesum;// 총 매출
	
	
	public static void main(String[] args) {
		int menu;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		} while (menu != 5);
		
		
		
	}
	
	private static void runMenu(int menu) {
		switch (menu) {
		case 1: {
			// 제품 입고 추가
			for(int i = 0; i < storecount; i++) {
				storeList[i].printProduct();
			}
			insertStore();
			break;
		}
		case 2: {
			//제품 판매
			sale();
			break;
		}
		
		case 3: {
			//제품 수정
			update();
			break;
		}
		case 4: {
			//매출 내역
			sales();
			break;
		}
		case 5: {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
		}
	}

	
	/**
	 * 매출 내역 출력 메서드
	 */
	private static void sales() {
		System.out.print("메뉴를 선택해주세요 : ");
		System.out.println("1. 제품 이름으로 조회하기");
		System.out.println("2. 일자별로 조회하기");
		int menu = scan.nextInt();
		switch (menu) {
		case 1: {
			productNameSerch();
			
			break;
		}
		case 2: {
			pricesum = 0;
			System.out.print("조회 하고 싶은 날짜를 입력하세요 : ");
			String date = scan.next();
			for(int i = 0; i <salecount; i++) {
				if(saleList[i].equalsDate(date)) {
					pricesum += saleList[i].price;
				}
			}
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
		}
		
		
	}

	
	
	
	private static void productNameSerch() {
		System.out.println("판매 리스트");
		for(int i = 0; i < salecount; i++) {
			saleList[i].printProduct();
		}
		System.out.println("총 판매액 : " + pricesum);
	}

	
	
	/**
	 * 제품을 판매하는 메소드
	 */
	private static void sale() {
		try {
			System.out.println("판매할 제품을 입력해 주세요 : ");
			scan.nextLine();
			String saleproduct = scan.nextLine();
			int index = -1;
			for(int i = 0; i < storecount; i++) {
				if(storeList[i].equalsProduct(saleproduct)) {
					index = i;
				}
			}
			if(index == -1) {
				System.out.println("일치하는 제품이 없습니다.");
				return;
			}
			//만약 판매에 성공한 제품이 있으면 saleList에 추가
			createSaleList(index);
			salecount++;
			storecount--;
			
			//복사할 배열 생성
			Product[] tmp = new Product[storeList.length];
			//똑같이 tmp에 storeList복사
			System.arraycopy(storeList, 0, tmp, 0, storeList.length);
			//떼어낸 만큼 붙여넣기
			System.arraycopy(tmp, index+1, storeList, index, storecount - index);
			
		} catch (Exception e) {
			System.out.println("제품이나 가격에 문자와 숫자를 제대로 기입해주세요");
		}
		
	}

	
	/**판매한 물품을 저장 하는 메서드
	 * 
	 * @param index 제품 리스트에서 판매됨 물건의 위치를 저장하는 변수
	 */
	private static void createSaleList(int index) {
		pricesum = 0;

		for(int i = 0; i <= salecount; i++) {
			Product product = new Product(storeList[index].price, storeList[index].Products,storeList[index].date);
			saleList[i] = product;
			pricesum += saleList[i].price; 
		}
	
		saleListexpand();
		
	}

	
	
	/**
	매출 목록이 다 차면 증가 시켜주는 메소드
	 */
	private static void saleListexpand() {
		if(saleList.length == salecount) {
			Product [] saletmp = new Product[storeList.length + 10];
			System.arraycopy(saleList, 0, saletmp, 0, storecount);
			saleList = saletmp;
		}
	}
	
	
	/**
	 * 제품의 가격을 수정 시키는 메서드
	 */
	private static void update() {
		try {
			System.out.print("수정할 제품을 입력해주세요 : ");
			scan.nextLine();
			String Product = scan.nextLine();
			for(int i = 0; i < storecount; i++) {
				if(storeList[i].equalsProduct(Product)) {
					System.out.print(Product+"의 가격을 수정해주세요 : ");
					int updatePrice = scan.nextInt();
					storeList[i].update(updatePrice);
					break;
				}
			}
			System.out.println("일치하는 제품이 없습니다.");
		} catch (Exception e) {
			System.out.println("제품이나 가격에 문자와 숫자를 제대로 기입해주세요");
		}
		

	}
	
	

	/**
	 * 제품을 입고 시키는 메서드
	 */
	
	public static void insertStore() {
		try {
			System.out.print("입고할 제품을 입력해주세요 : ");
			scan.nextLine();
			String storeProduct = scan.nextLine();
			System.out.print(storeProduct + "의 가격을 입력해주세요 : ");
			int price = scan.nextInt();
			System.out.print("입고된 날짜를 입력해주세요 : ");
			String date = scan.next();
			Product product = new Product(price, storeProduct, date);
			storeList[storecount] = product;
			storecount++;
			if(storeList.length == storecount) {
				storeListexpand();
			}
		} catch (InputMismatchException e) {
			System.out.println("제품이나 가격에 문자와 숫자를 제대로 기입해주세요");
			return;
		}
		
	}
	
	/**
	 * 제품과 가격 리스트가 꽉 차면 증량 시켜주는 메서드
	 */
	private static void storeListexpand() {
			// 만약 가격리스트랑 제품 리스트가 제품과 같아지게 되면 증량시켜줌
			Product [] storetmp = new Product[storeList.length + 10];
			System.arraycopy(storeList, 0, storetmp, 0, storecount);
			storeList = storetmp;
	}

	
	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("메뉴");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");//가격만 수정하기
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	
}













































