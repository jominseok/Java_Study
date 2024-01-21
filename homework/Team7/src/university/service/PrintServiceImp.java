package university.service;

import java.util.Scanner;

public class PrintServiceImp implements PrintService {
	static Scanner scan= new Scanner(System.in);

	// 프로그램 시작시 포지션 선택 메뉴 출력 메서드
	@Override
	public void printPositionMenu() {
		System.out.println("---메뉴---");
		System.out.println("1.학교 관리자");
		System.out.println("2.교수");
		System.out.println("3.학생");
		System.out.println("4.종료");
		System.out.println("---------");
		System.out.print("메뉴 선택 : ");
	}

	// 관리자 메뉴 선택시 메뉴 출력 메서드
	@Override
	public void printManagerMenu() {
		System.out.println("--관리자 메뉴--");
		System.out.println("1.교수 관리");
		System.out.println("2.학생 관리");
		System.out.println("3.수업 관리");
		System.out.println("4.뒤로가기");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");		
	}

	// 교수 메뉴 선택시 메뉴 출력 메서드
	@Override
	public void printProfessorMenu() {
		System.out.println("--교수 메뉴--");
		System.out.println("1.수강생 조회");
		System.out.println("2.성적 입력");
		System.out.println("3.성적 수정");
		System.out.println("4.석차 조회");		
		System.out.println("5.뒤로가기");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	// 학생 메뉴 선택시 메뉴 출력 메서드
	@Override
	public void printStudentMenu() {
		System.out.println("--학생 메뉴--");
		System.out.println("1.수강신청");
		System.out.println("2.수강취소");
		System.out.println("3.수강수업 조회");
		System.out.println("4.성적조회");
		System.out.println("5.뒤로가기");
		System.out.println("-----------");
		System.out.print("메뉴 선택 :");
		
	}

	// 관리자의 교수 관리 메뉴 출력 메서드
	@Override
	public void printMangerProfessorMenu() {
		 System.out.println("--교수 관리 메뉴--");
		 System.out.println("1.교수 등록");
		 System.out.println("2.교수 수정");
		 System.out.println("3.교수 삭제");
		 System.out.println("4.교수 조회");
		 System.out.println("5.뒤로가기");
		 System.out.println("--------------");
		 System.out.print("메뉴 선택 : ");
		
	}

	// 관리자의 학생 관리 메뉴 출력 메서드
	@Override
	public void printManagerStudentMenu() {
		System.out.println("--학생 관리 메뉴--");
		System.out.println("1.학생 등록");
		System.out.println("2.학생 수정");
		System.out.println("3.학생 삭제");
		System.out.println("4.학생 조회");
		System.out.println("5.뒤로가기");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
		
	}
	

	// 관리자의 수업 관리 메뉴 출력 메서드
	@Override
	public void printManagerLessonMenu() {
		System.out.println("--수업 관리 메뉴--");
		System.out.println("1.수업 등록");
		System.out.println("2.수업 수정");
		System.out.println("3.수업 삭제");
		System.out.println("4.뒤로가기");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
		
	}

	// 관리자가 교수 조회시 메뉴 출력하는 메서드
	@Override
	public void printMangerProfessorSelectMenu() {
		System.out.println("--조회 선택--");
		System.out.println("1.전체 조회");
		System.out.println("2.과별 조회");
		System.out.println("3.이름 조회");
		System.out.println("4.뒤로가기");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}
	

	// 관리자가 학생 조회시 메뉴 출력하는 메서드
	@Override
	public void printManagerStudentSelectMenu() {
		System.out.println("--조회 선택--");
		System.out.println("1.전체 조회");
		System.out.println("2.과별 조회");
		System.out.println("3.학번 조회");
		System.out.println("4.뒤로가기");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
		
	}

	
	

	

}
