package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVo;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();

	/* 화면에서 전달한 id와 pw을 콘솔창에 출력 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("아이디는 : " + id + " 비밀번호는 : " + pw);
		MemberVo user = memberService.login(new LoginDTO(id, pw));
		System.out.println(user);
		if (user != null) {
			// 세션에 회원 정보를 저장하여 로그인 유지
			HttpSession session = request.getSession();// request에 있는 세션을 가져옴
			session.setAttribute("user", user); // 세션에 user라는 이름으로 회원 정보를 저장
			response.sendRedirect(request.getContextPath()+"/");// sendRedirect는 작업이 끝난 후 다른 페이지로 이동한다는 뜻임
		} else {
			doGet(request, response);
		}
	}

}
