package day10.word;

public class word {
	int num;
	String eng, kor;
	
	
	public word(int num, String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}

	public void printInfoDetail() {
		System.out.println(eng + "=>" + kor);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	
	
	
}

