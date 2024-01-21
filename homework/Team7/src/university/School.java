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
	
	//수강생 출력
	public void selectLessonStudent(int classOf) {
		//교수 리스트에서 이름을 가져옴
		String name=professorName(classOf);
		//강의(lesson)애서 해당 교수 수업이 있는지 확인 
		int index=lessonList.indexOf(new Lesson(name));
		if(index>=0) {
			//있다면 강의에서 학번을 가져와서 학생과 비교해서 출력함
			List<Integer> cl=lessonList.get(index).getClassNum();
			for(int i=0;0<cl.size();i++){
				index=studentList.indexOf(new Student(cl.get(i)));
				if (index>=0) {
					System.out.println(studentList.get(index));
				}
			}
		}else {
			System.out.println("수업이 없습니다");
		}
	
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
			return; //등록이 욋다고 알림
		}else {
			System.out.println("없는 학번입니다");
		}
	}

	//석차 조회-병호
	public void selectLessonTopStudent(int classOf) {
		
	}
	
	//강의 등록-병호
	public void addLesson(String subject, String professor, int classRoom, String dayOfWeek, int sTime, int eTime,
			int max) {
		//강의명이 중복되면 메세지 출력후 종료
//		int index=lessonList.indexOf(new Lesson(subject));
		if(lessonList.contains(new Lesson(subject))) {
			System.out.println("같은 강의가 있습니다");
			return;
		}
		int count=0;
		//시간을 배열을이용하여 같은값이 있는지 확인하기위해
		int[] tl=new int[(eTime-sTime)+1];
		for(int i=sTime;i<=eTime;i++) {
			tl[count++]=i;
		}
		//요일 시간 강의실 비교
		for(Lesson tmp:lessonList) {
			if(tmp.compa(subject,classRoom,tl)) {
				lessonList.add(new Lesson(subject, professor, dayOfWeek, sTime, eTime, classRoom, max));
			}else {
				System.out.println("시간때가 맞지 않습니다");
			}
		}
		
	}
	
	//================================== 조민석 ========================================
	
	//수강신청 - 조민석
		public void Enrolment(String name, String selection, int classOf, String subject) {
			//수강 과목이 뭐뭐가 있는지 조회 합니다.
			Lesson ls = new Lesson();
			boolean new_subject = ls.Discrimination(subject);
			
			//수강 할수 없는 과목이면 리턴시킴
			if(!new_subject) {
				System.out.println("해당 과목이 없거나 개설 되지 않았습니다.");
				return;
			}
			
			//학생 객체를 생성
			Student st = new Student(classOf, name, selection);

			//Student리스트에 학생 추가
			studentList.add(st);
			System.out.println("학생 리스트에 학생을 추가 하엿습니다.");
		}
	
	
	//수강 신청 취소 - 조민석
	public void deleteEnrolment() {
		//자신이 수강중인 수업을 조회합니다.
		setEnrolment();
		//자신의 학번과 수강과목을 입력합니다.
		System.out.print("학번 : ");
		int classOf = scan.nextInt();
		System.out.print("취소하고 싶은 과목 이름을 입력해주세요 : ");
		//과목을 입력 받음
		String subject = scan.nextLine();
		scan.nextLine();
		Student st = new Student(classOf);

		//수강 취소시키면서 안내 문자를 출력
		System.out.println(studentList.remove(st)+" 삭제 되었습니다."); 
	}

	//수강 수업 조회 - 조민석
	public void setEnrolment() {
		//자신이 수강중인 수업을 조회합니다.
		for(Lesson tmp:lessonList) {
			System.out.println("현재 수강중인 수업은 : " + tmp.getSubject() + "입니다.");
		}
	}
	
	//성적 조회 - 조미석
	public void setScore() {
		System.out.print("학번을 입력하세요 : ");
		int classNum = scan.nextInt();
		Score score = new Score(classNum);
		//등록된 학생이 아니라면
		if(score.equals(score)) {
			return;
		}
		//등록된학생이라면 조회
		for(Score tmp:scoreList) {
			if(tmp.equals(score)) {
				System.out.println("점수를 출력합니다."+ tmp.toString());
			}
		}
	}
	
	
	// ====================================조민석========================
	
	// -------------------관리자-------------------최병호
	
	//교수 등록 -옮김
	public boolean addProfessor(int classOf, String name, String selection) {
		//같은 학번이 있는지 확인 후 있으면 false를 출력
		if(professorList.contains(new Professor(classOf))) {
			return false;
		}
		//교수를 등록함
		professorList.add(new Professor(classOf,name,selection));
		return true;
	}

	//교수 수정 -옮김
	public void setProfessor(int classOf, String name, String selection) {
		int index = professorList.indexOf(new Professor(classOf));
		professorList.set(index, new Professor(classOf, name, selection));
		System.out.println("교수 정보를 수정하였습니다.");
	}
	
	//교수 삭제 -옮김
	public void remove(int classOf) {
		professorList.remove(new Professor(classOf));
		System.out.println("교수 삭제를 완료했습니다.");	
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
	
	


}

