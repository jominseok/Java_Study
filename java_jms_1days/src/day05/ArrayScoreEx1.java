package day05;

import java.util.Scanner;

public class ArrayScoreEx1 {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 국어 성적을 입력 받고, 총점과 평균을 구하는 평균을 구하는 코드를 작성하시오
		 * */ 
		Scanner scan = new Scanner(System.in);
		
		int[] korScores = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("학생 " + (i+1) + "의 점수 입력 : ");
			korScores[i] = scan.nextInt();
			sum +=korScores[i];
		}
		double avg = (double)sum / korScores.length;
		System.out.println("학생 5명의 총점 : " + sum + "평균 : " + avg);

	}

}
