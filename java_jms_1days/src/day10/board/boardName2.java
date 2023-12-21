package day10.board;

import java.util.Scanner;


public class boardName2 {
	private static Scanner scan = new Scanner(System.in);
	//1. 게시글 배열이 필요(어느 위치에서 선언하고 생성할건지. 크기는 얼마로?)
	private static boardClass[] boardList = new boardClass[5];//게시글 목록
	private static int count = 0; //현재 등록된 게시글 개수 
	/* 게시판에서 게시글 관리를 위한 콘솔 프로그램 작성하세요.
	 * - 제한사항 정리
	 *   - 게시판은 1개
	 *   - 로그인, 회원가입 구현 X => 게시글 작성 시 아이디를 입력
	 *   - 게시글 제목과 내용은 한 줄만 가능
	 *   - 작성일을 입력
	 * 1. 필요한 기능을 정리해서 메뉴로 출력
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 : 1
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 1
	 *   조회할 게시글 번호 : 2
	 *   번호 : 2
	 *   제목 : 가입인사
	 *   내용 : 안녕하세요.
	 *   일자 : 2023-12-20
	 *   작성자: asd
	 *   조회수: 2
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 2
	 *   수정할 게시글 번호 : 2
	 *   제목 : 가입인사입니다.
	 *   내용 : 만나서 반갑습니다.
	 *   수정이 완료됐습니다.
	 * 게시글 목록
	 *   2. 가입인사입니다. 2023-12-20 asd 2
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 3
	 *   삭제할 게시글 번호 : 1
	 *   게시글이 삭제됐습니다.
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 4
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 :2
	 *   제목 : 테스트
	 *   내용 : 테스트
	 *   일자 : 2023-12-20
	 *   아이디: qwe
	 *   등록이 완료됐습니다.
	 *   
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 : 1
	 * 게시글 목록
	 *   3. 테스트 2023-12-20 qwe 0
	 *   2. 가입인사입니다. 2023-12-20 asd 2
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 
	 * 2. 기능을 구현
	 * */
	public static void main(String[] args) {
		
		int menu;
		//반복문
		do {
			//메뉴출력
			printMenu();
			
			//메뉴선택
			menu = scan.nextInt();
			
			//선택한 기능 실행
			runMenu(menu);
		}while(menu != 3);
	}
	
	/**
	 * menu가 주어지면 menu에 맞는 기능을 실행하는 메서드
	 * @param menu 실행할 메뉴의 번호
	 */
	private static void runMenu(int menu) {
		switch (menu) {
		case 1: {
			//게시글 목록 출력, 번호가 높은 순으로
			PostList();
			//서브 메뉴를 출력
			printSubMenu();
			//서브 메뉴 선택
			int subMenu = scan.nextInt();
			runSubmenu(subMenu);
			break;
		}
		case 2:{
			// 게시글 관리를 위한 Board클래스를 정의 하세요.
			insertBoard();
			break;
		}
		case 3:{
			System.out.println("프로그램 종료");
			break;
		}
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	
	private static void PostList() {
		// TODO Auto-generated method stub
		System.out.println("게시글 목록");
		for(int i = count-1; i>=0; i--) {
			boardList[i].printInfo();
		}
	}

	private static void runSubmenu(int subMenu) {
		switch (subMenu) {
		case 1: {
			PostList();
			printBoardDetail();
			//내가 생각한 방법
			//int n = scan.nextInt();
			//tkdtpapsb(n);
			break;
		}
		case 2: {
			PostList();
			updateboard();
			break;
		}
		case 3: {
			//게시글 삭제
			deleteBoard();
			break;
		}
		case 4: {
			System.out.println("이전 메뉴로 넘어갑니다.");
			break;
		}
		default:
			System.out.println("잘못된 메뉴 선택");
			break;
		}
		
	}

	private static void deleteBoard() {
		// 삭제할 게시글 번호 입력
		System.out.print("삭제할 게시글 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		int index = -1;//일치하는 게시글이 있는 번지
		for(int i = 0; i < count; i++) {
			//입력한 번호와 일치하는 게시글을 찾아 번지를 저장
			if(num == boardList[i].getNum()) {
				index = i;
				break;
			}
		}
		if(index == -1) {//일치하는 게시글이 없다는 뜻임 초기값이기 때문에
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		
		count--;
		// 가장 최근에 게시된 게시글을 삭제했다면
		// == 배열에서 가장 마지막에 있는 게시글을 삭제 했다면
		if(index == count) {
			return;
		}
		
		
		//찾은 번지 다음부터 한칸씩 당겨옴
		// 기존 배열과 크기가 같은 새배열 생성
		boardClass[] tmpList = new boardClass[boardList.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, boardList.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서 
		//새배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index+1, boardList, index, count - index);
		
		System.out.println("게시글이 삭제 되었습니다.");

		
	}

	private static void printBoardDetail() {
		//게시글 상세 조회 구현 예정
		System.out.print("조회할 게시글 번호 : ");
		int num = scan.nextInt();
		//반복문 : 등록된 게시글 전체, 배열전체x
		for(int i = 0;i<count;i++) {
			//입력한 번호와 같은 번호를 가진 게시글 찾고
			if(num == boardList[i].getNum()){
				//해당 게시글의 printInfoDetail을 호출
				boardList[i].printInfoDetail();
				boardList[i].getViews();
				return;
			}
			System.out.println("일치하는 게시글이 없습니다.");
		}
	}

	
	/**게시글을 상세 조회하는 내가 만든 메서드
	 * @param n 조회할 메서드의 숫자 입력
	 */
	private static void tkdtpapsb(int n) {
		boardList[n-1].printInfoDetail();
	}
	
	
	private static void updateboard() {
		//수정할 게시글 번호와 제목, 내용을 입력
		System.out.print("수정할 게시글 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 전체 목록 
		for(int i = 0; i < count; i++) {
			//입력한 게시글 번호와 일치하는 게시글이 있으면
			if(num == boardList[i].getNum()) {
				scan.nextLine();
				System.out.print("제목 : ");
				String title = scan.nextLine();
				System.out.print("내용 : ");
				String contents = scan.nextLine();
				boardList[i].update(contents, title);;
				return;
			}
			//해당 게시글의 제목과 내용을 수정하고 메서드 종료
			System.out.println("일치하는 게시글이 없습니다.");
		}
	}

	
	private static void printSubMenu() {
		System.out.println("----------서브메뉴---------");
		System.out.println("1. 게시글 상세 조회");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("------------------------");
		System.out.print("메뉴 선택 : ");
	}

	/** 게시글 정보를 입력받아 게시글을 등록하는 메서드
	 */
	private static void insertBoard() {
		scan.nextLine(); //입력 버퍼에 남아있는 엔터 처리
		//2. 제목, 내용, 일자, 아이디 순으로 입력받음
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String cntents = scan.nextLine();
		System.out.print("작성날짜 : ");
		String date = scan.next();
		System.out.print("아이디(닉네임) : ");
		String writer = scan.next();
		System.out.println("등록이 완료됐습니다.");
		// 입력받은 정보들을 이용하여 게시글 인스턴스 생성
		boardClass board = new boardClass(cntents, date, writer, title);
		// 생성된 인스턴스 배열에 저장(몇번지)
		boardList[count] = board;
		++count;//저장된 개수 증가
		System.out.println(boardList.length);
		//배열의 크기를 안늘려도 되면 종료
		if(count < boardList.length) {
			return;
		}
		//배열이 꽉 차면 배열을 늘려줌
		boardClass[] tmpList = new boardClass[boardList.length + 5];
		//기존 배열보다 큰 배열을 생성하고 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList에 연결
		boardList = tmpList;
	}

	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 게시글 목록 조회");
		System.out.println("2. 게시글 등록");
		System.out.println("3. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}
	
	

}
