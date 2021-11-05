package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.FileSaveVO;

public interface IFileUploadRepository {

	// file_code 가져오기
	String getFileCode();

	// 멤버넘버 가져오기
	String getMemeberNum();

	// 개인 파일 업로드
	void uploadFile(FileSaveVO file);

	// 데이터 서버에 있는 파일 가져오기 (개인 폴더)
	List<FileSaveVO> getPersonalFileList(String memberNum);

	// 개인 폴더에서 공유 폴더로 이동하기 위한 파일 선택
	FileSaveVO getSelectFile(String fileCode);

	// 공유 서버에 있는 파일 가져오기
	List<FileSaveVO> getShareFileList(String fileManagedCode);
	
	// 개인 폴더에 파일 삭제하기
	void deletePersonalFile(String fileCode);
	
	// 개인 폴더 검색_파일 이름
	List<FileSaveVO> searchPersonalFileByFileName(String memberNum, String fileName);
	
	// 공유 폴더 검색_파일 이름
	List<FileSaveVO> searchShareFileByFileName(String fileManagedCode, String fileName);
}
