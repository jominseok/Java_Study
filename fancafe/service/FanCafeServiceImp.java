	package fancafe.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import fancafe.dao.FanCafeDao;
import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;
import fancafe.pagination.Criteria;

public class FanCafeServiceImp implements FanCafeService {
	private FanCafeDao fanCafeDao;
	
	public FanCafeServiceImp () {
		String resource = "fancafe/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			fanCafeDao = session.getMapper(FanCafeDao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//회원가입-최병호
	@Override
	public boolean signUpMember(Member member) {
		if(member==null||member.getMe_id()==null) {
			System.out.println("값이 없습니다");
			return false;
		}
		if(checkMemberIdName(member)) { 
			System.out.println("아이디 닉네임이 중복됩니다");
			return false;
		}
		if(member.errorchecking()) { //제약조건을 만족하지 못할떄
			System.out.println("조건을 만족하지 못함");
			return false;
		}
		return fanCafeDao.signUpMember(member);
	}
	
	//아이디 닉네임 중 하나라도 겹치지 확인-최병호
	private boolean checkMemberIdName(Member member2) {
		List<Member> memberList=fanCafeDao.selectMember(); //회원 정보를 가져옴
		for(Member tmp:memberList) {
			if (tmp.idNameEquals(member2.getMe_id(),member2.getMe_name())) { //아이디 닉네임 중복 검사
				return true;
			}
		}
		return false;
	}
	
	//등급 가져오기-최병호
	@Override
	public String getMemberLevel(String me_id) {
		return fanCafeDao.selectMemberLevel(me_id);
	}
	
	//회원들 정보를 가져옴-최병호
	@Override
	public List<Member> selectMember() {
		List<Member>memberList=fanCafeDao.selectMember(); //회원 정보를 가져옴
		for(Member tmp:memberList) {
			System.out.println(tmp.getMe_ap_level()+" 닉네임:"+tmp.getMe_name());
		}
		System.out.println("----------------");
		return memberList;
	}
	
	//관리자를 제외한 회원들 정보를 가져옴-최병호
	@Override
	public List<Member> selectMembers() {
		List<Member>memberList=fanCafeDao.selectMember(); //회원 정보를 가져옴
		memberList.remove(new Member("관리자"));
		for(Member tmp:memberList) {
			System.out.println(tmp.getMe_ap_level()+" 닉네임:"+tmp.getMe_name());
		}
		System.out.println("----------------");
		return memberList;
	}

	//닉네임을 통한 삭제-최병호
	@Override
	public boolean deleteMemberName(String me_name) {
		return fanCafeDao.deleteMemberName(me_name);
	}

	//게시판 업데이트-최병호
	@Override
	public boolean updateBoardName(int bd_num, String bd_title) {
		return fanCafeDao.updateBoardName(bd_num,bd_title);
	}

	//게시판 추가 삭제-최병호
	@Override
	public boolean insertBoard(String bd_title) {
		return fanCafeDao.insertBoard(bd_title);
	}

	//게시판 삭제-최병호
	@Override
	public boolean deleteBoard(int bd_num) {
		return fanCafeDao.deleteBoard(bd_num);
	}
	
	//유저등급수정-최병호
	@Override
	public void updateMemberLevel(String me_name) {
		fanCafeDao.updateMemberLevel(me_name); //해당 비회원을 정회원으로 바꿈
	}

	//비회원유저 출력-최병호
	@Override
	public List<Member> selectMemberUnderLevel() {
		List<Member>memberList=fanCafeDao.selectMemberUnderLevel(); //비회원정보만 가져옴
		for(Member tmp:memberList) {
			System.out.println(tmp.getMe_ap_level()+" 닉네임:"+tmp.getMe_name()+" 가입사유:"+tmp.getMe_content());
		}
		return memberList;
	}
	
	//해당 아이디가 비회원 인지 아닌지 구분하는 코드 
	@Override
	public boolean userSelectLevel(String me_id) {
		List<Member>memberList=fanCafeDao.selectMemberUnderLevel();
		for(Member tmp:memberList) {
			if(tmp.idUnderLevel(me_id)) {
				return true;
			}
		}
		return false;
	}
	
	//====================조민석시작==============================
	//로그인을위한 아이디 비번 가져오는 메서드 - 조민석
	@Override
	public List<Member>getMemberLoginList(String me_id) {
		return fanCafeDao.selectMemberLoginList(me_id);
	}
	
	//게시판 선택을 위한 메서드 - 조민석
	@Override
	public ArrayList<Board> getUserBoardSelect() {
		ArrayList<Board> boardList = fanCafeDao.userBoardSelect();
		for(Board tmp : boardList) {
			System.out.println(tmp);
		}
		return boardList;
	}

	@Override
	public boolean postUpUser(Post post) {
		if(post == null || post.getPo_content() == null || post.getPo_title() == null) {
			return false;
		}
		return fanCafeDao.postUpUser(post);
	}
	
	@Override
	public ArrayList<Post> selectUserPostList(int selectBoard) {
		return fanCafeDao.selectUserPostList(selectBoard);
	}
	
	@Override
	public boolean deleteUserPost(int po) {
		return fanCafeDao.deleteUserPost(po);
	}
	
	@Override
	public boolean updateUserPost(Post post) {
		return fanCafeDao.updateUserPost(post);
	}
	
	@Override
	public void viwePlus(int po_view, int po_num) {
		fanCafeDao.viwePlus(po_view, po_num);
	}
	@Override
	public ArrayList<Post> selectUserPostList2(int selectBoard, Criteria cri) {
		return fanCafeDao.selectUserPostList2(selectBoard, cri);
	}
	//====================조민석끝================================
	
	// 게시판에 유저가 쓴 게시글을 조회하는 메서드 : 최지용
	@Override
	public void selectMyPostInBoard(String me_id, int bd_num) {
		List<Post> postList = fanCafeDao.selectMyPostInBoard(me_id,bd_num);
		System.out.println("-------------------------------------------------------------------------");
		int count =1;
		for(Post tmp : postList) {
			System.out.print(count + ". ");
			System.out.println(tmp);
			count++;
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("게시글 조회를 완료했습니다.");
	}
	
	// 아이디 입력시 게시글 있는 게시판 번호와 게시판 이름을 가져오는 메서드 : 최지용
	@Override
	public List <Board> getMyBoard(String me_id) {
		return fanCafeDao.selectMyBoard(me_id);
	}

	
	// 입력한 게시판 번호에 유저가 글을 썼는지 확인하는 메서드(없는 게시판 번호이면 false 반환) : 최지용 
	@Override
	public boolean checkIdBdNum(String me_id, int bd_num) {
		if(fanCafeDao.countIdBdNum(me_id,bd_num)==0){
			return false;
		}
		return true;
	}

	// 닉네임 비교 메서드 : 입력한 닉네임이 중복이 없을 때 true 반환
	public boolean checkMemberName(String me_name) {
		List<Member> memberList=fanCafeDao.selectMember();
		boolean t=true;
		for(Member tmp : memberList) {
			if(tmp.nameEquals(me_name)) {
				t=false;
			}
		}
		if(t==true) {
			return true;
		}else {
			return false;
		}
	}
	
	//  입력한 닉네임이 사용 가능한지 확인하는 메서드
	public boolean checkName(String newName) {
		List<Member> memberList=fanCafeDao.selectMember();
		for(Member tmp : memberList) {
			if(tmp.nameEquals(newName)) {
				return false;
			}
		}
		return true;
	}
					
	// 기존 닉네임과 새 닉네임을 비교하는 메서드 : 최지용
	public boolean checkIdName(String me_id, String newName) {
		List<Member> memberList = fanCafeDao.selectIdName();
		for(Member tmp : memberList) {
			if(tmp.idEquals(me_id)) {
				if(checkMemberName(newName)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	//  입력한 아이디의 회원이  기존 비번을  입력한 새비번으로 수정 가능한지  확인하는 메서드 : 최지용
	public boolean checkMemberIdPw(String me_id, String newPw) {
		List<Member> member = getMemberLoginList(me_id);
		if(!member.get(0).getMe_pw().equals(newPw)) {
			return true;
		}else {
			return false;
		}
	}
		
	// 개인정보 수정, 문제 없을 시 비번 수정하는 메서드 
	public void updatePw(String me_id, String newPw) {
		fanCafeDao.updatePw(me_id, newPw);
	}
	
	// 개인정보 수정, 문제 없을 시 닉네임 수정하는 메서드 
	public void updateName(String me_id, String newName) {		
		fanCafeDao.updateName(me_id, newName);
	}

	@Override
	public void deleteUser(String me_id) {
		fanCafeDao.deleteUser(me_id);
	}
}
