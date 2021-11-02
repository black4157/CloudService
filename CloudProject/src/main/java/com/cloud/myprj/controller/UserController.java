package com.cloud.myprj.controller;

import javax.servlet.http.HttpServletRequest;
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
			memberVO = userService.memberlogin(memberVO);
			HttpSession session = req.getSession();

			if(memberVO.getName() != null) {
				model.addAttribute("memberVO", memberVO);
				session.setAttribute("memberVO", memberVO);
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
	
}
