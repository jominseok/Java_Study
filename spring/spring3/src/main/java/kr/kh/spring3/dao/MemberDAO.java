package kr.kh.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.MemberVO;

public interface MemberDAO {

	int selectMemberCount();

	boolean insertUser(@Param("member")MemberVO member);

	MemberVO selectMember(@Param("me_id")String me_id);

	ArrayList<MemberVO> selectUserList();

}
