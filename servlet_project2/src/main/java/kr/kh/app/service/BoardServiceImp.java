package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.pagenation.Criteria;

public class BoardServiceImp implements BoardService {

	BoardDAO BoardDao;

	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			BoardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		//현재 페이지 정보 null처리
		if(cri == null) {
			cri = new Criteria();
		}
		return BoardDao.selectBoard(cri);
	}

	@Override
	public boolean Boardinsert(BoardVO board) {
		if (board == null || !checkString(board.getBo_title()) || !checkString(board.getBo_content())) {

			return false;
		}
		return BoardDao.insertBoard(board);
	}

	// 문자열이 null이거나 빈 문자열이면 false 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return BoardDao.selectCommunityList();
	}
}
