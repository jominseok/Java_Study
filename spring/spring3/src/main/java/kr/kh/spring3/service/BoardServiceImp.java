package kr.kh.spring3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.utils.UploadFileUtils;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	@Resource
	String uploadPath;

	@Override
	public ArrayList<BoardVO> getPostList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectPostList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri ) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public boolean postInsert(BoardVO board, MemberVO user, MultipartFile[] files) {
		
		if(board == null || board.getBo_title() == null || board.getBo_content() == null) {
			return false;
		}
		if(user == null) {
			return false;
		}
		
		boolean res = boardDao.insertPost(board);
		log.info(board);
		if(!res) {
			return false;
		}
		if(files ==null || files.length == 0) {
			return true;
		}
		for(MultipartFile file : files) {
			uploadFile(board.getBo_num(), file);
		}
		return res;
	}

	private void uploadFile(int bo_num, MultipartFile file) {
		if(file==null || file.getOriginalFilename().length()==0) {
			return;
		}
		
		try {
			String fileOriName = file.getOriginalFilename();
			//첨부파일 업로드 후 경로를 가져옴
			String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			FileVO fileVO = new FileVO(bo_num, fileName, fileOriName);
			//DB에 첨부파일 정보를 추
			boardDao.insertFile(fileVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<CommunityVO> getBoardList() {
		
		return boardDao.selectBoardList();
	}
}
