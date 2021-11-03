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

	@Override
	public void uploadFile(FileSaveVO file) {
		file.setFileCode(fileUploadRepository.getFileCode());
		fileUploadRepository.uploadFile(file);
	}

	@Override
	public List<FileSaveVO> getPersonalFileList(String memberNum) {
		return fileUploadRepository.getPersonalFileList(memberNum);
	}

	@Override
	public FileSaveVO getSelectFile(String fileCode) {
		return fileUploadRepository.getSelectFile(fileCode);
	}

	@Override
	public List<FileSaveVO> getShareFileList(String fileManagedCode) {
		return fileUploadRepository.getShareFileList(fileManagedCode);
	}

}