package HomeHW02.jms;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MoneyProgram {
    private Scanner scan = new Scanner(System.in);
    private final int EXIT = 3;

    private Map<Integer, money> moneyRecords = new HashMap<>();

    public void run() {
        int menu = 0;

        do {
            try {
                printMenu();
                menu = scan.nextInt();
                runMenu(menu);
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("예외가 발생하였습니다");
                scan.nextLine();
            }

        } while (menu != EXIT);

    }

    public void runMenu(int menu) {
        switch (menu) {
            case 1: {
                // 가계부 내역 기입

                int menu1 = 0;
                do {
                    try {
                        printMenu1();
                        menu1 = scan.nextInt();
                        runMenu1(menu1);
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                        scan.nextLine();
                    }
                } while (menu1 != 4);
                break;
            }
            case 2: {
                // 조회
            	int menu2 = 0;
                do {
                    try {
                        printMenu2();
                        menu2 = scan.nextInt();
                        runMenu2(menu2);
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                        scan.nextLine();
                    }
                } while (menu2 != 4);
                break;
            }
            case 3: {
                // 종료
                System.out.println("종료 되었습니다.");
                break;
            }

            default:
                throw new InputMismatchException();
        }
    }

    private void runMenu2(int menu2) {
    	switch (menu2) {
		case 1: {
			//월 조회 (보류 하겠씁니다. 같이 상의 하고 싶은 부분이 있습니다)
        	
		}
		case 2: {
			//일 조회
        	System.out.print("월 입력 : ");
            int month = scan.nextInt();

            System.out.print("일 입력 : ");
            int day = scan.nextInt();
            
            money moneyMonth = moneyRecords.get(month);
            money moneyday = moneyRecords.get(day);
            if (moneyMonth == null && moneyday == null) {
            	System.out.println("해당 날짜에 거래 내역이 없습니다.");
            	return;
            }
            System.out.println(moneyMonth.getMonth() + "월 " + moneyMonth.getDay() + "일 " 
            		+ "지출 항목은 " + moneyMonth.getMemo() + "지출 비용은 " + moneyMonth.getMoneyOut() + "입니다.");
            
		}
		case 3: {
			System.out.println("종료 되었습니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}


	private void runMenu1(int menu1) {
        try {
            switch (menu1) {
                case 1: {
                    // 수입
                   insertMoneyIn();

                    break;
                }

                case 2: {
                    // 지출, 지출 내역서
                    insertMoneyOut();

                    break;
                }

                case 3: {
                    // 지출 수정
                	
                	System.out.print("월 입력 : ");
                    int month = scan.nextInt();

                    System.out.print("일 입력 : ");
                    int day = scan.nextInt();
                    
                    money moneyMonth = moneyRecords.get(month);
                    money moneyday = moneyRecords.get(day);
                    if (moneyMonth == null && moneyday == null) {
                    	System.out.println("해당 날짜에 지출 내역이없습니다.");
                    	return;
                    } else {
                    	moneyMonth.setDay(day);
                    	//moneyMonth.setMemo(memo);
                    	//setMoneyOut(moneyMonth.getMoneyOut() + moneyOut);
                    }
                    break;
                }
                case 4: {
                    System.out.println("종료 되었습니다.");
                    break;
                }
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("가계부 내역 기입중 예외 발생");
            scan.nextLine(); // Clear the input buffer
        }

    }
	
	//가계부 내역 기입에 지출, 지출 내역서 메서드
	private void insertMoneyOut() {
		// TODO Auto-generated method stub
		System.out.print("월 입력 : ");
        int month = scan.nextInt();

        System.out.print("일 입력 : ");
        int day = scan.nextInt();

        System.out.print("지출 비용 입력 : ");
        int moneyOut = scan.nextInt();

        System.out.print("지출 내역 입력 : ");
        String memo = scan.next();

        money moneyMonth = moneyRecords.get(month);
        money moneyday = moneyRecords.get(day);
        if (moneyMonth == null && moneyday == null) {
        	moneyMonth = new money(month, day, memo, moneyMonth.getMoneyIn(), moneyOut);
            moneyRecords.put(month, moneyMonth);
        } else {
        	moneyMonth.setDay(day);
        	moneyMonth.setMemo(memo);
        	moneyMonth.setMoneyOut(moneyMonth.getMoneyOut() + moneyOut);
        }
	}
	
	//가계부 내역 기입에 수입 메서드
	private void insertMoneyIn() {
		// TODO Auto-generated method stub
		 System.out.print("월 입력 : ");
         int month = scan.nextInt();
         if (month < 1 || month > 12) {
             System.out.println("잘못된 월 입력입니다.");
             return;
         }

         System.out.print("수입을 입력해 주세요: ");
         int moneyIn = scan.nextInt();

         money money = moneyRecords.get(month);
         System.out.println(moneyRecords.get(month+ "머니 레코드의 숫자는? "));
         //만약 해당 월에 값이 없다면 처음 실행
         if (money == null) {
             money = new money(month, null, null, moneyIn, 0);
             moneyRecords.put(month, money);
             //만약 해당 월에 수입이 있다면 더해서 추가
         } else {
             money.setMoneyIn(money.getMoneyIn() + moneyIn);
         }
	}

	private void printMenu2() {
		System.out.println("----가계부 프로그램----");
		System.out.println("1. 가계부 내역 기입");
		System.out.println("2. 조회");
		System.out.print("메뉴선택 : ");
		
	}

    private void printMenu1() {
        System.out.println("--가계부 내역 기입--");
        System.out.println("1. 수입");
        System.out.println("2. 지출, 지출 내역서");
        System.out.println("3. 지출 수정");
        System.out.println("4. 종료");
        System.out.println("---------------");
        System.out.print("메뉴선택 :");
    }

    public void printMenu() {
        System.out.println("---가계부 프로그램---");
        System.out.println("1. 가계부 내역 기입");
        System.out.println("2. 조회");
        System.out.println("3. 종료");
        System.out.println("---------------");
        System.out.print("메뉴선택 : ");
    }
}
