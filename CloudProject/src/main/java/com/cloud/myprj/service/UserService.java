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
	public MemberVO memberlogin(MemberVO memberVO) throws Exception {
		
		return userRepository.memberlogin(memberVO);
	}

}
