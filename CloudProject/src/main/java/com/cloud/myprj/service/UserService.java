package com.cloud.myprj.service;

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
		
		return userRepository.memberlogin(memberVO);
	}

	@Override
	public void memberSignUp(MemberVO memberVO) throws Exception {
		memberVO.setMemberNum(userRepository.getMemberNum());
		userRepository.memberRegister(memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		userRepository.memberUpdate(memberVO);	
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		userRepository.memberDelete(memberVO);
	}
	
	
}
