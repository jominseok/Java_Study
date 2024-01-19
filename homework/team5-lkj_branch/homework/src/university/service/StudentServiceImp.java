package university.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentServiceImp implements StudentService {

	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void runStudent() {
		int menu = 0;
		switch(menu) {
		case 1: 
					addStudent();
					break;
		case 2: 
					setStudent();
					break;
		case 3: 
					removeStudent();
					break;
		case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
		default:
					throw new InputMismatchException();
		}
	}
	private void removeStudent() {
		System.out.print("삭제할 학생 정보: ");
		scan.nextLine();
		String info = scan.nextLine();
		/*if(학생정보 저장소.removeInfo(info)) {//학생정보 저장소가 필요
				System.out.println("학생 정보를 삭제하였습니다.");
		}else {
				System.out.println("존재하지 않는 학생 정보 입니다.");
		}*/
	}
	private void setStudent() {
		System.out.print("수정할 학생 정보: ");
		scan.nextLine();
		String beforeInfo = scan.nextLine();
		System.out.print("변경한 학생 정보: ");
		String afterInfo = scan.nextLine();
		/*if(학생정보 저장소.setInfo(befortInfo, afterInfo)) {//학생 정보 저장소가 필요
				System.out.println("학생 정보를 수정했습니다.");
		}else {
					System.out.println("학생 정보 수정에 실패했습니다.");
		}*/
	}
	private void addStudent() {
		System.out.print("정보(교수/학생): ");//임시
		scan.nextLine();
		String info = scan.nextLine();
		//List<Student> studentList = new ArratList<Student>();학생 정보를 저장할 리스트 작성필요
		char isContinue = 'n';
		do {
				System.out.print("학생 학번(20240000): ");
				int num = scan.nextInt();
				System.out.print("학생 이름: ");
				String name = scan.next();
				System.out.print("학생 전공: ");
				String major = scan.next();
				
				//StudentList.add(new Student(num, name, major));학생 정보를 저장할 리스트 작성필요
				System.out.print("학생 정보를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
		}while(isContinue == 'y');
		/*if(학생정보 저장소 == null) {//학생 정보 저장소를 만든 후 작성완료
				System.out.println("등록된 학생 정보가 없습니다.");
				return;
		}
		if(학생정보 저장소.addStudent(num, name, major)) {
				System.out.println("학생 정보를 추가했습니다.");
		}else {
			System.out.println("중복된 학생 정보입니다.");
		}*/
	}

}
