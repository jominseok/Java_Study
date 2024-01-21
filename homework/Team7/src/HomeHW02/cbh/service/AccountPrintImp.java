package HomeHW02.cbh.service;
//메뉴출력기능
public class AccountPrintImp implements AccountPrint{
	
	@Override
	public void printMenu() {
		System.out.println("---가게부 프로그램---");
		System.out.println("1.가계부 내역 기입");
		System.out.println("2.조회");
		System.out.println("3.종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");	
	}

	@Override
	public void selectMenu() {
		System.out.println("---조회 기능---");
		System.out.println("1.월 조회");
		System.out.println("2.일 조회");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}

	@Override
	public void printInsertMenu() {
		System.out.println("1.수입 작성");
		System.out.println("2.지출,지출내역 작성");
		System.out.println("3.지출 수정");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}
}
