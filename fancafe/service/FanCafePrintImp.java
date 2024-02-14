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
		System.out.println("로그인을 했습니다.");
		System.out.println("1. 마이페이지");
		System.out.println("2. 게시판 선택");
		System.out.println("3. 로그아웃");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	
	
	public void printUserBoardMenu() {
		//여기에 db에서 게시판을 보여주고 선택함
		//자기 게시글에 들어갔을때만 나오게
		System.out.println("1. 글 수정");
		System.out.println("2. 글 삭제");
		System.out.println("3. 뒤로가기");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUserMyPageMenu() {
		System.out.println("마이페이지 입니다.");
		System.out.println("1. 개인정보 수정");
		System.out.println("2. 내가 쓴 글 조회");
		System.out.println("3. 뒤로가기");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	public void printUpdateUserDataMenu() {
		System.out.println("개인정보를 수정합니다.");
		System.out.println("1. 비밀번호");
		System.out.println("2. 닉네임");
		System.out.println("3. 뒤로가기");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}
	
	
	@Override
	public void printUserBoardSelect() {
		System.out.println("1. 다른 게시글 보기");
		System.out.println("2. 내가 게시글 쓰기");
		System.out.println("3. 뒤로가기");
		System.out.println("--------");
		System.out.print("메뉴 선택:");
	}

	
}
