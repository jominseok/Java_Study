package day12;

public class AbstractEx1 {

	public static void main(String[] args) {
		// 추상 클래스 예제
		//AA추상 클래스는 추상 메서드가 없지만 추상 클래스를 이용하여 
		// 인스턴스를 생성 할 수 없음
	    // aa1 = new AA();//에러 발생
		//추상 클래스의 인스턴스를  만들려면 익명 클래스를 이용 하거나
		AA aa1 = new AA() {
			
		};
		//추상 클래스를 상속 받은 일반 클래스를 생성 해서 생성(업캐스팅)
		//AA aa2 = new CA();
	}

}


abstract class AA{
	int num;
}

abstract class AB{
	int num;
	public abstract void print();
}

//class CA extends AB{
//	
//}

class DA extends AB{
	@Override
	public void print() {
		System.err.println("num : " + num);
	}
}
