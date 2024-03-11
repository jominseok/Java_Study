package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommendVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagenation.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	boolean Boardinsert(BoardVO boardVO, ArrayList<Part> partList);

	ArrayList<CommunityVO> getCommunityList();

	int getTotalCount(Criteria cri);

	BoardVO getBoardList(int num);

	boolean updateView(int num);

	boolean BoardDelete(int num, MemberVO user);

	boolean updateBoard(MemberVO member, BoardVO board, String[] nums, ArrayList<Part> partList);

	ArrayList<FileVO> getFile(int num);

	int recommend(int boNum, int state, String me_id);

	RecommendVO getRecommend(int num, MemberVO user);

	ArrayList<CommendVO> getCommentList(Criteria cri);

	int getTotalCommentCount(Criteria cri);
}
