package fancafe.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Post {
	private int po_num; //게시글 번호
	private String po_title; //게시글 제목
	private String po_content; //게시글 내용
	private Date po_date; //게시글 날짜
	private int po_view; //조회수
	private int po_bd_num; //게시판 번호
	private String po_me_id; //회원 아이디
	private String po_me_name; //회원 이름	
	
	// 게시글 출력 메서드 
	@Override
	public String toString() {
		return "제목 : " + po_title + ", 닉네임 : "+po_me_name+", 날짜 : " + this.getpo_date_str() + ", 조회수 : " + po_view;
	}
	
	// 게시글 작성 날짜를 이쁘게 바꿔서 반환하는 메서드 : 최지용
	public String getpo_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(po_date);
	}

	public Post(String po_title, String po_content, int po_bd_num, String po_me_id) {
		this.po_title = po_title;
		this.po_content = po_content;
		this.po_bd_num = po_bd_num;
		this.po_me_id = po_me_id;
	}

	public Post(int po_num, String po_title, String po_content) {
		this.po_num = po_num;
		this.po_title = po_title;
		this.po_content = po_content;
	}
	
}
