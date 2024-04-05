package kr.kh.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectPostList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri );

	boolean insertPost(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectBoardList();

	void uploadFile(@Param("bo_num")int bo_num,@Param("file") MultipartFile file);

	void insertFile(@Param("file")FileVO fileVO);

	
}
