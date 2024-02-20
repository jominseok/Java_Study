package fancafe.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import fancafe.main.FanCafeMain;
import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;
import fancafe.pagination.Criteria;
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
			System.out.println("없는 메뉴입니다");
		}
	}

	//회원 가입 기능-최병호
	public void SignUp() {
		System.out.println("아이디와 비밀번호를 입력하세요.");
		System.out.print("아이디:");
		String me_id=scan.next(); 
		System.out.println("비밀번호는 영문자,숫자,특수문자(!,@,?)포함 12자 이상 20자 이하");
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
		System.out.print("성별(남/여):");
		String me_gender=scan.next();
		System.out.print("생년월일(6자리):");
		String me_birth=scan.next(); 
		System.out.print("가입사유:");
		scan.nextLine();
		String me_content=scan.nextLine(); 
		Member member=new Member(me_id, me_pw, me_name, me_gender, me_birth, me_content);
		if(fanCafeService.signUpMember(member)){
			System.out.println("가입이 완료되었습니다");
		}else {
			System.out.println("되돌아갑니다");
		}	
	}
	
	//관리자 메뉴 페이지-최병호
	private void managerPage(String me_id) {
		System.out.println("매니저님 환영합니다.");
		int menu=0;
		do {
			fanCafePrint.printManagerMenu(); //메뉴출력
			try {
				menu = scan.nextInt();
				runManagerMenu(menu,me_id); //메뉴실행
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력 입니다.");
				scan.nextLine();
			}
		} while (menu != 5);	
	}

	//관리자 메뉴 실행 -최병호
	private void runManagerMenu(int menu, String me_id) {
		switch (menu) {
		case 1: 
			userMyPage(me_id); // 마이페이지 
			break;
		case 2: 
			// 회원관리
			userManager();
			break;	
		case 3: 
			// 게시판관리
			boardManager();
			break;
		case 4: 
			userBoard(me_id); // 게시판선택
			break;
		case 5: 
			System.out.println("로그아웃 합니다.");	
			break;
		default:
			System.out.println("없는 메뉴 입니다");
		}
	}

	//회원 관리 메뉴출력-최병호
	private void userManager() {
		System.out.println("회원을 관리합니다.");
		int menu=0;
		do {
			fanCafePrint.userManagerMenu(); //메뉴 출력
			try {
				menu=scan.nextInt();
				runUserManagerMenu(menu); //메뉴 실행
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu!=4);
	}

	//회원 관리 기능-최병호
	private void runUserManagerMenu(int menu) {
		switch (menu) {
		case 1: //승인
			updateMemberLevel();
			break;
		case 2: //강퇴
			deleteMember();
			break;	
		case 3: //조회
			selectMember();
			break;
		case 4: 
			System.out.println("뒤로 갑니다.");	
			break;
		default:
			System.out.println("없는 메뉴입니다.");
		}
	}

	//비회원 승인-최병호
	private void updateMemberLevel() {
		List<Member>memberList=fanCafeService.selectMemberUnderLevel(); //비회원인 회원닉네임 및 가입사유를 보여줌
		System.out.print("승인할 닉네임을 선택:");
		String me_name=scan.next();
		if(memberList.contains(new Member(me_name))) { //해당 닉네임을 확인
			fanCafeService.updateMemberLevel(me_name); //회원의 등급을 업시켜줌
		}else {
			System.out.println("없는 닉네임 입니다");
		}
	}

	//회원 강퇴기능-최병호
	private void deleteMember() {
		List<Member>memberList=fanCafeService.selectMembers(); //강퇴가능한 회원들 목록을 출력
		System.out.print("강퇴시킬 닉네임을 선택:");
		String me_name=scan.next();
		if(memberList.contains(new Member(me_name))) { //해당 닉네임을 확인
			if(fanCafeService.deleteMemberName(me_name)) { //해당회원을 탈퇴시킴
				System.out.println("강퇴가 되었습니다");
			}else {
				System.out.println("강퇴 실패");
			}
		}else {
			System.out.println("없는 닉네임 입니다");
		}
	}

	//회원 조회기능-최병호
	private void selectMember() {
		List<Member>memberList=fanCafeService.selectMember(); //회원들 목록을 출력
		System.out.print("조회할 닉네임을 선택:");
		String me_name=scan.next();
		int index=memberList.indexOf(new Member(me_name)); //해당 닉네임의 인덱스를 가저옴
		if(index>=0) {
			System.out.println(memberList.get(index)); //해당 인덱스의 회원의 정보를 출력
			return;
		}
		System.out.println("없는 닉네임 입니다");
	}
	
	//게시판 관리 메뉴출력-최병호
	private void boardManager() {
		System.out.println("게시판을 관리합니다.");
		int menu=0;
		do {		
			fanCafePrint.boardManagerMenu();
			try {
				menu=scan.nextInt();
				runBoardManagerMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입니다.");
				scan.nextLine();
			}
		}while(menu!=4);
	}
	
	//게시판 관리 기능-최병호
	private void runBoardManagerMenu(int menu) {
		switch (menu) {
		case 1: //추가
			addBoard();
			break;
		case 2: //수정
			updateBoard();
			break;	
		case 3: //삭제
			deleteBoard();
			break;
		case 4: 
			System.out.println("뒤로 갑니다.");	
			break;
		default:
			System.out.println("없는 메뉴입니다.");	
		}
	}

	//게시판 추가-최병호
	private void addBoard() {
		List<Board> boardList=fanCafeService.getUserBoardSelect(); //게시판 목록을 보여줌
		System.out.print("추가할 게시판 명:");
		String bd_title=scan.next();
		for(Board tmp:boardList) { //향상된 for문을 이용한 게시판명 비교
			if(tmp.getBd_title().equals(bd_title)) { 
				System.out.println("같은 게시판명이 있습니다");
				return;
			}
		}
		if(fanCafeService.insertBoard(bd_title)) { //게시판추가
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}

	//게시판 수정-최병호
	private void updateBoard() {
		List<Board> boardList=fanCafeService.getUserBoardSelect(); //게시판 목록을 보여줌
		System.out.println("-------------");
		System.out.print("수정할 게시판 번호:");
		int bd_num=scan.nextInt();
		if(!boardList.contains(new Board(bd_num))) { //게시판 번호를 통한 확인
			System.out.println("없는 번호입니다");
			return;
		}
		System.out.print("수정할 게시판 명:"); 
		String bd_title=scan.next();
		for(Board tmp:boardList) { 
			if(tmp.getBd_title().equals(bd_title)) {
				System.out.println("같은 게시판명이 있습니다");
				return;
			}
		}
		if(fanCafeService.updateBoardName(bd_num, bd_title)) { //게시판이름 수정
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}

	//게시판 삭제-최병호
	private void deleteBoard() {
		List<Board> boardList=fanCafeService.getUserBoardSelect();  //게시판 목록을 보여줌
		System.out.println("-------------");
		System.out.print("삭제할 게시판 번호:");
		int bd_num=scan.nextInt();
		if(!boardList.contains(new Board(bd_num))) {
			System.out.println("없는 번호입니다");
			return;
		}
		if(fanCafeService.deleteBoard(bd_num)) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	// 로그인한 유저가 선택한 메뉴를 실행하는 메서드 : 최지용
	private void runUserMenu(int menu, String me_id) {
		switch (menu) {
		case 1: 
			userMyPage(me_id); // 마이페이지-최지용
			break;
		case 2: 
			userBoard(me_id); // 게시판 선택-조민석
			break;	
		case 3: 
			System.out.println("로그아웃 합니다.");	
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	//---------조민석----
	//로그인 기능
	public void login() {
		System.out.println("아이디와 비밀번호를 입력하세요.");
		System.out.print("아이디:");
		String me_id=scan.next(); 
		System.out.print("비밀번호:");
		String me_pw = scan.next();

			List<Member> member = fanCafeService.getMemberLoginList(me_id);// 아이디를 확인하기 위한 메서드 다오에서 호출 
			//관리자인지 아닌지 판별하여 메뉴 페이지를 다르게 출력
			if(member.size()==0) {
				System.out.println("로그인에 실패했습니다.");
				return;
			}
			if(member.get(0).loginEquals(new Member(me_id, me_pw))) {
				if(fanCafeService.getMemberLevel(me_id).equals("관리자")) {
					managerPage(me_id);//관리자 페이지 실행
					return;
				}else {
					userPage(me_id); //유저 페이지 실행
					return;
				}
			}
			
			System.out.println("로그인에 실패했습니다.");		
	}
	
	// 유저가 게시판을 선택하고 글을 작성하는 기능 - 조민석
	private void userBoard(String me_id) {
		System.out.println("게시판을 선택해주세요.");
		//게시판 선택을 위한 메서드를 다오에서 호출
		ArrayList<Board> boardList = fanCafeService.getUserBoardSelect();
		System.out.println("----------");
		System.out.print("메뉴선택 : ");
		runPrintSelect(me_id, boardList);
		return;	
	}

	//게시판을 선택했을때 메서드-조민석
	private void runPrintSelect(String me_id, ArrayList<Board> boardList ) {
			int index = -1; //선택한 게시판의 게시판 번호를 가 있는지 없는지 판별하기 위한 변수
			int selectBoard = scan.nextInt();
			// 입력받은 숫자가 데베에 있는 번호와 일치하면 변수 저장
			for(int i = 0; i < boardList.size(); i++) {
				if(boardList.get(i).getBd_num() == selectBoard) {
					index = i;
				}
			}
			// 없으면 종료
			if(index == -1) {
				System.out.println("잘못 선택하셨습니다.");
				return;
			}
			//해당 게시판 선택 후 출력
			Board board = boardList.get(index);
			System.out.println("-------------------------------------------------------------");
			System.out.println(board.getBd_title() + "에 오신것을 환영합니다.");
		/*	System.out.println("-------------------------------------------------------------");
			postPrint(selectBoard);//선택한 게시판에 게시글들을 출력하는 메서드
			System.out.println("-------------------------------------------------------------");			
			*/
			try {
				//menu = scan.nextInt();
				runBoardSelect(board, me_id,selectBoard); //게시글을 선택했을때 메서드
				return;
			}catch(InputMismatchException e) {
				System.out.println("-------------------------------------------------------------");
				System.out.println("잘못된 선택입니다.");
				System.out.println("-------------------------------------------------------------");
			}
	}
	
	//선택한 게시판에 게시글들을 출력하는 메서드
		private void postPrint2(int selectBoard, Criteria cri) {
			//현재 페이지가 0보다 작아지면 1로 다시 클레스로 전송한다.
			if(cri.getPage() < 0) {
				cri = new Criteria(1);
			}
			//현재 입력받은 페이지를 입력받아 sql문문으로 전송 limit에서 사용함, selectBoard는 게시판의 숫자를 구별하기위한 변수 where문에서 사용
			ArrayList<Post> postListLimit = fanCafeService.selectUserPostList2(selectBoard, cri);
			if(postListLimit == null || postListLimit.size() == 0) {
				System.out.println("조회할 내역이 없습니다.");
			}
			else {
				for(Post tmp : postListLimit) {
					System.out.println(tmp.getPo_num()+ ". " + tmp);
				}
			}
		}

	//조민석 - 게시글을 선택 했을때 메서드
	private void runBoardSelect(Board board,String me_id, int selectBoard) {
		int menu;
		int page = 0;
		do {
			Criteria cri = new Criteria(page);
			System.out.println("-------------------------------------------------------------");
			postPrint2(selectBoard, cri);//선택한 게시판에 게시글들을 출력하는 메서드
			System.out.println("-------------------------------------------------------------");			
			fanCafePrint.printUserBoardSelect();
			menu = scan.nextInt();
			switch (menu) {
			case 1: {
				// 조회	
				if(fanCafeService.userSelectLevel(me_id)) { //해당 아이디가 비회원 인지 확인하는 코드
					System.out.println("비회원은 사용할 수 없습니다.");
					return;
				}
				ArrayList<Post> postList = fanCafeService.selectUserPostList(selectBoard);
				System.out.print("조회할 게시글을 선택해 주세요 : ");
				int selectPost = scan.nextInt();
				int index = -1;
				for(int i = 0; i < postList.size(); i++) {
					if(postList.get(i).getPo_num() == selectPost) {
						index = i;
					}
				}
				if(index == -1) {
					System.out.println("잘못 선택하셨습니다.");
					return;
				}
				Post po = postList.get(index);
				//게시글을 선택했을때 조회수가 올라가는 메서드
				fanCafeService.viwePlus(po.getPo_view()+1, po.getPo_num());
				postSelectPrint(po);
				//선택한 게시글이 내가 작성한 글일때 실행되는 메서드
				try {
					if(me_id.equals("admin")||po.getPo_me_id().contains(me_id)) {
						userMyPost(po);
					}
				} catch (Exception e) {
					
				}
				
					System.out.println("-------------------------------------------------------------");
					break;
			}
			case 2: {
				if(fanCafeService.userSelectLevel(me_id)) { //해당 아이디가 비회원 인지 확인하는 코드
					System.out.println("비회원은 사용할 수 없습니다.");
					return;
				}
				// 작성	
				System.out.println("글 제목을 입력해 주세요");
				scan.nextLine();
				String po_title = scan.nextLine();
				System.out.println("내용을 입력해주세요");
				String po_content = scan.nextLine();
				Post post = new Post(po_title, po_content, board.getBd_num(), me_id);
				//게시글 작성에 실패하면 종료
				if(fanCafeService.postUpUser(post)) {
					System.out.println("게시글 작성에 성공했습니다.");
					return;
				}else {
					System.out.println("게시글 작성에 실패하였습니다.");				
					}
				}
			case 3: {
				//페이지가 1이하로 내려가면 페이지를 0으로 초기화 하고 아니면 -5
				if(page < 1) {
					page = 0;
				}else {
					page -= 5;
				}
				break;
			}
			case 4: {
				//페이지 숫자 +5
				page +=5; 
				break;
			}
			case 5: {
				System.out.println("뒤로 돌아갑니다.");
				break;
			}
			default:
				System.out.println("-------------------------------------------------------------");
				System.out.println("잘못된 선택입니다.");
				System.out.println("-------------------------------------------------------------");
			}
		} while (menu != 5);
	}
	//게시글을 상세조회 했을때 메서드
	private void postSelectPrint(Post po) {
		System.out.println("제목 : " + po.getPo_title() + "\n" +
				   "작성 날짜 : " + po.getpo_date_str() + "\n" + 
				   "내용 : " + po.getPo_content() + "\n" + 
				   "조회수 : " + po.getPo_view());
	}
	
	private void userMyPost(Post po) {
		fanCafePrint.userMyPost();
		int index = scan.nextInt();
		switch (index) {
		case 1: {
			if(!fanCafeService.deleteUserPost(po.getPo_num())) {
				System.out.println("삭제에 실패하였습니다.");
				break;
			}
			System.out.println("게시글이 삭제되었습니다.");
			break;
		}
		case 2:{
			System.out.print("제목을 수정해주세요 : ");
			scan.nextLine();
			String po_title = scan.nextLine();
			System.out.print("내용을 수정해주세요: ");
			String po_content = scan.nextLine();
			Post post = new Post(po.getPo_num(),po_title, po_content);
			if(!fanCafeService.updateUserPost(post)) {
				System.out.println("수정에 실패하였습니다.");
				break;
			}
			System.out.println("수정이 완료되었습니다.");
			break;
		}
		case 3:{
			return;
		}
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	//---------최지용
	// 마이 페이지 실행 메서드 : 최지용
	private void userMyPage(String me_id) {
		System.out.println("마이페이지 입니다");
		int menu =0;		
		do {
			fanCafePrint.printUserMyPageMenu();
			try {
				menu = scan.nextInt();
				runUserMyPageMenu(menu, me_id);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu!=3);	
	}

	// 마이 페이지 선택 메뉴 실행 메서드 : 최지용
	private void runUserMyPageMenu(int menu, String me_id) {
		switch(menu) {
		case 1 : 
			updateMyData(me_id); // 개인 정보 수정 메서드
			break;
		case 2 :
			selectMyPost(me_id); // 내가 쓴 글 조회 메서드
			break;
		case 3:
			System.out.println("뒤로 갑니다.");
			break;	
		default : 
			throw new InputMismatchException();				
		}		
	}

	// 유저가 자신이 쓴 글 조회하는 메서드 : 최지용
	private void selectMyPost(String me_id) {
		if(!selectMyBoard(me_id)) {
			System.out.println("조회할 게시글이 없습니다.");
			return;
		}
		System.out.println("회원님의 게시글을 볼 게시판을 위에서 선택하세요.");
		System.out.print("게시판 번호 입력 : ");
		int bd_num = scan.nextInt();	
		if(fanCafeService.checkIdBdNum(me_id,bd_num)) {
			selectMyPostInBoard(me_id ,bd_num);
		}else {
			System.out.println("잘못된 게시판 번호입니다.");
			scan.nextLine();
		}	
	}
	
	// 유저가 사용한 게시판을 보여주는 메서드 : 최지용
	public boolean selectMyBoard(String me_id) {
		List <Board> boardList = fanCafeService.getMyBoard(me_id);
		if(boardList.size()==0) {
			return false;
		}
		System.out.println("회원님의 게시글이 등록된 것으로 확인되는 게시판들은 다음과 같습니다.");
		System.out.println("----------------");
		for(Board tmp : boardList) {
			System.out.println(tmp);
		}
		System.out.println("----------------");
		return true;
	}
	
	// 게시판 선택 후 자기 게시글 조회 메서드 : 최지용
	public void selectMyPostInBoard(String me_id ,int bd_num) {
		fanCafeService.selectMyPostInBoard(me_id,bd_num);
	}
	
	// 개인 정보 수정 메서드 : 최지용
	private void updateMyData(String me_id) {
		System.out.println("개인정보를 수정합니다.");
		int menu=0;
		do {
			fanCafePrint.printUpdateUserDataMenu();
			try {
				 menu = scan.nextInt();
				runUpdateUserDataMenu(menu, me_id);
			}catch(InputMismatchException e){
				System.out.println(" 잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu!=4);
	}

	// 개인 정보 수정 메뉴 실행 메서드 : 최지용
	private void runUpdateUserDataMenu(int menu, String me_id) {
		switch(menu) {
		case 1 :
			updatePw(me_id); // 비밀번호 수정 메서드
			break;
		case 2 :
			updateName(me_id); // 닉네임 수정 메서드
			break;
		case 3 :
			deleteUser(me_id);//회원탈퇴 기능
			break;	
		case 4 :
			System.out.println("뒤로 갑니다.");
			break;
		default :
			throw new InputMismatchException();				
		}	
	}

	private void deleteUser(String me_id) {
		System.out.println("========회원탈퇴========");
		System.out.println("정말로 회원을 탈퇴하시겟습니까?");
		System.out.println("회원탈퇴를 정말로 원하신다면 '회원탈퇴'를 입력해주세요");
		String deleteMent = scan.next();
		if(deleteMent.equals("회원탈퇴")) {
			fanCafeService.deleteUser(me_id);
			FanCafeMain.main(null);
			return;
		}
		System.out.println("회원탈퇴에 실패하였습니다.");
	}

	// 닉네임 수정 메서드 : 최지용
	private void updateName(String me_id) {
		System.out.println("닉네임을 수정합니다.");
		System.out.println("새 닉네임을 입력하세요.");
		scan.nextLine();
		String newName = scan.next();
		if(me_id.equals("admin")) {
			System.out.println("관리자는 닉네임 수정이 불가능합니다");
			return;
		}
		if(fanCafeService.checkName(newName)) {
			fanCafeService.updateName(me_id,newName);
			System.out.println("닉네임을 수정했습니다.");
		}else {
			System.out.println("이미 존재하는 닉네임 입니다.");
		}
	}
	
	// 비밀번호 수정 메서드 : 최지용
	private void updatePw(String me_id) {
		System.out.println("비밀번호를 수정합니다.");
		System.out.print("새 비밀번호를 입력하세요.");
		scan.nextLine();
		String newPw = scan.next();
		if(fanCafeService.checkMemberIdPw(me_id,newPw)) {
			fanCafeService.updatePw(me_id,newPw);
			System.out.println("비밀번호를 수정했습니다.");
			System.out.println("------------------");
		}else {
			System.out.println("기존 비밀번호와 같습니다. ");
		}
	}
			
	// 유저의 로그인 완료 후를 실행하는 메서드 : 최지용
	private void userPage(String me_id) {
		System.out.println("회원님 환영합니다.");
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
	
}

