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
//	public List<Course> courseList = new ArrayList<Course>(); // 수강 현
	Scanner scan = new Scanner(System.in);
	
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
	
	//---------------------교수기능--------------------
	
	//수강생 출력
	public void selectLessonStudent(int classOf) {
		//강의(lesson)애서 해당 교수 수업이 있는지 확인 
//		int index=lessonList.indexOf(new Lesson(classOf)); equals 때문에 못씀
		for(Lesson tmp:lessonList) {
			if(tmp.getProfessor()==classOf) { //같은 교번이 있다면
				if(tmp.getScoreList().size()==0) { //학생이 없으면
					System.out.println("수강생이 없습니다");
					return;
				}else {
					//있다면 강의에서 학번을 가져와서 학생과 비교해서 출력함
					List<Integer> cl=tmp.getScoreClassOf();
					System.out.println(cl);
					for(Integer tmp2:cl){
						int index=studentList.indexOf(new Student(tmp2));
						System.out.println(studentList.get(index));
					}
				}
				return;// 출력후 종료
			}
		}	
		System.out.println("강의가 없습니다");
	}

	//성적 추가
	public void addScore(int classOf, int score,int num) {
		String subject=LessonName(classOf);
		if(subject==null) {
			System.out.println("수업이 없습니다");
			return;
		}
		int index=lessonList.indexOf(new Lesson(subject));
		System.out.println(index);
		if(index>=0) {
			//addScore라는 메서드를 실행해서 등록 밑 각 안내문구출력
			if(lessonList.get(index).addScore(score,num)) {//오류
				System.out.println("등록이 되었습니다");
				System.out.println(lessonList);//태스트
				return; //등록이 욋다고 알림
			}else {
				System.out.println("해당 학생의 점수가 있습니다");
				return;
			}
		}
		System.out.println("없는 학번이 입니다");
	}

	//성적 수정-병호 //오류
	public void setScore(int classOf, int score, int num) {
		String subject=LessonName(classOf);
		if(subject==null) {
			System.out.println("수업이 없습니다");
			return;
		}
		int index=lessonList.indexOf(new Lesson(subject));
		if(lessonList.get(index).setScore(score,num)) {//오류
			System.out.println("등록이 되었습니다");
			System.out.println(lessonList);//태스트
			return; //등록이 욋다고 알림
		}else {
			System.out.println("성적이 없거나 없는 학번입니다");
		}
	}

	//석차 조회-병호
	public void selectLessonTopStudent(int classOf) {
		List<Integer> list=new ArrayList<Integer>();
		String subject=LessonName(classOf);
		int index=lessonList.indexOf(new Lesson(subject));
		lessonList.get(index).sortScore();//정렬
		list=lessonList.get(index).getScoreClassOf();//학번 리스트를 받음
		for(Integer num:list) {
			for(Student tmp: studentList) {
				if(tmp.equals(new Student(num))) {//학번 비교
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
				
				//해당과목이 있는지 없는지 판별
				int index = lessonList.indexOf(new Lesson(subject));
				if(index == -1) {
					System.out.println("해당 과목은 개설 되지 않았습니다.");
					return;
				}
				//Lesson클래스 안에 Score리스트를 추가함
				System.out.println("setScoreList들어가기 전까지는 옴");
				lessonList.get(index).setScoreList(classOf);
				System.out.println(lessonList);
			}
			
			
			//수강 신청 취소 - 조민석
			public void deleteEnrolment(int classOf) {
				System.out.println("=========수강취소============");
				//등록된 학생인지 판별
				int indexStudent = studentList.indexOf(new Student(classOf));
				if(indexStudent == -1) {
					System.out.println("등록 되지 않은 학생입니다.");
					return;
				}
				System.out.print("취소하고 싶은 과목 이름을 입력해주세요 : ");
				//과목을 입력 받음
				scan.nextLine();
				String subject = scan.nextLine();
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
				System.out.println(lessonList);
				
			}

			//수강 수업 조회 - 조민석
			public void selectEnrolment() {
				System.out.print("학번을 입력해주세요 : ");
				int classOf = scan.nextInt();
				for(Lesson tmp:lessonList) {
					//Lesson리스트 안에서 해당
					boolean a = tmp.setScore(classOf);
					if(a){
						System.out.println(tmp.getSubject());
					}
				}
			}
			
			//성적 조회 - 조미석
			public void setScore() {
				System.out.print("학번을 입력해주세요 : ");
				int classOf = scan.nextInt();
				for(Lesson tmp:lessonList) {
					//Lesson리스트 안에서 해당
					boolean a = tmp.setScore(classOf);
					if(a){
						System.out.println("과목 : " + tmp.getSubject()
						+ "성적 : " + tmp.setIntScore(classOf));
					}
				}
			}
	 
	// -------------------관리자-------------------
	
	//-----------------------------관리자 교수관리----------------------
	
	//교수 등록 -옮김
	public boolean addProfessor(int classOf, String name, String selection) {
		//같은 학번이 있는지 확인 후 있으면 false를 출력
		if(professorList.contains(new Professor(classOf))) {
			return false;
		}
		//교수를 등록함
		professorList.add(new Professor(classOf,name,selection));
		System.out.println(professorList);//태스트
		return true;
	}

	//교수 수정 -옮김
	public void setProfessor(int classOf, String name, String selection) {
		int index = professorList.indexOf(new Professor(classOf));
		professorList.set(index, new Professor(classOf, name, selection));
		System.out.println("교수 정보를 수정하였습니다.");
		System.out.println(professorList);//태스트
	}
	
	//교수 삭제 -옮김
	public void remove(int classOf) {
		professorList.remove(new Professor(classOf));
		System.out.println("교수 삭제를 완료했습니다.");	
		System.out.println(professorList);//태스트
	}

	//교수 전체조회 -옮김
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
		
		
		
	//교수 학과 조회-옮김
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
	
	//교수 이름 조회-옮김
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
	
	//-----------------------------관리자 학생관리----------------------

	//학생 전체조회 -옮김
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
	
	
	//학생 학과 조회-옮김
	
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
	
	//학생 학번 조회-옮김
	
	public void selectStudentByName(int classOf) {
		boolean t = true;
		for(Student tmp : studentList) {
			if(tmp.getClassOf()==classOf) {
				System.out.println("학번 : " + tmp.getClassOf() + ",이름 : " + tmp.getName() + ", 과 : " + tmp.getSelection());
				t=false;
			}
		}if(t==true) {
			System.out.println("없는 학번입니다. 다시 입력해주세요.");
		}
		if(t==false) {
			System.out.println("학번이" + classOf + "인 학생의 조회를 완료했습니다.");
		}
	}

		
		
	

	// 관리자의 학생 수정 메서드 : 최지용
	public void setStudent(int classOf) {
		int index = studentList.indexOf(new Student(classOf));
		System.out.println("수정할 정보들을 입력하세요."); // 학번은 수정하지 않는다
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("과 : ");   
		String selection = scan.nextLine();
		studentList.get(index).setName(name);
		studentList.get(index).setSelection(selection);
		System.out.println("학생 정보를 수정하였습니다.");
		System.out.println(studentList);//태스트
		
	}
	// 관리자의 학생 삭제 메서드
	public void deleteStudent(int classOf) {
		studentList.remove(new Student(classOf));
		System.out.println("학생 삭제가 완료됐습니다.");	
		System.out.println(studentList);//태스트
		
	}
	// 관리자의 학생 등록 메서드
	public void addStudent(int classOf, String name, String selection) {
		// 학번 중복 확인	 
		if(studentEquals(classOf)) {
			System.out.println("이미 등록된 학번입니다.");
			return;
		}
		studentList.add(new Student(classOf,name,selection));
		System.out.println("학생등록이 완료됐습니다.");		
		System.out.println(studentList);//태스트
	}
	
	//-----------------------------관리자 수업관리----------------------
	
	//강의 등록
	public void addLesson(String subject, int professor, int classRoom, String dayOfWeek, int sTime, int eTime,
			int max) {
		if(lessonList.size()==0) {
			lessonList.add(new Lesson(subject, professor, dayOfWeek, sTime, eTime, classRoom, max));
			System.out.println(lessonList);//태스트
			return;
		}
		//강의명이 중복되면 메세지 출력후 종료
//		int index=lessonList.indexOf(new Lesson(subject));
		if(lessonList.contains(new Lesson(subject))) {
			System.out.println("같은 강의가 있습니다");
			return;
		}
		//요일 시간 강의실 비교
		for(Lesson tmp:lessonList) {
			if(tmp.compa(subject,dayOfWeek,classRoom,sTime,eTime)) {
				lessonList.add(new Lesson(subject, professor, dayOfWeek, sTime, eTime, classRoom, max));
				System.out.println(lessonList);//태스트
				return;
			}		
		}
		System.out.println("시간때가 맞지 않습니다");
		System.out.println(lessonList);//태스트
		return;
	}
	
	// 관리자 강의 수정 : 교번이 수업 리스트에 있는지 확인메서드
	
	public boolean lessonProfessorEquals(int professor) {
		if(lessonList.contains(new Lesson(professor))) {
			return true;
		}
		return false;
	}
	
	// 관리자 강의 수정 : 강의실, 요일, 수업시간(시작, 끝) 이 수업리스트에 있는지  확인 메서드
	
	public boolean lessonEquals(String dayOfWeek, int startTime, int endTime, int classroom) {
		
		if(lessonList.contains(new Lesson(dayOfWeek,startTime,endTime,classroom))) {
			return true;
		}	
		return false;
	}
	
	// 관리자 강의 삭제: 강의명 입력시 강의 리스트에 있는지 확인하는 메서드
	
	public boolean lessonNameEquals(String subject) {
		if(lessonList.contains(new Lesson(subject))) {
			return true;
		}
		return false;
	}
	
	// 관리자가 강의 수정시, 수정 선택 메뉴 입력 후 실행 메서드
	
	public void runSetLessonMenu(int menu,int index) {
						
		switch(menu) {
		case 1 :
			System.out.println("강의명을 수정합니다.");
			System.out.print("새 강의명 입력 : ");
			 String newSubject = scan.nextLine();
			 for(Lesson tmp : lessonList) {
				 if(tmp.getSubject()==newSubject) {
					 System.out.println("이미 있는 강의명입니다.");
					 return;
				 }
			 }
			 lessonList.get(index).setSubject(newSubject);
			 System.out.println("강의명이 수정됐습니다.");
			 
			 break;
			 
		case 2 :
			System.out.println("담당 교수를 수정합니다.");
			System.out.print("새 담당 교수 교번 입력 : ");
			int newProfessor = scan.nextInt();
			// 교번이 존재해야 하며, 수업 리스트에서 존재하면 안된다.
			boolean t=true;
			if((professorEquals(newProfessor))){
				 lessonList.get(index).setProfessor(newProfessor);
				 System.out.println("담당 교수의 교번이 수정됐습니다.");
				 t=false;
			}
			if(t==true) {
				System.out.println("없는 교번이거나 해당 교번은 이미 등록된 강의가 있는 교번입니다.");
				return;
			}
			
			break;
			
		case 3 :
			System.out.println("최대 정원을 수정합니다.");
			System.out.print("새 최대 정원 입력 : ");
			int newMax = scan.nextInt();
			boolean f =true;
			if(lessonList.get(index).getMax()!=newMax) {
				lessonList.get(index).setMax(newMax);
				System.out.println("강의의 최대 정원이 수정됐습니다.");
				f=false;
			}
			if(f==true) {
				System.out.println("같은 최대 정원입니다. 다시 입력해주세요.");
				return;
			}
			
			break;
			
		case 4 :
			
			System.out.println("강의시간(요일,시간대) 혹은 강의실을 수정합니다.");
			System.out.print("새 강의 요일 입력 : ");
			scan.nextLine();
			String newDayOfWeek = scan.nextLine();
			System.out.print("새 강의 시작 시간 : ");
			int newStartTime = scan.nextInt();
			System.out.print("새 강의 끝나는 시간 : ");
			int newEndTime = scan.nextInt();
			System.out.print("새 강의실 : ");
			int newClassroom = scan.nextInt();
			
			boolean a =true;
			if(!(lessonEquals(newDayOfWeek, newStartTime, newEndTime, newClassroom))) {
				lessonList.get(index).setDayOfWeek(newDayOfWeek);
				lessonList.get(index).setStartTime(newStartTime);
				lessonList.get(index).setEndTime(newEndTime);
				lessonList.get(index).setClassroom(newClassroom); // 이거 되는지 확인
				System.out.println("강의 시간, 강의실이 변경됐습니다.");
				a=false;
			}
			if(a=true) {
				System.out.println("다른 수업과 겹쳐서 입력한 시간과 강의실로 수업을 수정할 수 없습니다. 다시 입력해주세요.");
				return;
			}		
			break;
			
		default :
			
			throw new InputMismatchException();		
		}
		
	}
	


}

