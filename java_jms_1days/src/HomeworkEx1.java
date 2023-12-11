import java.io.InputStream;
import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/*
		 * 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하시오
		 * 90점 이상 ~ 100이하 : A
		 * 80점 이상 ~ 90미만 : B
		 * 70점 이상 ~ 80미만 : C
		 * 60점 이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 * */ 
		System.out.print("성적을 입력해주세요 : ");
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		if(num < 0 || num > 100) {
			System.out.println("잘못된 점수");
		}
		else if(num >= 90) {
			System.out.println("A");
		}
		else if(num >= 80) {
			System.out.println("B");
		}
		else if(num >= 70) {
			System.out.println("C");
		}
		else if(num >= 60) {
			System.out.println("D");
		}
		else if(num < 60) {
			System.out.println("F");
		}
		

	}


}
