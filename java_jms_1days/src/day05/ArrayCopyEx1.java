package day05;

import java.awt.SystemColor;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		// 배열 복사 예제
		
		int arr1 [] = new int[] {1, 2, 3, 4, 5};
		
		int arr2 [] = arr1;
		
		int arr3 [] = new int [arr1.length];
		
		int arr4 [] = new int [arr1.length];
		
		// 반복문을 이용하여 arr1에 있는 값들을 arr3에 복사
		for(int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i];
		}
		
		//System.arraycopy를 이용하여 arr1을 arr4에 전체 복사
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		
		//arr2의 0번지 내용이 10으로 출력되는걸 확인
		for(int i = 0; i < 5; i++) {
			System.out.print("arr2확인 : "+arr2[i]+"\n");
		}
		//arr3의 내용을 확인
		for(int i = 0; i < 5; i++) {
			System.out.print("arr3확인 : " + arr3[i]);
		}
		System.out.println("\n arr4 확인 : ");
		for(int i = 0; i < 5; i++) {
			System.out.print( arr4[i] + " ");
		}
		int arr5[] = new int [arr1.length];
		//arr1배얄에 1번지부터 2개를 복사해서 arr5배열에 0번지부터 덮어씀
		System.arraycopy(arr1, 1, arr5, 0, 2);
		System.out.println("\n arr5 확인 : ");
		for(int i = 0; i < 5; i++) {
			System.out.print( arr5[i] + " ");
		}
	}

}
