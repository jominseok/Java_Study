package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		// 속담을 입력받아 저장하고 출력하는 코드를 작성하세요
		Scanner scan = new Scanner(System.in);
		String str;
		int count = 2;
		ArrayList<String> list = new ArrayList<String>();
		
		//리스트에 값을 추가하는 여러가지 방법
		do {
			System.out.println("속담을 입력하세요. (종료하려면 -1) : ");
			str = scan.nextLine();
			list.add(str);
		} while (!str.equals("-1"));
		//--------------------------
		while (true) {
			System.out.println("속담을 입력하세요. (종료하려면 -1) : ");
			str = scan.nextLine();
			if(!str.equals("-1")) {
				break;
			}
			list.add(str);
		}
		//-------------------------------
		for(int i = 0; i <count ; i++) {
			System.out.print("속담을 입력해 주세요 : ");
			str = scan.nextLine();
			list.add(str);
		}
		//리스트값 출력
		for(String tmp: list) {
			System.out.println(tmp);
		}
		//System.out.println(list);

	}

}
