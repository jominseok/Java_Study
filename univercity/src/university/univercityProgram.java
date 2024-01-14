package university;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.program;
import service.PrintServiceIMP;

public class univercityProgram implements program{
	
	Scanner scan = new Scanner(System.in);
	PrintServiceIMP ps = new PrintServiceIMP(); 
	private final int EXIT = 3;
	@Override
	public void run() {
		int menu = 0;
		do {
			
			ps.printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (InputMismatchException e) {
				
			}
			
			
		} while (menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1: {
			// 학교
			
			break;
		}
		case 2: {
			// 교수
			
			break;
		}
		case 3: {
			// 학생
			
			break;
		}
		case 4: {
			//조회 
			
			break;
		}
		case 5: {
			//사용자 메뉴얼
			ps.printMenual();
			break;
		}
		case 6: {
			System.out.println("종료 되었습니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}

}
