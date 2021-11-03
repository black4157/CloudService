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
	
	@Autowired
	IUserService userService;
	
	public int logincheck(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberVO") != null) {
			return 1;
		}
		else return 0;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpServletRequest req, RedirectAttributes rttr) {
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
				
				return "member/memberhome";
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
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest req) {
		try {
			if(logincheck(req) == 1) {
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

	@RequestMapping(value="/list")
	public String list(HttpServletRequest req, MemberVO memberVO, Model model) {
		List<MemberVO> memberList;

		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals("S0001")) {
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
	
	@RequestMapping(value="/info/{memberNum}")
	public String info(HttpServletRequest req, @PathVariable String memberNum, Model model, MemberVO memberVO) {
		
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals("S0001")) {
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
	
	@RequestMapping(value="/adminhome")
	public String adminhome(HttpServletRequest req, MemberVO memberVO) {
		HttpSession session = req.getSession();
		memberVO = (MemberVO)session.getAttribute("memberVO");
		if(session.getAttribute("memberNum").equals("S0001")) {
			return "admin/adminhome";
		}
		else {
			return "member/memberhome";
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("memberNum").equals("S0001")) {
			return "admin/insertform";
		}
		else {
			return "member/memberhome";
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(MemberVO memberVO) {
		try {
			userService.memberSignUp(memberVO);
			return "admin/adminhome";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "admin/adminhome";
		}
		
	}
	
	@RequestMapping(value="/update/{memberNum}", method=RequestMethod.GET)
	public String update(HttpServletRequest req, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals("S0001")) {
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
	
	@RequestMapping(value="/delete/{memberNum}", method=RequestMethod.GET)
	public String delete(HttpServletRequest req, @PathVariable String memberNum, MemberVO memberVO, Model model) {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute("memberNum").equals("S0001")) {
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










