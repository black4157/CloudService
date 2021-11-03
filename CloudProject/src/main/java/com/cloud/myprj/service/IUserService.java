package com.cloud.myprj.service;

import java.util.List;

import com.cloud.myprj.member.MemberVO;

public interface IUserService {
	// 로그인
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	// memberNum 가져오기
	public void memberSignUp(MemberVO memberVO) throws Exception;
	
	// 멤버 정보 수정
	public void memberUpdate(MemberVO memberVO) throws Exception;
	
	// Admin이 회원 삭제
	public void memberDelete(MemberVO memberVO) throws Exception;
	
	// memberList 가져오기
	public List<MemberVO> getMemberList() throws Exception;
}
