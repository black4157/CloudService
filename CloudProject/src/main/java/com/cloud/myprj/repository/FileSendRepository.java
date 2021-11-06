package com.cloud.myprj.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.SendVO;

@Repository
public class FileSendRepository implements IFileSendRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// sendNum + 1
	@Override
	public int getMaxSendnum() {
		String sql = "select nvl(max(send_num),0) from send";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	// 파일 전송
	@Override
	public void uploadSend(SendVO vo) {
		String sql = "insert into send values(?, ?, ?, ?, ?, ?, 'F', systimestamp)";
		jdbcTemplate.update(sql, vo.getSendNum(), vo.getSender(), vo.getRecipient(), vo.getSendTitle(), vo.getFileCode(), vo.getSendContent());
	}
	
	// 유저 목록 조회
	@Override
	public List<Map<String, Object>> userList(){
		String sql = "select member_num as memberNum, name from member where retire='F'";
		return jdbcTemplate.queryForList(sql);
	}

	// 받은 메일 조회
	@Override
	public List<JoinVO> receivedMail(String recipient) {
		String sql = "select s.send_num, s.sender, s.recipient, s.send_title, s.file_code, s.send_content, s.read_check, s.send_date, f.file_managed_code, f.file_name, f.file_content, f.file_explanation, f.delete_tf "
				+ "from send s, file_save f "
				+ "where s.file_code = f.file_code and recipient = ? "
				+ "order by send_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<JoinVO>() {

			@Override
			public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JoinVO vo = new JoinVO();
				vo.setSendNum(rs.getInt("send_num"));
				vo.setSender(rs.getString("sender"));
				vo.setRecipient(rs.getString("recipient"));
				vo.setSendTitle(rs.getString("send_title"));
				vo.setFileCode(rs.getString("file_code"));
				vo.setSendContent(rs.getString("send_content"));
				vo.setReadCheck(rs.getString("read_check"));
				vo.setSendDate(rs.getTimestamp("send_date"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setDeleteTF(rs.getString("delete_tf"));

				return vo;
			}
			
		}, recipient);
	}

	// 메일 검색_제목
	@Override
	public List<JoinVO> searchMailByTitle(String recipient, String sendTitle) {
		String sql = "select s.send_num, s.sender, s.recipient, s.send_title, s.file_code, s.send_content, s.read_check, s.send_date, f.file_managed_code, f.file_name, f.file_content, f.file_explanation, f.delete_tf "
				+ "from send s, file_save f "
				+ "where (s.file_code = f.file_code and recipient = ?) and s.send_title like ? "
				+ "order by send_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<JoinVO>() {

			@Override
			public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JoinVO vo = new JoinVO();
				vo.setSendNum(rs.getInt("send_num"));
				vo.setSender(rs.getString("sender"));
				vo.setRecipient(rs.getString("recipient"));
				vo.setSendTitle(rs.getString("send_title"));
				vo.setFileCode(rs.getString("file_code"));
				vo.setSendContent(rs.getString("send_content"));
				vo.setReadCheck(rs.getString("read_check"));
				vo.setSendDate(rs.getTimestamp("send_date"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				
				return vo;
			}
			
		}, recipient, "%" + sendTitle + "%");
	}

	// 메일 검색_내용
	@Override
	public List<JoinVO> searchMailByContent(String recipient, String sendContent) {
		String sql = "select s.send_num, s.sender, s.recipient, s.send_title, s.file_code, s.send_content, s.read_check, s.send_date, f.file_managed_code, f.file_name, f.file_content, f.file_explanation, f.delete_tf "
				+ "from send s, file_save f "
				+ "where (s.file_code = f.file_code and recipient = ?) and s.send_content like ? "
				+ "order by send_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<JoinVO>() {

			@Override
			public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JoinVO vo = new JoinVO();
				vo.setSendNum(rs.getInt("send_num"));
				vo.setSender(rs.getString("sender"));
				vo.setRecipient(rs.getString("recipient"));
				vo.setSendTitle(rs.getString("send_title"));
				vo.setFileCode(rs.getString("file_code"));
				vo.setSendContent(rs.getString("send_content"));
				vo.setReadCheck(rs.getString("read_check"));
				vo.setSendDate(rs.getTimestamp("send_date"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				return vo;
			}
			
		}, recipient, "%" + sendContent + "%");
	}

	// 메일 하나 상세 조회
	@Override
	public JoinVO viewMail(int sendNum) {
		String sql = "select s.send_num, s.sender, s.recipient, s.send_title, s.file_code, s.send_content, s.read_check, s.send_date, f.file_managed_code, f.file_name, f.file_content, f.file_explanation, f.delete_tf "
				+ " from send s, file_save f "
				+ "where s.file_code = f.file_code and send_num = ? "
				+ "order by send_date desc";
		return jdbcTemplate.queryForObject(sql, new RowMapper<JoinVO>() {
			@Override
			public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JoinVO vo = new JoinVO();
				vo.setSendNum(rs.getInt("send_num"));
				vo.setSender(rs.getString("sender"));
				vo.setRecipient(rs.getString("recipient"));
				vo.setSendTitle(rs.getString("send_title"));
				vo.setFileCode(rs.getString("file_code"));
				vo.setSendContent(rs.getString("send_content"));
				vo.setReadCheck(rs.getString("read_check"));
				vo.setSendDate(rs.getTimestamp("send_date"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				
				return vo;
			}
		}, sendNum);
	}

	// 읽음 확인
	@Override
	public void readCheck(int sendNum) {
		String sql = "update send "
				+ "set read_check = 'T' "
				+ "where send_num = ?";
		jdbcTemplate.update(sql, sendNum);
		
	}

	// 메일 삭제
	@Override
	public void delete(int sendNum) {
		String sql = "delete send where send_num = ?";
		jdbcTemplate.update(sql, sendNum);
	}

	@Override
	public int getNotRead(String recipient) {
		String sql = "select count(*) from send where recipient = ? and read_check = 'F'";
		return jdbcTemplate.queryForObject(sql, Integer.class, recipient);
	}
	
	

}
