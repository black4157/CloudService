package com.cloud.myprj.repository;

import java.util.List;
import java.util.Map;

import com.cloud.myprj.member.SendVO;

public interface IFileSendRepository {

	//sendNum + 1
	int getMaxSendnum();
	
	//파일 전송
	void uploadSend(SendVO vo);

	//유저목록
	List<Map<String, Object>> userList();
	
	//받은 메일함
	List<Map<String, Object>> receivedMail(String recipient);
	
	//메일 확인
	Object viewMail(int sendNum);
}
