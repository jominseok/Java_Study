package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.model.vo.MemberVo;
import kr.kh.app.pagenaination.Criteria.Criteria;

public interface BoardService {

	boolean insertBoard(BoardVO baord);

	ArrayList<CommunityVo> selectCommunityList();

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(int num);

	boolean updateView(int num);

	boolean deleteBoard(int num, MemberVo user);

	boolean updateBoard(BoardVO board, MemberVo user);

}
