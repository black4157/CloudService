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
   public String getMemberNum() {
      String sql = "select nvl(max(SUBSTR(member_num,length(member_num)-3,length(member_num))),0) as member_num"
            + " from member";
      int intResult = jdbcTemplate.queryForObject(sql, Integer.class) + 1;
      String strResult = String.format("%04d", intResult);
      return "S" + strResult;
   }
	
	@Override
	public void memberRegister(MemberVO memberVO) throws Exception {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, memberVO.getMemberNum(), memberVO.getPwd(), memberVO.getName(), memberVO.getPhone(), memberVO.getPosition(), memberVO.getDepartment(), memberVO.getMemberAuth());
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		String sql = "select * from member where member_num = ? and pwd = ?";
		Object[] args = {memberVO.getMemberNum(), memberVO.getPwd()};
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberNum(rs.getString("member_num"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setPosition(rs.getString("position"));
				memberVO.setDepartment(rs.getString("department"));
				memberVO.setMemberAuth(rs.getString("member_auth"));
				return memberVO;
			}
		});
	}
	
	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		String sql = "update member set pwd=?, name=?, phone=?, position=?, department=?, member_auth=? where member_num=?";
		jdbcTemplate.update(sql, memberVO.getPwd(),
								 memberVO.getName(),
								 memberVO.getPhone(),
								 memberVO.getPosition(),
								 memberVO.getDepartment(),
								 memberVO.getMemberAuth());	
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		String sql = "delete from member where member_num=?";
		
		
	}

	@Override
	public MemberVO getByUserId(String memberNum) throws Exception {
		return null;
	}

	@Override
	public List<MemberVO> getMemberList() {
		String sql = "select * from member where member_num not in('S0001') order by member_num";
		return jdbcTemplate.query(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberNum(rs.getString("member_num"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setPosition(rs.getString("position"));
				memberVO.setDepartment(rs.getString("department"));
				memberVO.setMemberAuth(rs.getString("member_auth"));
				return memberVO;
			}
		});
	}

	@Override
	public MemberVO getMemberInfo(String memberNum) throws Exception {
		String sql = "select member_num, name, phone, "
				+ "position, department, member_auth "
				+ "from member "
				+ " where member_num=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberNum(rs.getString("member_num"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setPosition(rs.getString("position"));
				memberVO.setDepartment(rs.getString("department"));
				memberVO.setMemberAuth(rs.getString("member_auth"));
				return memberVO;
			}
		}, memberNum);
	}



}
