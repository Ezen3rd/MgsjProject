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

	// 공지 게시글 등록
	@Override
	public void boardWriteOp(BoardDTO boardDTO) throws Exception {

		logger.info("BoardDAOImpl에서 공지 게시글 등록하기 시작");

		sqlSession.insert(NAME_SPACE + ".boardWriteOp", boardDTO);
	}

	// 일반 게시글 등록
	@Override
	public void boardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("BoardDAOImpl에서 이용자 게시글 등록하기 시작");

		sqlSession.insert(NAME_SPACE + ".boardWrite", boardDTO);
	}
	// 공지 게시글 삭제

	@Override
	public void boardDeleteOp(int bno) throws Exception {
		
		logger.info("BoardDAOImpl에서 공지 게시글 삭제하기 시작");

		sqlSession.delete(NAME_SPACE + ".boardDeleteOp", bno);
	}

	// 일반 게시글 삭제
	@Override
	public void boardDelete(int bno) throws Exception {
		
		logger.info("BoardDAOImpl에서 이용자 게시글 삭제하기 시작");

		sqlSession.delete(NAME_SPACE + ".boardDelete", bno);
	}
	
	//공지 게시글 상세 조회
	@Override
	public BoardDTO boardDetailOp(int bno) throws Exception {

		logger.info("BoardDAOImpl에서 공지 게시글 상세 조회하기 시작");
		
		return sqlSession.selectOne(NAME_SPACE + ".boardDetailOp", bno);
	}
	
	// 일반 게시글 상세 조회
	@Override
	public BoardDTO boardDetail(int bno) throws Exception {
		
		logger.info("BoardDAOImpl에서 이용자 게시글 상세 조회하기 시작");
		
		return sqlSession.selectOne(NAME_SPACE + ".boardDetail", bno);
		
	}
	
	//공지 게시글 목록
	@Override
	public List<BoardDTO> boardListOp() throws Exception {
		
		logger.info("BoardDAOImpl에서 이용자 게시글 목록 조회하기 시작");
		
		return sqlSession.selectList(NAME_SPACE + ".boardListOp");
	}
	
	//일반 게시글 목록
	@Override
	public List<BoardDTO> boardList() throws Exception {
		
		logger.info("BoardDAOImpl에서 일반 게시글 목록 조회하기 시작");
		
		return sqlSession.selectList(NAME_SPACE + ".boardList");
	}
	

}
