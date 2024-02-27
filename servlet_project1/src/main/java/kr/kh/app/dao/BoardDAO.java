package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.pagenaination.Criteria.Criteria;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO baord);

	ArrayList<CommunityVo> selectCommunityList();

	ArrayList<BoardVO> selectBoardList(@Param("cri") Criteria cri);

	int selectTotalCount(@Param("cri") Criteria cri);

}
