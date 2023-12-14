package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {
		/*1에서 9사이의 정수를 5개 입력받아 각 숫자가 몇개씩 입력했는지 출력하는 코드를 작성하세요
		 * 1 2 3 1 2
		 * 1 : 2
		 * 2 : 2
		 * 3 : 1
		 * 4 : 0
		 * 5 : 0
		 * 6 : 0
		 * 7 : 0
		 * 8 : 0
		 * 9 : 0
		 * */
		int user[] = new int[5];
		int num[] = new int[10];
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자5개를 입력해주세요.");
		for (int i = 0; i < user.length; i++) {
			user[i] = scan.nextInt();
		}
		for(int i = 1; i <= 9; i++) {
			int k = 0;
			for(int j = 0; j<user.length; j++) {
				if(i == user[j]) {
					k++;
				}
			}
			num[i] = k;
		}
		for(int i = 1; i < num.length; i++) {
			System.out.println((i) + " : " + num[i]+ "개");
		}
		
	}

}
