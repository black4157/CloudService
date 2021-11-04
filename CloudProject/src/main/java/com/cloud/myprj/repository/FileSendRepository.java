package com.cloud.myprj.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.SendVO;

@Repository
public class FileSendRepository implements IFileSendRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public int getMaxSendnum() {
		String sql = "select nvl(max(send_num),0) from send";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public void uploadSend(SendVO vo) {
		String sql = "insert into send values(?, ?, ?, ?, ?, 'F', systimestamp)";
		jdbcTemplate.update(sql, vo.getSendNum(), vo.getSender(), vo.getRecipient(), vo.getFileCode(), vo.getSendContent());
	}
	
	@Override
	public List<Map<String, Object>> userList(){
		String sql = "select member_num as memberNum, name from member";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> receivedMail(String recipient) {
		String sql = "select * from send s, file_save f where s.file_code = f.file_code and recipient = ?";
		return jdbcTemplate.queryForList(sql, recipient);
	}

	@Override
	public Object viewMail(int sendNum) {
		String sql = "select * from send s, file_save f where s.file_code = f.file_code and send_num = ? order by send_date desc";
		return jdbcTemplate.queryForList(sql, sendNum);
	}

}
