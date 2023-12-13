package day04;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/*구구단 2단부터 9단까지 출력하는 코드 작성하세요.
		 * 반복 회수 : num은 2부터 9까지 1씩 증가
		 * 규칙성 : num단을 출력
		 * */
		
		//2단 출력하는 코드 작성
		for(int i = 1; i<=9; i++) {
			System.out.println("2 X " + i + " = " + i*2);
		}
		
		for(int i = 2; i <=9; i++) {
			System.out.println(i+"단 시작!");
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + " X " + j + " = " + i*j+"\n");
			}
		}
	}

}
