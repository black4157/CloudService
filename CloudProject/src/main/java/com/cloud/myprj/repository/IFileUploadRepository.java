package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.FileSaveVO;

public interface IFileUploadRepository {

	// file_code 가져오기
	String getFileCode();

	// 멤버넘버 가져오기
	String getMemeberNum();

	// 파일 가져오기
	void uploadFile(FileSaveVO file);

	// 데이터 서버에 있는 파일 가져오기
	List<FileSaveVO> getPersonalFileList(String memberNum);

	// 개인폴더에서 공유폴더로 이동하기위한 파일 선택
	FileSaveVO getSelectFile(String fileCode);

	// 공유 서버에 있는 파일 가져오기
	List<FileSaveVO> getShareFileList(String fileManagedCode);
}
