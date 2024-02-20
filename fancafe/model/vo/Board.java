package fancafe.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Board {
	private int bd_num; //게시판 번호
	private String bd_title; //게시판 이름
	
	// 게시판 번호, 이름 출력 메서드 
	@Override
	public String toString() {
		return bd_num + ". " + bd_title;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return bd_num == other.bd_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bd_num);
	}

	public Board(int bd_num) {
		this.bd_num = bd_num;
	}
	
}
