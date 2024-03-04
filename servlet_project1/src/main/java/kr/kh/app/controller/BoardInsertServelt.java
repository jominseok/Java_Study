package kr.kh.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.model.vo.MemberVo;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/insert")
@MultipartConfig(
			maxFileSize = 1024 * 1024 * 10,//10Mb
			maxRequestSize = 1024 * 1024 * 10 * 3, //10Mb 최대 3개
			fileSizeThreshold = 1024 * 1024 //1Mb : 파일 업로드시 메모리에 저장되는 임시 파일 크기
		)
public class BoardInsertServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// MemberFilter 추가로 인해 불필요한 코드 주석 처리
		/*/게시글은 회원만 작성 가능하기 때문에 아래 작업을 진행
		//로그인한 회원 정보를 가져옴 => 세션에서 user 정보를 가져옴  
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//회원정보가 없으면 게시글 리스트로 이동
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/board/list");
			return;
		}*/
		
		
		//게시판 전체를 가져옴
		ArrayList<CommunityVo> list = boardService.selectCommunityList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 작성 화면에서 장시간 가만히 있으면 세션이 만료되서 로그인이 풀림 
		//로그인이 풀리면 게시글을 작성할 수 없게 해야하기 때문에 
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		
		//MemberFilter 추가로 인해 불필요한 코드 주석 처리
		/*
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/board/list");
			return;
		}
		*/
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = user.getMe_id();
		int co_num = Integer.parseInt(request.getParameter("community"));
		BoardVO board = new BoardVO(co_num, title, content, writer);
		
		//첨부파일을 가져옴
		Part filePart = request.getPart("file");
		//파일을 저장할 폴더를 지정
		String uploadPath = "D://uploads";
		//저장할 파일 이름을 추가
		String fileName = getFilename(filePart);
		//경로가 포함된 파일명
		String filePath = uploadPath + File.separator + fileName;
		//클라이언트가 보내준 파일에서 InputStream으로 읽어와서 서버에 OutputStream으로 파일을 생성
		try (InputStream is = filePart.getInputStream();
				OutputStream os = new FileOutputStream(filePath)){
			byte [] buffer = new byte[1024*4];//4kb씩 읽어와서 덮어쓰기
			int readCount;//읽어온 개수
			//InputStream.read(byte[])은 읽어와서 배열에 저장 후 읽어온 개수를 반환
			//읽어온 개수가 없으면 -1을 리턴
			while((readCount = is.read(buffer)) != -1){
				os.write(buffer, 0, readCount);
			}
		} catch (Exception e) {
			
		}
		//서비스에게 게시글을 주면서 등록하라고 시킴
		if(boardService.insertBoard(board)) {
			response.sendRedirect(request.getContextPath()+"/board/list/");
		}else {
			response.sendRedirect(request.getContextPath()+"/board/insert");
		}
	}
	private String getFilename(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		
		for(String item : items) {
			//item은 다음과 같은 형태로 구성
			//속성명 = 값
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("="));
			}
		}
		return "";
	}
}