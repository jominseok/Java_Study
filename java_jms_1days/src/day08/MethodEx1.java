package day08;

public class MethodEx1 {

	public static void main(String[] args) {
		/*재귀 매서드를 이영하여 스택 오버플로우가 발생하는 예제*/
		recursive();
	}
	
	public static void recursive() {
		System.out.println("재귀 메서드입니다.");
		recursive();
	}

}
