package fancafe.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import fancafe.model.vo.Board;
import fancafe.model.vo.Member;
import fancafe.model.vo.Post;

public interface FanCafeDao {


	boolean signUpMember(@Param("member") Member member);

	ArrayList<Member> selectMemberIdName();

	ArrayList<Member> selectMemberLoginList();//로그인을 위한 메서드 -조민석
	
	ArrayList<Board> userBoardSelect();//게시판을 조회 하기 위한 메서드 - 조민석
	
	boolean postUpUser(@Param("post") Post post);
} 

