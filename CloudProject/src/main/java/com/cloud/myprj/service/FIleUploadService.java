package com.cloud.myprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.repository.IFileUploadRepository;

@Service
public class FIleUploadService implements IFileUploadService {

	@Autowired
	IFileUploadRepository fileUploadRepository;

	// 파일 업로드(개인 폴더)
	@Override
	public void uploadFile(FileSaveVO file) {
		file.setFileCode(fileUploadRepository.getFileCode());
		fileUploadRepository.uploadFile(file);
	}

	// 개인 폴더 리스트 조회
	@Override
	public List<FileSaveVO> getPersonalFileList(String memberNum) {
		return fileUploadRepository.getPersonalFileList(memberNum);
	}

	// 파일 선택
	@Override
	public FileSaveVO getSelectFile(String fileCode) {
		return fileUploadRepository.getSelectFile(fileCode);
	}

	// 공유 폴더 리스트 조회
	@Override
	public List<FileSaveVO> getShareFileList(String fileManagedCode) {
		return fileUploadRepository.getShareFileList(fileManagedCode);
	}

	// 개인 폴더에서 검색_파일 이름
	@Override
	public List<FileSaveVO> searchPersonalFileByFileName(String memberNum, String fileName) {
		return fileUploadRepository.searchPersonalFileByFileName(memberNum, fileName);
	}

	// 공유 폴더에서 검색_파일 이름
	@Override
	public List<FileSaveVO> searchShareFileByFileName(String fileManagedCode, String fileName) {
		return fileUploadRepository.searchShareFileByFileName(fileManagedCode, fileName);
	}

	// 개인 파일 삭제
	@Override
	public void deletePersonalFile(String fileCode) {
		fileUploadRepository.deletePersonalFile(fileCode);
	}

	// 공유 폴더로 옮기기
	@Override
	public void uploadShareFile(List<String> fileCodes) {
		for(String fileCode: fileCodes) {
			FileSaveVO vo = new FileSaveVO();
			vo = fileUploadRepository.getSelectFile(fileCode);
			vo.setFileManagedCode("s");
			uploadFile(vo);
		}
	}

}
