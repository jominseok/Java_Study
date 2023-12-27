package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DateEx1 {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		
		System.out.println(date);
		
		//Date => String
		/* 화면에 보여줄 시간 패턴을 문자열로 지정
		 * yyyy : 년, MM : 월, dd : 일, hh : 시(오후2시 -> 2시),
		 * HH : 시(오후2시 -> 14시), mm : 분, ss : 초
		 * MM과 mm은 바꾸면 안됨
		 * */
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
		String str = format.format(date);
		System.out.println(str);
		
		//String => Date
		Date date2 = format.parse(str);
		System.out.println(date2);
		
		Board board = new Board("제목", "내용", new Date());
		System.out.println(board);
		Board board2 = new Board("제목2", "내용", null);
		board2.setRegDate("2023-12-27 18:00:00");
		
	}
}

@AllArgsConstructor
@Data
class Board{
	String title, contents;
	
	Date regDate;//작성일
	public void setRegDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			regDate = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


