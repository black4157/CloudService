package com.cloud.myprj.repository;

import java.util.HashMap;
import java.util.List;

import org.omg.PortableServer.ServantLocatorPOA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cloud.myprj.member.FileSaveVO;

@Repository
public class FileUploadRepository implements IFileUploadRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void uploadFile(FileSaveVO file) {
		String sql = "insert into file_save(file_code, " + "file_managed_code, " + "member_num, " + "file_name, "
				+ "file_content, " + "file_explanation, " + "file_path" + ") + values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, file.getFileCode(), file.getFileManagedCode(), file.getMemberNum(), file.getFileName(),
				file.getFileContent(), file.getFileExplanation(), file.getFilePath());
	}

	@Override
	public String getFileCode() {
		String sql = "select nvl(max(SUBSTR(file_id,length(file_id)-9,length(file_id))),0) as file_code"
				+ " from upload_file";
		int intResult = jdbcTemplate.queryForObject(sql, Integer.class);
		String strResult = String.format("%09d", intResult);
		return "S" + strResult;
	}

	@Override
	public FileSaveVO getFile(String fileCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileSaveVO> getFileList(String directoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilePath(String fileCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFile(FileSaveVO file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePath(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

	}

	public FileUploadRepository() {
		// TODO Auto-generated constructor stub
	}
}
