package university;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


// 수강 현황 클래스
@Data
@AllArgsConstructor
public class Course {
	
	private int classOf; // 학번

	private String name; // 이름
	
	private String selection; // 과
	
	private List<Lesson> lessonList; // 수강 수업 리스트
	
	 
	// 생성자
	
	// 학생 정보 초기화 생성자
	
	public Course(int classOf, String name, String selection) {
		this.classOf=classOf;
		this.name=name;
		this.selection=selection;
	}
	

	// 출력 메서드
	
	@Override
	public String toString() {
		return "학생 정보[" + "학번 :" + classOf + ", 이름 :" + name + ", 과 :" + selection + "]" + ", 수강 수업 목록:"
				+ lessonList;
	}
	
	
	// 학번이 같으면 같은 객체이다
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return classOf == other.classOf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classOf);
	}
	
	
	
}
