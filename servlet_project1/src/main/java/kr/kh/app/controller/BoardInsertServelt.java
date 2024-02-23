package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVo;
import kr.kh.app.model.vo.MemberVo;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/insert")
public class BoardInsertServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	public BoardInsertServelt() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글은 회원만 작성 가능하기 때문에 아래 작업을 진행
		// 로그인한 회원 정보를 가져옴 => 세션에서 user정보를 가져옴
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		// MemberVo user = (MemberVo)request.getSession().getAttribute("user");
		// 회원 정보가 없으면 게시글 리스트로 이동
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/board/list/");
			return;
		}
		// 게시판 전체를 가져옴
		ArrayList<CommunityVo> list = boardService.selectCommunityList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//게시글 작성 화면에서 장시간 가만히 있으면 세션이 만료되서 로그인이 풀림
		//로그인이 풀리면 게시글을 작성 할 수 없게 해야 하기 때문에 
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/board/list/");
			return;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = user.getMe_id();
		int co_num = Integer.parseInt(request.getParameter("community"));
		BoardVO baord = new BoardVO(co_num, title, content, writer);
		//서비스에게 게시글을 주면서 등록하라고 시킴
		if(boardService.insertBoard(baord)) {
			response.sendRedirect(request.getContextPath() + "/board/list/");
		}else {
			//doGet(request, response); <= 이 코드 아니먄 아래 코드 둘중 하나로 게시글 등록 실패 했을때 그 등록 페이지에 그대로 있게함
			response.sendRedirect(request.getContextPath() + "/board/insert");
		}
	}

}
