package com.cloud.myprj.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


import com.cloud.myprj.member.MemberVO;

//UserRepositoryImpl
@Repository
public class UserRepository implements IUserRepository {
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void memberRegister(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO memberlogin(MemberVO memberVO) throws Exception {
		String sql = "select * from member where member_num = ? and pwd = ?";
		Object[] args = {memberVO.getMemberNum(), memberVO.getPwd()};
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberNum(rs.getString("member_num"));
				memberVO.setDepartment(rs.getString("department"));
				memberVO.setMemberAuth(rs.getString("member_auth"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setPosition(rs.getString("position"));
				memberVO.setName(rs.getString("name"));
				return memberVO;
			}
		});
	}
	
	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int memberIdChk(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO getByUserId(String memberNum) throws Exception {
		return null;
	}



}
