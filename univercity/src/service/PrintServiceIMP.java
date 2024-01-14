package service;

public class PrintServiceIMP implements PrintService {

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("------대학생 관리 프로그램------");
		System.out.println("1. 학교");
		System.out.println("2. 교수");
		System.out.println("3. 학생");
		System.out.println("4. 조회");
		System.out.println("5. 사용자 메뉴얼");
		System.out.println("6. 종료");
		System.out.println("-------------------------");
		System.out.println("메뉴 선택 : ");
	}

	public void printMenual() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("학교");
		System.out.println("===================================================");
		System.out.println("학교에서 학과와 수강 과목을(전공, 교양) 정해 줄 수 있습니다.");
		System.out.println("학교에서 학과를 등록하기 전에 교수와 학생 모두 수강 과목을 정할 수 없습니다.");
		System.out.println("과목에 교수를 배정 할 때는 과목을 먼저 만들어야 배정할 수 있습니다.");
		System.out.println("===================================================");
		
		System.out.println();
		System.out.println("교수");
		System.out.println("===================================================");
		System.out.println("교수는 자신의 학과와 수업을 정할 수 있습니다.");
		System.out.println("수업을 정하는 과정에서 다른 교수의 전공 수업을 고를 수 없습니다.");
		System.out.println("교양 수업은 다른 교수와 겹칠 수 있습니다.");
		System.out.println("교수는 자신의 수업에 학생들의 성적을 부여 할 수 있습니다.");
		System.out.println("===================================================");
		
		System.out.println();
		System.out.println("학생");
		System.out.println("===================================================");
		System.out.println("교수는 자신의 학과와 수업을 정할 수 있습니다.");
		System.out.println("수업을 정하는 과정에서 다른 교수의 전공 수업을 고를 수 없습니다.");
		System.out.println("교양 수업은 다른 교수와 겹칠 수 있습니다.");
		System.out.println("===================================================");
		
		System.out.println();
		System.out.println("조회");
		System.out.println("===================================================");
		System.out.println("학생들이 본인의 정보들을(학과, 성적, 학번, 수강 과목) 조회 할 수 있습니다.");
		System.out.println("교수들이 본인의 정보(학과, 수업 과목 등)을 확인할 수 있습니다.");
		System.out.println("교양 수업은 다른 교수와 겹칠 수 있습니다.");
		System.out.println("===================================================");
	}


	public void printShcool() {
		System.out.println();
		System.out.println("========================");
		System.out.println("1. 학과 등록");
		System.out.println("2. 학생 등록");
		System.out.println("3. 교수 등록");
		System.out.println("4. 과목 등록");
	}

	

}
