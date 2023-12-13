package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/*
		 * Scanner를 이용하여 국어, 영어, 수학 성적을 입력받고
		 * 총점과 평균을 구하는 코드를 작성하세요.
		 * */ 
		
		Scanner Scan = new Scanner(System.in);
		System.out.print("수학 점수를 입력해주세요");
		int math = Scan.nextInt();
		System.out.print("국어 점수를 입력해주세요");
		int kor = Scan.nextInt();
		System.out.print("영어 점수를 입력해주세요");
		int eng = Scan.nextInt();
		
		System.out.println("수학, 국어, 영어의 총점은" + (math +kor +eng));
		System.out.println("수학, 국어, 영어의 평균은" + ((math +kor +eng)/3));
		
		//다른 방법
		System.out.println("성적 입력(국어, 영어, 수학 순) : ");
		int kor_ = Scan.nextInt();
		int eng_ = Scan.nextInt();
		int math_ = Scan.nextInt();
		
		// 성적의 총점과 평균을 계산
		int sum = kor_ + eng_ + math_;
		double avg = (double)sum / 3;
		//성적의 총점과 평균을 출력
		System.out.println("총점 : " + sum +"평균 : " + avg);
	}

}
