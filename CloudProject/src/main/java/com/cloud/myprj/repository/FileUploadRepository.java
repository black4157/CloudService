package com.cloud.myprj.repository;

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
		String sql="insert into file_save(file_code, " + 
				"file_managed_code, " + 
				"member_num, " + 
				"file_name, " + 
				"file_content, " + 
				"file_explanation, " + 
				"file_path" + 
				") + values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, file.getFileCode(), file.getFileManagedCode(),
				file.getMemberNum(),file.getFileName(),
				file.getFileContent(), file.getFileExplanation(),
				file.getFilePath());
	}

	@Override
	public String getFileCode() {
		String sql = "select nvl(max(SUBSTR(file_id,length(file_id)-9,length(file_id))),0) as file_code"
		+ " from upload_file";
		int intResult = jdbcTemplate.queryForObject(sql, Integer.class);
		String strResult= String.format("%09d", intResult);
		return "S" + strResult;
	}

}
