package day2;

import java.util.Scanner;

public class TestEx4 {

	public static void main(String[] args) {
		//성인 판별 예제
		//나이를 입력받아 나이가 20세 이상이면 성인을 출력하고
		//20세 미만이면 미성년자 출력하는 코드를 작성하시오
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요 : ");
		
		int old = scan.nextInt();
		
		System.out.println(old<20? "미성년자" : "성인");
		
		scan.close();
	}

}
