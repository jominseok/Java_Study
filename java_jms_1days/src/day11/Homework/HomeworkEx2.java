package day11.Homework;

import java.util.Scanner;

public class HomeworkEx2 {

	 /* 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요.
	 * 메서드를 생성
	 */
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = 1, b = 2;
		char c = '/';

		double d = arithmeticCaculator(a, b, c);
		System.out.println("" + a + c + b + " = " + d);
		
	}
	
	/**
	 * 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메서드
	 * @param a 정수1
	 * @param b 정수2
	 * return 정수1과 정수2를 산술 연산한 결과
	 */
	private static int arithmeticCaculator(int a, int b, char c) {
		
		switch (c) {
		case '+': return a + b;
		case '-': return a - b;
		case '*': return a * b;
		case '/': return a / b;
		case '%': return a % b;}
		return 0;
		//산술 연산자가 아닌 경우. 아직은 예외처리를 안배워서 0으로 리턴
		//그래서 0이 리턴 되는 경우 1-1인지, 1*0인지 4%2인지, 잘못된 연산자 때문인지 구분이 안됨
	}
	
	
	}
