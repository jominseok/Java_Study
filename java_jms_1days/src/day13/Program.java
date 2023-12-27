package day13;

public interface Program {
	
//	int num1 = 10;//변수 앞에 final static이 자동으로 추가 // 상수이기 때문에 무조건 초기화해주기
//	final static int num2 = 20;
	
	// 메서드 앞에 public abstract가 자동으로 추가
	void printMenu();
	void runMenu(int menu);
	void printExit();
	void run();
}



abstract class TestA{
	//클래스에서는 fanal static을 생략하면 멤버변수, 붙여주면 상수
	int num1 = 10; 
	final static int num2 = 20;
	
	
	//클래스에서는 추상 매서드에 abtract가 자동으로 추가 되지 않음
	public abstract void printMenu();
}
