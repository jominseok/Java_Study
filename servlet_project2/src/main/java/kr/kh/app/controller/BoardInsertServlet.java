package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;


@WebServlet("/board/insert")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,//10Mb
		maxRequestSize = 1024 * 1024 * 10 * 3, //10Mb 최대 3개
		fileSizeThreshold = 1024 * 1024 //1Mb : 파일 업로드시 메모리에 저장되는 임시 파일 크기
	)
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스에게 게시판 리스트를 가져오라고 시킴
		ArrayList<CommunityVO> list = boardService.getCommunityList(); 
		//화면에 게시판 리스트를 보냄
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//화면에서 보낸 제못 내용을 가져옴
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//회원 정보가 있으면
		//작성자에 회원 아이디를 저장
		String bo_me_id = user.getMe_id();
		//게시판 번호는 1번으로 저장
		int bo_co_num = Integer.parseInt(request.getParameter("community")); 
		//제목 내용 작성자 게시판 번호를 이용하여 게시글 객체를 생성
		BoardVO board = new BoardVO(bo_co_num, bo_me_id, title, content);
		//서비스에게 게시글 객체를 주면서 등록하라고 시킴
		
		//첨부파일들을 가져옴
		ArrayList<Part> partList = (ArrayList<Part>) request.getParts();
		
		
		boolean res = boardService.Boardinsert(board, partList);
		if(res) {
			//등록을 하면 화면에 msg로 게시글 등록했습니다 라고 전송
			request.setAttribute("msg", "게시글을 등록했습니다.");
		}		
		else {
			//등록하지 못하면 msg로 게시글을 등록하지 못했습니다라고 전송
			request.setAttribute("msg", "게시글 등록을 못했습니다.");
		}
		request.setAttribute("url", "board");
		//message.jsp를 전송
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
