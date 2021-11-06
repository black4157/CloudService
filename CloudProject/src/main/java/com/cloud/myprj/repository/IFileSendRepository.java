package com.cloud.myprj.repository;

import java.util.List;
import java.util.Map;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.SendVO;

public interface IFileSendRepository {

	// sendNum + 1
	int getMaxSendnum();
	
	// 파일 전송
	void uploadSend(SendVO vo);

	// 유저목록
	List<Map<String, Object>> userList();
	
	// 받은 메일함
	List<JoinVO> receivedMail(String recipient);
	
	// 메일 확인
	JoinVO viewMail(int sendNum);
	
	// 읽음 확인
	void readCheck(int sendNum);
	
	// 메일 삭제
	void delete(int sendNum);
	
	// 받은 메일함 검색_제목
	List<JoinVO> searchMailByTitle(String recipient, String sendTitle);
	
	// 받은 메일함 검색_내용
	List<JoinVO> searchMailByContent(String recipient, String sendContent);
	
	int getNotRead(String recipient);
}
