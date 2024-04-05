package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.Pagemaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String postList(Model model, Criteria cri) {
		ArrayList<BoardVO> list = boardService.getPostList(cri);
		int totalCount = boardService.getTotalCount(cri);
		Pagemaker pm = new Pagemaker(3, cri, totalCount);
		model.addAttribute("pm", pm);
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("list", list);
		return "/board/postlist";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		ArrayList<CommunityVO> boardList = boardService.getBoardList();
		model.addAttribute("board", boardList);
		return("/board/insert");
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, BoardVO board, HttpSession session, MultipartFile [] files) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		boolean res = boardService.postInsert(board, user, files);
		if(res) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "등록 했습니다.");
		}else {
			model.addAttribute("url", "/post/insert");
			model.addAttribute("msg", "등록 하지 못했습니다.");
		}	
		return("/message");
	}
}
