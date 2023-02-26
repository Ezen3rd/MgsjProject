package com.project.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.board.domain.BoardDTO;
import com.project.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	// 공지 게시글 목록보기
	@RequestMapping(value = "/board/adminBoardList", method = RequestMethod.GET)
	public void adminBoardList(Model model) throws Exception {

		logger.info("BoardController에서 공지 게시글 목록보기 시작");

		List<BoardDTO> adminBoardList = boardService.adminBoardList();

		logger.info("공지 게시글 목록 ==> " + adminBoardList);

		model.addAttribute("adminBoardList", adminBoardList);

	}

	// 일반 게시글 목록보기
	@RequestMapping(value = "/board/memberBoardList", method = RequestMethod.GET)
	public void memberBoardList(Model model) throws Exception {

		logger.info("BoardController에서 일반 게시글 목록보기 시작");

		List<BoardDTO> memberBoardList = boardService.memberBoardList();

		logger.info("일반 게시글 목록 ==> " + memberBoardList);

		model.addAttribute("boardList", memberBoardList);

	}

	// 공지 게시글 작성 페이지 접속
	@RequestMapping(value = "/board/adminBoardWritePage", method = RequestMethod.GET)
	public void connectAdminBoardWrite() throws Exception {

		logger.info("관리자 게시글 작성 페이지 접속 adminBoardWrite - controller");

	}

	// 이용자 게시글 작성 페이지 접속
	@RequestMapping(value = "/board/memberBoardWritePage", method = RequestMethod.GET)
	public void connectMemberBoardWrite() throws Exception {

		logger.info("회원 게시글 작성 페이지 접속 memberBoardWrite - controller");

	}

	// 공지 게시글 작성하기
	@RequestMapping(value = "/board/adminBoardWrite", method = RequestMethod.POST)
	public String adminBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("공지 게시글 작성 adminBoardWrite - controller");

		boardService.adminBoardWrite(boardDTO);

		return "redirect:/board/main";
	}

	// 이용자 게시글 등록하기
	@RequestMapping(value = "/board/memberBoardWrite", method = RequestMethod.POST)
	public String memberBoardWrite(BoardDTO boardDTO) throws Exception {

		logger.info("회원 게시글 작성 memberBoardWrite - controller");

		boardService.memberBoardWrite(boardDTO);

		return "redirect:/board/main";
	}

	// 공지 게시글 삭제하기
	@RequestMapping(value = "/board/adminBoardDelete", method = RequestMethod.POST)
	public String adminBoardDelete(int bno) throws Exception {

		logger.info("공지 게시글 삭제 adminBoardDelete - controller");

		boardService.adminBoardDelete(bno);

		return "redirect:/board/main";
	}

	// 이용자 게시글 삭제하기
	@RequestMapping(value = "/board/memberBoardDelete", method = RequestMethod.POST)
	public String memberBoardDelete(int bno) throws Exception {

		logger.info("회원 게시글 삭제 memberBoardDelete - BoardController");

		boardService.memberBoardDelete(bno);

		return "redirect:/board/main";
	}

	// 공지 게시글 조회하기
	@RequestMapping(value = "/board/adminBoardView", method = RequestMethod.GET)
	public void adminBoardView(Model model, BoardDTO boardDTO, int bno) throws Exception {

		logger.info("공지 게시글 조회 adminBoardView - BoardController");

		boardService.adminBoardView(bno);

		model.addAttribute("boardDTO", boardDTO);

	}

	// 이용자 게시글 조회하기
	@RequestMapping(value = "/board/memberBoardDetail", method = RequestMethod.GET)
	public void memberBoardView(Model model, BoardDTO boardDTO, int bno) throws Exception {

		logger.info("회원 게시글 조회 memberBoardDetail - BoardController");

		boardService.memberBoardView(bno);

		model.addAttribute("boardDTO", boardDTO);

	}

}
