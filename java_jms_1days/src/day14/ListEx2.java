package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

	public static void main(String[] args) {
		// 정수를 5개 입력받아 입력받은 정수를 리스트에 저장하거 출력 코드를 작성하세요
		Scanner scan = new Scanner(System.in);
		//입력 받을 변수 / 입력받을 정수의 개수
		int num,count = 5;
		//System에 있는 out 인스턴스에서 제공하는 print메서드를 이용하여 콘솔창에 문자열을 출력
		System.out.print("정수 입력 : ");
		//정수를 여러개 저장하기 위해 ArrayList 인스턴스를 생성
		//정수이기 때문에 Integer를 추가. int가 안되는 이유는 제네릭은 클래스만 올수 있음
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//리스트에 값 추가하기 
		for(int i = 0; i<count; i++) {
			//scan.nextInt()를 통해 입력 버퍼에 있는 값 중 정수 값을 가져옴.
			//만약 입력 버퍼에 정수가 아닌 문자나 문자열이 있으면 예외 발생
			//가져온 정수를 tmp에 저장
			num = scan.nextInt();
			//Collection에서 제공하는 add메서드를 이용하여 리스트에 정수값을 추가
			//int인 tmp가 Integer로 박싱 되면서 리스트에 추가
			list.add(num);
		}
		
		//리스트에 있는 정수들을 반복문으로 가져와서 tmp에 저장
		//가져온 Integer의 인스턴스를 int형으로 언방싱을 함
		System.out.println(list);
		for(int tmp : list) {
			//표준 출력(콘솔 창)에 정수를 입력
			System.out.println(tmp);
		}
		
	}

}
