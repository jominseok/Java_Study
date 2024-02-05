package db.mybatis.service;

import java.util.ArrayList;

import db.mybatis.model.MemberVO;


public interface MemberService {

	boolean insertMember(MemberVO member);


	ArrayList<MemberVO> getMemberList();


}
