package com.project.board.service;
 
import java.util.List;

import com.project.board.domain.BoardDTO;

public interface BoardService {
	
	// 공지 게시글 작성하기
	public void adminBoardWrite(BoardDTO boardDTO) throws Exception;
	
	// 회원 게시글 등록하기
	public void memberBoardWrite(BoardDTO boardDTO) throws Exception;
	
	// 공지 게시글 삭제하기
	public void adminBoardDelete(int bno) throws Exception;
	
	// 이용자 게시글 삭제하기
	public void memberBoardDelete(int bno) throws Exception;
	
	// 공지 게시글 조회하기
	public BoardDTO adminBoardView(int bno) throws Exception;
	
	//이용자 게시글 조회하기
	public BoardDTO memberBoardView(int bno) throws Exception;
	
	// 공지 게시글 목록보기
	public List<BoardDTO> adminBoardList() throws Exception;
	
	// 일반 게시글 목록 보기
	public List<BoardDTO> memberBoardList() throws Exception;
	
}
