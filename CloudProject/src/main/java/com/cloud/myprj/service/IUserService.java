package com.cloud.myprj.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cloud.myprj.member.MemberVO;

public interface IUserService {
	// 로그인
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	// memberNum 가져오기
	public void memberSignUp(MemberVO memberVO) throws Exception;
	
	// 멤버 정보 수정
	public void memberUpdate(MemberVO memberVO, String memberNum) throws Exception;
	
	// Admin이 회원 삭제
	public void memberDelete(MemberVO memberVO, String memberNum) throws Exception;
	
	// memberList 가져오기
	public List<MemberVO> getMemberList() throws Exception;
	
	// memberInfo
	public MemberVO getMemberInfo(String memberNum) throws Exception;

	// 세션이 있는지 (로그인 되었는지) 확인
	public int logincheck(HttpServletRequest req);

}
