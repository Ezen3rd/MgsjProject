package com.project.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.board.domain.BoardDTO;
import com.project.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	// 공지 게시글 목록보기
	@RequestMapping(value = "/board/admin/adminBoardList", method = RequestMethod.GET)
	public void adminBoardList(Model model) throws Exception {

		logger.info("BoardController에서 공지 게시글 목록보기 시작");

		List<BoardDTO> adminBoardList = boardService.adminBoardList();

		logger.info("공지 게시글 목록 ==> " + adminBoardList);

		model.addAttribute("adminBoardList", adminBoardList);

	}

	// 일반 게시글 목록보기
	@RequestMapping(value = "/board/member/memberBoardList", method = RequestMethod.GET)
	public void memberBoardList(Model model) throws Exception {

		logger.info("BoardController에서 일반 게시글 목록보기 시작");

		List<BoardDTO> memberBoardList = boardService.memberBoardList();

		logger.info("일반 게시글 목록 ==> " + memberBoardList);

		model.addAttribute("memberBoardList", memberBoardList);

	}

	// 작성 페이지 접속
	@RequestMapping(value = "/board/boardWritePage", method = RequestMethod.GET)
	public void connectMemberBoardWrite() throws Exception {

		logger.info("회원 게시글 작성 페이지 접속 memberBoardWrite - controller");
		
	}

	// 게시글 등록하기
	@RequestMapping(value = "/board/boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("회원 게시글 작성 memberBoardWrite - controller");

		boardService.boardWrite(boardDTO);

		return "redirect:/board/member/memberBoardList";
	}

	// 게시글 삭제하기
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam("bno") int bno) throws Exception {

		logger.info("회원 게시글 삭제 memberBoardDelete - BoardController");

		boardService.boardDelete(bno);

		return "redirect:/board/main";
	}

	// 게시글 조회하기
	@RequestMapping(value = "/board/boardView", method = RequestMethod.GET)
	public void boardView(@RequestParam("bno") int bno, Model model, BoardDTO boardDTO) throws Exception {

		logger.info("회원 게시글 조회 memberBoardDetail - BoardController");

		boardDTO = boardService.boardView(bno);

		model.addAttribute("boardDTO", boardDTO);

	}
	
	// 게시글 수정하기 (의 개념으로 수정페이지 들어가기)
	@RequestMapping(value = "/board/boardModifyPage", method = RequestMethod.GET)
	public void connectBoardModify(@RequestParam("bno") int bno, Model model, BoardDTO boardDTO) throws Exception {
		
		logger.info("공지 게시글 수정 페이지 접속 connectBoardModify - controller");
		
		boardDTO = boardService.boardView(bno);
		
		model.addAttribute("boardDTO", boardDTO);
	}
	
	// 게시글 수정하기 로직
	@RequestMapping(value = "/board/boardModify", method = RequestMethod.POST)
	public String boardModify(BoardDTO boardDTO) throws Exception {
		
		logger.info("공지 게시글 수정 로직 boardModify - controller");
		logger.info("게시글 번호 : {}", boardDTO.getBno());
		
		boardService.boardModify(boardDTO);
		
		return "redirect:/board/boardView?bno=" + boardDTO.getBno();
	}

}
