package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberServiceImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 데이터를 가져옴
		String id = request.getParameter("id");//form태그 안 입력 태그에 name이 id 요소의 값을 가져옴
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		//이용중이라는 회원 상태가 db에 저장 되어 있는경우
		MemberVO member = new MemberVO(id, pw, email, "이용중");
		boolean res = memberService.signup(member);
		if(res) {
			request.setAttribute("msg", "회원가입에 성공하였습니다.");
			request.setAttribute("url", "");
		}else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			request.setAttribute("url", "signup");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		/*if(res) {
			//회원 추가에 성공하면 홈화면으로 이동
			response.sendRedirect(request.getContextPath() + "/");
		}else {
			//회원 추가에 실패하면 회원가입 화면에 정지
			//sendRedirect는 새로고침 하는거다
			response.sendRedirect(request.getContentType() + "/signup");
		}*/
	}

}
