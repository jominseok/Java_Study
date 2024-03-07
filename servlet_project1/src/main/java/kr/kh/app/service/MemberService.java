package kr.kh.app.service;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVo;

public interface MemberService {

	boolean signup(MemberVo memberVo);

	MemberVo login(LoginDTO loginDTO);

	boolean checkId(String id);

}
