package com.cloud.myprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.service.IUserService;

@Controller
public class UserController {
	static final String admin="S0001";
	
	@Autowired
	IUserService userService;
	
	// 홈
	@RequestMapping(value="/home")
	public String home(HttpSession session) {
		if(userService.logincheck(session) == 1){
			return "redirect:/positioncheck";
		}
		else return "member/login";
	}

	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpSession session, RedirectAttributes attr) {
		String msg = "로그인에 실패하였습니다.";
		try {
			memberVO = userService.memberLogin(memberVO);
			if(memberVO.getName() != null) {
				model.addAttribute("memberVO", memberVO);
				session.setAttribute("memberVO", memberVO);
				session.setAttribute("memberNum", memberVO.getMemberNum());
				return "redirect:/positioncheck";
			}
			else {
				session.setAttribute("memberVO", null);
				attr.addFlashAttribute("msg", msg);
				return "redirect:/home";
			}
		}
		catch(Exception e) {
			attr.addFlashAttribute("msg", msg);
			return "redirect:/home";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		try {
			if(userService.logincheck(session) == 1) {
				session.invalidate();
				return "redirect:/home";
			}
			else return "redirect:/home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "redirect:/home";
		}
	}
	
	// 사원, 관리자 계정 체크 후 홈페이지 구분
	@RequestMapping(value="/positioncheck")
	public String positionCheck(HttpSession session) {
		if(session.getAttribute("memberNum").equals(admin)) {
			return "redirect:/adminhome";
		}
		else return "redirect:/memberhome";
	}
	
	// 멤버 홈페이지로 이동
	@RequestMapping(value="/memberhome")
	public String memberHome(HttpSession session) {
		if(userService.logincheck(session) == 1) {
			return "member/memberhome";
		}
		else return "redirect:/home";
	}
	
	// 관리자 홈페이지로 이동
	@RequestMapping(value="/adminhome")
	public String adminHome(HttpSession session, MemberVO memberVO, Model model) {
		memberVO = (MemberVO)session.getAttribute("memberVO");
		if(session.getAttribute("memberNum").equals(admin)) {
			model.addAttribute("memberVO", memberVO);
			return "admin/adminhome";
		}
		else {
			return "redirect:/home";
		}
	}
	
	// 사원 검색
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String searchList(String name, HttpSession session, Model model) {
		
		try {
			if(session.getAttribute("memberNum").equals(admin)) {
				List<MemberVO> memberList;
				memberList = userService.searchMemberName(name);
				
				model.addAttribute("memberList", memberList);
				return "admin/list";
			}
			else return "redirect:/home";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/home";
		}
	}

	// 전체 사원 조회 리스트
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpSession session, MemberVO memberVO, Model model) {
		List<MemberVO> memberList;
		try {
			if(session.getAttribute("memberNum").equals(admin)) {
				memberList = userService.getMemberList();
				model.addAttribute("memberList", memberList);
				return "admin/list";
			}
			else {
				return "redirect:/home";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/home";
		}
	}
	
	// 사원 상세 정보 조회
	@RequestMapping(value="/info/{memberNum}")
	public String info(HttpSession session, @PathVariable String memberNum, Model model, MemberVO memberVO) {
		
		try {
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/info";
			}else {
				return "redirect:/home";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			return "redirect:/home";
		}
		
	}
	
	// 사원 추가_Get
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(HttpSession session) {
		if(session.getAttribute("memberNum").equals(admin)) {
			return "admin/insertform";
		}
		else {
			return "redirect:/home";
		}
	}

	// 사원 추가_Post
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(MemberVO memberVO) {
		try {
			userService.memberSignUp(memberVO);
			return "redirect:/adminhome";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/adminhome";
		}
		
	}
	
	// 사원 정보 수정_Get
	@RequestMapping(value="/update/{memberNum}", method=RequestMethod.GET)
	public String update(HttpSession session, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/updateform";
			}
			else {
				return "redirect:/home";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/home";
		}
	} 

	// 사원 정보 수정_Post
	@RequestMapping(value="/update/{memberNum}", method=RequestMethod.POST)
	public String update(MemberVO memberVO, @PathVariable String memberNum) {
		try {
			userService.memberUpdate(memberVO, memberNum);
			return "redirect:/list";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/updateform";
		}
		
	}
	
	// 사원 삭제(T로 세팅)_Get
	@RequestMapping(value="/delete/{memberNum}", method=RequestMethod.GET)
	public String delete(HttpSession session, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/deleteform";
			}
			else {
				return "redirect:/home";
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "redirect:/home";
		}

	}
	
	// 사원 삭제(T로 세팅)_Post
	@RequestMapping(value="/delete/{memberNum}", method=RequestMethod.POST)
	public String delete(MemberVO memberVO, @PathVariable String memberNum) {
		try {
			userService.memberDelete(memberVO, memberNum);
			return "redirect:/list";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/deleteform";
		}
	}
}
