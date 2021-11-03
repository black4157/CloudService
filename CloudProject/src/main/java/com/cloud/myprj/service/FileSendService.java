package com.cloud.myprj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.SendVO;
import com.cloud.myprj.repository.IFileSendRepository;

@Service
public class FileSendService implements IFileSendService {

	@Autowired
	IFileSendRepository fileSendRepository;
	
	@Override
	public int getMaxSendnum() {
		return 0;
	}
	
	@Override
	public void uploadSend(SendVO vo) {
		vo.setSendNum(fileSendRepository.getMaxSendnum()+1);
		fileSendRepository.uploadSend(vo);

	}

	@Override
	public List<Map<String, Object>> userList() {
		return fileSendRepository.userList();
	}

	@Override
	public List<Map<String, Object>> receivedMail(String recipient) {
		return fileSendRepository.receivedMail(recipient);
	}

	@Override
	public Object viewMail(int sendNum) {
		return fileSendRepository.viewMail(sendNum);
	}
	
}
