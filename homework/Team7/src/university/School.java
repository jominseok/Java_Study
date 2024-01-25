package university;

import java.util.ArrayList;
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
//		int index=lessonList.indexOf(new Lesson(classOf)); eqauls 때문에 못씀
		for(Lesson tmp:lessonList) {
			if(tmp.getProfessor()==classOf) { //같은 교번이 있다면
				if(tmp.getScoreList().size()==0) { //학생이 없으면
					System.out.println("수강생이 없습니다");
					return;
				}else {
					//있다면 강의에서 학번을 가져와서 학생과 비교해서 출력함
					List<Integer> cl=tmp.getClassNum();
					System.out.println(cl);
					for(int i=0;0<cl.size();i++){
						if(studentEquals(cl.get(i))) {
							System.out.println(cl.get(i));
						}
					}
				}
				return;// 출력후 종료
			}
		}	
		System.out.println("강의가 없습니다");
	}

	//성적 추가
	public void addScore(int classOf, int score,int num) {
		String pName=professorName(classOf); //교수 이름을가져옴
		//교수의 해당 강의의 인덱스를 가져옴
		int index=lessonList.indexOf(new Lesson(pName));
		if(index>=0) {
			//addScore라는 메서드를 실행해서 등록 밑 각 안내문구출력
			if(lessonList.get(index).addScore(score,num)) {
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

	//성적 수정-병호
	public void setScore(int classOf, int score, int num) {
		String pName=professorName(classOf); //교수 이름을가져옴
		//교수의 해당 강의의 인덱스를 가져옴
		int index=lessonList.indexOf(new Lesson(pName));
		if(lessonList.get(index).setScore(score,num)) {
			System.out.println("등록이 되었습니다");
			System.out.println(lessonList);//태스트
			return; //등록이 욋다고 알림
		}else {
			System.out.println("없는 학번입니다");
		}
	}

	//석차 조회-병호
	public void selectLessonTopStudent(int classOf) {
		
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
		public void deleteEnrolment() {
			System.out.println("=========수강취소============");
			System.out.print("학번 입력 : ");
			int classOf = scan.nextInt();
			//등록된 학생인지 판별
			int indexStudent = studentList.indexOf(new Student(classOf));
			if(indexStudent == -1) {
				System.out.println("등록 되지 않은 학생입니다.");
				return;
			}
			System.out.print("취소하고 싶은 과목 이름을 입력해주세요 : ");
			//과목을 입력 받음
			String subject = scan.nextLine();
			scan.nextLine();
			//해당과목이 있는지 없는지 판별
			int index = lessonList.indexOf(new Lesson(subject));
			if(index == -1) {
				System.out.println("해당 과목은 개설 되지 않았습니다.");
				return;
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
		for(Professor tmp : professorList) {
			tmp.toString();
		}	
	}

	//교수 학과 조회-옮김
	public void selectProfessorBySelection(String selection) {
		boolean t= true;
		for(Professor tmp : professorList) {
			if(tmp.getSelection()==selection) {
				tmp.toString();
				t=false;
			}		
		}
		if(t=true) {
			System.out.println("없는 과이거나 과에 교수가 없습니다.");
		}
	}
	
	//교수 이름 조회-옮김
	public void selectProfessorByName(String name) {
		boolean t = true;
		for(Professor tmp : professorList) {
			if(tmp.getName()==name) {
				tmp.toString();
				t=false;
			}
		}if(t=true) {
			System.out.println("없는 이름입니다. 다시 입력해주세요.");
		}
	}
	
	//-----------------------------관리자 학생관리----------------------

	//학생 전체조회
	public void selectAllStudent() {
		for(Student tmp : studentList) {
			tmp.toString();
		}
	}

	//관리자의 과별 학생 조회
	public void selectStudentBySelection(String selection) {
		boolean t= true;
		for(Student tmp : studentList) {
			if(tmp.getSelection()==selection) {
				tmp.toString();
				t=false;
			}		
		}
		if(t=true) {
		System.out.println("없는 과이거나 과에 학생이 없습니다.");
		}
		
	}
	//관리자의 학번별 학생 조회 메서드
	public void selectStudentByName(int classOf) {
		boolean t = true;
		for(Student tmp : studentList) {
			if(tmp.getClassOf()==classOf) {
				tmp.toString();
				t=false;
				break;
			}			
		}if(t=true) {
			System.out.println("없는 학번입니다. 다시 입력해주세요.");
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
	


}

