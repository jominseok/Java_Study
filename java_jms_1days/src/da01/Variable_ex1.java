package da01;

public class Variable_ex1 {

	public static void main(String[] args) {
		// 문자형 변수 선언 예제
		/* 변수 선언 방법
		 * 1. 변수를 선언만 함
		 * 변수 타입 변수명;
		 * 2. 변수를 선언 하고 초기화를 함
		 * 변수 타입 변수명 = 값;
		 * 
		 * */
		// 문자형 변수 ch1을 선언함
		char ch1;
		// 문자형 변수 ch2를 초기화함
		char ch2 = 'A';
		// 변수는 초기화 된후 사용되어야 합니다. 초기화 되지 않고 사용되면 에러가 발생합니다.
		//System.out.println(ch1);
		// 문자형 변수 출력
		System.out.println(ch2);
		// ch1 초기화
		ch1 = 'B';
		System.out.println(ch1);
		// ""는 문자열을 의미한 ""에 한글자가 들어간다고 해서 char변수 자료형이 될 수 없음
		//char ch3 = "ㄴ";
		//''안에는 한 글자가 들어가야함
		//char ch4 = '12';
		//유니코드 65에 해당하는 문자를 저장하기 때문에 역슬레쉬u형식으로 시작되는건 입력이 된다.
		char ch5 = '\u0061';
		System.out.println(ch5);
		// 아스키코드61에 해당하는 문자 저장함
		char ch6 = 61;
		System.out.println(ch6);
		//\가 들어간 문자들이 있음. \n : 엔터, \t : 탭키만큼의 공백
		//\\ : \문자 등
		char ch7 = '\n';
		System.out.println(ch7);
	}

}
