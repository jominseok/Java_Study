package day02;

public class IfElseIfEx1 {
	
	//if else if문 예제
	public static void main(String[] args) {
		
		int num = 3;
		
		//num가 0이면 0이라고 출력하고, num가 양수이면 양수라고 출력하고 num가 음수이면 음수라고 출력하는 코드 작성
		//코드를 작성하세요
		if(num == 0) {
			System.out.println("0입니다.");
		}
		else if(num > 0) {
			System.out.println("양수입니다.");
		}
		else if(num < 0) {
			System.out.println("음수입니다.");
		}

	}

}
