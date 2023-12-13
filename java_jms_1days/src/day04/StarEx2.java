package day04;

public class StarEx2 {

	public static void main(String[] args) {
		/*
		 * 다음과 같이 출력 되도록 코드를 작성하시오
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 *  8 = i개 출력
		 * 		=> 반복 회수 : j는 1부터 5까지 1씩 증가
		 * 		=> 규칙성	 : * 출력 후 엔터
		 * 		   반복 회수 : j는 1부터 i까지
		 * 		   규칙성 : *을 출력
		 * 		   반복문종료 후 : 엔터
		 * */ 
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
