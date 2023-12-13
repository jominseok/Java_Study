package day04;

import java.util.Scanner;

public class LcmEx1 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 10의 배수 : 10, 20 ,30 ....
		 * 15의 배수 : 15, 30, 45 ....
		 * 10과 15의 공배수 : 30, 60, 90, ....
		 * 10과 15의 최소 공배수
		 * 반복회수 : i는 1부터 num1 * num2까지 1씩 증가
		 * 규칙성 : i가 num1과 num2의 공배수이면 i출력하고 반복문 종료
		 * 		=>i가 num1의 배수이고, i가 num2의 배수이면 i를 출력하고 반복문 종료
		 * 		=>i를 num1으로 나누었을 때 나머지가 0과 같고 i를 num2로 나누었을때 나머지가 0과 같다면
		 * 		i를 출력 
		 * */
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("두 정수를 입력하세요 : ");
//		int num1 = scan.nextInt();
//		int num2 = scan.nextInt();
//		int i = 0;
//		while(true) {
//			if(num1%i == 0 && num2%i == 0) {
//				System.out.println(i);
//				break;
//			}
//		}
		// 정답
		
		int num3 = 10, num4 = 15;
		for(int j = 1; j <= num3*num4; j++) {
			System.out.println(j);
			if(j%num3 == 0 && j%num4 == 0) {
				System.out.println(j);
				break;
			}
		}
		
		//i가 num1부터 num1씩 증가 => i를 num1의 배수들로만 계산함
		for(int j = num3; j <= num3*num4; j+=num3) {
			System.out.println(j);
			if(j%num4 == 0) {
				System.out.println(j);
				break;
			}
		}
	}

}
