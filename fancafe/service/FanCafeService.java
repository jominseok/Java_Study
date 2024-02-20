package fancafe.service;

import java.util.ArrayList;
import java.util.List;

import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;
import fancafe.pagination.Criteria;
public interface FanCafeService {

	boolean checkIdBdNum(String me_id, int num);

	boolean signUpMember(Member member);
	
	List<Member> getMemberLoginList(String me_id);	

	String getMemberLevel(String me_id);

	boolean checkMemberIdPw(String me_id, String newPw);
	
	boolean checkName(String newName);

	void updatePw(String me_id, String newPw);
	
	void updateName(String me_id, String newName);
	
	void selectMyPostInBoard(String me_id, int num);

	List <Board> getMyBoard(String me_id);

	List<Member> selectMember();
	List<Member> selectMembers();

	boolean deleteMemberName(String me_name);

	ArrayList<Board> getUserBoardSelect();
	
	boolean postUpUser(Post post);

	ArrayList<Post> selectUserPostList(int selectBoard);

	boolean updateBoardName(int bd_num, String bd_title);

	boolean insertBoard(String bd_title);

	boolean deleteBoard(int bd_num);
	
	boolean deleteUserPost(int po_num);

	boolean updateUserPost(Post post);

	void viwePlus(int po_view, int po_num);

	void updateMemberLevel(String me_name);

	List<Member> selectMemberUnderLevel();

	boolean userSelectLevel(String me_id);

	ArrayList<Post> selectUserPostList2(int selectBoard, Criteria cri);

	void deleteUser(String me_id);
}
