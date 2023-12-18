package day06;

import java.util.Scanner;

public class HomeworkEx1 {

   public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
      /* 숫자 야구게임을 구현하세요.
       * - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
       * - S : 숫자가 있고, 위치가 같은 경우
       * - B : 숫자가 있지만 위치가 다른 경우
       * - O : 일치하는 수자가 하나도 없는 경우
       * - 3S가 되면 게임이 종료
       * 
       * 예시
       * 랜덤으로 생성된 숫자 : 3 9 1
       * 입력 : 1 2 3
       * 결과 : 2B
       * 입력 : 4 5 6
       * 결과 : O
       * 입력 : 7 9 8
       * 결과 : 1S
       * 입력 : 3 1 9
       * 결과 : 1S2B
       * 입력 : 3 9 1
       * 결과 : 3S
       * 정답입니다.
       * */
	  //컴퓨터가 랜덤으로 중복 되지 않은 숫자 3개를 생성(1~9)
	   int min = 1, max = 9, count = 0;
		int com[] = new int[3];
		
		while(count < 6) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			System.out.println(r);
			boolean duplicated = false;
			for(int i = 0; i < count; i++) {
				if(r == com[i]) {
					duplicated = true;
					break;
				}
			}
			if(!duplicated) {
				com[count] = r;
				count++;
			}
		}
		//출력
		for(int i = 0; i < com.length; i++) {
			System.out.print(com[i] + " ");
		}
	   // 빈복문 : 맞출떔까지 => 스트라이크 개수가 3개 미만인 경우
		int strike, ball;
		int user[] = new int[com.length];
		do {
			// 중복 되지 않은 숫자 3개를 입력
			count = 0;
			while(count < user.length) {
				int input = scan.nextInt();
				int i;
				for(i = 0; i<count; i++) {
					//중복되지 않으면 저장 후 count증가
					if(user[i] == input) {
						break;
					}		
				}
			}
	   		// 스트라이크와 볼의 개수 계산
			strike = 0;
			ball = 0;
			for(int i = 0; i <com.length; i++) {
				for(int j=0;j<user.length; j++) {
					if(com[i] == user[j]) {
						//위치가 같으면 스트라이크
						if(i == j) {
							strike++;
						}else { //다르면 볼
							ball++;
						}
					}
				}
			}
	   		// 스트라이크와 볼의 개수를 따른 결과를 출력
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			if(strike == 0 && ball ==0) {
				System.out.print("0");
			}
			System.out.println();
		}while(strike <3);
	   	//정답입니다.
		System.out.println("정답입니다.");
	   scan.close();
   }
}
	   
	   //========================================================
//package day06;
//
//import java.util.Scanner;
//
//public class HomeworkEx1 {
//
//   public static void main(String[] args) {
//	  Scanner scan = new Scanner(System.in); 
	   
	   // 내가 하려다 실패한거
     
      //int max = 9, min = 1;
//      int num[] = new int[3];// num은 랜덤으로 생성된 숫자임
//      for(int i = 0; i < num.length; i++) {
//         num[i] = (int) (Math.random() * (max - min + 1) + 1);
//      }
//      System.out.print("랜덤으로 생성된 숫자 : ");
//      for(int i = 0; i < num.length; i++) {
//         System.out.print(num[i] + " ");
//      }
//      
//      System.out.println();
//      int inp[] = new int[3];//사용자가 입력한 숫자
//      int cnt = 0;
//      while(cnt < 3) {
//         
//         System.out.print("입력 : ");
//         for(int i = 0; i < inp.length; i++) {
//            inp[i] = scan.nextInt();
//            }
//         for(int i = 0; i < inp.length; i++) {
//            System.out.print(inp[i]);
//         }
//         cnt = 0;
//         int bol = 0;
//         int str = 0;
//         if(cnt == 3) {
//            System.out.println("결과 : 3S\n정답입니다.");
//         }
//         else {
//            for (int i = 0; i < num.length; i++) {
//               for(int j = 0; j < inp.length; j++) {
//                  if(num[i] == inp[j] && i == j) {
//                     str++;
//                     cnt++;
//                  }
//                  else if(num[i] == inp[j] && i != j) {
//                     bol ++;
//                  }
//               }
//            }
//            System.out.println("결과 : " + str + "S" + bol + "B");
//         }
//
//   }
//
//   }
//   }