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
	public void adminBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("BoardServiceImpl에서 운영진 게시글 등록하기 시작");

		boardDAO.adminBoardWrite(boardDTO);
	}

	// 이용자 게시글 등록하기
	@Override
	public void memberBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("BoardServiceImpl에서 이용자 게시글 등록하기 시작");

		boardDAO.memberBoardWrite(boardDTO);
	}

	// 이용자 게시글 삭제하기
	@Override
	public void memberBoardDelete(int bno) throws Exception {

		logger.info("BoardServiceImpl에서 이용자 게시글 삭제하기 시작");

		boardDAO.memberBoardDelete(bno);
	}

	// 공지 게시글 삭제하기
	@Override
	public void adminBoardDelete(int bno) throws Exception {

		logger.info("BoardServiceImpl에서 공지 게시글 삭제하기 시작");

		boardDAO.adminBoardDelete(bno);
	}

	// 공지 게시글 상세 조회하기
	@Override
	public BoardDTO adminBoardView(int bno) throws Exception {

		logger.info("BoardServiceImpl에서 공지 게시글 상세 조회하기 시작");

		return boardDAO.adminBoardView(bno);
	}

	// 이용자 게시글 상세 조회하기
	@Override
	public BoardDTO memberBoardView(int bno) throws Exception {

		logger.info("BoardServiceImpl에서 이용자 게시글 상세 조회하기 시작");

		return boardDAO.memberBoardView(bno);
	}

	// 공지 게시글 목록보기
	@Override
	public List<BoardDTO> adminBoardList() throws Exception {

		logger.info("BoardServiceImpl에서 공지 게시글 상세 조회하기 시작");

		return boardDAO.adminBoardList();
	}

	// 일반 게시글 목록보기

	@Override
	public List<BoardDTO> memberBoardList() throws Exception {

		logger.info("BoardServiceImpl에서 일반 게시글 상세 조회하기 시작");

		return boardDAO.memberBoardList();
	}

}
