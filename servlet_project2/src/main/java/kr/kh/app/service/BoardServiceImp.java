package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagenation.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {

	BoardDAO BoardDao;
	private String uploadPath = "D:\\uploads";
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			BoardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(uploadPath);
		if(file.exists()) {
			file.mkdirs();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		//현재 페이지 정보 null처리
		if(cri == null) {
			cri = new Criteria();
		}
		return BoardDao.selectBoardList(cri);
	}

	@Override
	public boolean Boardinsert(BoardVO board, ArrayList<Part> partList) {
		if (board == null || !checkString(board.getBo_title()) || !checkString(board.getBo_content())) {

			return false;
		}
		
		boolean res = BoardDao.insertBoard(board);
		
		//게시글 등록에 싪한 경우
		if(!res) {
			return false;
		}
		
		//첨부 파일이 없는 경우
		if(partList == null || partList.size() == 0) {
			return true;
		}
		
		for(Part part : partList) {
			
			uploadFile(part, board.getBo_num());
		}
		
		
		return true;
	}
	
	private void uploadFile(Part part, int bo_num) {
		if(part == null || bo_num == 0) {
			return;
		}
		//서버에 업로드
		String fileOriginalName = FileUploadUtils.getFileName(part);
		if(!checkString(fileOriginalName)) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, part);
		//DB에 추가
		FileVO fileVo = new FileVO(bo_num,fileName, fileOriginalName);
		
		BoardDao.insertFile(fileVo);
	}


	// 문자열이 null이거나 빈 문자열이면 false 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return BoardDao.selectCommunityList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return BoardDao.selectTotalCount(cri);
	}

	@Override
	public BoardVO getBoardList(int num) {
		return BoardDao.selectBoard(num);
	}

	@Override
	public boolean updateView(int num) {
		
		return BoardDao.updateView(num);
	}

	@Override
	public boolean Boardboard(int num, MemberVO user) {
		if(user==null) {
			return false;
		}
		
		//게시글을 가져옴
		BoardVO board = BoardDao.selectBoard(num);
		//게시글이 없거나 작성자가 아니면 false리턴
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 삭제요청
		return BoardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(MemberVO user, BoardVO board) {
		//게시글 null체크
		if(board == null || !checkString(board.getBo_title()) || !checkString(board.getBo_content())) {
			return false;
		}
		//회원 null체크
		if(user == null ) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbboard = BoardDao.selectBoard(board.getBo_num());
		System.out.println(board);
		//게시글이 없거나 게시글 작성자가 회원이 아니면 false를 리턴
		if(dbboard==null||!dbboard.getBo_me_id().equals(user.getMe_id())) {
			System.out.println("3번오류");
			return false;
		}
		//서비스에게 게시글을 주면서 수정하라고 요청
		return BoardDao.updateBoard(board);
	}

	@Override
	public ArrayList<FileVO> getFile(int num) {
		
		return BoardDao.selectFile(num);
	}
	
}
