package day05;

public class ArrayInitEx1 {

	public static void main(String[] args) {
		/*
		 * 
		 * */ 
		// arr1배열에는 0부터 4번까지 0으로 초기화가 됨
		// char는 \0, 정수는 0, 실수는 0.0, boolean는 false
		int arr1[] = new int[5];
		
		//arr2는 0번지에1, 1번지에 2, 2번지에 3, ...4번지에 5가 저장
		int arr2[] = new int[] {1, 2, 3, 4, 5};
		// arr2와 같음
		int arr3[] = {1, 2, 3, 4,5};
		//arr3 = {1, 2, 3, 4, 5}// 에러가 발생
	}

}
