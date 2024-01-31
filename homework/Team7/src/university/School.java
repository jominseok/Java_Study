package university;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//클래스 총 관리 
public class School {
	public List<Professor> professorList=new ArrayList<Professor>(); // 교수 리스트
	public List<Student> studentList=new ArrayList<Student>(); // 학생 리스트
	public List<Lesson> lessonList=new ArrayList<Lesson>(); // 수업 리스트

	//교수 확인(교번을 통한 교수 확인)
	public boolean professorEquals(int classOf) {
		if(professorList.contains(new Professor(classOf))) {
			return true;
		}
		return false;	
	}
	
	// 학생 확인(학번을 통한 학생 확인)
	public boolean studentEquals(int classOf) {
		if(studentList.contains(new Student(classOf))) {
			return true;
		}
		return false;
	}
	
	//교번을 통해 교수이름을 가져오는 기능
	public String professorName(int classOf) {
		int index=professorList.indexOf(new Professor(classOf));
		String name=professorList.get(index).getName();
		return name;
	}
	
	//교번을 통해 강의 이름을 가져옴
	public String LessonName(int classOf) {
		String subject = null;
		for(Lesson tmp:lessonList) {
			if(tmp.getProfessor()==classOf) {
				subject=tmp.getSubject();
			}
		}
		return subject;
	}
	
	//학생 이름을 통해 학번을 가져옴(있는 학생이라고 가정하며 동명이인 없다고 생각하고 우선 만듬)
	public int studentClassOf(String name) {
		int index=studentList.indexOf(new Student(name));
		int num=studentList.get(index).getClassOf();
		return num;
	}
	
	//날짜입력 비교
	private boolean dayEquals(String dayOfWeek) {
		switch (dayOfWeek) {
		case "월":
			return true;
		case "화":
			return true;
		case "수":
			return true;
		case "목":
			return true;
		case "금":
			return true;
		default:
			return false;
		}
	}
	
	//---------------------교수기능--------------------	
	//수강생 출력
	public void selectLessonStudent(int classOf) {
		String subject=LessonName(classOf);//교번을통해 강의 이름을 가져옴
		int index=lessonList.indexOf(new Lesson(subject));//강의이름을 통해 해당리스트의 인덱스를 가져옴
		if(index>=0) {//강의가 있다면
			if(lessonList.get(index).getScoreList().size()==0) {//수강생이 없으면
				System.out.println("학생이 없습니다");
				return;
			}
			List<Integer> cl=lessonList.get(index).getScoreClassOf();//해당 강의에 수강생의 학점을 list로 가져옴
			for(Integer tmp:cl){
				index=studentList.indexOf(new Student(tmp)); //해당 학번의 학생이 있으면 index를 가져옴
				System.out.println(studentList.get(index)); //해당 학번인덱스의 학생을 출력
			}
			return;
		}
		System.out.println("강의가 없습니다");
	}

	//성적 추가
	public void addScore(int classOf, int score,int num) {
		String subject=LessonName(classOf); //교번을통해 강의 이름을 가져옴
		if(subject==null) { //강의명이 없다면
			System.out.println("강의가 없습니다");
			return;
		}
		int index=lessonList.indexOf(new Lesson(subject));//강의이름을 통해 해당리스트의 인덱스를 가져옴
		if(lessonList.get(index).getScoreList().size()==0) {//강의 안에 점수리스트 안에 학번과 점수가 없으면
			System.out.println("수강생이 없습니다");
			return;
		}
		if(index>=0) {//강의가 있으면
			//addScore라는 메서드를 실행해서 등록 밑 각 안내문구출력
			if(lessonList.get(index).addScore(score,num)) {
				System.out.println("등록이 되었습니다");
				return; //등록이 욋다고 알림
			}else {
				System.out.println("해당 학생의 점수가 있습니다");
				return;
			}
		}
	}

	//성적 수정-병호
	public void setScore(int classOf, int score, int num) {
		String subject=LessonName(classOf);//교번을통해 강의 이름을 가져옴
		if(subject==null) {//강의명이 없다면
			System.out.println("강의가 없습니다");
			return;
		}
		int index=lessonList.indexOf(new Lesson(subject));
		if(lessonList.get(index).setScore(score,num)) {//수정기능
			System.out.println("등록이 되었습니다");
			return; //등록이 욋다고 알림
		}else {
			System.out.println("성적이 없거나 없는 학번입니다");
		}
	}

	//석차 조회-병호
	public void selectLessonTopStudent(int classOf) {
		List<Integer> list=new ArrayList<Integer>(); //리스트를 생성
		String subject=LessonName(classOf);//교번을통해 강의 이름을 가져옴
		if(subject==null) {//강의 인덱스가 없으면
			System.out.println("강의가 없습니다");
			return;
		}
		int index=lessonList.indexOf(new Lesson(subject));
		if(lessonList.get(index).getScoreList().size()==0) {//강의리스트안에 학생정보가 없다면
			System.out.println("수강생이 없습니다");
			return;
		}
		lessonList.get(index).sortScore();//성적순으로 정렬
		list=lessonList.get(index).getScoreClassOf();//학번 리스트를 받음
		for(Integer num:list) {
			for(Student tmp: studentList) {
				if(tmp.equals(new Student(num))) {//학생리스트의 학번과 가저온 학번 리스트를 비교함
					System.out.println(tmp+" 성적:"+lessonList.get(index).equalsScore(num));
				}
			}
		}
	}
	
	//================================== 학생기능 ========================================
	//수강신청 - 조민석
	public void Enrolment(int classOf, String subject) {
		//등록된 학생인지 판별
		int indexStudent = studentList.indexOf(new Student(classOf));
		if(indexStudent == -1) {
			System.out.println("등록 되지 않은 학생입니다.");
			return;
		}	
		//최대 인원수 비교 추가
		for(Lesson tmp : lessonList) {
			//해당 과목이면
			if(tmp.equals(new Lesson(subject))) {
				//max함수 호출하고 true면 신청 가능 false면 최대정원 초과
				if(!tmp.max()) {
					System.out.println("최대 정원을 초과하였습니다.");
					return;
				}
			}
		}	
		//해당과목이 있는지 없는지 판별
		int index = lessonList.indexOf(new Lesson(subject));
		if(index == -1) {
			System.out.println("해당 과목은 개설 되지 않았습니다.");
			return;
		}
		//Lesson클래스 안에 Score리스트를 추가함
		lessonList.get(index).setScoreList(classOf);
	}
	
	//수강 신청 취소 - 조민석
	public void deleteEnrolment(int classOf, String subject) {
		//등록된 학생인지 판별
		int indexStudent = studentList.indexOf(new Student(classOf));
		if(indexStudent == -1) {
			System.out.println("등록 되지 않은 학생입니다.");
			return;
		}
		//해당과목이 있는지 없는지 판별
		int index = lessonList.indexOf(new Lesson(subject));
		if(index == -1) {
			System.out.println("해당 과목은 개설 되지 않았습니다.");
			return;
		}
		//이미 삭제된 과목이거나 신청 되지 않은 과목이면 리턴
		for(Lesson tmp:lessonList) {
			//Lesson리스트 안에서 해당
			boolean a = tmp.setScore(classOf);
			if(!a){
				System.out.println("이미 삭제 되었거나 수강중인 과목이 아닙니다.");
				return;
			}
		}
		//Lesson클래스 안에 Score리스트를 삭제
		lessonList.get(index).deleteScore(classOf);
	}

	//수강 수업 조회 - 조민석
	public void selectEnrolment(int classOf) {
		for(Lesson tmp:lessonList) {
			//Lesson리스트 안에서 해당
			boolean a = tmp.setScore(classOf);
			if(a){
				System.out.println(tmp.getSubject());
			}
		}
	}
	
	//성적 조회 - 조미석
	public void setScore(int classOf) {
		for(Lesson tmp:lessonList) {
			boolean a = tmp.setScore(classOf);
			if(a){
				System.out.println("과목 : " + tmp.getSubject()
				+ "성적 : " + tmp.setIntScore(classOf));
			}
		}
	}
 
	// -------------------관리자-------------------
	//교수 등록
	public boolean addProfessor(int classOf, String name, String selection) {
		//같은 학번이 있는지 확인 후 있으면 false를 출력
		if(professorList.contains(new Professor(classOf))) {
			return false;
		}
		//교수를 등록함
		professorList.add(new Professor(classOf,name,selection));
		return true;
	}

	//교수 수정
	public void setProfessor(int classOf, String name, String selection) {
		int index = professorList.indexOf(new Professor(classOf));
		professorList.set(index, new Professor(classOf, name, selection));
		System.out.println("교수 정보를 수정하였습니다.");
	}
	
	//교수 삭제
	public void remove(int classOf) {
		professorList.remove(new Professor(classOf));
		System.out.println("교수 삭제를 완료했습니다.");	
	}

	//교수 전체조회
	public void selectAllProfessor() {
		boolean t = true;
		if(professorList.size()==0) {
			System.out.println("조회할 교수가 없습니다. 교수를 등록해주세요.");
		}else {
			for(Professor tmp : professorList) {
				System.out.println("교번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());	
				t=false;
			}
			if(t==false) {
				System.out.println("전체 교수 조회를 완료했습니다.");
			}
		}
	}
		
	//교수 학과 조회
	public void selectProfessorBySelection(String selection) {
		boolean t= true;
		for(Professor tmp : professorList) {
			if(tmp.getSelection().equals(selection)) {				
				System.out.println("교번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());
				t=false;
			}			
		}
		if(t==true) {
			System.out.println("없는 과이거나 과에 교수가 없습니다.");
		}
		if(t==false) {
			System.out.println(selection+ "과의 교수 조회를 완료했습니다.");
		}
	}
	
	//교수 이름 조회
	public void selectProfessorByName(String name) {
		boolean t = true;
		for(Professor tmp : professorList) {
			if(tmp.getName().equals(name)) {
				System.out.println("교번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());
				t=false;
			}
		}if(t==true) {
			System.out.println("없는 이름입니다. 다시 입력해주세요.");
		}
		if(t==false) {
			System.out.println(name + "교수님 조회를 완료했습니다.");
		}
	}

	//학생 전체조회
	public void selectAllStudent() {
		boolean t = true;
		if(studentList.size()==0) {
			System.out.println("조회할 학생이 없습니다. 학생을 등록해주세요.");
		}else {
			for(Student tmp : studentList) {
				System.out.println("학번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());	
				t=false;
			}
			if(t==false) {
				System.out.println("전체 학생 조회를 완료했습니다.");
			}
		}
	}
	
	//학생 학과 조회
	public void selectStudentBySelection(String selection) {
		boolean t= true;
		for(Student tmp : studentList) {
			if(tmp.getSelection().equals(selection)) {				
				System.out.println("학번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());
				t=false;
			}			
		}
		if(t==true) {
			System.out.println("없는 과이거나 과에 학생이 없습니다.");
		}
		if(t==false) {
			System.out.println(selection+ "과의 학생 조회를 완료했습니다.");
		}
	}
	
	//학생 학번 조회	
	public void selectStudentByName(int classOf) {
		boolean t = true;
		for(Student tmp : studentList) {
			if(tmp.getClassOf()==classOf) {
				System.out.println("학번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());
				t=false;
			}
		}
		if(t==true) {
			System.out.println("없는 학번입니다. 다시 입력해주세요.");
		}
		if(t==false) {
			System.out.println("학번이" + classOf + "인 학생의 조회를 완료했습니다.");
		}
	}

	// 관리자의 학생 수정 메서드 : 최지용
	public void setStudent(int classOf,String name,String selection) {
		int index = studentList.indexOf(new Student(classOf));
		studentList.get(index).setName(name);
		studentList.get(index).setSelection(selection);
		System.out.println("학생 정보를 수정하였습니다.");
	}

	// 관리자의 학생 삭제 메서드 : 최지용
	public void deleteStudent(int classOf) {
		studentList.remove(new Student(classOf));
		System.out.println("학생 삭제가 완료됐습니다.");	
	}

	// 관리자의 학생 등록 메서드 : 최지용
	public void addStudent(int classOf, String name, String selection) {
		// 학번 중복 확인	 
		if(studentEquals(classOf)) {
			System.out.println("이미 등록된 학번입니다.");
			return;
		}
		studentList.add(new Student(classOf,name,selection));
		System.out.println("학생등록이 완료됐습니다.");		
	}

	//-----------------------------관리자 수업관리----------------------
	public void addLesson(String subject, int professor, int classRoom, String dayOfWeek, int sTime, int eTime,
			int max) {
		if(!professorEquals(professor)) {//해당교번이 교수리스트에 있다면
			System.out.println("없는 교수 입니다");
			return;
		}	
		String suject2=LessonName(professor);//교번으로 강의명을가져옴
		if(suject2!=null) {//강의명이 없다면
			System.out.println("해당 교수는 수업이 있습니다");
			return;
		}
		if(!dayEquals(dayOfWeek)) {//월~금이 아닌 다른요일을 입력 또는 잘못된 문자열이면
			System.out.println("잘못된 요일입니다");
			return;
		}
		//요일 시간 강의실 비교
		for(Lesson tmp:lessonList) {
			if(!tmp.compa(subject,dayOfWeek,classRoom,sTime,eTime)) {
				System.out.println("이미 있는 수업명이거나 수업시간과 강의실이 겹치는 수업이 있습니다.");
				return;
			}		
		}
		//등록
		lessonList.add(new Lesson(subject, professor, dayOfWeek, sTime, eTime, classRoom, max));
	}
	
	// 관리자 강의 삭제, 강의명 입력시 강의 리스트에 있는지 확인하는 메서드 : 최지용
	public boolean lessonNameEquals(String subject) {
		if(lessonList.contains(new Lesson(subject))) {
			return true;
		}
		return false;
	}
	
	//강의명 수정 : 최지용
	public void setLessonSubject(int index, String newSubject) {
		boolean t =true;
		for(Lesson tmp : lessonList) {
			if(tmp.getSubject().equals(newSubject)) {
				System.out.println("이미 있는 강의명입니다. 강의명을 다시 입력해주세요.");
				t=false;
				return;
			}
		}
		if(t==true) {
		lessonList.get(index).setSubject(newSubject);
		System.out.println("강의명이 " + newSubject + " 로 수정됐습니다.");
		}	
	}
	
	//강의 교번수정 : 최지용
	public void setLessonProfessor(int index, int newProfessor) {
		boolean t=true;
		if((professorEquals(newProfessor))&&LessonName(newProfessor)==null){
			 lessonList.get(index).setProfessor(newProfessor);
			 System.out.println("담당 교수의 교번이 " + newProfessor + " 로 수정됐습니다.");
			 t=false;
		}
		if(t==true) {
			System.out.println("없는 교번이거나 해당 교번은 이미 등록된 강의가 있는 교번입니다.");
			return;
		}	
	}

	//강의 정원 수정 : 최지용
	public void setLessonMax(int index, int newMax) {
		boolean f =true;
		if(lessonList.get(index).getMax()!=newMax) {
			lessonList.get(index).setMax(newMax);
			System.out.println("강의의 최대 정원이 " + newMax +" 명으로 수정됐습니다.");
			f=false;
		}
		if(f==true) {
			System.out.println("같은 최대 정원입니다. 다시 입력해주세요.");
			return;
		}
	}
	
	//강의 시간변경 : 최지용
	public void setLessonTime(int index, String newDayOfWeek, int newStartTime, int newEndTime, int newClassroom) {
		for(Lesson tmp : lessonList) {
			if(!tmp.compaLesson(newDayOfWeek,newStartTime,newEndTime,newClassroom)) {
				System.out.println("수업 시간과 강의실이 겹치는 수업이 있습니다. 다시 입력해주세요.");		
				return;
			}
		}	
		lessonList.get(index).setDayOfWeek(newDayOfWeek);
		lessonList.get(index).setStartTime(newStartTime);
		lessonList.get(index).setEndTime(newEndTime);
		lessonList.get(index).setClassroom(newClassroom);
		System.out.println("수업시간과 강의실이 변경됐습니다.");
		}
		
	}