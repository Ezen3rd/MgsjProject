package com.project.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	private static final String NAME_SPACE = "mappers.boardMapper";

	// 공지 게시글 목록
	@Override
	public List<BoardDTO> adminBoardList() throws Exception {

		logger.info("BoardDAOImpl에서 이용자 게시글 목록 조회하기 시작");

		return sqlSession.selectList(NAME_SPACE + ".adminBoardList");
	}

	// 일반 게시글 목록
	@Override
	public List<BoardDTO> memberBoardList() throws Exception {

		logger.info("BoardDAOImpl에서 일반 게시글 목록 조회하기 시작");

		return sqlSession.selectList(NAME_SPACE + ".memberBoardList");
	}

	// 공지 게시글 등록
	@Override
	public void adminBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("BoardDAOImpl에서 공지 게시글 등록하기 시작");

		sqlSession.insert(NAME_SPACE + ".adminBoardWrite", boardDTO);
	}

	// 이용자 게시글 등록
	@Override
	public void memberBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("BoardDAOImpl에서 이용자 게시글 등록하기 시작");

		sqlSession.insert(NAME_SPACE + ".memberBoardWrite", boardDTO);
	}

	// 공지 게시글 삭제
	@Override
	public void adminBoardDelete(int bno) throws Exception {

		logger.info("BoardDAOImpl에서 공지 게시글 삭제하기 시작");

		sqlSession.delete(NAME_SPACE + ".adminBoardDelete", bno);
	}

	// 이용자 게시글 삭제
	@Override
	public void memberBoardDelete(int bno) throws Exception {

		logger.info("BoardDAOImpl에서 이용자 게시글 삭제하기 시작");

		sqlSession.delete(NAME_SPACE + ".memberBoardDelete", bno);
	}

	// 공지 게시글 조회
	@Override
	public BoardDTO adminBoardView(int bno) throws Exception {

		logger.info("BoardDAOImpl에서 공지 게시글 상세 조회하기 시작");

		return sqlSession.selectOne(NAME_SPACE + ".adminBoardView", bno);
	}

	// 이용자 게시글 조회
	@Override
	public BoardDTO memberBoardView(int bno) throws Exception {

		logger.info("BoardDAOImpl에서 이용자 게시글 상세 조회하기 시작");

		return sqlSession.selectOne(NAME_SPACE + ".memberBoardView", bno);

	}

}
