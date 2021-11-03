package com.cloud.myprj.controller;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;
import com.cloud.myprj.service.IBoardService;

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	IBoardService boardService;

	@RequestMapping(value = "/board/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getAllBoard());
		return "board/boardList";
	}

	@RequestMapping(value = "/board/boardReply/{contentNum}", method = RequestMethod.GET)
	public String board(@PathVariable String contentNum, Model model) {
		logger.info("글 출력" );
		model.addAttribute("board", boardService.getBoard(contentNum));
		model.addAttribute("commentList", boardService.getComment(contentNum));
		return "board/boardReply";
	}

	@RequestMapping(value = "/board/boardReply", method = RequestMethod.POST)
	public String insertReply(@RequestParam String comment, @RequestParam String contentNum,
			RedirectAttributes redirectAttrs) {
		try {
			logger.info("댓글 등록" + comment+contentNum);
			BoardCommentVO boardComment = new BoardCommentVO();
			boardComment.setContentNum(contentNum);
			boardComment.setCommentContent(comment);
			boardComment.setMemberNum("s");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			boardComment.setCommentDate(timestamp);
			boardService.insertComment(boardComment);

		} catch (Exception e) {
			logger.error(e.getMessage());
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/boardReply/"+contentNum;
	}
	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.GET)
	public String getBoardNum(Model model) {
		return "board/boardInsert";
	}

	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.POST)
	public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent, String num,
			RedirectAttributes redirectAttrs) {
		try {

			logger.info("공지사항 등록" + boardTitle);
			BoardVO board = new BoardVO();
			board.setContentNum(num);
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			board.setBoardDate(timestamp);
			boardService.insertBoard(board);

		} catch (Exception e) {
			logger.error(e.getMessage());
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardDelete/{commentNum}",  method = RequestMethod.GET)
	public String deleteBoardComment(@RequestParam String commentNum, Model model) {
		boardService.deleteComment(commentNum);
		return "/board/boardReply/";
	}
//	@RequestMapping(value = "/board/boardReply/{contentNum}", method = RequestMethod.GET)
//	public String board(@PathVariable String contentNum, Model model) {
//		logger.info("글 출력" );
//		model.addAttribute("board", boardService.getBoard(contentNum));
//		model.addAttribute("commentList", boardService.getComment(contentNum));
//		return "board/boardReply";
//	}
}
