package com.cloud.myprj.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return userRepository.memberLogin(memberVO);
	}

	// memberNum + 1 , 사원 추가_admin
	@Override
	public void memberSignUp(MemberVO memberVO) throws Exception {
		memberVO.setMemberNum(userRepository.getMemberNum());
		userRepository.memberRegister(memberVO);
	}

	// 사원 정보 수정_admin
	@Override
	public void memberUpdate(MemberVO memberVO, String memberNum) throws Exception {
		userRepository.memberUpdate(memberVO, memberNum);	
	}

	// 사원 정보 삭제(T로 세팅)_admin
	@Override
	public void memberDelete(String retire, String memberNum) throws Exception {
		userRepository.memberDelete(retire, memberNum);
	}
	
	// 전체 사원 조회
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return userRepository.getMemberList();
	}

	// 사원 정보 상세 조회
	@Override
	public MemberVO getMemberInfo(String memberNum) throws Exception {
		return userRepository.getMemberInfo(memberNum);
	}
	
	// 검색_사원 이름
	@Override
	public List<MemberVO> searchMemberName(String memberName) throws Exception {
		return userRepository.searchMemberName(memberName);
	}

	// 로그인 했는지 check
	@Override
	public int logincheck(HttpSession session) {
		if(session.getAttribute("memberVO") != null) {
			return 1;
		}
		else return 0;
	}

}
