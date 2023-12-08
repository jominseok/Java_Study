package da01;

public class Variable_ex2 {

	public static void main(String[] args) {
		//정수형 변수 선언 예제
		byte num1 = 1;
		System.out.println(num1);
		// byte는 127까지 표현 가능 하기 때문에 128은 저장x
		//byte num2 = 128;
		
		// byte의 양수 표현 범위를 넘어서 오버 플로우 발생으로 -128이 됨
		byte num3 = (byte)(127 + 1);
		System.out.println(num3);
		// byte의 음수 표현 범위가 넘어서 언더 플로우가 발생하여 127이 됨.
		byte num4 = (byte)(-128 - 1);
		System.out.println(num4);
		
		int num5 = 128;
		System.out.println(num5);
		//int의 양수 표현 범위를 넘어 저장할 수 없습니다.
		//int num6 = 12345657513414;
		
		int num7 = 010;//10진수 => 8
		int num8 = 0x10;//10진수 => 16
		int num9 = 0b10;//10진수 => 2
		System.out.println(num7); 
		System.out.println(num8); 
		System.out.println(num9); 
		//큰 수로 초기화 하는 경우 기본 타입이 int이기 때문에 뒤에접미사 L을 붙여야 합니다.
		long num10 = 123143513561241455L;
		
		
	}

}
