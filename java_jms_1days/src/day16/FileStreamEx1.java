package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fis1 = null;
		FileOutputStream fos1 =null;
		
		String fileName = "src/day16/fileEx3";
		
		try {
			fos1 = new FileOutputStream(fileName);
			fis1 = new FileInputStream(fileName);
			
			String str = "hello";
			
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
		} finally {
			try {
				fos1.close();
				fis1.close();
			} catch (IOException e2) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}
		
		
	}

}
