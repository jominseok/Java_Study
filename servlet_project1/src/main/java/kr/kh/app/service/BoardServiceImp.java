package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.dao.MemberDao;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.pagenaination.Criteria.Criteria;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;

	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertBoard(BoardVO baord) {
		if (baord == null || baord.getBo_title() == null || baord.getBo_title().length() == 0) {
			return false;
		}
		if (baord.getBo_me_id() == null) {
			return false;
		}
		if (baord.getBo_content() == null) {
			return false;
		}
		return boardDao.insertBoard(baord);
	}

	@Override
	public ArrayList<CommunityVo> selectCommunityList() {

		return boardDao.selectCommunityList();
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if (cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if (cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}
}
