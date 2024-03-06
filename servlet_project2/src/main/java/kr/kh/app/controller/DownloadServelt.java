package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String uploadPath = "D:\\uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 이름을 가져옴
		String fileName = request.getParameter("filename");
		//가져온 실제파일 클라이언트로 보내는 코드 (이름의 \를 /로 바꿔줌)
		String filePath = uploadPath + fileName.replace('/', File.separatorChar);
		//파일 객체를 통해 위에서 만들 파일을 찾음
		File file = new File(filePath);
		//파일 인풋 스트립을 통해
		try (FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream()){
			String mimeType = getServletContext().getMimeType(filePath);
			
			//파일을 읽는다
			response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
			response.setContentLength((int) (file.length()));
			response.setHeader("Content-Disposition", "attachment : filename=\"" + fileName + "\"");
			
			//리스턴스 객체에 채운다
			byte[] buffer = new byte[1024 * 4];
			int readCount;
			while((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
		}
	}
}
