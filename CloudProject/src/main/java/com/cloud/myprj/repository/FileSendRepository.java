package com.cloud.myprj.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.SendVO;

@Repository
public class FileSendRepository implements IFileSendRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void uploadSend(SendVO vo) {
		String sql = "insert into send values(?, ?, ?, ?, 'F', systimestamp)";
		jdbcTemplate.update(sql, vo.getSender(), vo.getRecipient(), vo.getFileCode(), vo.getSendContent());
	}
//
//	@Override
//	public List<FileSaveVO> fileList(String memberNum) {
//		String sql = "select * from file_save where member_num=?";
//		
//		return jdbcTemplate.queryForList(sql, memberNum);
//	}
}
