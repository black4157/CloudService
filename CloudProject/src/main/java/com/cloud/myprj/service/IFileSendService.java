package com.cloud.myprj.service;

import java.util.List;
import java.util.Map;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.SendVO;

public interface IFileSendService {
	// sendNum + 1
	int getMaxSendnum();
	
	// 파일 전송
	void uploadSend(SendVO vo);

	// 유저 목록 조회
	List<Map<String, Object>> userList();
	
	// 받은 메일함 조회
	List<JoinVO> receivedMail(String recipient);
	
	// 메일 하나 상세 조회
	JoinVO viewMail(int sendNum);
	
	// 읽음 확인
	void readCheck(int sendNum);
	
	// 메일 삭제
	void delete(int sendNum);
	
	// 받은 메일함 검색_제목
	List<JoinVO> searchMailByTitle(String recipient, String sendTitle);
	
	// 받은 메일함 검색_내용
	List<JoinVO> searchMailByContent(String recipient, String sendContent);
}
