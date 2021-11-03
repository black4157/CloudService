package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;

public interface IBoardRepository {
	
	List<BoardVO> getAllBoard();
	BoardVO getBoard(String contentNum);
	void insertBoard(BoardVO board);
	String getBoardNum();
	void insertComment(BoardCommentVO boardComment);
	String getCommentNum();
	List<BoardCommentVO> getComment(String contentNum);
	void deleteComment(String commentNum);
}
