package da01;

public class TypeCasting_ex1 {
	// 자동 자료형 변환 예제
	// - 작은 자료형 값을 큰 자료형으로 변환
	// - 정수를 실수로 변환할때 
	public static void main(String[] args) {
		// 리터럴 1은 타입이 int이고, num1은 타입이 double
		// 리터럴 1을 num1에 저장 하기 위해서 int를 double로 자동 형변환해서 저장
		double num1 = 1;
		System.out.println(num1);
		//리터럴 2는 타입 int이고 num2는 타입이 long
		//자동 형변환에 의해 int값 2를 long에 저장
		long num2 = 2;
		System.out.println(num2);
		
		char ch = 'a';
		int num3 =ch;
		// 'a'의 아스키 코드값인 97의 값이 저장이 됩니다.
		System.out.println(num3);
	}

}
