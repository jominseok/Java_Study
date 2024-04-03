package kr.kh.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("안녕하세요 스프링 메인입니다.");
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : " + count);
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO user, String pw2) {
		boolean res = memberService.signup(user);
		if(res) {
			model.addAttribute("msg", "회원가입을 했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}	
		return "message";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		model.addAttribute("user", user); //user라는 이름으로 전송
		log.info(user);
		if(user != null) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인을 했습니다.");
		}else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인을 하지 못했습니다.");
		}	
		return "message";
	}
	
	@GetMapping
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		//session.removeAttribute("user");
		request.getSession().removeAttribute("user");
		model.addAttribute("url", "/");
		model.addAttribute("msg", "로그아웃을 했습니다.");
		return "message";
	}
}
