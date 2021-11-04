package com.cloud.myprj.service;

import java.util.List;
import java.util.Map;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.SendVO;

public interface IFileSendService {
	int getMaxSendnum();
	
	void uploadSend(SendVO vo);

	List<Map<String, Object>> userList();
	
	List<JoinVO> receivedMail(String recipient);
	
	JoinVO viewMail(int sendNum);
	
	void readCheck(int sendNum);
	
	void delete(int sendNum);
}
