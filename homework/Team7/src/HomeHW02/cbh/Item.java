package HomeHW02.cbh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
	private int month; //월,달
	List<itemList> itemlist; //지출 리스트
	private int money_in; //수입
	//생성자
	public Item(int month, List<itemList> il) {
		this.month = month;
		this.itemlist = il;
	}
	public Item( List<itemList> il) {
		this.itemlist = il;
	}
	public Item(int month) {
		this.month = month;
	}
	public Item(int month,List<itemList> il, int money_in) {	
		this.month = month;
		this.itemlist = il;
		this.money_in = money_in;
	}
	
	//월을 비교 /인덱스사용으로 인한 사용횟수 부족
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return month == other.month;
	}

	@Override
	public int hashCode() {
		return Objects.hash(month);
	}
	
	
	
	//지출관련 추가
	public boolean addMoneyList(List<itemList> il) {
		//값이 없으면
		if(itemlist==null) return false;
		//날짜가 같으면 false를 리턴
		Iterator<itemList>it=itemlist.iterator();//반복자 사용
		while(it.hasNext()) {
			int day=it.next().getDay(); //날짜를 가져옴
			if(il.contains(new itemList(day))){ //비교
				return false;
			}
		}
		//날짜가 다르면 해당 리스트가 추가함
		itemlist.addAll(il);
		return true;
	}
	
	//지출 수정 /미사용
	public boolean setMoneyList(int day,int money_out,String memo) {
		//값이 없으면
		if(itemlist==null) return false;
		//해당 날짜에 인덱스번호를 가져옴
		int index=itemlist.indexOf(new itemList(day));
		//해당 날짜가 없다면
		if(index<0) return false;
		//수정할 지출액이 0원이면 지운다
		if(money_out==0) {
			itemlist.remove(index);
			return true;
		}
		//해당 지출부분을 수정
		itemlist.set(index,new itemList(day, memo, money_out));
		return true;
	}
	
	//출력 확인용
	@Override
	public String toString() {
		return month + "월 " + itemlist + " 수입:" + money_in +"원";
	}	
}
