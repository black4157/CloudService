package com.cloud.myprj.repository;

import java.util.HashMap;
import java.util.List;

import com.cloud.myprj.member.FileSaveVO;

public interface IFileUploadRepository {
	
	String getFileCode();
	void uploadFile(FileSaveVO file);
	
	List<FileSaveVO> getFileList(String directoryName);

	FileSaveVO getFile(String fileCode);
	
	String getFilePath(String fileCode);
	void updatePath(HashMap<String, Object>map);
	
	void updateFile(FileSaveVO file);
	
}
