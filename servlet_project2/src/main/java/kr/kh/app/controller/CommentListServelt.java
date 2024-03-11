package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.CommendVO;
import kr.kh.app.pagenation.Criteria;
import kr.kh.app.pagenation.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boNum = 0, page = 1;
		try {
			boNum = Integer.parseInt(request.getParameter("boNum"));
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Criteria cri = new Criteria(page, 2, "", "" + boNum);
		ArrayList<CommendVO> list = boardService.getCommentList(cri);
		
		int totalCount = boardService.getTotalCommentCount(cri);
		//페이지 네이션 객체 생성
		PageMaker pm = new PageMaker(5, cri, totalCount);
		
		//화면에 list를 전송(객체로)
		JSONObject jobj = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String pmStr = "";
		try {
			//객체를 JSON형태의 문자열로 변환
			pmStr = om.writeValueAsString(pm);
		} catch (Exception e) {
			// TODO: handle exception
		}

		//화면에  pm을 전송(json문자열로)
		jobj.put("list", list);
		jobj.put("pm", pmStr);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
