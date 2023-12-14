package day05;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2 {

	public static void main(String[] args) {
		/*
		 * 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스번호),
		 * 사용자가 로또 번호를 입력하면(로또번호 6자리) 당첨 등수를 출력하는 코드를 작성해 주세요
		 * */
		int max = 46, min = 1, count = 0;
		int arr[] = new int[7];
		
		//7개짜리 배열을 만들어 로또 당첨 번호를 랜덤으로 생성 - 1번 배열
		while(count<arr.length) {
			int r = (int) (Math.random() * (max - min + 1) + 1);
			boolean duplicated = false;
			for(int i = 0; i <count; i++) {
				if(r == arr[i]) {
					duplicated = true;
					break;
				}
			}
			if(!duplicated) {
				arr[count++] = r;
		}
	}
		// 위에서 생성한 배열중 0번지부터 6개를 새로운 배열에 복사 - 2번 배열
		int arr2[] = new int[6];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[i];
		}
		//1번 배열 6번지에 있는 값을 보너스로 지정 - 보너스 번호
		int bonus = arr[6];
		//2번 배열 정렬 후 출력
		Arrays.sort(arr2);
		System.out.print("당첨번호는 : ");
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+ " ");
		}
		System.out.println("보너스번호는 : " + bonus);
		Scanner scan = new Scanner(System.in);
		int userarray[] = new int[6];
		System.out.print("입력번호 : ");
		//사용자 번호를 입력(6개)해서 배열에 저장 - 3번배열
		for(int i = 0; i < userarray.length; i++) {
			userarray[i] = scan.nextInt();
		}
		System.out.print("\n사용자 번호 확인 : ");
		for(int i = 0; i < userarray.length; i++) {
			System.out.print(userarray[i]+ " ");
		}
		scan.close();
		//당첨 개수 확인
		int cn = 0;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<userarray.length; j++) {
				if(arr[i] == userarray[j]) {
					cn+=1;
					break;//브레이크를 거는 이유는 사용자가 중복된 값을 입력할 수 있기에 방지차원
				}
			}
		}
		System.out.println("");
		System.out.println("당첨 개수는 : " + cn);
		
		//당첨 개수에 따른 등수 출력
		switch (cn) {
		case 6: {
			System.out.println("1등");
			break;
		}
		case 5: {
			int i;
			// 사용자가 입력한 번호에 보너스가 있는지 확인
			for(i = 0; i<userarray.length; i++) {
				if(bonus == i) {
					break;
				}
				//보너스 번호와 일치하는 번호가 없으면 
				if(i == userarray.length) {
					System.out.println("3등!");
				}
				else {
					System.out.println("2등!");
				}
			}
		}
		
		case 4: {
			System.out.println("4등");
			break;
		}
		case 3: {
			System.out.println("5등");
			break;
		}
		default:
			System.out.println("다음 기회에....");
			break;
		}
		

	}


}
