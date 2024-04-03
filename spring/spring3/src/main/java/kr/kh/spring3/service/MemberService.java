package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.kh.spring3.model.vo.MemberVO;

public interface MemberService {
	
	
	int getMemberCount();

	boolean signup(MemberVO user);

	MemberVO login(MemberVO member);

}
