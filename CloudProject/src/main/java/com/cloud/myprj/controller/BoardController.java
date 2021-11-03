package com.cloud.myprj.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.service.IBoardService;

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	public int logincheck(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberVO") != null) {
			return 1;
		}
		else return 0;
	}
	
	@Autowired
	IBoardService boardService;

	@RequestMapping(value = "/board/boardList")
	public String boardList(Model model, HttpServletRequest req) {
		if(logincheck(req) == 1) {
			model.addAttribute("boardList", boardService.getAllBoard());
			return "board/boardList";
		}
		else return "home";
	}

	@RequestMapping(value = "/board/boardReply/{contentNum}", method = RequestMethod.GET)
	public String board(@PathVariable String contentNum, Model model, HttpServletRequest req) {
		if(logincheck(req)==1) {
			logger.info("글 출력");
			model.addAttribute("board", boardService.getBoard(contentNum));
			model.addAttribute("commentList", boardService.getComment(contentNum));
			return "board/boardReply";
		}
		else return"home";
	}

	@RequestMapping(value = "/board/boardReply", method = RequestMethod.POST)
	public String insertReply(@RequestParam String comment, @RequestParam String contentNum,
			RedirectAttributes redirectAttrs, HttpServletRequest req, MemberVO memberVO, Model model) {
		if(logincheck(req) == 1) {
			try {
				HttpSession session = req.getSession();
				model.addAttribute("memberVO", memberVO);
				logger.info("댓글 등록" + comment + contentNum);
				BoardCommentVO boardComment = new BoardCommentVO();
				boardComment.setContentNum(contentNum);
				comment=comment.replace("\r\n", "<br>");
				boardComment.setCommentContent(comment);
				boardComment.setMemberNum((String)session.getAttribute("memberNum"));
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				boardComment.setCommentDate(timestamp);
				boardService.insertComment(boardComment);
	
			} catch (Exception e) {
				logger.error(e.getMessage());
				redirectAttrs.addFlashAttribute("message", e.getMessage());
			}
			return "redirect:/board/boardReply/" + contentNum;
		}
		else return "home";
	}

	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.GET)
	public String getBoardNum(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			return "board/boardInsert";
		}
		else return "redirect:/board/boardList";
	}

	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.POST)
	public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent,
			RedirectAttributes redirectAttrs) {
		try {

			logger.info("공지사항 등록" + boardTitle);
			BoardVO board = new BoardVO();
			board.setBoardTitle(boardTitle);
			//내용 줄바꿈 적용
			boardContent=boardContent.replace("\r\n", "<br>");
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

	// 댓글 삭제
	@RequestMapping(value = "/board/boardCommentDelete")
	public String deleteBoardComment(Model model, String commentNum, String contentNum, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			boardService.deleteComment(commentNum);
			return "redirect:/board/boardReply/" + contentNum;
		}
		else return "redirect:/board/boardReply/" + contentNum;
	}

	// 공지사항 수정하기,get
	@RequestMapping(value = "/board/boardUpdate/{contentNum}", method = RequestMethod.GET)
	public String getUpdateBoard(@PathVariable String contentNum, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			BoardVO boardLoad=boardService.getBoard(contentNum);
			boardLoad.setBoardContent(boardLoad.getBoardContent().replace("<br>","\r\n"));
			model.addAttribute("board", boardLoad);
			return "board/boardUpdate";
		}
		else return "redirect:/board/boardList";
	}

	// 공지사항 수정하기,post
	@RequestMapping(value = "/board/boardUpdate", method = RequestMethod.POST)
	public String UpdateBoard(@RequestParam String boardTitle, @RequestParam String boardContent,
			@RequestParam String boardcontentNum, RedirectAttributes redirectAttrs) {
		try {

			logger.info("공지사항 수정" + boardTitle);
			BoardVO board = new BoardVO();
			board.setContentNum(boardcontentNum);
			board.setBoardTitle(boardTitle);
			boardContent=boardContent.replace("\r\n", "<br>");
			board.setBoardContent(boardContent);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			board.setBoardDate(timestamp);
			boardService.updateBoard(board);

		} catch (Exception e) {
			logger.error(e.getMessage());
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/boardList";
	}

	// 공지사항 삭제
	@RequestMapping(value = "/board/boardDelete")
	public String deleteBoard(Model model, String contentNum, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			logger.info("공지사항 삭제" + contentNum);
			boardService.deleteBoard(contentNum);
			return "redirect:/board/boardList";
		}
		else return "redirect:/board/boardList";
	}

}
