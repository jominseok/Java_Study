package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.compiler.ast.Member;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/update")
public class BoardUpdateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private BoardService boardService = new BoardServiceImp(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (Exception e) {
			num = 0;
		}
		
		BoardVO board = boardService.getBoardList(num);
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		request.setAttribute("board", board);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 번호, 내용, 제목, 게시판 번호을 가져옴
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num;
		int co_num;
		try {
			num = Integer.parseInt(request.getParameter("num"));			
			co_num = Integer.parseInt(request.getParameter("community"));
		} catch (Exception e) {
			num = 0;
			co_num = 0;
		}
		//게시글 번호, 내용, 제목을 이용해서 게시글 객체를 생성
		BoardVO board = new BoardVO(num, co_num, title, content);
		//회원 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//서비스에게 회원 정보와 수정할 게시글 정보를 주면서 수정하라고 요청
		boolean res = boardService.updateBoard(user, board);
		//수정했으면 게시글을 수정했습니다.
		if(res) {
			request.setAttribute("msg", "게시글을 수정하였습니다.");
			//request.setAttribute("url", "board");
			//request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		//못했으면 게시글을 수정하지 못했습니다 라고 알림
		else {
			request.setAttribute("msg", "게시글을 수정하지 못하였습니다.");
			//request.setAttribute("url", "update");
			//request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		
		//게시글 상세로 이동
		request.setAttribute("url", "detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
