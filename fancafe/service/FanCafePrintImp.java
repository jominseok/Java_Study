package fancafe.service;

public class FanCafePrintImp implements FanCafePrint{
	//매뉴출력
	public void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUserMenu() {
		//유저가 로그인 했을 때 승인/미승인 상태일수 있음
		System.out.println("---회원 메뉴---");
		System.out.println("1. 마이페이지");
		System.out.println("2. 게시판 선택");
		System.out.println("3. 로그아웃");
		System.out.println("------------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUserBoardMenu() {
		//여기에 db 에서 게시판을 보여주고 선택함
		//자기 게시글에 들어갔을때만 나오게
		System.out.println("1. 글 수정");
		System.out.println("2. 글 삭제");
		System.out.println("3. 뒤로가기");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUserMyPageMenu() {
		System.out.println("---마이 페이지 메뉴---");
		System.out.println("1. 개인정보 수정");
		System.out.println("2. 내가 쓴 글 조회");
		System.out.println("3. 뒤로가기");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUpdateUserDataMenu() {
		System.out.println("---수정 메뉴---");
		System.out.println("1. 비밀번호");
		System.out.println("2. 닉네임");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 뒤로가기");
		System.out.println("------------");
		System.out.print("메뉴 선택:");
	}
	
	@Override
	public void printUserBoardSelect() {
		System.out.println("1. 조회");
		System.out.println("2. 작성");
		System.out.println("3. 이전으로");
		System.out.println("4. 다음으로");
		System.out.println("5. 뒤로가기");
		System.out.println("--------------");
		System.out.print("메뉴 선택:");
	}

	//관리자 메뉴
	@Override
	public void printManagerMenu() {
		System.out.println("---관리자 메뉴---");
		System.out.println("1. 마이페이지");
		System.out.println("2. 회원 관리");
		System.out.println("3. 게시판 관리");
		System.out.println("4. 게시판 선택");		
		System.out.println("5. 로그아웃");
		System.out.println("-------------");
		System.out.print("메뉴 선택:");
	}
	
	@Override
	public void userManagerMenu() {
		System.out.println("---회원 관리 메뉴---");
		System.out.println("1. 회원 승인");
		System.out.println("2. 회원 강퇴");
		System.out.println("3. 회원 조회 ");
		System.out.println("4. 뒤로가기");
		System.out.println("----------------");
		System.out.print("메뉴 선택:");
	}

	@Override
	public void boardManagerMenu() {
		System.out.println("---게시판 관리 메뉴---");
		System.out.println("1. 게시판 추가");
		System.out.println("2. 게시판 수정");
		System.out.println("3. 게시판 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}

	@Override
	public void userMyPost() {
		System.out.println("내가 작성한 게시글을 수정 및 삭제합니다.");
		System.out.println("---내가 쓴 글 관리 메뉴---");
		System.out.println("1. 내가 쓴 글 삭제");
		System.out.println("2. 내가 쓴 글 수정");
		System.out.println("3. 뒤로가기");
		System.out.println("-----------------");
		System.out.print("메뉴 선택:");
	}
	
}
