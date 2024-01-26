package university;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Data;
// 최병호
@Data
// 수업 관리 클래스
public class Lesson {
	private String subject; // 수업 이름
	private int professor; // 교번(수정)
	private String dayOfWeek; // 요일
	private int startTime; // 수업 시작 시간
	private int endTime; // 수업 끝나는 시간
	private int classroom; // 강의실
	List<Score> scoreList=new ArrayList<Score>(); // 수강하는 학생들 정보(학생의 학번과 성적)  리스트와 리스트사이즈가 현 인원수
	private int max; // 최대 정원

	//생성자 
	//강의 등록(학교 관리자)
	public Lesson(String subject, int professor, String dayOfWeek, int startTime, int endTime, int classroom,
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
	public Lesson(String subject) {
		this.subject=subject;	}
	
	
	//교번 비교를 위한 생성자
	public Lesson(int professor) {
		this.professor = professor;
	}
	

	// 강의의 강의실, 수업시간 생성자
	public Lesson(String dayOfWeek, int startTime, int endTime, int classroom) {
		this.dayOfWeek=dayOfWeek;
		this.startTime=startTime;
		this.endTime=endTime;
		this.classroom=classroom;
	}
	
	
	//이건 필요 없을 것 같음(Course 클래스)
	//수강 신청(학생 기준) 수업이름, 교수,날짜 학생정보
	public Lesson(String subject, int professor, String dayOfWeek, List<Score> scoreList) {
		this.subject = subject;
		this.professor = professor;
		this.dayOfWeek = dayOfWeek;
		this.scoreList = scoreList;
	}
	
	//태스트용 출력
	@Override
	public String toString() {
		return "[" + "강의명: " + subject + ", 교번:" + professor + 
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
		for(Score tmp:scoreList) {
			if(tmp.equals(new Score(num,0))) {
				tmp.setScore(score);
				return true; //등록 완료
			}
		}			
		
		return false; //점수가 있음으로 false
	}
	
	//성적 수정-병호
	public boolean setScore(int score, int num) {
		for(Score tmp:scoreList) {
			if(tmp.equals(new Score(num))&&tmp.getScore()!=0) {
				tmp.setScore(score);
				return true; //수정 완료
			}
		}
		return false;
	}
	
	//=================조민석===================
	
	public Lesson() {
		
	}
	//수강 신청때 추가할 메서드 - 조민석
	public void setScoreList(int classOf) {
		System.out.println("setScoreList까지는 들어옴");
		//Shool클래스 안에 수강 신청 과목이 있는리스트랑 같은 인덱스 번호 리스트에 학번을 추가 하였습니다.
		scoreList.add(new Score(classOf, 0));
		System.out.println(scoreList);
		System.out.println("해당 수강 신청 과목이 등록 되었습니다.");
	}
	
	//수강 신청 취소 메서드 - 조민석
	public void deleteScore(int classOf) {
		scoreList.remove(new Score(classOf));
		System.out.println(scoreList);
	}
	
	//성적 조회 메서드 - 조민석
	public boolean setScore(int classOf) {
		//입력받은 학번이 
		for(Score tmp : scoreList) {
			if(tmp.equals(new Score(classOf))) {
				return true;
			}
		}
		return false;
	}

	
	// 성적(int 형 반환 메서드) - 조민석
	public int setIntScore(int classOf) {
		//입력받은 학번이 
		for(Score tmp : scoreList) {
			if(tmp.equals(new Score(classOf))) {
				return tmp.getScore();
			}
		}
		return 0;
	}

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
	public boolean compa(String subject,String dayOfWeek, int classroom, int sTime,int eTime) {
		if(this.subject.equals(subject)) { //강의명이 같다면
			return false;
		}
		int count=0;
		//시간을 배열을이용하여 같은값이 있는지 확인하기위해
		int[] tl=new int[(eTime-sTime)+1];
		for(int i=sTime;i<=eTime;i++) {
			tl[count++]=i;
		}
		if(this.classroom==classroom&&this.dayOfWeek.equals(dayOfWeek)) { //클래스룸,요일이 같다면
			for(int i=0; i<tl.length;i++) {
				//강의시간때가 시작시간 또는 종료시간이 있으면 false를 리턴
				if(tl[i]==startTime||tl[i]==endTime) {
					return false;
				}
			}
		}
		return true;
	}
	
	//성적순으로 정렬
	public void sortScore() {
		Collections.sort(scoreList,(o1,o2)->o2.getScore()-o1.getScore());
	}
	//학번을 리턴함
	public List<Integer> getScoreClassOf() {
		List<Integer> list=new ArrayList<Integer>();
		for(Score tmp:scoreList) {
			list.add(tmp.getClassOf());
		}
		return list;
	}
	
	//점수를 리턴
	public int equalsScore(int num) {
		int index=scoreList.indexOf(new Score(num));
		return scoreList.get(index).getScore();
	}

}
