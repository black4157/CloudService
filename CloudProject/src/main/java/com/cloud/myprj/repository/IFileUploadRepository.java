package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.FileSaveVO;

public interface IFileUploadRepository {
	
	String getFileCode();
	void uploadFile(FileSaveVO file);
}
