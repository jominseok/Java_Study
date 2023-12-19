package day08.acces1;

public class Student {
	private int grade;
	int calssNum; //접근 제어자가 default
	public int num;
	private String name;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCalssNum() {
		return calssNum;
	}
	public void setCalssNum(int calssNum) {
		this.calssNum = calssNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
