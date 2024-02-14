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
	
	//회원가입(오류가 많다...)
	@Override
	public boolean signUpMember(Member member) {
		if(member==null||member.getMe_id()==null) {
			return false;
		}
		if(checkMemberIdName(member.getMe_id(),member.getMe_name())) {
			return false;
		}
		return fanCafeDao.signUpMember(member);
	}
	
	//아이디 닉네임 비교
	private boolean checkMemberIdName(String me_id, String me_name) {
		List<Member> memberList=new ArrayList<Member>();
		memberList=fanCafeDao.selectMemberIdName();
		for(Member tmp:memberList) {
			if (tmp.idNameEquals(me_id, me_name)) {
				return true;
			}
		}
		return false;
	}
	
	//====================조민석시작==============================
	//로그인을위한 아이디 비번 가져오는 메서드 - 조민석
	@Override
	public ArrayList<Member> getMemberLoginList() {
		return fanCafeDao.selectMemberLoginList();
	}
	
	//게시판 선택을 위한 메서드 - 조민석
	@Override
	public ArrayList<Board> getUserBoardSelect() {
		
		return fanCafeDao.userBoardSelect();
	}

	@Override
	public boolean postUpUser(Post post) {
		if(post == null || post.getPo_content() == null || post.getPo_title() == null) {
			return false;
		}
		return fanCafeDao.postUpUser(post);
	}
	@Override
	public ArrayList<Post> selectUserPostList() {
		
	}
	//====================조민석끝================================



}
