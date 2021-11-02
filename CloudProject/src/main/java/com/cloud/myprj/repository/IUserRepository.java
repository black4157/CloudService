package com.cloud.myprj.repository;

import com.cloud.myprj.member.MemberVO;


public interface IUserRepository {
	public void memberRegister(MemberVO memberVO) throws Exception;
	public MemberVO memberlogin(MemberVO memberVO) throws Exception;
	public void memberUpdate(MemberVO memberVO) throws Exception;
	public void memberDelete(MemberVO memberVO) throws Exception;
	public int memberIdChk(MemberVO memberVO) throws Exception;
	
	
	//관리자가 수정할 회원 가져오기
	public MemberVO getByUserId(String memberNum) throws Exception;

	
}
