package com.cloud.myprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpServletRequest req) {
		try {
			memberVO = userService.memberLogin(memberVO);
			HttpSession session = req.getSession();

			if(memberVO.getName() != null) {
				model.addAttribute("memberVO", memberVO);
				session.setAttribute("memberVO", memberVO);
				session.setAttribute("memberNum", memberVO.getMemberNum());
				
//				session.setAttribute("pwd", memberVO.getPwd());
//				session.setAttribute("name", memberVO.getName());
//				session.setAttribute("phone", memberVO.getPhone());
//				session.setAttribute("position", memberVO.getPosition());
//				session.setAttribute("department", memberVO.getDepartment());
//				session.setAttribute("memberAuth", memberVO.getMemberAuth());
				
				return "redirect:/positioncheck";
			}
			else {
				session.setAttribute("memberVO", null);
				return "home";
			}
		}
		catch(Exception e) {
			return "home";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest req) {
		try {
			if(userService.logincheck(req) == 1) {
				session.invalidate();
				return "home";
			}
			else return "member/logoutfail";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "member/logoutfail";
		}
	}
	
	// 사원, 관리자 계정 체크 후 홈페이지 구분
	@RequestMapping(value="/positioncheck")
	public String positioncheck(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals(admin)) {
			return "redirect:/adminhome";
		}
		else return "redirect:/memberhome";
	}
	
	// 멤버 홈페이지로 이동
	@RequestMapping(value="/memberhome")
	public String memberhome(HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			return "member/memberhome";
		}
		else return "home";
	}
	
	// 관리자 홈페이지로 이동
	@RequestMapping(value="/adminhome")
	public String adminhome(HttpServletRequest req, MemberVO memberVO, Model model) {
		HttpSession session = req.getSession();
		memberVO = (MemberVO)session.getAttribute("memberVO");
		if(session.getAttribute("memberNum").equals(admin)) {
			model.addAttribute("memberVO", memberVO);
			return "admin/adminhome";
		}
		else {
			return "member/memberhome";
		}
	}

	// 전체 사원 조회 리스트
	@RequestMapping(value="/list")
	public String list(HttpServletRequest req, MemberVO memberVO, Model model) {
		List<MemberVO> memberList;
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals(admin)) {
				memberList = userService.getMemberList();
				model.addAttribute("memberList", memberList);
				return "admin/list";
			}
			else {
				return "admin/adminhome";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/adminhome";
		}
	}
	
	// 사원 상세 정보 조회
	@RequestMapping(value="/info/{memberNum}")
	public String info(HttpServletRequest req, @PathVariable String memberNum, Model model, MemberVO memberVO) {
		
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/info";
			}else {
				return "admin/list";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			return "admin/list";
		}
		
	}
	
	// 사원 추가_Get
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals(admin)) {
			return "admin/insertform";
		}
		else {
			return "member/memberhome";
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
	public String update(HttpServletRequest req, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/updateform";
			}
			else {
				return "member/memberhome";
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "member/memberhome";
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
	public String delete(HttpServletRequest req, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals(admin)) {
				memberVO = userService.getMemberInfo(memberNum);
				model.addAttribute("memberVO", memberVO);
				return "admin/deleteform";
			}
			else {
				return "member/memberhome";
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "member/memberhome";
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
