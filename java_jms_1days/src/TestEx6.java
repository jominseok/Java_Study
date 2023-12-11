import java.util.Scanner;

public class TestEx6 {

	public static void main(String[] args) {
		/*
		 * 산술연산자와 두 정수를 입력받아서
		 * 산술 연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요
		 * 예) 
		 * 두 정수와 연산자 입력 (예 : 1 + 2) : 1+2
		 * 1 + 2 + 3
		 * 두 정수와 연산자 입력 (예 : 1 + 2) : 1/2
		 * 1 / 2 = 0.5
		 * 두 정수와 연산자 입력 (예 : 1 + 2) : 1 ? 2
		 * ?는 산술 연산자가 아닙니다.
		 * */ 
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요 : ");
		int num1 = scan.nextInt();
		System.out.print("정수를 입력해주세요 : ");
		int num2 = scan.nextInt();
		System.out.print("연산자를 입력해주세요 : ");
		char str1 = scan.next().charAt(0);
		if(str1 == '+') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1+num2);
	 	}
		else if(str1 == '-') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + (num1 - num2));
		}
		else if(str1 == '/') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1/num2);
		}
		else if(str1 == '%') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1%num2);
		}
		else {
			System.out.println(str1+"는 연산자가 아닙니다.");
		}
		
		// 다른 방법
		
		if(str1 == '+') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1+num2);
	 	}
		else if(str1 == '-') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + (num1 - num2));
		}
		else if(str1 == '/') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1/num2);
		}
		else if(str1 == '%') {
			System.out.println(num1 + " " + str1+ " "  + num2 + " = " + num1%num2);
		}
		else {
			System.out.println(str1+"는 연산자가 아닙니다.");
		}
			
	}

}
