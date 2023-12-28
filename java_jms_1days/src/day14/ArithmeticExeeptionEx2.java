package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExeeptionEx2 {
	
	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 결과를 출력하는 메서드를 구현하세요
		// 단, 메서드를 이용, throws와 throw를 이용
		Scanner scan = new Scanner(System.in);

		try {
			int num1, num2;
			char op;
			System.out.print("연산자와 정수를 입력해주세요 ex) 1 + 2 : ");
			num1 = scan.nextInt();
			op = scan.next().charAt(0);
			num2 = scan.nextInt();
			double res = artimetic(num1, num2, op);
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1, op, num2, res));
		} catch (Exception e) {
			System.out.println("예외가 발생하였습니다.");
		}

	}

	public static double artimetic(int num1, int num2, char op) throws RuntimeException {
		// TODO Auto-generated method stub
		switch (op) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/':
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌수 없습니다.");
			}
			return num1 / num2;
		case '%': 
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌수 없습니다.");
			}
			return num1 % (double)num2;
		default:
			throw new RuntimeException(op + "산술 연산자가 아닙니다.");
			}
		}
	}


