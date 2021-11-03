package com.cloud.myprj.repository;

import com.cloud.myprj.member.MemberVO;


public interface IUserRepository {
	// Admin이 회원가입
	public void memberRegister(MemberVO memberVO) throws Exception;
	
	// 로그인
	public MemberVO memberlogin(MemberVO memberVO) throws Exception;
	
	// Admin이 회원 수정
	public void memberUpdate(MemberVO memberVO) throws Exception;
	
	// Admin이 회원 삭제
	public void memberDelete(MemberVO memberVO) throws Exception;
	
	//관리자가 수정할 회원 가져오기
	public MemberVO getByUserId(String memberNum) throws Exception;

	// memberNum 가져오기
	public String getMemberNum() throws Exception;
	
}
