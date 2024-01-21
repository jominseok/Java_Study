package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
// 최병호
@Data
// 수업 관리 클래스
public class Lesson {
	private String subject; // 수업 이름
	private String professor; // 교수
	private String dayOfWeek; // 요일
	private int startTime; // 수업 시작 시간
	private int endTime; // 수업 끝나는 시간
	private int classroom; // 강의실
	List<Score> scoreList; // 수강하는 학생들 정보(학생의 학번과 성적)  리스트와 리스트사이즈가 현 인원수
	                       // 변수를 안만드는 이유는 관리자가 수업을 입력할 때 수강하는 학생을 직접 입력하지 않기 때문이다. 
	private int max; // 최대 정원

	//생성자 
	//강의 등록(학교 관리자)
	public Lesson(String subject, String professor, String dayOfWeek, int startTime, int endTime, int classroom,
			int max) {
		this.subject = subject;
		this.professor = professor;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.classroom = classroom;
		this.max = max;
	}
	
	// 수업이름 초기화 생성자	
	/*public Lesson(String subject) {
		this.subject=subject;	}*/
	
	
	//교수 이름 비교를 위한 생성자
	public Lesson(String professor) {
		this.professor = professor;
	}
	
	
	
	
	//이건 필요 없을 것 같음(Course 클래스)
	//수강 신청(학생 기준) 수업이름, 교수,날짜 학생정보
	public Lesson(String subject, String professor, String dayOfWeek, List<Score> scoreList) {
		this.subject = subject;
		this.professor = professor;
		this.dayOfWeek = dayOfWeek;
		this.scoreList = scoreList;
	}
	
	//태스트용 출력
	@Override
	public String toString() {
		return "[" + "강의명: " + subject + ", 교수명:" + professor + 
				", 요일:" + dayOfWeek + ", 시작시간: "
				+ startTime + ", 종료시간: " + endTime + ", 강의실: " + classroom + ", 등록된학생: " + scoreList
				+ ", 인원 제한 " + max + "]";
	}

	//scorelist안에 학번을 리스트으로 바꾸고 그 리스트를 리턴함
	public List<Integer> getClassNum() {
		List<Integer> cl=new ArrayList<Integer>();
		for(Score tmp:scoreList) {
			int n=tmp.getClassOf();
			cl.add(n);
		}
		return cl;
	}
	


	//성적 추가-병호
	public boolean addScore(int score, int num) {
		//학번이 있고 점수가 없다면
		if(scoreList.contains(new Score(num,0))) {//오류 가능성
			for(Score tmp:scoreList) {
				if(tmp.equals(num)) {
					tmp.setScore(score);
					return true; //등록 완료
				}
			}			
		}
		return false; //점수가 있음으로 false
	}
	
	//성적 수정-병호
	public boolean setScore(int score, int num) {
		for(Score tmp:scoreList) {
			if(tmp.equals(num)) {
				tmp.setScore(score);
				return true; //수정 완료
			}
		}
		return false;
	}
	
	//==========조민석=================
	public Lesson() {
		
	}
	
	//수강 할 수 있는 과목인지 확인하는 메서드
	public boolean Discrimination(String new_subject) {
		//입력받은 과목이 개설 되었는지 확인
		if(!subject.equals(new_subject)) {
			return false;
		}
		

		return true;
	}
	
	
	
	//=============조민석================

	//강의 이름비교-병호
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(subject, other.subject);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(subject);
	}
	//강의 명 강의실 시간떄 비교-병호
	public boolean compa(String subject2, int classRoom2, int[] tl) {
		if(subject==subject2) { //강의명이 같다면
			return false;
		}
		if(classroom==classRoom2) { //클래스룸이 같다면
			for(int i=0; i<tl.length;i++) {
				//강의시간때가 시작시간 또는 종료시간이 있으면 false를 리턴
				if(tl[i]==startTime||tl[i]==endTime) {
					return false;
				}
			}
		}
		return true;
	}



}
