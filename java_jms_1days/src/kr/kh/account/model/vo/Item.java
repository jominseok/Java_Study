package kr.kh.account.model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data	
public class Item {
	private int it_num;
	private int it_ca_num; 
	private Date it_date; 
	private int it_money; 
	private String it_content;
	
	public Item(int categoryNum, String date, int money, String content) throws ParseException{
		it_ca_num = categoryNum;
		it_money = money;
		it_content = content;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		it_date = format.parse(date);
	}
	
	
}
