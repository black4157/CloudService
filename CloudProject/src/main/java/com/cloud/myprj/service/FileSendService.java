package com.cloud.myprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.SendVO;
import com.cloud.myprj.repository.IFileSendRepository;

@Service
public class FileSendService implements IFileSendService {

	@Autowired
	IFileSendRepository fileSendRepository;
	
	@Override
	public void uploadSend(SendVO vo) {
		fileSendRepository.uploadSend(vo);

	}
}
