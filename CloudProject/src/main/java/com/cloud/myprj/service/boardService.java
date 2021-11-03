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

	@Override
	public List<BoardVO> getAllBoard() {

		return boardRepository.getAllBoard();
	}

	@Override
	public BoardVO getBoard(String contentNum) {
		return boardRepository.getBoard(contentNum);
	}

	@Override
	public void insertBoard(BoardVO board) {
		board.setContentNum(boardRepository.getBoardNum());
		boardRepository.insertBoard(board);
	}

	@Override
	public void insertComment(BoardCommentVO boardComment) {
		boardComment.setCommentNum(boardRepository.getCommentNum());
		boardRepository.insertComment(boardComment);

	}

	@Override
	public List<BoardCommentVO> getComment(String contentNum) {
		return boardRepository.getComment(contentNum);
	}

	@Override
	public void deleteComment(String commentNum) {
		boardRepository.deleteComment(commentNum);

	}

	@Override
	public void updateBoard(BoardVO board) {
		boardRepository.updateBoard(board);
	}

	@Override
	public void deleteBoard(String contentNum) {
		boardRepository.deleteBoard(contentNum);

	}
}
