package com.cloud.myprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpServletRequest req, RedirectAttributes rttr) {
		try {
			memberVO = userService.memberLogin(memberVO);
			HttpSession session = req.getSession();

			if(memberVO.getName() != null) {
				model.addAttribute("memberVO", memberVO);
				session.setAttribute("memberVO", memberVO);
				
				session.setAttribute("memberNum", memberVO.getMemberNum());
				session.setAttribute("pwd", memberVO.getPwd());
				session.setAttribute("name", memberVO.getName());
				session.setAttribute("phone", memberVO.getPhone());
				session.setAttribute("position", memberVO.getPosition());
				session.setAttribute("department", memberVO.getDepartment());
				session.setAttribute("memberAuth", memberVO.getMemberAuth());
				
				return "member/loginsuccess";
			}
			else {
				session.setAttribute("memberVO", null);
				return "member/loginfail";
			}
		}
		catch(Exception e) {
			return "member/loginfail";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		try {
			session.invalidate();
			return "member/logout";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "member/logoutfail";
		}

	}
	
	@RequestMapping(value="/list")
	public String list() {
		return "member/list";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			return "admin/insertform";
		}
		else {
			return "home";
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(MemberVO memberVO) {
		try {
			userService.memberSignUp(memberVO);
			return "admin/adminhome";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/insertform";
		}
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			return "admin/updateform";
		}
		else {
			return "home";
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(MemberVO memberVO) {
		try {
			userService.memberUpdate(memberVO);
			return "admin/adminhome";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/updateform";
		}
		
	}
	
}










