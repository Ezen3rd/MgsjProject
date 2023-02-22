package com.project.board.dao;

import java.util.List;

import com.project.board.domain.BoardDTO;

public interface BoardDAO {

	 
	// 운영진 게시글 등록하기 
	public void boardWriteOp(BoardDTO boardDTO) throws Exception;
	
	
	// 일반 게시글 등록하기
	public void boardWrite(BoardDTO boardDTO) throws Exception;
	
	
	// 운영진 게시글 삭제하기
	public void boardDeleteOp(int bno) throws Exception;
	
	
	// 일반 게시글 삭제하기
	public void boardDelete(int bno) throws Exception;
	
	
	// 공지 게시글 상세 조회하기
	public BoardDTO boardDetailOp(int bno) throws Exception;
	
	
	// 일반 게시글 상세 조회하기
	public BoardDTO boardDetail(int bno) throws Exception;
	
	// 공지 게시글 목록보기
	public List<BoardDTO> boardListOp() throws Exception;
	
	// 일반 게시글 목록보기
	public List<BoardDTO> boardList() throws Exception;
}
