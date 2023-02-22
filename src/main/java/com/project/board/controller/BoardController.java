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
import com.project.board.service.BoardServiceImpl;

// 클래스에 리퀘스트 매핑을 달면 검색이 어려워진다. -> 메서드에 자체적으로 달자 /패키지/요청
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardServiceImpl boardService;
	
	
	// 공지 게시글 작성폼
	@RequestMapping(value = "/board/boardWriteFormOp", method = RequestMethod.GET)
	public String boardWriteFormOp() throws Exception {
		
		logger.info("BoardController에서 운영진 게시글 쓰기 시작");
		
		
		return "/board/boardWriteFormOp";
	}
	// 일반 게시글 작성폼
	@RequestMapping(value = "/board/boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm() throws Exception {
		
		logger.info("BoardController에서 일반 게시글 쓰기 시작");
		
		
		return "/board/boardWriteForm";
	} 
	
	// 공지 게시글 등록하기
	@RequestMapping(value = "/board/boardWriteOp", method = RequestMethod.POST)
	public String boardWriteOp(BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardController에서 운영진 게시글 등록하기 시작");
		
		boardService.boardWriteOp(boardDTO);
		
		return "redirect:/board/main";
	}
	// 일반 게시글 등록하기
		@RequestMapping(value = "/board/boardWrite", method = RequestMethod.POST)
		public String boardWrite(BoardDTO boardDTO) throws Exception {
			
			logger.info("BoardController에서 일반 게시글 등록하기 시작");
			
			boardService.boardWrite(boardDTO);
			
			
			return "redirect:/board/main";
	}
	// 공지 게시글 삭제하기
	@RequestMapping(value = "/board/boardDeleteOp", method = RequestMethod.POST)
	public String boardDeleteOp(int bno) throws Exception {
		
		logger.info("BoardController에서 운영진 게시글 삭제하기 시작");
		
		boardService.boardDeleteOp(bno); 
		
		return "redirect:/board/main";
	}
		
		
	// 일반 게시글 삭제하기
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.POST)
	public String boardDelete(int bno) throws Exception {
		
		logger.info("BoardController에서 일반 게시글 삭제하기 시작");
		
		boardService.boardDelete(bno);
		
		return "redirect:/board/main";
	}
	
	// 공지 게시글 상세 조회하기
	@RequestMapping(value = "/board/boardDetailOp", method = RequestMethod.GET)
	public void boardDetailOp(Model model, BoardDTO boardDTO, int bno) throws Exception {
		
		logger.info("BoardController에서 공지 게시글 상세 조회 시작하기");
		
	
		boardService.boardDetailOp(bno);
		
		
		model.addAttribute("boardDTO", boardDTO);
		
	}
	
	// 일반 게시글 상세 조회하기
	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public void boardDetail(Model model, BoardDTO boardDTO, int bno) throws Exception {
		
		logger.info("BoardController에서 일반 게시글 상세 조회 시작하기");
		
	
		boardService.boardDetail(bno);
		
		
		model.addAttribute("boardDTO", boardDTO);
		
	}
	/*
	// 공지 게시글 수정하기
	@RequestMapping(value = "/board/boardUpdateOp", method = RequestMethod.POST)
	public String boardUpdateOp(BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardController에서 공지 게시글 수정하기 시작");
		
	
		boardService.boardUpdateOp(boardDTO);
		
		
		return "redirect:/board/main";
	}
		
		
	// 이용자 게시글 수정하기
	@RequestMapping(value = "/board/board", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO, int bno) throws Exception {
		
		logger.info("BoardController에서 공지 게시글 수정하기 시작");
		
		HashMap<String, Object> boardUpdate = new HashMap<String, Object>();
		boardUpdate.put("bno", bno);
		boardUpdate.put("boardDTO", boardDTO);
		
		boardService.boardUpdate(boardUpdate);
		
		return "redirect:/board/main";
	}
	*/
	
	
	// 공지 게시글 목록보기
	@RequestMapping(value = "/board/boardListOp", method = RequestMethod.GET)
	public void boardListOp(Model model) throws Exception {
		
		logger.info("BoardController에서 공지 게시글 목록보기 시작");
		
		List<BoardDTO> boardList = boardService.boardListOp();
		
		logger.info("공지 게시글 목록 ==> " + boardList);
		
		model.addAttribute("boardListOp", boardList);
		
	}
	
	// 일반 게시글 목록보기
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public void boardList(Model model) throws Exception {
		
		logger.info("BoardController에서 일반 게시글 목록보기 시작");
		
		List<BoardDTO> boardList = boardService.boardList();
		
		logger.info("일반 게시글 목록 ==> " + boardList);
		
		model.addAttribute("boardList", boardList);
		
	}
}



































