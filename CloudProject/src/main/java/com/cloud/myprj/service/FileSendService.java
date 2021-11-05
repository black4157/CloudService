package com.cloud.myprj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.SendVO;
import com.cloud.myprj.repository.IFileSendRepository;

@Service
public class FileSendService implements IFileSendService {

	@Autowired
	IFileSendRepository fileSendRepository;
	
	// sendNum + 1
	@Override
	public int getMaxSendnum() {
		return 0;
	}
	
	// 파일 전송
	@Override
	public void uploadSend(SendVO vo) {
		vo.setSendNum(fileSendRepository.getMaxSendnum()+1);
		fileSendRepository.uploadSend(vo);

	}

	// 메일 검색_제목
	@Override
	public List<JoinVO> searchMailByTitle(String recipient, String sendTitle) {
		return fileSendRepository.searchMailByTitle(recipient, sendTitle);
	}

	// 메일 검색_내용
	@Override
	public List<JoinVO> searchMailByContent(String recipient, String sendContent) {
		return fileSendRepository.searchMailByContent(recipient, sendContent);
	}

	// 유저 목록 출력
	@Override
	public List<Map<String, Object>> userList() {
		return fileSendRepository.userList();
	}

	// 받은 메일함 조회
	@Override
	public List<JoinVO> receivedMail(String recipient) {
		return fileSendRepository.receivedMail(recipient);
	}

	// 메일 하나 상세 조회
	@Override
	public JoinVO viewMail(int sendNum) {
		return fileSendRepository.viewMail(sendNum);
	}

	// 읽음 확인
	@Override
	public void readCheck(int sendNum) {
		fileSendRepository.readCheck(sendNum);
	}

	// 메일 삭제
	@Override
	public void delete(int sendNum) {
		fileSendRepository.delete(sendNum);
	}
	
	
}
