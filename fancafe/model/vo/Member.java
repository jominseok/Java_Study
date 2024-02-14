package fancafe.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Member {
	private String me_id; //회원 아이디
	private String me_pw; //회원 비번
	private String me_name; //회원 닉네임
	private String me_gender;//회원 성별
	private String me_birth; //회원 생년월일
	private String me_content; //회원 가입 인사
	private String me_ap_level; //회원 등급
	
	// 회원 등급 제외한 생성자 
	public Member(String me_id, String me_pw, String me_name, String me_gender, String me_birth, String me_content) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_name = me_name;
		this.me_gender = me_gender;
		this.me_birth = me_birth;
		this.me_content = me_content;
	}

	// 입력한 아이디와 닉네임 중복 확인 메서드 : false 이여야 사용 가능한 아이디와 닉네임 
	public boolean idNameEquals(String me_id,String me_name) {
		if(me_id==null) {
			return true;
		}
		if(me_name==null) {
			return true;
		}
		return this.me_id.equals(me_id)||this.me_name.equals(me_name);
	}
	
	// 로그인 시 아이디와 비밀번호 일치 확인 메서드 : true 여야 옳은 아이디와 비번
	public boolean loginEquals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(me_id, other.me_id) && Objects.equals(me_pw, other.me_pw);
	}


	public int loginHashCode() {
		return Objects.hash(me_id, me_pw);
	}


	public Member(String me_id, String me_pw) {
		//로그인을 위한 생성자
		this.me_id = me_id;
		this.me_pw = me_pw;
	}

	

}
