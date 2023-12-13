package day04;

public class StarEx1 {
	
	public static void main(String[] args) {
		/*
		 * *****
		 * *****
		 * *****
		 * 위와 같이 출력되도록 작성해보시오
		 * 반복회수 : i는 1부터 3까지 1씩 증가
		 * 규칙성 : *5개 출력
		 * 		=> 반복 회수 : j는 1부터 5까지 1씩 증가
		 * 		=> 규칙성	 : * 출력 후 엔터
		 * 		   반복 회수 : j는 1부터 i까지
		 * 		   규칙성 : *을 출력
		 * 		   반복문종료 후 : 엔터
		 */ 
		for(int i = 0; i <3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
