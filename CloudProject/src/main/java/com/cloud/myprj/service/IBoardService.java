package com.cloud.myprj.service;

import java.util.List;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;

public interface IBoardService {

	// 공지사항 목록 가져오기
	List<BoardVO> getAllBoard();
	// 공지사항 하나 내용 가져오기
	BoardVO getBoard(String contentNum);
	void insertBoard(BoardVO board);
	void insertComment(BoardCommentVO boardComment);
	List<BoardCommentVO> getComment(String contentNum);
}
