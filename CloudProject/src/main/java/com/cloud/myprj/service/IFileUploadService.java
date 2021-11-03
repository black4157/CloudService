package com.cloud.myprj.service;

import java.util.HashMap;
import java.util.List;

import com.cloud.myprj.member.FileSaveVO;

public interface IFileUploadService {
	void uploadFile(FileSaveVO file);
	
	void uploadShareFile(List<String> fileCodes);
	
	List<FileSaveVO> getPersonalFileList(String memberNum);
	
	// 개인폴더에서 공유폴더로 이동하기위한 파일 선택
	FileSaveVO getSelectFile(String fileCode);
	
	// 공유 서버에 있는 파일 가져오기
	List<FileSaveVO> getShareFileList(String fileManagedCode);
	
	// 개인폴더에 파일 삭제하기
	void deletePersonalFile(String fileCode);
	
//	List<FileSaveVO> getSelectFileGroup(HashMap<String, Object> map);
}	
