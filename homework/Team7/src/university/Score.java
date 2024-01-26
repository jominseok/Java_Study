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

	@Override
	public String toString() {
		return classOf+" 성적은 : " + score;
	}

}
