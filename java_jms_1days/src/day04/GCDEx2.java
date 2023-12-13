package day04;

import java.util.Scanner;

public class GCDEx2 {

	public static void main(String[] args) {
		/*두 정수의 공약수를 출력하는 코드를 작성하세요/
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8의 약수 : 1, 2, 4, 8
		 * 8과 12의 공약수 : 1, 2, 4
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		for(int i = 1; i <= num1; i++) {
			if(num1%i==0 && num2%i==0) {
				System.out.println(i);
			}
		}
		// Scanner 사용 안하고 해보기
		int num3 = 8, num4 =12;
		for(int i = 1; i <= num3;i++) {
			if(num3%i==0 && num4%i==0) {
				System.out.println(i);
			}
		}
		//결과값 한줄로 나오게 하기
		for(int i = 1; i <= num3;i++) {
			if(num3%i==0 && num4%i==0) {
				System.out.print((i == 1) ? "" : ", " + i);
			}
		}
		
	}

}
