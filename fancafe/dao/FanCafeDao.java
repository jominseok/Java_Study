package fancafe.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;
import fancafe.pagination.Criteria;

public interface FanCafeDao {

	boolean signUpMember(@Param("member") Member member);
	
	List<Member> selectMemberIdPw();

	void updatePw(@Param("me_id") String me_id, @Param("newPw") String newPw);

	void updateName(@Param("me_id") String me_id, @Param("newName")String newName);
	
	List<Member> selectMemberLoginList(@Param("me_id")String me_id);

	String selectMemberLevel(@Param("me_id")  String me_id);

	ArrayList<Post> selectMyPostInBoard(@Param("me_id")String me_id, @Param("bd_num")int bd_num);

	ArrayList <Board> selectMyBoard(@Param("me_id")String me_id);

	Integer countIdBdNum(@Param("me_id")String me_id, @Param("bd_num")int bd_num);
	
	List<Member> selectMember();

	boolean deleteMemberName(@Param("me_name") String me_name);

	ArrayList<Member> selectMemberLoginList();//로그인을 위한 메서드 -조민석
	
	ArrayList<Board> userBoardSelect();//게시판을 조회 하기 위한 메서드 - 조민석
	
	boolean postUpUser(@Param("post") Post post);// 게시글 작성을 위한 메서드

	ArrayList<Post> selectUserPostList(@Param("selectBoard") int selectBoard);

	boolean updateBoardName(@Param("bd_num")int bd_num,@Param("bd_title") String bd_title);

	boolean insertBoard(@Param("bd_title")String bd_title);

	boolean deleteBoard(@Param("bd_num")int bd_num);
	
	List<Member> selectIdName();

	boolean deleteUserPost(@Param("po_num") int po_num);
	
	boolean updateUserPost(@Param("post") Post post);

	void viwePlus(@Param("po_view") int po_view, @Param("po_num") int po_num);

	void updateMemberLevel(@Param("me_name")String me_name);

	List<Member> selectMemberUnderLevel();

	ArrayList<Post> selectUserPostList2(@Param("selectBoard") int selectBoard,@Param("cri") Criteria cri);

	void deleteUser(@Param("me_id")String me_id);

} 

