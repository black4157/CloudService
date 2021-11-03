package com.cloud.myprj.service;

import java.util.List;
import java.util.Map;

import com.cloud.myprj.member.SendVO;

public interface IFileSendService {
	int getMaxSendnum();
	
	void uploadSend(SendVO vo);

	List<Map<String, Object>> userList();
	
	List<Map<String, Object>> receivedMail(String recipient);
	
	Object viewMail(int sendNum);
}
