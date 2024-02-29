package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.pagenation.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoard(@Param("cri") Criteria cri);

	boolean insertBoard(@Param("board") BoardVO boardVO);

	ArrayList<CommunityVO> selectCommunityList();

	int selectTotalCount(@Param("cri")Criteria cri);

}
