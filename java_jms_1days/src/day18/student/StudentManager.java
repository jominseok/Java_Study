package day18.student;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentManager {
	
	private List<Student> list = new ArrayList<Student>();


	public StudentManager(List<Student> list) {
		if(list == null){
			return;
		}
		this.list = list;
	}

	/** 학생 정보가 주어지면 학생 정보를 추가하는 메서드로, 학년, 반, 번호가 같은
	 * 학생이 있는 경우 학생정보를 추가하지 않음
	 * @param student 학생정보
	 * @return 학생 정보를 추가 했는지 여부를 반환시켜줌 
	 */
	public boolean insertStudent(Student std) {
		//중복체크
		if(list.contains(std)) {
			return false;
		}
		//아니면 추가
		list.add(std);
		//학년 반 번호 순으로 정렬
		return true;
	}
	

	
	//학생 정보 출력
	public void printAll() {
		list.stream().forEach(s->System.out.println(s));
	}

	public boolean updateStudent(Student std) {
		//등록된 학생인지 확인하고 
		int index = list.indexOf(std);
		//등록된 학생이 아니면 false를 리턴
		if(index <0) {
			return false;
		}
		//등록된 학생이면 이름을 수정
		list.get(index).setName(std.getName());
		return true;
	}

	
}
