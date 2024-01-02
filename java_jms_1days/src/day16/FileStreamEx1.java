package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = "src/day16/fileEx3";
		
		//try resource를 이용한 예제로
		//파일을 열고나서 따로 닫지 않아도 try문이 종료되면 자동으로 닫아짐
		try( FileInputStream fis1 = new FileInputStream(fileName);
				FileOutputStream fos1 = new FileOutputStream(fileName);	
				) {
	
			String str = "HELLO";
			
			for(int i = 0; i <str.length(); i++) {
				fos1.write(str.charAt(i));
			}
			
			for(int i = 0; i < str.length(); i++){
				int ch = fis1.read();
				System.out.println((char)ch);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (Exception e) {
			System.out.println("파일 작업 중 예외 발생");
		}

	}

}
