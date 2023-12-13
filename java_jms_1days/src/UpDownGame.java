import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/*
		 * Up Down 게임을 구현하세요
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새 게임
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새 게임은 업다운 게임을 시작
		 * - 최고기록 확인은 업다운 게임을 하면서 맞춘 가장 적은
		 * 	 횟수를 알려줌
		 * */
		/* 숫자 업다운 게임을 작성하세요.
		 * 랜덤으로 생성된 숫자를 맞추는 게임. 1~100
		 * 예시
		 * 랜덤으로 생성된 숫자 : 30
		 * 정수 : 50
		 * Down!
		 * 정수 : 20
		 * Up!
		 * 정수 : 30
		 * 정답!
		 * */
		Scanner scan = new Scanner(System.in);
		
		int num;
		//반복문 - 
		do {
			// 메뉴를 출력
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			// 메뉴를 선택
			num = scan.nextInt();
			// 선택한 메뉴에 따라 기능을 실행
			// 1번 메뉴 선택
			// 업다운 게임 실행
			int max = 100;
			int min = 1;
			if(num == 1) {
				// 랜덤한 수 생성
				int r =(int) (Math.random() * (max-min+1)+min);
				for(;num != r;) {
					
				}
				// 반복문
					//정수 입력
					//입력회수 1증가
					//입력한 정수와 랜덤한 수 비교후 up/down/정답 출력
				// 게임이 끝났으면 현재 횟수가 최고 기록 횟수보다 좋으면
				// 최고 기록 횟수를 현재 획수로 수정
			}
		}while(num != 3);
			
		
			
			
			
			// 2번 메뉴 선택
				// 최고 기록을 출력
			// 3번 메뉴 선택
				//프로그램 종료
	}


}
