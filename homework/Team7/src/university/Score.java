package university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

// 조민석
@Data
public class Score {
	private int classOf; // 학번
	private int score; // 점수 
	
	//생성자
	public Score(int classOf, int score) {
		this.classOf = classOf;
		this.score = score;
	}
	
	// 학번 초기화 생성자
    public Score(int classOf) {
    	this.classOf=classOf;
    }
    
	//학번을 비교한다..... 솔직히 아직도 이부분 이해가 안됩니다 여기에 왜 학번이 멤버변수로 있어야 하는지 ㅠㅠ
	// Student classof = new Student();
	// int classNum; //사용자한테 입력받은 변수
	//classof.equals(classNum); 기능을 만들때 입부분을 해야하지 않을까 싶어요...
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return classOf == other.classOf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classOf);
	}

}
