package HomeHW02.TeamHw2;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class Money {
	
	
	private int month,day; // 월, 일
	
	private String memo; // 내역
	
	private int money; // 수입, 지출 금액
	

    // 월,일,내역 같은면 같은 객체로 생각
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return day == other.day && Objects.equals(memo, other.memo) && month == other.month;
	}		
}
