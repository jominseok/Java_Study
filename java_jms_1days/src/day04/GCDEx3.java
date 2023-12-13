package day04;

import java.util.List;
import java.util.Scanner;

public class GCDEx3 {
	public static void main(String[] args) {
		/*두 정수의 공약수를 출력하는 코드를 작성하세요/
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8의 약수 : 1, 2, 4, 8
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대 공약수 : 4
		 * 반복 회수 : i = 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num1과 num2의 약수이면 gcd에 i를 저장
		 * */
	Scanner scan = new Scanner(System.in);
	
	System.out.print("정수 입력");
	int num1 = scan.nextInt();
	int num2 = scan.nextInt();
	int a = 0;
	for(int i = 1; i <= num1; i++) {
		if(num1%i==0 && num2%i==0) {
			a = i;
		}
	}
	System.out.println("최대 공약수는 : "+a);
	
	//다른방법
	for(int i = num1; i >= 1; i--) {
		if(num1%i==0 && num2%i==0) {
			System.out.println("최대 공약수는 : "+a);
			break;
		}
	}
	
	}
	
}
