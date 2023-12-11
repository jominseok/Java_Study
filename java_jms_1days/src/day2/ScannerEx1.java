package day2;

import java.util.Scanner;

public class ScannerEx1 {
	
	//콘솔창에서 정수, 실수, 믄자, 문자열을 입력받는 예제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//정수 입력받는 예제
		System.out.println("정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.println("입력받은 정수 : " + num1);
		
		//한 단어 입력받는 예제
		//스페이스 공백 엔터등 모두 제외하고 맨 앞 한 단어만 가지고 옴
		System.out.println("한 단어를 입력하세요");
		String str1 = scan.next();
		System.out.println("입력받은 단어 : " + str1);
		
		// 실수 입력받기
		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextFloat();
		System.out.println("입력받은 실수 : " + num2);
		
		// 한문장 입력받는 예제
		System.out.println("한 문장을 입력하세요");
		scan.nextLine();//실수 다음에 입력한 엔터를 처리
		String str2 = scan.nextLine();
		System.out.println("입력받은 문장 : " + str2);
		
		// 문자를 입력받는 예제
		System.out.println("문자를 입력하세요 : ");
		//"문자열".charAt(번지) : 번지번째에 있는 문자를 가져옴
		char ch = scan.next().charAt(0);
		System.out.println("입력받은 문자 : " + ch);
		scan.close();

	}

}
