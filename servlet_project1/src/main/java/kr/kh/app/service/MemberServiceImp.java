package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDao;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVo;

public class MemberServiceImp implements MemberService {
	private MemberDao memberDao;

	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVo memberVo) {
		if (memberVo == null || memberVo.getMe_id() == null || memberVo.getMe_pw() == null) {
			return false;
		}
		// 정규 표현식 체크 : to do

		try {
			// 아이디가 중복되면 예외가 발생
			return memberDao.insertMember(memberVo);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public MemberVo login(LoginDTO loginDTO) {
		if (loginDTO == null) {
			return null;
		}
		// 아이디를 주고 회원 정보를 요청
		MemberVo user = memberDao.selectMember(loginDTO.getId());

		// 아이디가 잘못 입력하면
		if (user == null) {
			return null;
		}
		// 비번이 같은지 확인
		if (user.getMe_pw().equals(loginDTO.getPw())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkId(String id) {
		MemberVo member = memberDao.selectMember(id);
		return member == null;
	}

}
