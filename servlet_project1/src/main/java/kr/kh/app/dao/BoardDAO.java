package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO baord);

	ArrayList<CommunityVo> selectCommunityList();

	ArrayList<BoardVO> selectBoardList();

}
