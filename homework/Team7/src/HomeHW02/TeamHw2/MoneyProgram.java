package HomeHW02.TeamHw2;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MoneyProgram implements Program {
	
	
	private Scanner scan = new Scanner(System.in);
	
	private final long EXIT = 3;
	
	List <Money> listIn = new ArrayList <Money>(); // 수입  내역 리스트
	
	List <Money> listOut =new  ArrayList <Money>(); // 지출 내역 리스트
	
	List <Money> listAll = new ArrayList<Money>();  // 전체 내역 리스트
	

	
	// 전체 실행 메서드
	@Override
	public void run() {
		
		int menu=0;
		
		do {
			printMenu();
			
			try {
				
				menu = scan.nextInt();
				
				runMenu(menu);
				
			}catch(InputMismatchException e) {
				
				System.out.println();
			}
						
		}while(menu!=EXIT);		
	}

	
	
	// 메인메뉴 실행 메서드
	
	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1 :
			
			insert();
			
			break;
			
		case 2 :
			
			select();
			
			break;
			
		case 3 :
			
			System.out.println("프로그램을 종료합니다.");
			
		default :
				
			throw new InputMismatchException("잘못된 메뉴 입력");			
		}	
		
	}

	
	
	// 조회 기능 실행 메서드
	
	public void select() {
		
		System.out.println("가계부 조회 기능을 선택하셨습니다.");
		
		printSelectSubMenu();
		
		int selectSubMenu = scan.nextInt();
		
		runSelectSubMenu(selectSubMenu);
			
	}


  
	// 조회 서브 메뉴 실행 메서드
	
	public void runSelectSubMenu(int selectSubMenu) {

		switch(selectSubMenu) {
		
		case 1 :
			
			selectByMonth();
			
			break;
			
		case 2 :
			
			selectMonthDay();
			
			break;
			
			default :
				
			throw new InputMismatchException("없는 메뉴 입니다.");
		}
	}
		
		
		

	// 월,일 별 조회 메서드

	public void selectMonthDay() {
		
		System.out.println("월,일 조회 기능을 선택하셨습니다.");
		
		System.out.println("조회할 날짜를 입력해주세요.");
		
		System.out.println("월 : ");
		
		int month = scan.nextInt();
		
		System.out.println("일 : ");
		
		int day = scan.nextInt();
		
		// 잘못된 월,일을 입력 했을 경우
		
		if((month<1||month>12)||(day<1||day>31)) {
			
		System.out.println("올바른 날짜를 입력해주세요.");
		return;
		}
		
		
		// 내역이 우선 있는지 확인
		
		boolean t = false;
				
		for(Money tmp : listAll) {
			
			if(tmp.getMonth()==month&&tmp.getDay()==day) {
				
				t = true;
			}
		}
		// 내역이 있는 경우
		if(t) {
			
			System.out.println(month + "월 " + day + "일" + " 내역이 다음과 같습니다. ");
			
			
			
			for(Money tmp : listIn) {
				
				if(tmp.getMonth()==month&&tmp.getDay()==day) {
					
					System.out.println("내역 : " + tmp.getMemo() + " , 수입 금액 : " + tmp.getMoney());
					
				}
				
			}
			
			for(Money tmp : listOut) {
				
				if(tmp.getMonth()==month&&tmp.getDay()==day) {
					
					System.out.println("내역 : " + tmp.getMemo() + " , 지출 금액 : " + tmp.getMoney());
					
				}
			}
			
		}
		// 총 지출,수입 출력
		printSumMoneyByDay(month,day);
		
	}
		
	
	
				
		
	// 입력한 날짜에 총 수입,지출 출력 메서드
		
	public void  printSumMoneyByDay(int month, int day) {
		
		int sumIn=0; int sumOut=0; // 총 수입, 지출 변수
		
		for(Money tmp : listIn) {
			
			if(tmp.getMonth()==month&&tmp.getDay()==day) {
				
				sumIn+=tmp.getMoney();
			}			
		}
		
		for(Money tmp : listOut) {
			
			if(tmp.getMonth()==month&&tmp.getDay()==day) {
				
				sumOut+=tmp.getMoney();				
			}
		}
		
		if(sumIn==0&&sumOut==0) {
			
			System.out.println(month + "월" + day + "일에 내역이 없습니다.");
			
		}else if(sumIn==0&&sumOut!=0) {
			
			System.out.println("총 지출 금액 : " + sumOut + ", 수입이 없습니다.");
			
		}else if(sumIn!=0&&sumOut==0) {
			
			System.out.println("총 수입 금액 : " + sumIn + ", 지출이 없습니다.");
			
		}else {
			
			System.out.println("총 수입 금액 : " + sumIn + ", 총 지출 금액 : " + sumOut);
		}
	}
		
		
		
	
	
	// 입력한 월에 총 수입,지출 출력 메서드
	public void printSumMoneyByMonth(int month) {
		
		int sumOut =0;
		int sumIn = 0;
		
		for(Money tmp : listIn) {
			
			if(tmp.getMonth()==month) {
				
				sumIn+=tmp.getMoney();
			}
		}
		
		for(Money tmp : listOut) {
			if(tmp.getMonth()==month) {
				
				sumOut+=tmp.getMoney();
			}
		}
		
		
        if(sumIn==0&&sumOut==0) {
			
			System.out.println(month + "월 내역이 없습니다.");
			
		}else if(sumIn==0&&sumOut!=0) {
			
			System.out.println("총 지출 금액 : " + sumOut + ", 수입이 없습니다.");
			
		}else if(sumIn!=0&&sumOut==0) {
			
			System.out.println("총 수입 금액 : " + sumIn + ", 지출이 없습니다." );
			
		}else {
			
			System.out.println("총 수입 금액 : " + sumIn + ", 총 지출 금액 : " + sumOut);
		}
						
	}
		
		
		


	// 월별 조회 메서드

	public void selectByMonth() {
		
		System.out.println("월별 조회 기능을 선택하셨습니다.");
		
		System.out.println("조회할 월을 입력하세요");
		
		System.out.print("월 : ");
		
		int month = scan.nextInt();
		
		// month가 정상적인지 확인
		boolean f= false;
		
		for(int i =1;i<=12;i++) {
			
			if(i==month) {
				
				f=true;
			}
			
		}
		
		if(!f) {
			
			System.out.println("올바른 월을 입력해주세요.");
			return;
		}
		
		
		
		boolean t = false;
		
		for(Money tmp : listAll) {
			
			if(tmp.getMonth()==month) {
				
				t=true;				
			}
		}
		
		if(t) {
			
			System.out.println(month + "월의 내역이 다음과 같습니다.");
			
			for(Money tmp : listIn) {
				
				if(tmp.getMonth()==month) {
					
					System.out.println(tmp.getDay()+ "일" + "" + "내역 : " + tmp.getMemo() + ", 수입 금액 : " + tmp.getMoney());
				}
				
			}
			
			for(Money tmp : listOut) {
				
				if(tmp.getMonth()==month) {
					
					System.out.println(tmp.getDay() + "일" + "" + "내역 : " + tmp.getMemo() + ", 지출 금액 : " + tmp.getMoney());					
				}
			}
			
		}
		printSumMoneyByMonth(month);
	}
			
			
			
	
		
	// 가계부 기입 메서드	
	




	// 가계부 기입 메서드

	// 새 내역 추가 메서드

  
	public void insert() {
		
		System.out.println("가계부 기입 기능을 선택하셨습니다.");
		
		
		
		printInOutMenu();		
		
		
		int menu = scan.nextInt();
		
		switch(menu) {
		
		case 1 :
			
			System.out.println("수입 내역을 입력하세요.");
			System.out.print("월 : ");
			int monthIn = scan.nextInt();
			System.out.print("일 : ");
			int dayIn = scan.nextInt();
			System.out.println("내역 : ");
			String memoIn = scan.next();
			System.out.println("금액 : ");
			int moneyIn = scan.nextInt();
			
			
			
			Money newIn = new Money(monthIn,dayIn,memoIn,moneyIn);
			
			// 중복제거 과정
			
			for(Money tmp : listIn) {
				
				if(tmp.equals(newIn)) {
					
					System.out.println("이미 있는 내역입니다.");
					return;
				}				
			}
			// 중복 없으니 추가
			
			listIn.add(newIn);
			listAll.add(newIn);
						 
			 System.out.println("수입 내역이 입력 됐습니다.");
			 
			 break;
			 
		case 2 :
			
			System.out.println("지출 내역을 입력하세요.");
			System.out.print("월 : ");
			int monthOut = scan.nextInt();
			System.out.print("일 : ");
			int dayOut = scan.nextInt();
			System.out.println("내역 : ");
			String memoOut = scan.next();
			System.out.println("금액 : ");
			int moneyOut = scan.nextInt();
			
			Money newOut = new Money(monthOut,dayOut,memoOut,moneyOut);
			
			// 중복제거 과정
			
			for(Money tmp : listOut) {
				
				if(tmp.equals(newOut)) {
					
					System.out.println("이미 있는 내역입니다.");
					return;
				}			
			}
			// 중복 없으니 추가
						
			listOut.add(newOut);
			listAll.add(newOut);
			
			System.out.println("지출 내역이 입력됐습니다.");
			
			break;
			
		default :
			
			throw new InputMismatchException("없는 메뉴 입니다.");			
		}		
		
	}
	
	
	
	
	
	// 메인 메뉴 출력 메서드
	// 메인메뉴 출력 메서드
	





	@Override
	public void printMenu() {
		
		System.out.println("--------");
		System.out.println("메뉴");
		System.out.println("1.가계부 기입");
		System.out.println("2.가계부 조회");
		System.out.println("3.종료");
		System.out.println("--------");
		System.out.print("메뉴 선택 : ");
		
	}

	
	
	
	
	// 수입, 지출 선택 메뉴 출력 메서드
	
	public void printInOutMenu() {
		
		
		System.out.println("--------");
		System.out.println("1.수입");
		System.out.println("2.지출");
		System.out.println("--------");
		System.out.print("메뉴 선택 : ");
	}
	
	
	
	
	// 조회 서브 메뉴 출력 메서드
	
	public void printSelectSubMenu() {
				
		System.out.println("----------");
		System.out.println("조회 메뉴");
		System.out.println("1.월별 조회");
		System.out.println("2.월,일 조회");
		System.out.println("----------");
		System.out.println("메뉴 선택 : ");
	}
	
	
	
}
