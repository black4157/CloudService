package com.cloud.myprj.controller;

import java.sql.Timestamp;
import java.util.List;

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
import com.cloud.myprj.service.IUserService;

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	static final String admin="S0001";

	@Autowired
	IBoardService boardService;
	
	@Autowired
	IUserService userService;

	// 공지사항 목록 가져오기_Get
	@RequestMapping(value = "/board/boardList", method=RequestMethod.GET)
	public String boardList(Model model, HttpSession session, MemberVO memberVO) {
		if (userService.logincheck(session) == 1) {
			List<BoardVO> lstBoard= boardService.getAllBoard();
			memberVO = (MemberVO) session.getAttribute("memberVO");
			for(BoardVO board :lstBoard) {
				if(board.getBoardContent().length()>20) {
					board.setBoardContent(board.getBoardContent().substring(0, 20).replace("<br>", " "));
				}
			}
			if(lstBoard == null) {
				String msg = "조회된 공지사항이 없습니다.";
				model.addAttribute("msg", msg);
			}
			model.addAttribute("boardList", lstBoard);
			model.addAttribute("memberVO", memberVO);
			return "board/boardList";
		} else
			return "redirect:/home";
	}

	// 공지사항 목록 가져오기_Post (검색 : 제목, 내용)
	@RequestMapping(value = "/board/boardList", method=RequestMethod.POST)
	public String searchBoardList(String boardTitle, String boardContent, HttpSession session, Model model, MemberVO memberVO) {
		if(userService.logincheck(session) == 1) {
			List<BoardVO> lstBoard = null;
			if(boardContent == null) {
				lstBoard= boardService.searchBoardByTitle(boardTitle);
			}
			else {
				lstBoard= boardService.searchBoardByContent(boardContent);
			}
			memberVO.setMemberNum((String) session.getAttribute("memberNum"));
			for(BoardVO board :lstBoard) {
				if(board.getBoardContent().length()>20) {
					board.setBoardContent(board.getBoardContent().substring(0, 20).replace("<br>", " "));
				}
			}
			model.addAttribute("boardList", lstBoard);
			model.addAttribute("memberVO", memberVO);
			return "board/boardList";
		}
		else return "redirect:/home";
	}
	
	// 공지사항 내용 하나 가져오기
	@RequestMapping(value = "/board/boardReply/{contentNum}", method = RequestMethod.GET)
	public String board(@PathVariable String contentNum, Model model, HttpSession session, MemberVO memberVO) {
		if (userService.logincheck(session) == 1) {
			logger.info("글 출력");
			System.out.println("member 세팅 전 : " + memberVO);
			memberVO.setMemberNum((String) session.getAttribute("memberNum"));
			model.addAttribute("board", boardService.getBoard(contentNum));
			model.addAttribute("commentList", boardService.getComment(contentNum));
			model.addAttribute("memberVO", memberVO);
			System.out.println("member 세팅 후 : " + memberVO);
			return "board/boardReply";
		} else
			return "redirect:/home";
	}

	// 댓글 작성
	@RequestMapping(value = "/board/boardReply", method = RequestMethod.POST)
	public String insertReply(@RequestParam String comment, @RequestParam String contentNum,
			RedirectAttributes redirectAttrs, HttpSession session, MemberVO memberVO, Model model) {
		if (userService.logincheck(session) == 1) {
			try {
				model.addAttribute("memberVO", memberVO);
				logger.info("댓글 등록" + comment + contentNum);
				BoardCommentVO boardComment = new BoardCommentVO();
				boardComment.setContentNum(contentNum);
				comment = comment.replace("\r\n", "<br>");
				boardComment.setCommentContent(comment);
				boardComment.setMemberNum((String) session.getAttribute("memberNum"));
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				boardComment.setCommentDate(timestamp);
				boardService.insertComment(boardComment);

			} catch (Exception e) {
				logger.error(e.getMessage());
				redirectAttrs.addFlashAttribute("message", e.getMessage());
			}
			return "redirect:/board/boardReply/" + contentNum;
		} else
			return "redirect:/home";
	}

	// 게시글 번호 +1 증가 하기 위한 클래스
	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.GET)
	public String getBoardNum(Model model, HttpSession session) {
		if (admin.equals(session.getAttribute("memberNum"))) {
			return "board/boardInsert";
		} else
			return "redirect:/board/boardList";
	}

	// 게시글 작성
	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.POST)
	public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent,
			RedirectAttributes redirectAttrs) {
		try {

			logger.info("공지사항 등록" + boardTitle);
			BoardVO board = new BoardVO();
			board.setBoardTitle(boardTitle);
			// 내용 줄바꿈 적용
			boardContent = boardContent.replace("\r\n", "<br>");
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
	public String deleteBoardComment(Model model, String commentNum, String contentNum, HttpSession session) {
		if (admin.equals(session.getAttribute("memberNum"))) {
			boardService.deleteComment(commentNum);
			return "redirect:/board/boardReply/" + contentNum;
		} else
			return "redirect:/board/boardReply/" + contentNum;
	}

	// 공지사항 수정하기,get
	@RequestMapping(value = "/board/boardUpdate/{contentNum}", method = RequestMethod.GET)
	public String getUpdateBoard(@PathVariable String contentNum, Model model, HttpSession session) {
		if (admin.equals(session.getAttribute("memberNum"))) {
			BoardVO boardLoad = boardService.getBoard(contentNum);
			boardLoad.setBoardContent(boardLoad.getBoardContent().replace("<br>", "\r\n"));
			model.addAttribute("board", boardLoad);
			return "board/boardUpdate";
		} else
			return "redirect:/board/boardList";
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
			boardContent = boardContent.replace("\r\n", "<br>");
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
	public String deleteBoard(Model model, String contentNum, HttpSession session) {
		if (admin.equals(session.getAttribute("memberNum"))) {
			logger.info("공지사항 삭제" + contentNum);
			boardService.deleteBoard(contentNum);
			return "redirect:/board/boardList";
		} else
			return "redirect:/board/boardList";
	}

}
