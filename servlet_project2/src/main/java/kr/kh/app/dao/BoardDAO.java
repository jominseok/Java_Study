package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagenation.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri") Criteria cri);

	boolean insertBoard(@Param("board") BoardVO boardVO);

	ArrayList<CommunityVO> selectCommunityList();

	int selectTotalCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("num") int num);

	boolean updateView(@Param("num") int num);

	boolean deleteBoard(@Param("num") int num);

	boolean updateBoard(@Param("board") BoardVO board);

	void insertFile(@Param("file") FileVO fileVo);

	ArrayList<FileVO> selectFile(@Param("num")int num);

	ArrayList<FileVO> selectFileByBo_num(@Param("num") int num);

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile2(@Param("fi_num")int num);

	RecommendVO selectRecommend(@Param("bo_num")int boNum, @Param("me_id")String me_id);

	void insertRecommend(@Param("re") RecommendVO recommend);

	void updateRecommend(@Param("re")RecommendVO recommend);

}
