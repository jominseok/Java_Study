package university.service;

public class PrintServiceImp implements PrintService{

	@Override
	public void printMainmenu() {
		// 메인메뉴
		System.out.println("----------메뉴----------");
		System.out.println("1. 교수 정보");
		System.out.println("2. 학생 정보");
		System.out.println("3. 기록 조회");
		System.out.println("4. 프로그램 종료");
		System.out.println("-------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printProfessorMenu() {
		// 교수정보
		System.out.println("----------메뉴----------");
		System.out.println("1. 교수 정보 추가");
		System.out.println("2. 교수 정보 수정");
		System.out.println("3. 교수 정보 삭제");
		System.out.println("4. 이전으로");
		System.out.println("-------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printStudentMenu() {
		// 교수정보
		System.out.println("----------메뉴----------");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 수정");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 이전으로");
		System.out.println("-------------------------");
		System.out.print("메뉴 선택: ");
	}

}
