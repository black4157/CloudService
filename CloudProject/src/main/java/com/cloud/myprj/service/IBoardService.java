package com.cloud.myprj.service;

import java.util.List;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;

public interface IBoardService {

	// 공지사항 목록 가져오기
	List<BoardVO> getAllBoard();
	
	// 공지사항 하나 내용 가져오기
	BoardVO getBoard(String contentNum);
	
	// 게시글 작성
	void insertBoard(BoardVO board);
	
	// 댓글 작성
	void insertComment(BoardCommentVO boardComment);
	
	// 댓글 보기
	List<BoardCommentVO> getComment(String contentNum);
	
	// 댓글 삭제
	void deleteComment(String commentNum);
	
	// 게시글 수정
	void updateBoard(BoardVO board);
	
	// 게시글 삭제
	void deleteBoard(String contentNum);
	
	// 검색_게시글 제목
	public List<BoardVO> searchBoardByTitle(String boardTitle);
	
	// 검색_게시글 내용
	public List<BoardVO> searchBoardByContent(String boardContent);
	
	List<BoardVO> selectFive();
}
