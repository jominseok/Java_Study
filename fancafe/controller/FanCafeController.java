package fancafe.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;
import fancafe.service.FanCafePrint;
import fancafe.service.FanCafePrintImp;
import fancafe.service.FanCafeService;
import fancafe.service.FanCafeServiceImp;

public class FanCafeController {
	private FanCafeService fanCafeService=new FanCafeServiceImp();
	private FanCafePrint fanCafePrint=new FanCafePrintImp();
	private Scanner scan=new Scanner(System.in);
	//메뉴 출력
	public void printMenu() {
		fanCafePrint.printMenu();
	}

	//메뉴 실행
	public void runMenu(int menu) {
		switch (menu) {
		case 1: //로그인 입력
			login();
			break;
		case 2: //회원 가입
			SignUp();
			break;
		case 3: 
			System.out.println("종료합니다");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	//로그인 기능
	public void login() {
		System.out.println("아이디와 비밀번호를 입력하세요.");
		System.out.print("아이디:");
		String me_id=scan.next(); 
		System.out.print("비빌번호:");
		String me_pw = scan.next();
		Member member = new Member(me_id, me_pw);
		for(Member tmp : fanCafeService.getMemberLoginList()) {
			if(tmp.loginEquals(member)) {
				System.out.println("로그인에 성공 하였습니다.");
				// 여기에 로그인에 성공 했을때 함수 실행하면 될것 같습니다!!
				// 지금은 로그인한 사람이 관리자는 생각 안함 
				userPage(me_id);
				return;
			}
		}
		System.out.println("로그인에 실패했습니다.");
	}

	
	// 로그인한 유저가 선택한 메뉴를 실행하는 메서드 
	
	private void runUserMenu(int menu, String me_id) {
		switch (menu) {
		case 1: 
			myPage(me_id); // 마이페이지 
			break;
		
		case 2: 
			userBoard(me_id); // 게시판 선택
			
			break;
		
		case 3: 
			System.out.println("로그아웃 합니다.");
				
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + 1);
		}
	}
	
	
	// 유저가 게시판을 선택하고 글을 작성하는 기능 - 조민석
	private void userBoard(String me_id) {
		System.out.println("게시판을 선택해주세요.");
		ArrayList<Board> boardList = fanCafeService.getUserBoardSelect();
		for(Board tmp : boardList) {
			System.out.println(tmp.getBd_num() + " " + tmp.getBd_title());
		}
		System.out.print("----------");
		System.out.print("메뉴선택 : ");
		int selectBoard = scan.nextInt();
		runPrintSelect(selectBoard, boardList, me_id);
		return;
		
	}

	//게시판을 선택했을때 메서드-조민석
	private void runPrintSelect(int selectBoard, ArrayList<Board> boardList, String me_id) {
		int po_bd_num = selectBoard-1;
		Board board = boardList.get(po_bd_num);
		if(board.getBd_title().contains("공지")) {
			System.out.println("일반 회원은 글 작성이 불가합니다.");
			return;
		}
		System.out.println(board.getBd_title() + " 게시판에 오신것을 환영합니다.");
		int menu=0;
		do {
			fanCafePrint.printUserBoardSelect();
			try {
				menu = scan.nextInt();
				runBoardSelect(menu, board, po_bd_num, me_id);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입니다.");
			}
		} while (menu != 3);
	}

	private void runBoardSelect(int menu, Board board, int po_bd_num ,String me_id) {
		switch (menu) {
		case 1: {
			// 다른 게시글 보기
			fanCafeService.selectUserPostList();
			break;
		}
		case 2: {
			// 내가 게시글 쓰기
			System.out.println("글 제목을 입력해 주세요");
			scan.next();
			String po_title = scan.nextLine();
			System.out.println("내용을 입력해주세요");
			String po_content = scan.nextLine();
			Post post = new Post(po_title, po_content, po_bd_num+1, me_id);
			//게시글 작성에 실패하면 종료
			if(fanCafeService.postUpUser(post)) {
				System.out.println("게시글 작성에 성공했습니다.");
				break;
			}else {
				System.out.println("게시글 작성에 실패하였습니다.");				
			}
			break;
		}
		case 3: {
			System.out.println("뒤로 돌아갑니다.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
	}

	// 마이 페이지 실행 메서드
	private void myPage(String me_id) {
		fanCafePrint.printUserMyPageMenu();
		int menu = scan.nextInt();
		runUserMyPageMenu(menu);
		
		
	}

	// 마이 페이지 선택 메뉴 실행 메서드 
	private void runUserMyPageMenu(int menu) {
		switch(menu) {
		case 1 : 
			
			break;
			
		case 2 :
			
			break;
			
		case 3 :
			
			break;
			
			
		
		}
		
	}

	// 유저의 로그인 완료 후를 실행하는 메서드
	private void userPage(String me_id) {
		int menu=0;
		do {
			fanCafePrint.printUserMenu();
			try {
			menu = scan.nextInt();
			runUserMenu(menu, me_id);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입니다.");
				scan.nextLine();
			}
		} while (menu != 3);
		
	}


	//회원가입 기능
	public void SignUp() {
		System.out.println("회원가입입니다.");
		System.out.print("아이디:");
		String me_id=scan.next(); 
		System.out.print("비빌번호:");
		String me_pw=scan.next(); 
		System.out.print("비밀번호 확인:");
		String me_pw2=scan.next(); 
		if(!me_pw.equals(me_pw2)) {
			System.out.println("비밀번호가 다릅니다");
			return;
		}
		System.out.print("닉네임:");
		String me_name=scan.next(); 
		System.out.print("성별:");
		String me_gender=scan.next();
		System.out.print("생년월일:");
		String me_birth=scan.next(); 
		System.out.print("가입사유:");
		scan.nextLine();
		String me_content=scan.nextLine(); 
		Member member=new Member(me_id, me_pw, me_name, me_gender, me_birth, me_content);
		if(fanCafeService.signUpMember(member)){
			System.out.println("가입이 완료되었습니다");
		}else {
			System.out.println("중복되는 정보가 있습니다");
		}	
	}
	

}
