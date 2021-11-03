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
public class boardRepository implements IBoardRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BoardVO> getAllBoard() {
		String sql = "select * from BOARD ORDER BY CONTENT_NUM";

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

	@Override
	public String getBoardNum() {
		String sql = "select NVL(MAX(CONTENT_NUM),0) from BOARD";
		String num = jdbcTemplate.queryForObject(sql, String.class);
		return String.valueOf(Integer.parseInt(num) + 1);
	}

	@Override
	public void insertBoard(BoardVO board) {
		String sql = "insert into board(CONTENT_NUM, BOARD_TITLE, BOARD_CONTENT,BOARD_DATE) values(?,?,?,?)";
		jdbcTemplate.update(sql, board.getContentNum(), board.getBoardTitle(), board.getBoardContent(),
				board.getBoardDate());

	}

	@Override
	public String getCommentNum() {
		String sql = "select NVL(MAX(COMMENT_NUM),0) from BOARD_COMMENT";
		String num = jdbcTemplate.queryForObject(sql, String.class);
		return String.valueOf(Integer.parseInt(num) + 1);
	}

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

	@Override
	public void insertComment(BoardCommentVO boardComment) {
		String sql = "insert into BOARD_COMMENT(COMMENT_NUM, CONTENT_NUM, COMMENT_CONTENT,MEMBER_NUM,COMMENT_DATE) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, boardComment.getCommentNum(), boardComment.getContentNum(),
				boardComment.getCommentContent(), boardComment.getMemberNum(), boardComment.getCommentDate());

	}

	@Override
	public void deleteComment(String commentNum) {
		String sql = "DELETE FROM BOARD_COMMENT WHERE COMMENT_NUM= ?";
		jdbcTemplate.update(sql, commentNum);

	}

	@Override
	public void updateBoard(BoardVO board) {
		String sql = "Update board set board_title=?, board_content=?,board_date=? where content_num=?";
		jdbcTemplate.update(sql, board.getBoardTitle(), board.getBoardContent(), board.getBoardDate(),
				board.getContentNum());
	}

	@Override
	public void deleteBoard(String contentNum) {
		//공지사항을 삭제
		String sql = "DELETE FROM BOARD WHERE CONTENT_NUM= ?";
		jdbcTemplate.update(sql, contentNum);
		//공지사항에 올라왔던 댓글 삭제
		String sql2 = "DELETE FROM BOARD_COMMENT WHERE CONTENT_NUM= ?";
		jdbcTemplate.update(sql2, contentNum);
	}
}
