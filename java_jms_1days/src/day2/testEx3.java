package day2;

import java.util.Scanner;

public class testEx3 {

	public static void main(String[] args) {
		//정수를 입력받아서 0인지 양수인지, 음수인지 판별하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.print("정수를 입력해주세요 : ");
		
		int num = scan.nextInt();
		
		if(num == 0) {
			System.out.println("입력받은 정수는 : "+num+"은 0입니다.");
		}
		else if(num > 0 ) {
			System.out.println("입력받은 정수는 : "+num+"은 양수 입니다.");
		}
		else if(num < 0 ) {
			System.out.println("입력받은 정수는 : "+num+"은 음수 입니다.");
		}
		scan.close();
	}

}
