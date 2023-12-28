package day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class LottoEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 알려주는 코드를 작성하세요
		* 단, 컬렉션을 이용
		* 당첨번호 : 6개, 보너스 : 1개
		* 사용자 : 6개
		* 번호 범위 : 1~45
		*/
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int bonus;
		int min = 1, max = 45;
		Set<Integer> lottoList = new HashSet<Integer>();
		Set<Integer> userList = new HashSet<Integer>();
		System.out.print("당첨 번호는 : ");
		
		//로또 번호를 생성하고 출력하는 코드(중복 x)
		while(lottoList.size() < 7) {
			int j = random.nextInt(max - min + 1) + min;
			lottoList.add(j);
		}
		//보너스 번호를 생성
		List<Integer> lotto2 = new ArrayList<Integer>();
		lotto2.addAll(lottoList);
		bonus = lotto2.remove(lotto2.size() -1);
		System.out.println(lottoList + ", 보너스 : " + bonus);
		//사용자가 당첨 번호를 입력
		System.out.println("번호(중복되지 않은 6개) : ");
		while(userList.size() < 6) {
			int tmp = scan.nextInt();
			userList.add(tmp);
		}
		
		//일치하는 개수 계산
		int count = 0;
		for(int tmp : userList) {
			if(lotto2.contains(tmp)) {
				count++;
			}
		}
		//등수 출력
		switch (count) {
		case 6: {
			System.out.println("1등 입니다.");
			break;
		}
		case 5: {
			int rank = userList.contains(bonus)?2:3;
			System.out.println(rank + "등입니다.");
			break;
		}
		case 4: {
			System.out.println("4등 입니다.");
			break;
		}
		case 3: {
			System.out.println("5등 입니다.");
			break;
		}
		default:
			System.out.println("꽝입니다.");
			break;
		}
		
	
	}

}
