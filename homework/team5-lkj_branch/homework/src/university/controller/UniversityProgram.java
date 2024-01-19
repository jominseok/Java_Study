package university.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import university.program.Program;
import university.service.ClassService;
import university.service.ClassServiceImp;
import university.service.MajorService;
import university.service.MajorServiceImp;
import university.service.PrintService;
import university.service.PrintServiceImp;
import university.service.ProfessorService;
import university.service.ProfessorServiceImp;
import university.service.StudentService;
import university.service.StudentServiceImp;

public class UniversityProgram implements Program{
	
	private final int EXIT = 4;
	
	private PrintService printService = new PrintServiceImp();
	private ClassService classService = new ClassServiceImp();
	private MajorService majorService = new MajorServiceImp();
	private ProfessorService professorService = new ProfessorServiceImp();
	private StudentService studentService = new StudentServiceImp();

	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void run() {
		int menu = 0;
		do {
				try {
						printMenu();//메인메뉴선택
						menu = scan.nextInt();
						runMenu(menu);
				}catch(InputMismatchException e) {
						System.out.println("잘못된 메뉴 입니다.");
						scan.nextLine();
						}
				}while(menu != EXIT);
				/*if(serviceclass.save(fileName, 저장소.getList())) {//각 기능의 저장소가 있는데도 필요한가?
						System.out.println("저장을 완료하였습니다.");
				}else {
						System.out.println("저장에 실패하였습니다.");
				}*/
	}
	@Override
	public void printMenu() {//메뉴를 정리해야 한다
		printService.printMainmenu();
	}
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
					printService.printProfessorMenu();
					runProfessorMenu();
					break;
		case 2:
					printService.printStudentMenu();
					runStudent();
					break;
		case 3://searchInfo();//교수정보&학생정보를 조회 작업진행에 따라 나뉠 수 있음
					break;
		case 4:
					System.out.println("프로그램을 종료합니다.");
					break;
		default:
					throw new InputMismatchException();
		}
	}
	private void runStudent() {
		studentService.runStudent();
	}
	private void runProfessorMenu() {
		professorService.runProfessor();
	}
}
