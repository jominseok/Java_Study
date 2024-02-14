package fancafe.model.vo;

import lombok.Data;

@Data
public class Approve {
	private String ap_level; //회원등급(관리자,정회원,비회원(미승인))
}
