package day14;
import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력 받아 산술하는 코드를 작성하세요
		// 단, 0으로 나눌 때 예외처리를 적용
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char a;
		try {
			System.out.print("정수 2개를 입력해주세요 : ");
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			System.out.print("산술 연산자를 입력해주세요 : ");
			a = scan.next().charAt(0);
			switch (a) {
				case '+': {
					System.out.println(" " + num1 + " + " + num2 + " = " + (num1+num2));
					break;
				}
				case '-': {
					System.out.println(" " + num1 + " - " + num2 + " = " + (num1-num2));
					break;
				}
				case '/': {
					System.out.println(" " + num1 + " / " + num2 + " = " + num1/num2);
					break;
				}
				case '%': {
					System.out.println(" " + num1 + " % " + num2 + " = " + num1%num2);
					break;
				}
			}
			String pattern = "{0} {1} {2} = {3}";
			//System.out.println(MessageFormat.format(pattern, args));
		}
		catch(ArithmeticException e) {
			System.out.println("예외가 발생했습니다.");
		}
	}

}
