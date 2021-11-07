package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;
import com.cloud.myprj.member.MemberVO;

public interface IBoardRepository {
	
	// 공지사항 리스트 출력
	List<BoardVO> getAllBoard();
	
	// 공지사항 하나 출력
	BoardVO getBoard(String contentNum);
	
	// 공지사항 작성
	void insertBoard(BoardVO board);
	
	// 게시글 번호 얻기
	String getBoardNum();
	
	// 댓글 작성
	void insertComment(BoardCommentVO boardComment);
	
	// 댓글 번호 얻기
	String getCommentNum();
	
	// 댓글 리스트 출력
	List<BoardCommentVO> getComment(String contentNum);
	
	// 댓글 삭제
	void deleteComment(String commentNum);
	
	// 공지사항 수정
	void updateBoard(BoardVO board);
	
	// 공지사항 삭제
	void deleteBoard(String contentNum);

	// 게시판 검색_제목
	public List<BoardVO> searchBoardByTitle(String boardTitle);
	
	// 게시판 검색_내용
	public List<BoardVO> searchBoardByContent(String boardContent);
	
	//최신글 5개 가져오기
	List<BoardVO> selectFive();
}
