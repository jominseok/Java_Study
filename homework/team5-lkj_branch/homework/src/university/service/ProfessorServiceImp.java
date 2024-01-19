package university.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProfessorServiceImp implements ProfessorService {
	
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void runProfessor() {
		int menu = 0;
		switch(menu) {
		case 1: 
					addProfessor();
					break;
		case 2: 
					setProfessor();
					break;
		case 3: 
					removeProfessor();
					break;
		case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
		default:
					throw new InputMismatchException();
		}
	}
	private void removeProfessor() {
		System.out.print("삭제할 교수 정보: ");
		scan.nextLine();
		String info = scan.nextLine();
		/*if(교수정보 저장소.removeInfo(info)) {//교수정보 저장소가 필요
				System.out.println("교수 정보를 삭제하였습니다.");
		}else {
				System.out.println("존재하지 않는 교수 정보 입니다.");
		}*/
	}
	private void setProfessor() {
		System.out.print("수정할 교수 정보: ");
		scan.nextLine();
		String beforeInfo = scan.nextLine();
		System.out.print("변경한 교수 정보: ");
		String afterInfo = scan.nextLine();
		/*if(교수정보 저장소.setInfo(befortInfo, afterInfo)) {//교수 정보 저장소가 필요
				System.out.println("교수 정보를 수정했습니다.");
		}else {
					System.out.println("교수 정보 수정에 실패했습니다.");
		}*/
	}
	private void addProfessor() {
		System.out.print("정보(교수/학생): ");//임시
		scan.nextLine();
		String info = scan.nextLine();
		//List<Professor> professorList = new ArratList<Professor>();교수 정보를 저장할 리스트 작성필요
		char isContinue = 'n';
		do {
				System.out.print("교수 연구실: ");
				String lab = scan.next();
				System.out.print("교수 이름: ");
				String name = scan.next();
				System.out.print("교수 전공: ");
				String major = scan.next();
				
				//professorList.add(new Professor(lab, name, major));교수 정보를 저장할 리스트 작성필요
				System.out.print("교수 정보를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
		}while(isContinue == 'y');
		/*if(교수정보 저장소 == null) {//교수 정보 저장소를 만든 후 작성완료
				System.out.println("등록된 교수 정보가 없습니다.");
				return;
		}
		if(교수정보 저장소.addProfessor(lab, name, major)) {
				System.out.println("교수 정보를 추가했습니다.");
		}else {
			System.out.println("중복된 교수 정보입니다.");
		}*/
	}
}
