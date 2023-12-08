package da01;

public class Variable_ex5 {
	// String 선언 예제
	public static void main(String[] args) {
		
		String str1 = null;
		System.out.println(str1);
		
		// int num1 = null; 기본형 변수는 null로 초기화를 할 수 없지만 참조형에는 가능 하다.
		String str2 = "Hello";
		System.out.println(str2);
		//String 클래스에 문자를 저장 할 수 없다.
		//""는 가능 하지만 ''는 안된다.
		//String str3 = 'A';
		String str4 = "A";
		System.out.println(str4);
		
		//string class에 빈 문자열 저장 가능하다.
		String str5 = "";
		System.out.println(str5);
		// 문자열에 정수 또는 실수 또는 논리값을 더하면 문자열이 됨
		// 빈 문자열 + A는 "A"가 되어서 저장이 가능함
		String str6 = "가나다라마바사"+ 'A';
		System.out.println(str6);
	}

}
