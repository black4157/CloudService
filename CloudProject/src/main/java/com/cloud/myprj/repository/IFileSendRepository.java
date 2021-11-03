package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.member.SendVO;

public interface IFileSendRepository {

	//파일 전송
	void uploadSend(SendVO vo);
//	
//	//파일 목록
//	List<FileSaveVO> fileList(String memberNum);
}
