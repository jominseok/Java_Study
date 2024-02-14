package fancafe.service;

import java.util.ArrayList;

import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;

public interface FanCafeService {

	boolean signUpMember(Member member);
	
	ArrayList<Member> getMemberLoginList();
	
	ArrayList<Board> getUserBoardSelect();
	
	boolean postUpUser(Post post);

	ArrayList<Post> selectUserPostList();
}
