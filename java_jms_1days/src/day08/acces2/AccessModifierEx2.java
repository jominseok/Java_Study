package day08.acces2;

import day08.acces1.Student;

public class AccessModifierEx2 {

	public static void main(String[] args) {
		
		Student std = new Student();
		//std.grade = 1;// grade의 접근 제어자가 private이어서 같은 패키지에 있는 클래스에서 사용X
					 // grade의 패키지가 아닌 다른 패키지에서 사용 x
		//std.calssNum = 1; // classNum의 접근 제어자가 defualt이어서 같은 패키지에 있는 클래스에서 사용 O
						  // classNum의 접근 제어자가 defualt이어서 다른 패키지에서 사용 X
		std.num = 1; // num의 접근 제어자가 public이어서 사용 O
		
	}

}
