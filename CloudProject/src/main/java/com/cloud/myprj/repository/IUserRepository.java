package com.cloud.myprj.repository;

import java.util.List;

import com.cloud.myprj.member.MemberVO;


public interface IUserRepository {
	// Admin이 회원가입
	public void memberRegister(MemberVO memberVO) throws Exception;
	
	// 로그인
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	// Admin이 회원 수정
	public void memberUpdate(MemberVO memberVO, String memberNum) throws Exception;
	
	// Admin이 회원 삭제
	public void memberDelete(String retire, String memberNum) throws Exception;
	
	// memberNum +1씩 증가
	public String getMemberNum() throws Exception;
	
	// memeber list 가져오기
	public List<MemberVO> getMemberList() throws Exception;
	
	// memberInfo 회원상세정보 조회
	public MemberVO getMemberInfo(String memberNum) throws Exception;
	
	// 사원 검색_이름
	public List<MemberVO> searchMemberName(String memberName) throws Exception;
	
}
