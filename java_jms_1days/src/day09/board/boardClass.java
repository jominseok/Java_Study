package day09.board;

import java.util.Scanner;

/* 게시글 관리를 위한 Board클래스를 정의 하세요.
 * - 멤버 변수와 메서드를 추가
 * */
public class boardClass {
	Scanner scan = new Scanner(System.in);
	//정보 : 게시일, 제목, 내용, 작성자, 조회수, 번호
	private int views, num;
	private String contents, date, writer, title;
	//      getter와 setter
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//기능 : 게시글정보를 출력(목록 조회), 게시글 정보를 출력(상세조회), 
	//     게시글 수정 기능
	
	/** 게시글 목록에서 게시글 정보를 출력하는 메서드
	 * 번호. 제목 작성일 작성자 조회수 순으로 출력
	 */
	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(title + " ");
		System.out.print(date + " ");
		System.out.print(writer + " ");
		System.out.print(views + "\n");
	}
	
	/** 게시글 상세에서 게시글 정보를 자세히 출력하는 메서드
	 * 번호 : num
	 * 제목 : title
	 * 내용 : contents
	 * 일자 : date
	 * 작성자: writer
	 * 조회수: views
	 * 순으로 출력
	 */
	public void printInfoDetail() {
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + contents);
		System.out.println("일자 : " + date);
		System.out.println("작성자 : " + writer);
		System.out.println("조회수 : " + views++);
	}
	
	/** 수정할 제목과 내용이 주어지면 게시슬의 제목과 내용을 수정하는 메서드
	 * @param cotents1 수정할 내용
	 * @param title1 수정할 제목
	 */
	public void update(String contents1 ,String title1) {
		title = title1;
		contents = contents1;
	}
	
	public void delete() {
		
	}
	
	//생성자 : 게시글 번호, 제목, 내용, 작성자, 게시일이 주어진 생성자
	public boardClass(int num, String contents, String date, String writer, String title) {
		super();
		this.num = num;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
		this.title = title;
	}
	
}
