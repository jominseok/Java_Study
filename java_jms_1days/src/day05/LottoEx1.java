package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {
		/*
		 * 1~45사이의 랜덤한 수 6개를 생성하여 출력하는 예제를 작성하세요.
		 * 단, 정렬되도록
		 * */
		
		int min = 1, max = 45, count = 0;
		int arr1[] = new int[6];
		
		while(count < 6) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			System.out.println(r);
			boolean duplicated = false;
			for(int i = 0; i < count; i++) {
				if(r == arr1[i]) {
					duplicated = true;
					break;
				}
			}
			if(!duplicated) {
				arr1[count] = r;
				count++;
			}
		}
		// 다른 방법
		while(count < arr1.length) {
			//랜덤한 수 생성
			int r = (int) (Math.random() * (max - min + 1) - 1);
			// 중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(arr1[i] == r) {
					break;
				}
				
			}
			//중복되지 않으면 저장 후 count 증가
			if(i == count) {
				arr1[count++] = r;
			}
		}
		//출력
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
