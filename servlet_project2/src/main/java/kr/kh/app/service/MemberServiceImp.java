package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;



public class MemberServiceImp implements MemberService{
	
	MemberDAO mamberDao;
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			mamberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		//필수 항목체크
		if(member.getMe_id() == null || member.getMe_pw() == null || member.getMe_email() == null) {
			return false;
		}
		//아이디 중복 체크
		
		//각 항목 유효성 검사
		
		//아래 예외 처리는 아이디 중복체크 검사를 안했기 때문에 발생하는 예외를 임시 처리하기 위한 방법
		try {
			boolean res = mamberDao.insertMember(member);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public MemberVO getMember(LoginDTO loginDTO) {
		System.out.println(loginDTO);
		if(loginDTO == null) {
			return null;
		}
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		MemberVO user = mamberDao.selectMember(loginDTO.getId());
		//가져온 회원정보가 없으면 null리턴
		if(user == null) {
			return null;
		}
		//있으면 DB 정보의 비번과 입력한 비번이 같으면 DB정보를, 다르면 null을 리턴
		if(user.getMe_id().equals(loginDTO.getPw())) {
			return user;
		}
		return null;
	}
}
