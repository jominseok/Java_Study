package day07;

public class PrimeNumberMethodEx1 {

	public static void main(String[] args) {
		// 주어진 num가 소수인지 아닌지 판별하는 코드를 작성 하세요 (메서드를 이용)
		int num = 2;
		if(isPrimeNumber(num)) {
			System.out.println(num + "소수");
		}
		else {
			System.out.println(num + "소수가 아닙니다.");
		}
		
		if(isPrimeNumber2(num)) {
			System.out.println(num + "소수");
		}
		else {
			System.out.println(num + "소수가 아닙니다.");
		}
	}
	/* 기능 : 정수가 주어지면 주어진 정수가 소수이면 소수라고 알려주고 아니면 아니라고 알려주는 매서드
	 * 매게 변수 : 정수 => int num
	 * 리턴 타입 : 소수인지 아닌지 => boolean
	 * 메서드 명 : isPrimeNumber
	 * */
	public static boolean isPrimeNumber(int num) {
		int count = 0; //약수의 개수를 저장하는 변수
		
		for(int i = 1;i < num; i++) {
			if(isDivisor(num, i)) {
				count++;
			}
		if(count ==2) {
			return true;
		}
			
		}
		
		return false;
	}
	/* 기능 : 정수 num1과 정수 num2가 주어졌을 때 num2가 num1의 약수이면 참, 아니면 거짓을 알려주는 매서드
	 * 매게변수 : 정수 num1과 정수 num2 => int num1, int num2
	 * 리턴타입 : 약수이거나 아니거나
	 * 매서드명 : isDrivisor
	 * */
	
	public static boolean isDivisor(int num1, int num2) {
		return num1 % num2 == 0;
	}
	//1과 자기 자신을 제외한 약수가 존재하면 소수가 아니고 존재하지 않으면 소수
	/* 기능 : 정수 num1과 정수 num2가 주어졌을 때 num2가 num1의 약수이면 참, 아니면 거짓을 알려주는 매서드
	 * 매게변수 : 정수 num1과 정수 num2 => int num1, int num2
	 * 리턴타입 : 약수이거나 아니거나
	 * 매서드명 : isPrimeNumber2
	 * */
	public static boolean isPrimeNumber2(int num) {
		
		for(int i = 2; i<num; i++) {
			if(isDivisor(num, i)) {
				return false;
			}
		}
		
		return num != 1;
	}
	

}
