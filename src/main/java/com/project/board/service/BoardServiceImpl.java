package com.project.board.service;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDAO;
import com.project.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
 
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	// 운영진 게시글 등록하기
	@Override
	public void boardWriteOp(BoardDTO boardDTO) throws Exception {
			
		logger.info("BoardServiceImpl에서 운영진 게시글 등록하기 시작");
			
		boardDAO.boardWriteOp(boardDTO);
	}
	
	// 일반 게시글 등록하기
	@Override
	public void boardWrite(BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardServiceImpl에서 일반 게시글 등록하기 시작");
		
		boardDAO.boardWrite(boardDTO);
	}
	
	// 일반 게시글 삭제하기
	@Override
	public void boardDelete(int bno) throws Exception {
		
		logger.info("BoardServiceImpl에서 일반 게시글 삭제하기 시작");
		
	boardDAO.boardDelete(bno);
	}
	
	// 공지 게시글 삭제하기
	@Override
	public void boardDeleteOp(int bno) throws Exception {
		
		logger.info("BoardServiceImpl에서 공지 게시글 삭제하기 시작");
		
	boardDAO.boardDeleteOp(bno);
	}
	
	// 공지 게시글 상세 조회하기
	@Override
	public BoardDTO boardDetailOp(int bno) throws Exception {
		
		logger.info("BoardServiceImpl에서 공지 게시글 상세 조회하기 시작");
			
		return boardDAO.boardDetailOp(bno);
	}
	
	// 일반 게시글 상세 조회하기
	@Override
	public BoardDTO boardDetail(int bno) throws Exception {
		 
		logger.info("BoardServiceImpl에서 일반 게시글 상세 조회하기 시작");
	
		return boardDAO.boardDetail(bno);
	}
	
	// 공지 게시글 목록보기
	@Override
	public List<BoardDTO> boardListOp() throws Exception {
		
		logger.info("BoardServiceImpl에서 공지 게시글 상세 조회하기 시작");
	
		return boardDAO.boardListOp();
	}
	
	//일반 게시글 목록보기
	
	@Override
	public List<BoardDTO> boardList() throws Exception {
		
		logger.info("BoardServiceImpl에서 일반 게시글 상세 조회하기 시작");
		
		return boardDAO.boardList();
	}
}




