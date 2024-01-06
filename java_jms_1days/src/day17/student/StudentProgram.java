package day17.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {
	
	private Scanner scan = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	final private int EXIT = 3;

	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/day17/student/student.txt";
		//불러오기
		load(fileName);
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			} catch (InputMismatchException e) {
					System.out.println("메뉴를 잘못 선택했습니다.");
					scan.nextLine();
			
			}
			
		} while (menu != EXIT);
		
		//저장
		save(fileName);
	}

	private void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(sm.getList());
			System.out.println("저장하기 성공");
		} catch (FileNotFoundException e) {
			//폴더 경로가 잘 못된 경우
			System.out.println("지정된 위치에 파일을 찾을 수 없습니다.");
		} catch (IOException e1) {
			System.out.println("저장에 실패했습니다");
		}
		
	}

	private void load(String fileName) {
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			sm.setList((ArrayList<Student>)ois.readObject());
			System.out.println("불러오기 성공");
		} catch (FileNotFoundException e) {
			//폴더 경로가 잘 못된 경우
			System.out.println("지정된 위치에 파일을 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다");
		}
	}

	@Override
	public void printMenu() {
		System.out.println("-----기능-----");
		System.out.println("1. 학생추가");
		System.out.println("2. 학생조회");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int Menu) {
		
		switch (Menu) {
		case 1: {
			insertStudent();
			break;
		}
		case 2: {
			sm.printAll();
			break;
		}
		case 3: {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		default:
			throw new InputMismatchException();
		}
	}

	private void insertStudent() {
		//학생 정보 입력
		//학년 반 번호 이름 입력 받음
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		//학생 객체 생성
		Student std = new Student(grade, classNum, num, name);
		//추가 해서 성고 실패 둘다 알림
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
		
	}

}
