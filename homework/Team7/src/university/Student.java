package university;

import java.util.Objects;

import lombok.Data;

@Data
public class Student {

	private int classOf; // 학번
	private String name; // 이름
	private String selection; // 과
	
	
	// 학번 초기화 생성자
	public Student(int classOf) {
		this.classOf=classOf;
	}

	// 이름 생성자
	public Student(String name) {
		this.name = name;
	}
	

	// 학번이 같으면 같은 학생 객체이다
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classOf == other.classOf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classOf);
	}
	 
	
	
	// 출력 메서드
	
	@Override
	public String toString() {
		return "학번: " + classOf + ", 이름: " + name + ", 과: " + selection;
	}

	public Student(int classOf, String name, String selection) {
		super();
		this.classOf = classOf;
		this.name = name;
		this.selection = selection;
	}
}
