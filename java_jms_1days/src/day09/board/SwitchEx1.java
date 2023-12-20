package day09.board;

public class SwitchEx1 {

	public static void main(String[] args) {
		// Switch문 안에 지역변수를 선언하는 경우 발생할 수 있는 문제점
		
		for(int i = 0; i<5; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		for(int i = 0; i < 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int menu = 1;
		switch (menu) {
		case 1: {
			//여기서 선언된num가 break문이 없으면 case2까지 
			//갈수 있기때문에 여기서 선언된 num는 이후 switch
			//아래코드에서 사용할 수 있음
			int num = 10;
			System.out.println(num);
			break;
		}
		case 2 : {
			//int num = 20;//을 하면 위에서 선언된 num와 중복. 에러 발생
			int num = 20;
			System.out.println(num);
			break;
		}
		default:
			
		}
	}

}
