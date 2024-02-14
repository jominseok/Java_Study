package fancafe.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	private int po_num; //게시글 번호
	private String po_title; //게시글 제목
	private String po_content; //게시글 내용
	private Date po_date; //게시글 날짜
	private int po_view; //조회수
	private int po_bd_num; //게시판 번호
	private String po_me_id; //회원 아이디
	
	public Post(String po_title, String po_content, int po_bd_num, String po_me_id) {
		this.po_title = po_title;
		this.po_content = po_content;
		this.po_bd_num = po_bd_num;
		this.po_me_id = po_me_id;
	}
	
	
}
