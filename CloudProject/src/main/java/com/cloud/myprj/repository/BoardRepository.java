package com.cloud.myprj.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.BoardCommentVO;
import com.cloud.myprj.member.BoardVO;

@Repository
public class BoardRepository implements IBoardRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// 게시판 리스트 출력
	@Override
	public List<BoardVO> getAllBoard() {
		String sql = "select * from BOARD ORDER BY BOARD_DATE desc";

		return jdbcTemplate.query(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO board = new BoardVO();
				board.setContentNum(rs.getString("CONTENT_NUM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				return board;
			}
		});
	}
	
	// 검색_게시글 제목
	@Override
	public List<BoardVO> searchBoardByTitle(String boardTitle) {
		String sql = "select * from BOARD where board_title like ? ORDER BY CONTENT_NUM";
		return jdbcTemplate.query(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO board = new BoardVO();
				board.setContentNum(rs.getString("CONTENT_NUM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				return board;
			}
		}, "%" + boardTitle + "%");
	}
	
	// 검색_게시글 내용
	@Override
	public List<BoardVO> searchBoardByContent(String boardContent) {
		String sql = "select * from BOARD where board_content like ? ORDER BY CONTENT_NUM";
		return jdbcTemplate.query(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO board = new BoardVO();
				board.setContentNum(rs.getString("CONTENT_NUM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				return board;
			}
		}, "%" + boardContent + "%");
	}

	// 게시글 하나 보기
	@Override
	public BoardVO getBoard(String contentNum) {
		String sql = "select * from BOARD where CONTENT_NUM=?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO board = new BoardVO();
				board.setContentNum(rs.getString("CONTENT_NUM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				return board;
			}

		}, contentNum);
	}

	// 게시글 번호 +1 자동 생성
	@Override
	public String getBoardNum() {
		String sql = "select NVL(MAX(CONTENT_NUM + 0),0) from BOARD";
		String num = jdbcTemplate.queryForObject(sql, String.class);
		return String.valueOf(Integer.parseInt(num) + 1);
	}

	// 게시글 쓰기
	@Override
	public void insertBoard(BoardVO board) {
		String sql = "insert into board(CONTENT_NUM, BOARD_TITLE, BOARD_CONTENT,BOARD_DATE) values(?,?,?,?)";
		jdbcTemplate.update(sql, board.getContentNum(), board.getBoardTitle(), board.getBoardContent(),
				board.getBoardDate());

	}

	// 댓글 번호 +1 자동 생성
	@Override
	public String getCommentNum() {
		String sql = "select NVL(MAX(COMMENT_NUM + 0),0) from BOARD_COMMENT";
		String num = jdbcTemplate.queryForObject(sql, String.class);
		return String.valueOf(Integer.parseInt(num) + 1);
	}

	// 댓글 보기
	@Override
	public List<BoardCommentVO> getComment(String contentNum) {
		String sql = "select * from BOARD_COMMENT where CONTENT_NUM=? ORDER BY COMMENT_NUM";
		return jdbcTemplate.query(sql, new RowMapper<BoardCommentVO>() {

			@Override
			public BoardCommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardCommentVO boardComment = new BoardCommentVO();
				boardComment.setCommentContent(rs.getString("COMMENT_CONTENT"));
				boardComment.setContentNum(rs.getString("CONTENT_NUM"));
				boardComment.setCommentDate(rs.getTimestamp("COMMENT_DATE"));
				boardComment.setCommentNum(rs.getString("COMMENT_NUM"));
				boardComment.setMemberNum(rs.getString("MEMBER_NUM"));

				return boardComment;
			}
		}, contentNum);
	}

	// 댓글 쓰기
	@Override
	public void insertComment(BoardCommentVO boardComment) {
		String sql = "insert into BOARD_COMMENT(COMMENT_NUM, CONTENT_NUM, COMMENT_CONTENT,MEMBER_NUM,COMMENT_DATE) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, boardComment.getCommentNum(), boardComment.getContentNum(),
				boardComment.getCommentContent(), boardComment.getMemberNum(), boardComment.getCommentDate());

	}

	// 댓글 삭제
	@Override
	public void deleteComment(String commentNum) {
		String sql = "DELETE FROM BOARD_COMMENT WHERE COMMENT_NUM= ?";
		jdbcTemplate.update(sql, commentNum);

	}

	// 게시글 수정
	@Override
	public void updateBoard(BoardVO board) {
		String sql = "Update board set board_title=?, board_content=?,board_date=? where content_num=?";
		jdbcTemplate.update(sql, board.getBoardTitle(), board.getBoardContent(), board.getBoardDate(),
				board.getContentNum());
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(String contentNum) {
		//공지사항을 삭제
		String sql = "DELETE FROM BOARD WHERE CONTENT_NUM= ?";
		jdbcTemplate.update(sql, contentNum);
		//공지사항에 올라왔던 댓글 삭제
		String sql2 = "DELETE FROM BOARD_COMMENT WHERE CONTENT_NUM= ?";
		jdbcTemplate.update(sql2, contentNum);
	}

	@Override
	public List<BoardVO> selectFive() {
		String sql = "select content_num, board_title, board_content, board_date " + 
				"from (select rownum,content_num, board_title, board_content, board_date from board order by board_date desc) " + 
				"where rownum between 1 and 5";
		return jdbcTemplate.query(sql, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO vo = new BoardVO();
				vo.setContentNum(rs.getString("CONTENT_NUM"));
				vo.setBoardTitle(rs.getString("BOARD_TITLE"));
				vo.setBoardContent(rs.getString("BOARD_CONTENT"));
				vo.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				return vo;
			}
			
		});
	}
}
