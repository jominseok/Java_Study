package HomeHW02.cbh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import HomeHW02.cbh.itemList;

public class AccountBook {
	private List<Item> list;

	public AccountBook(List<Item> list) {
		if(list==null) {
			list=new ArrayList<Item>();
		}
		this.list = list;
	}
	
	//수입 추가
	public boolean addMoney_in(int month,int money_in) {
		//money의 ml 리스트가 null이면 false만 나오므로
		List<itemList> ml=new ArrayList<itemList>();
		if(list==null) {
			return false;
		}
		//같은 월(달) 의 인덱스를 가져옴
		int index=list.indexOf(new Item(month));
		//같은 월이 없으면 리스트를 추가함
		if(index<0) {
			list.add(new Item(month, ml,money_in));
			return true;	
		}
		//같은 월이 있고 수입이 0원이면 수정
		if(index>=0&&list.get(index).getMoney_in()==0) {
			list.set(index,new Item(month,list.get(index).getItemlist(), money_in));
		}
		return false;
	}
	
	//지출내역
	public boolean addMoney_out(int month,List<itemList> ml) {
		if(list==null) return false;
		//같은 월이 있는지 확인하기윈한 인덱스
		int index=list.indexOf(new Item(month));
		//없으면 지출내역을 저장
		if(index<0) {
			list.add(new Item(month,ml));
			return true;
		}
		//달은 같지만 일이 다른지 비교하고 해당 달에 저장
		if(list.get(index).addMoneyList(ml)) {
			return true;
		}
		return false;
	}
	//출력 확인용
	public void print() {
		System.out.println(list);
	}
	
	//지출 수정
	public boolean setMoney_Out(int month, int day, int money, String memo) {
		//같은 날짜가 있으면 인덱스를가져옴
		int index=list.indexOf(new Item(month));
		//같은 달이 있다면 .setMoneyList를 통해 일도 비교해서 수정함
		if(index>=0) {
			if(list.get(index)
					.setMoneyList(day, money, memo)) return true;
		}
		return false;
	}
	
	//월 조회기능 수입 수입 총지출액 손익
	public void monthPrint(int month) {	
		int sum=0; //총지출액
		int index=list.indexOf(new Item(month));//또 인덱스
		if(index>=0) { //일치하는게 있다면
			//수입을 가저옴
			int money_in=list.get(index).getMoney_in();
			//list의 지출목록인 itemlist를 가져옴
			List<itemList>il=list.get(index).getItemlist();
			//반복자를 이용해서 지출액을 모두더함
			Iterator<itemList>it=il.iterator();
			while(it.hasNext()) {
				sum+=it.next().getMoney_out();
			}
			//출력 /item에 메서드 만들고 가져와도 될듯
			System.out.println(month+"월 수입:"+money_in+
					"원 총지출액:"+sum+"원 손익:"+(money_in-sum)+"원");
			return;
		}
		System.out.println("기록이 없습니다");
	}

	//일자 조회기능
	public void dayPrint(int month, int day) {
		//비교후 인덱스를 가져와서 해당날짜 지출액,내용을 출력함
		int index=list.indexOf(new Item(month));
		if(index>=0) {
			List<itemList> il=list.get(index).getItemlist();
			index=il.indexOf(new itemList(day));
			if(index>=0){
				System.out.println(month+"월 "+il.get(index));
			}else {
				System.out.println("일치하는 일이 없습니다");
			}
			return;
		}
		System.out.println("일치하는 달이 없습니다");
	}
}