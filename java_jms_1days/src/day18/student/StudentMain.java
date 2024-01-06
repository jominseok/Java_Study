package day18.student;

public class StudentMain {

	/* 학생 관리 프로그램을 구현 하세요
	 * - 기능
	 *   - 학생 등록
	 *   - 학생 목록 조회
	 *   - 종료
	 * - Student 클래스를 생성해서 구현
	 * 	 - 학년, 반, 번호, 이름
	 * - 소켓 통신을 이용해서 학생 정보를 서버에 저장, 불러와서 조회
	 * */
	
	public static void main(String[] args) {
		StudentProgram sp = new StudentProgram();
		sp.run();
	}

}
