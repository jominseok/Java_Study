package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagenation.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	boolean Boardinsert(BoardVO boardVO);

	ArrayList<CommunityVO> getCommunityList();

	int getTotalCount(Criteria cri);

	BoardVO getBoardList(int num);

	boolean updateView(int num);

	boolean Boardboard(int num, MemberVO user);
}
