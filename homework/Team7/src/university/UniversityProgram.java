package university;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import university.Professor;
import university.Student;
import university.service.PrintService;
import university.service.PrintServiceImp;

public class UniversityProgram implements Program {
	public School school=new School();
	public Scanner scan= new Scanner(System.in);
	public PrintService printService=new PrintServiceImp();
	static final int EXIT=4;

	// 전체 실행 메서드
	@Override
	public void run() {
		System.out.println("kh대학교 프로그램을 실행합니다.");
		int menu=0;
		do {
			printService.printPositionMenu(); //메뉴 출력
			try {
				menu=scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴를 입력했습니다.");
				scan.nextLine();
			}
		}while(menu!=EXIT);
	}

	// 주메뉴(포지션 메뉴) 실행 메서드
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 :
			//학교 기능
			manager(); // 최지용
			break;	
		case 2 :
			//교수 기능
			professor(); // 최병호
			break;
		case 3 :
			//학생 기능
			student(); // 조민석
			break;		
		case 4 :
			System.out.println("프로그램을 종료합니다.");
			return;		
		default :
			throw new InputMismatchException();
		}		
	}

	// 학생 신분 선택시 실행 메서드: 조민석
		private void student() {
			
			try {
				printService.printStudentMenu();
				int menu = scan.nextInt();
				studentRun(menu);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	 

		
		//조민석
		private void studentRun(int menu) {
			switch (menu) {
			case 1: {
				//수강 신청
				//자신의 이름, 학번, 과를 입력합니다.
				System.out.print("이름 : ");
				String name = scan.next();
				System.out.print("과 : ");
				String selection = scan.next();
				System.out.print("학번 : ");
				int classOf = scan.nextInt();
				//수강 과목이 뭐뭐가 있는지 조회 합니다.
				Lesson ls = new Lesson();
				ls.toString();
				//수강 신청 시작
				System.out.print("수강하고 싶은 과목 이름을 입력해주세요 : ");
				//과목을 입력 받음
				
				//엔터처리
				scan.nextLine();
				String subject = scan.nextLine();
				
				//shcool 클래스에서 불러옴
				school.Enrolment(classOf, subject);
				break;
			}
			case 2: {
				//수강 취소
				school.deleteEnrolment();
				break;
			}
			case 3: {
				//수강 수업 조회
				school.selectEnrolment();
				break;
			}
			case 4: {
				//성적 조회
				school.setScore();
				break;
			}
			case 5: {
				System.out.println("뒤로 되돌아 갔습니다.");
				break;
			}
			default:
				throw new InputMismatchException();
			}
			
		}

	//교수기능
	private void professor() {
		System.out.print("교번 입력:");
		int classOf=scan.nextInt();
		//해당교수가 맞는지 확인
		if(school.professorEquals(classOf)) {
			printService.printProfessorMenu();//메뉴 출력
			int menu=scan.nextInt();
			runProfessorMenu(menu,classOf);//메뉴 실행,교번도 전송
		}else {
			System.out.println("없는 교번 입니다. 다시 입력해주세요.");
		}
	}
	
	//메뉴 실행 : 최병호
    private void runProfessorMenu(int menu, int classOf) {
		switch (menu) {
		case 1: //수강생 조회
			printLessonStudent(classOf);
			break;
		case 2: //성적입력
			addScore(classOf);
			break;
		case 3: //성적수정
			setScore(classOf);
			break;
		case 4: //석차조회
			selectStudentScore(classOf);
			break;
		case 5: //뒤로가기
			System.out.println("뒤로 돌아갑니다");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	//석차조회
	private void selectStudentScore(int classOf) {
			
	}

	//성적 수정
	private void setScore(int classOf) {
					
	}
	
	//성적 추가
	private void addScore(int classOf) {
		System.out.print("성적을 추가할 학번:");
		int num=scan.nextInt();
		System.out.print("성적 입력:");
		int score=scan.nextInt();
		school.addScore(classOf,score,num);			
	}
	
	//수강생 조회/오류
	private void printLessonStudent(int classOf) {
		school.selectLessonStudent(classOf);
	}
	
	// 관리자 기능 실행 메서드 : 최지용
	private void manager() {
		System.out.println("관리자님 환영합니다.");
		System.out.println("다음 메뉴를 선택하세요.");
		printService.printManagerMenu();
		try {
			int managerMenu = scan.nextInt();
			runManagerMenu(managerMenu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴를 입력했습니다.");
			scan.nextLine();
		}
	}
		
	// 관리자가 선택한 메뉴 실행 메서드 : 최지용
	public void runManagerMenu(int managerMenu) {
		switch(managerMenu) {
		case 1 :
			professorManage(); // 교수 관리
			break;
		case 2 :
			studentManage(); // 학생 관리
			break;
		case 3 :
			classManage(); // 수업 관리
			break;
		case 4 :
			return;        // 뒤로가기
		default :
			throw new InputMismatchException();
		}	
	}
	
	// 관리자의 교수 관리 실행 메서드 : 최지용
	public void professorManage() {
		System.out.println("관리자님이 교수 관리 기능을 선택하셨습니다.");
		printService.printMangerProfessorMenu();
		try {
			int managerProfessorMenu=scan.nextInt();
			runManagerProfessorMenu(managerProfessorMenu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴를 입력했습니다.");
			scan.nextLine();
		}	
	}
	
	// 관리자의 교수 관리 메뉴 실행 메서드 : 최지용
	public void runManagerProfessorMenu(int managerProfessorMenu ) {
		switch(managerProfessorMenu) {
		case 1 :
			addProfessor(); // 교수 등록
			break;
		case 2 :
			setProfessor(); // 교수 수정
			break;		
		case 3 :
			deleteProfessor(); // 교수 삭제
			break;
		case 4 :
			selectProfessor(); // 교수 조회
			break;
		case 5 :
			return;            // 뒤로가기
		default:
			throw new InputMismatchException();
		}	
	}
	 
	// 관리자의 교수 등록 메서드 : 최지용
	public void addProfessor() {
		System.out.println("교수 등록 기능을 실행합니다.");
		System.out.println("새로 등록할 교수의 정보를 입력하세요.");
		System.out.print("교번 : ");
		int classOf= scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("과 : ");
		String selection = scan.nextLine();
		if(school.addProfessor(classOf,name,selection)) {
			System.out.println("교수등록이 완료됐습니다.");
		}else {
			System.out.println("이미 등록된 교번입니다.");
		}	
	}
	
	// 관리자의 교수 수정 메서드 : 최지용
	public void setProfessor() {
		System.out.println("교수 수정 기능을 실행합니다.");
		System.out.println("수정할 교수의 정보를 입력하세요.");
		System.out.print("교번 : ");
		int classOf = scan.nextInt();
		if(!school.professorEquals(classOf)) {
			System.out.println("없는 교번입니다. 다시 입력해주세요.");
			return;
		}		
		System.out.println("수정할 정보들을 입력하세요."); // 교번은 수정하지 않는다
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("과 : ");   
		String selection = scan.nextLine();
		school.setProfessor(classOf,name,selection);

	}
		
	
	
	// 관리자의 교수 삭제 메서드 : 최지용
	public void deleteProfessor() {
		System.out.println("교수 삭제 기능을 실행합니다.");
		System.out.println("삭제할 교수의 정보를 입력하세요.");
		System.out.print("교번 : ");
		int classOf = scan.nextInt();
		if(!school.professorEquals(classOf)) {
			System.out.println("없는 교번입니다. 다시 입력해주세요.");
			return;
		}
		school.remove(classOf);
	}
	
	
	// 관리자의 교수 조회 메서드 : 최지용
	public void selectProfessor() {
		System.out.println("교수 조회 기능을 실행합니다.");
		System.out.println("조회하실 방법을 선택해주세요.");
		printService.printMangerProfessorSelectMenu();
		int managerProfessorSelectMenu= scan.nextInt();
		runManagerProfessorSelectMenu(managerProfessorSelectMenu);		
	}
	
	// 관리자의 교수 조회 메뉴 실행 메서드 : 최지용
	public void runManagerProfessorSelectMenu(int menu) {
		switch(menu) {
		case 1 :
			selectAllProfessor(); // 교수 전체 조회
			break;
		case 2 :
			selectProfessorBySelection(); // 과별 교수 조회
			break;
		case 3 :
			selectProfessorByName(); // 이름으로 교수 조회
			break;
		case 4:
			return; // 뒤로가기
		default :
			throw new InputMismatchException();		
		}
	}
	
	// 관리자의 교수 전체 조회 메서드 : 최지용  /오류
	public void selectAllProfessor() {
		System.out.println("교수 전체 조회 기능을 실행합니다.");
		school.selectAllProfessor();
	}
	
	// 관리자의 과별 교수 조회 메서드 : 최지용 /오류
	public void selectProfessorBySelection() {
		System.out.println("과별 교수 조회 기능을 실행합니다.");
		System.out.println("조회할 과를 입력하세요.");
		System.out.print("과 : ");
		scan.nextLine();
		String selection = scan.nextLine();
		school.selectProfessorBySelection(selection);
	}
	
	// 관리자의 이름별 교수 조회 메서드(동명이인이면 모두 조회) : 최지용 /오류
	public void selectProfessorByName() {
		System.out.println("이름별 교수 조회 기능을 실행합니다.");
		System.out.println("조회하실 교수님의 이름을 입력하세요.");
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		school.selectProfessorByName(name);
	}
	
	// 관리자의 학생 관리 실행 메서드 : 최지용
	public void studentManage() {
		System.out.println("관리자님이 학생 관리 기능을 선택하셨습니다.");
		printService.printManagerStudentMenu();
		try {
		int managerStudentMenu= scan.nextInt();
		runManagerStudentMenu(managerStudentMenu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴를 입력했습니다.");
			scan.nextLine();
		}
	}
	
	// 관리자의 학생 관리 메뉴 실행 메서드 : 최지용
	public void runManagerStudentMenu(int managerStudentMenu) {
		switch(managerStudentMenu) {
		case 1 :
			addStudent(); // 학생 등록
			break;
		case 2 :
			setStudent(); // 학생 수정
			break;
		case 3 :
			deleteStudent(); // 학생 삭제
			break;
		case 4 :
			selectStudent(); // 학생 조회
			break;
		case 5 :
			return;        // 뒤로가기
		default :
			throw new InputMismatchException();
		}
	}
	
	// 관리자의 학생 등록 메서드 : 최지용
	public void addStudent() {
		System.out.println("학생 등록 기능을 실행합니다.");
		System.out.println("새로 등록할 학생의 정보를 입력하세요.");
		System.out.print("학번 : ");
		int classOf= scan.nextInt();
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		scan.nextLine();
		System.out.print("과 : ");
		String selection = scan.nextLine();
		
		school.addStudent(classOf,name,selection);
	}
	
	// 관리자의 학생 수정 메서드 : 최지용
	public void setStudent() {
		System.out.println("학생 수정 기능을 실행합니다.");
		System.out.println("수정할 학생의 정보를 입력하세요.");
		System.out.print("학번 : ");
		int classOf = scan.nextInt();
		if(!school.studentEquals(classOf)) {
			System.out.println("없는 학번입니다. 다시 입력해주세요.");
			return;
		}
		school.setStudent(classOf);
	}
	
	// 관리자의 학생 삭제 메서드 : 최지용
	public void deleteStudent() {
		System.out.println("학생 삭제 기능을 실행합니다.");
		System.out.println("삭제할 학생의 정보를 입력하세요.");
		System.out.print("학번 : ");
		int classOf = scan.nextInt();
		if(!school.studentEquals(classOf)) {
			System.out.println("없는 학번입니다. 다시 입력해주세요.");
			return;
		}
		school.deleteStudent(classOf);
	}
	
	// 관리자의 학생 조회 메서드 : 최지용
	public void selectStudent() {
		System.out.println("학생 조회 기능을 실행합니다.");
		System.out.println("조회하실 방법을 선택해주세요.");
		printService.printManagerStudentSelectMenu();
		int managerStudentSelectMenu= scan.nextInt();
		runManagerStudentSelectMenu(managerStudentSelectMenu);		
	}
	
	// 관리자의 학생 조회 메뉴 실행 메서드 : 최지용
	public void runManagerStudentSelectMenu(int menu) {
		switch(menu) {
		case 1 :
			selectAllStudent(); // 학생 전체 조회
			break;
		case 2 :
			selectStudentBySelection(); // 과별 학생 조회
			break;
		case 3 :
			selectStudentByName(); // 학번으로 학생 조회
			break;
		case 4:
			return; // 뒤로가기
		default :
			throw new InputMismatchException();		
		}
	}
	
	// 관리자의 학생 전체 조회 메서드 : 최지용  /오류
	public void selectAllStudent() {
		System.out.println("학생 전체 조회 기능을 실행합니다.");
		school.selectAllStudent();
	}
	
	// 관리자의 과별 학생 조회 메서드 : 최지용 /오류
	public void selectStudentBySelection() {
		System.out.println("과별 학생 조회 기능을 실행합니다.");
		System.out.println("조회할 과를 입력하세요.");
		System.out.print("과 : ");
		scan.nextLine();
		String selection = scan.nextLine();
		school.selectStudentBySelection(selection);
	}
	
	// 관리자의 학번별 학생 조회 메서드(학생은 동명인이 많을 수 있어서 학번으로 조회하기로 함) : 최지용 /오류
	public void selectStudentByName() {
		System.out.println("학번별 학생 조회 기능을 실행합니다.");
		System.out.println("조회하실 학생의 학번을 입력하세요.");
		System.out.print("학번 : ");
		int classOf = scan.nextInt();
		school.selectStudentByName(classOf);
	}
	
	// 관리자의 수업 관리 실행 메서드 : 최지용
	public void classManage() {
		System.out.println("관리자님이 수업 관리 기능을 선택하셨습니다.");
		printService.printManagerLessonMenu();
		try {
		int managerLessonMenu=scan.nextInt();
		runManagerLessonMenu(managerLessonMenu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴를 입력했습니다.");
			scan.nextLine();
		}
	}
	
	// 관리자의 수업 관리 메뉴 실행 메서드 : 최지용
	public void runManagerLessonMenu(int managerLessonMenu) {
		switch(managerLessonMenu) {
		case 1:
			addLesson(); // 수업 등록
			break;
		case 2 :
			setLesson(); // 수업 수정
			break;
		case 3 :
			deleteLesson(); // 수업 삭제
			break;
		case 4 :
			return;        // 뒤로가기
		default :
			throw new InputMismatchException();
		}		
	}
			
	// 관리자의 수업 등록 메서드 : 최병호
	public void addLesson() {
		System.out.print("등록할 강의명:");
		scan.nextLine();
		String subject=scan.nextLine();
		System.out.print("담당 교수교번:");
		int professor=scan.nextInt();
		System.out.print("강의실:");
		int classRoom=scan.nextInt();
		System.out.print("해당 요일:");
		String dayOfWeek=scan.next();
		System.out.print("강의 시작시간:");
		int sTime=scan.nextInt();
		System.out.print("강의 종료시간:");
		int eTime=scan.nextInt();
		System.out.print("최대 정원:");
		int max=scan.nextInt();
		school.addLesson(subject,professor,
				classRoom,dayOfWeek,sTime,eTime,max);
	}
	
	// 관리자의 수업 수정 메서드 : 최지용
	public void setLesson() {
		
	}
	
	// 관리자의 수업 삭제 메서드 : 최지용
	public void deleteLesson() {
		
	}
	
	
}

