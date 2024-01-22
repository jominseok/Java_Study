package HomeHW02.cbh;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class itemList {
	private int day; //날짜
	private String memo; //지출내용
	private int	money_out; //지출비용
	//날짜를 비교/인덱스로 가져오느라 잘안씀
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemList other = (itemList) obj;
		return day == other.day;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(day);
	}
	//출력용
	@Override
	public String toString() {
		return day + "일 지출액:" + money_out + "원 지출내용:" + memo+"";
	}

	public itemList(int day) {
		this.day = day;
	}
}
