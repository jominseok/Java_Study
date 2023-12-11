package day2;

public class IfElseEx1 {
	//if문 예쩨
	public static void main(String[] args) {
		/* ...이면 ~이다 : 조건문 
		 * ... : 조건식
		 * ~ : 실행문
		 * if(조건식){
		 * 	실행문
		 * }
		 * */
		//정수가 0이면 0이라고 출력하고, 정수가 0이 아니면 0이 아닙니다라고 출력하는 예제
		int num = 10;
		if (num == 0) {
			System.out.println(num+"은 0이 입니다.");
		}
		// if를 두번 쓰면 무조건 2번 확인
		// if else를 쓰면 num가 0이면 1번 확인, num가 0이 아니면 2번 확인
		else {
			System.out.println(num+"은 0이 아임돠~");
		}

	}

}
