package day07;

public class MethodEx1 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		int result = sum(num1, num2);
		System.out.println(num1+" + "+num2+" = "+result);
		System.out.println(sum(num1, num2));
	}
	
	
	/* 두 정수의 합을 알려주는 메서드
	 * 메개 변수 : 두 정수 => int num1, int num2
	 * 리턴 타입 : 정수의 합 =? 정수 => int
	 * 메서드 명 : sum
	 * */
	public static int sum(int num1, int num2) {
		//구현;
		int result = num1 + num2;
		return result;
	}
}
