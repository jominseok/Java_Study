package day13;

import java.util.regex.Pattern;

public class PatternEx1 {
	/*
	 * ^[abc]$ 가 의미하는것은?

		한글자이고 a나 b나c인 경우만 참
		^[abc]+$ 가 의미하는것은?
		
		문자열이 abc로만 되어 있고, 1글자 이상인 경우
		^[a-z]$ 가 의미하는것은?
		
		한글자이고, a~z인 경우
		^\d{3,5} 가 의미하는것은?
		
		숫자 3~5
		\d가 의미하는것은?
		
		숫자1자
		^\d{3,}$가 의미하는것은?
		
		숫자3자 이상
		^\d{3}가 의미하는것은?
		
		숫자3자
		^(010|011|012)$가 의미하는것은?
		
		010, 011, 012인 경우
		문자열이 영문 5~8자리인 경우를 확인하는 정규 표현식을 적성하세요
		
		^[a-zA-Z]{5,8}$
		아이디는 영문, 숫자로 구성되어있고, 8~13자인 경우를 확인하는 정규 표현식을 작성하세요
		
		^\w{8,13}$
		url인지 아닌지 판별하기 위해 문자열의 시작이 https또는 http가 맞는지 확인하는 정규표현식을 작성하세요﻿
		
		^https?://[a-zA-Z0-9\.]+$
		^[^abc]$가 의미하는것은?
		a,b,c가 아닌 한글자 (^가 중간에 있을때는 not을 의미함)
	 */
	
	public static void main(String[] args) {
		//Pattern 클래스를 이용하여 문자열이 정규 표현식에 맞는지 확인하는 예제
		String str = "abc";
		String regex = "^[a-zA-Z]{3}$";//영문자이고 3자
		
		if(Pattern.matches(regex, str)) {
			System.out.println("영문자이고 3자입니다.");
		}else{
			System.out.println("영문자가 아니거나 3자가 아닙니다.");
		}
	}
}
