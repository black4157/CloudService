package com.cloud.myprj.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.member.SendVO;

@Repository
public class FileUploadRepository implements IFileUploadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// 개인 파일 업로드
	@Override
	public void uploadFile(FileSaveVO file) {
		String sql = "insert into file_save values(?,?,?,?,?,?,systimestamp,systimestamp,'F',?)";
		jdbcTemplate.update(sql, file.getFileCode(), file.getFileManagedCode(), file.getMemberNum(), file.getFileName(),
				file.getFileContent(), file.getFileExplanation(), file.getFilePath());
	}
	
	// file_code + 1 자동 생성
	@Override
	public String getFileCode() {
		String sql = "select nvl(max(SUBSTR(file_code, length(file_code)-8, length(file_code))),0) as file_code"
				+ " from file_save";
		int intResult = jdbcTemplate.queryForObject(sql, Integer.class) + 1;
		String strResult = String.format("%09d", intResult);
		return "F" + strResult;
	}

	// 멤버 번호  + 1 자동 생성
	@Override
	public String getMemeberNum() {
		String sql = "select nvl(max(SUBSTR(member_num,length(member_num)-3,length(member_num))),0) as member_num"
				+ " from member";
		int intResult = jdbcTemplate.queryForObject(sql, Integer.class) + 1;
		String strResult = String.format("%04d", intResult);
		return "S" + strResult;
	}

	// 개인 폴더 리스트 조회
	@Override
	public List<FileSaveVO> getPersonalFileList(String memberNum) {
		String sql = "select * from file_save where member_num = ? and file_managed_code='p' order by update_date desc";

		return jdbcTemplate.query(sql, new RowMapper<FileSaveVO>() {
			@Override
			public FileSaveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileSaveVO vo = new FileSaveVO();
				vo.setFileCode(rs.getString("file_code"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setMemberNum(rs.getString("member_num"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setUploadDate(rs.getTimestamp("upload_date"));
				vo.setUpdateDate(rs.getTimestamp("update_date"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				vo.setFilePath(rs.getString("file_path"));
				return vo;
			}
		}, memberNum);
	}

	// 공유 폴더 리스트 조회
	@Override
	public List<FileSaveVO> getShareFileList(String fileManagedCode) {
		String sql = "select * from file_save where file_managed_code = ? order by update_date desc";

		return jdbcTemplate.query(sql, new RowMapper<FileSaveVO>() {
			@Override
			public FileSaveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileSaveVO vo = new FileSaveVO();
				vo.setFileCode(rs.getString("file_code"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setMemberNum(rs.getString("member_num"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setUploadDate(rs.getTimestamp("upload_date"));
				vo.setUpdateDate(rs.getTimestamp("update_date"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				vo.setFilePath(rs.getString("file_path"));
				return vo;
			}
		}, fileManagedCode);
	}

	// 개인 폴더 검색_파일 이름
	@Override
	public List<FileSaveVO> searchPersonalFileByFileName(String memberNum, String fileName) {
		String sql = "select * from file_save where (member_num = ? and file_managed_code='p') and file_name like ? order by update_date desc";

		return jdbcTemplate.query(sql, new RowMapper<FileSaveVO>() {
			@Override
			public FileSaveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileSaveVO vo = new FileSaveVO();
				vo.setFileCode(rs.getString("file_code"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setMemberNum(rs.getString("member_num"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setUploadDate(rs.getTimestamp("upload_date"));
				vo.setUpdateDate(rs.getTimestamp("update_date"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				vo.setFilePath(rs.getString("file_path"));
				return vo;
			}
		}, memberNum, "%" + fileName + "%");
	}

	// 공유 폴더 검색_파일 이름
	@Override
	public List<FileSaveVO> searchShareFileByFileName(String fileManagedCode, String fileName) {
		String sql = "select * from file_save where file_managed_code = ? and file_name like ? order by update_date desc";

		return jdbcTemplate.query(sql, new RowMapper<FileSaveVO>() {
			@Override
			public FileSaveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileSaveVO vo = new FileSaveVO();
				vo.setFileCode(rs.getString("file_code"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setMemberNum(rs.getString("member_num"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setUploadDate(rs.getTimestamp("upload_date"));
				vo.setUpdateDate(rs.getTimestamp("update_date"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				vo.setFilePath(rs.getString("file_path"));
				return vo;
			}
		}, fileManagedCode, "%" + fileName + "%");
	}

	// 개인 폴더에서 공유 폴더로 이동하기 위한 파일 선택
	@Override
	public FileSaveVO getSelectFile(String fileCode) {
		String sql = "select * from file_save where file_code = ?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<FileSaveVO>() {
			@Override
			public FileSaveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileSaveVO vo = new FileSaveVO();
				vo.setFileCode(rs.getString("file_code"));
				vo.setFileManagedCode(rs.getString("file_managed_code"));
				vo.setMemberNum(rs.getString("member_num"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFileContent(rs.getBytes("file_content"));
				vo.setFileExplanation(rs.getString("file_explanation"));
				vo.setUploadDate(rs.getTimestamp("upload_date"));
				vo.setUpdateDate(rs.getTimestamp("update_date"));
				vo.setDeleteTF(rs.getString("delete_tf"));
				vo.setFilePath(rs.getString("file_path"));
				return vo;
			}
		}, fileCode);
	}

	// 개인 폴더에서 파일 삭제
	@Override
	public void deletePersonalFile(String fileCode) {
		String sql = "delete from file_save where file_code = ?";
		
		jdbcTemplate.update(sql,fileCode);
	}
}

