package day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LombokEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test(1,2);
		t.print();
		t.setNum1(10);
		System.out.println(t.getNum1());
		System.out.println(t);

	}

}


@Data//내 기준 약간 파이썬이랑 비슷하게 만들어주는 친구
@AllArgsConstructor//모든 멤버들이 매개변수로 들어간 생성자를 생성
@NoArgsConstructor//기본 생성자 추가
class Test{
	private int num1;
	private int num2;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
	}
}