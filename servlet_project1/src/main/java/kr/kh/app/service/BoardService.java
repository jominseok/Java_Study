package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVo;
import kr.kh.app.pagenaination.Criteria.Criteria;

public interface BoardService {

	boolean insertBoard(@Param("board")BoardVO baord, @Param("partList") ArrayList<Part> partList);

	ArrayList<CommunityVo> selectCommunityList();

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(int num);

	boolean updateView(int num);

	boolean deleteBoard(int num, MemberVo user);

	boolean updateBoard(BoardVO board, MemberVo user, int fi_num, Part file);

	FileVO getFile(int num);

}
