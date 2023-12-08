package da01;

public class Variable_ex4 {

	public static void main(String[] args) {
		//boolean 변수 선언 예제
		
		boolean isEven = true;
		System.out.println(isEven);
		//아래 코드는 논리형 변수가 이런식으로 사용 된다는걸 보여주기 위한 코드
		isEven = 2 % 2 == 0;
		System.out.println("2 is isEven number? " + isEven);
	}

}
