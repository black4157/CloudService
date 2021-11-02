package com.cloud.myprj.service;

import com.cloud.myprj.member.MemberVO;

public interface IUserService {
	public MemberVO memberlogin(MemberVO memberVO) throws Exception;
}
