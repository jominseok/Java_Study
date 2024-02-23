package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;

public interface BoardService {

	boolean insertBoard(BoardVO baord);

	ArrayList<CommunityVo> selectCommunityList();

	ArrayList<BoardVO> getBoardList();

}
