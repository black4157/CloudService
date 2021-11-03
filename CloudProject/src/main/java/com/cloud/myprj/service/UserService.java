package com.cloud.myprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		return userRepository.memberLogin(memberVO);
	}

	@Override
	public void memberSignUp(MemberVO memberVO) throws Exception {
		memberVO.setMemberNum(userRepository.getMemberNum());
		userRepository.memberRegister(memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO, String memberNum) throws Exception {
		userRepository.memberUpdate(memberVO, memberNum);	
	}

	@Override
	public void memberDelete(MemberVO memberVO, String memberNum) throws Exception {
		userRepository.memberDelete(memberVO, memberNum);
	}
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return userRepository.getMemberList();
	}

	@Override
	public MemberVO getMemberInfo(String memberNum) throws Exception {
		return userRepository.getMemberInfo(memberNum);
	}
	
}
