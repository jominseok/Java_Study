package fancafe.model.vo;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	
	public Member(String me_id, String me_pw) {
		//로그인을 위한 생성자
		this.me_id = me_id;
		this.me_pw = me_pw;
	}
	
	//닉네임 비교
	public Member(String me_name) {
		this.me_name = me_name;
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
	
	// 입력한 닉네임과의 중복 확인 메서드 : false 이여야 사용 가능한 닉네임 
	public boolean nameEquals(String me_name) {
		if(me_name==null) {
			return true;
		}
		return this.me_name.equals(me_name);
	}
	
	// 입력한 아이디와의 중복 확인 메서드 : true 이여야 있는 아이디
	public boolean idEquals(String me_id) {
		if(me_id==null) {
			return false;
		}
		return this.me_id.equals(me_id);
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
	
	public boolean idUnderLevel(String me_id) {
		if (me_id == null) {
			return false;
		}
		return  this.me_id.equals(me_id)&& me_ap_level.equals("비회원");
	}

	public int loginHashCode() {
		return Objects.hash(me_id, me_pw);
	}

	@Override
	public String toString() {
		return "등급:" + me_ap_level+" 닉네임:"+ me_name + " 성별:" + me_gender + " 생년월일" + me_birth ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(me_name, other.me_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(me_name);
	}
	
	//비밀번호 제약조건
	public boolean passwordChecking() {
		String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@!?])[A-Za-z[0-9]@!?]{12,20}$";
		Matcher match;
		match = Pattern.compile(pattern1).matcher(this.me_pw);
		if(!match.find()) {
			return true;
		}
		return false;
	}
	
	//문자열 길이,제약
	public boolean errorchecking() {
		//비밀번호 제약조건
		if(passwordChecking()) {
			return true;
		}
		//성별 제약
		switch (this.me_gender){
		case "남":
			break;
		case "여":
			break;
		default:
			return true;
		}
		//문자열수 제약
		if(this.me_id.length()>10 || this.me_birth.length()!=6) {
			return true;
		}
		//문제없음
		return false;
	}

}
