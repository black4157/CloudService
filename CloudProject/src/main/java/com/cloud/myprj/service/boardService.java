package com.cloud.myprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;
import com.cloud.myprj.repository.IBoardRepository;

@Service
public class boardService implements IBoardService {
	@Autowired
	IBoardRepository boardRepository;

	// 공지사항 목록 가져오기
	@Override
	public List<BoardVO> getAllBoard() {

		return boardRepository.getAllBoard();
	}

	// 검색_게시글 제목
	@Override
	public List<BoardVO> searchBoardByTitle(String boardTitle) {
		return boardRepository.searchBoardByTitle(boardTitle);
	}
	
	// 검색_게시글 내용
	@Override
	public List<BoardVO> searchBoardByContent(String boardContent){
		return boardRepository.searchBoardByContent(boardContent);
	}

	// 공지사항 하나 가져오기
	@Override
	public BoardVO getBoard(String contentNum) {
		return boardRepository.getBoard(contentNum);
	}

	// 게시글 작성
	@Override
	public void insertBoard(BoardVO board) {
		board.setContentNum(boardRepository.getBoardNum());
		boardRepository.insertBoard(board);
	}

	// 댓글 작성
	@Override
	public void insertComment(BoardCommentVO boardComment) {
		boardComment.setCommentNum(boardRepository.getCommentNum());
		boardRepository.insertComment(boardComment);

	}

	// 댓글 보기
	@Override
	public List<BoardCommentVO> getComment(String contentNum) {
		return boardRepository.getComment(contentNum);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(String commentNum) {
		boardRepository.deleteComment(commentNum);

	}

	// 게시글 수정
	@Override
	public void updateBoard(BoardVO board) {
		boardRepository.updateBoard(board);
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(String contentNum) {
		boardRepository.deleteBoard(contentNum);

	}
}
