package day08;

import java.util.Scanner;

/*
 * 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램을 작성하려고 한다.
 * 이때 필요한 학생 클래스를 생성해보세요
 * */
public class Student {
	// ↓↓↓↓추상화 하는 방법
	// 멤버 변수 : 국어 성적, 영어성적, 수학성적,  학년, 반, 학생번호, 이름
	
	int kor, eng, math;
	int grade, classNum, num;
	String name;

	// 메서드 : 학생 정보 확인, 학생 성적 확인, 국어성적 수정, 수학성적 수정, 영어성적, 수정
	/* 기능 : 학생 정보(학년, 반, 번호, 이름)을 콘솔에 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printInfo
	 * */
	public void printInfo() {
		System.out.println("==================");
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("==================");
	}
	
	/* 기능 : 학생 성적(학년, 반, 번호, 이름, 국어, 영어, 수학)을 콘솔에 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printScore
	 * */
	public void printScore() {
		printInfo();
		System.out.println("국어 성적은 : "+ kor);
		System.out.println("영어 성적은 : "+ eng);
		System.out.println("수학 성적은 : "+ math);
	}
	
	/* 기능 : 국어 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 국어 성적 int korScore
	 * 리턴타입 : 없음 => void
	 * 메서드명 : setKor
	 * */
	public void setKor(int korScore) {
		System.out.print("국어 성적은 : ");
		kor = korScore;
		Scanner scan = new Scanner(System.in);
		kor = scan.nextInt();
	}
	
	/* 기능 : 영어 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 영어 성적 int engScore
	 * 리턴타입 : 없음 => void 
	 * 메서드명 : setEng
	 * */
	public void setEng(int engScore) {
		System.out.print("영어 성적은 : ");
		eng = engScore;
		Scanner scan = new Scanner(System.in);
		eng = scan.nextInt();
	}
	
	/* 기능 : 수학 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 수학 성적 int mathScore
	 * 리턴타입 : 없음 => void 
	 * 메서드명 : setMath
	 * */
	public void setMath(int mathScore) {
		System.out.print("수학 성적은 : ");
		math = mathScore;
		Scanner scan = new Scanner(System.in);
		math = scan.nextInt();
	}
}
