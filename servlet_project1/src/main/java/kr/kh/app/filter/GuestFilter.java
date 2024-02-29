package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVo;


@WebFilter({"/login", "/signup"})
public class GuestFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		MemberVo user = (MemberVo) httpServletRequest.getSession().getAttribute("user");
		if(user != null) {
			request.setAttribute("msg", "로그인 한 회원은 이용할 수 없는 서비스 입니다.");
			request.setAttribute("user", "");
			request.getRequestDispatcher("/WEB-INF/views/board/message.jsp").forward(httpServletRequest, response);
		}
		chain.doFilter(request, response);
	}


}
