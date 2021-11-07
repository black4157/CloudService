package com.cloud.myprj.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.myprj.member.JoinVO;
import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.member.SendVO;
import com.cloud.myprj.service.IFileSendService;
import com.cloud.myprj.service.IFileUploadService;
import com.cloud.myprj.service.IUserService;

@Controller
public class SendController {

	static final Logger logger = LoggerFactory.getLogger(SendController.class);

	@Autowired
	IFileSendService fileSendService;

	@Autowired
	IFileUploadService fileUploadService;
	
	@Autowired
	IUserService userService;

	// 파일 전송_Get
	@RequestMapping(value = "/send/write")
	public String send(Model model, HttpSession session, MemberVO memberVO) {
		if(userService.logincheck(session) == 1) {
	
			memberVO = (MemberVO) session.getAttribute("memberVO");
			model.addAttribute("memberVO", memberVO);
			model.addAttribute("userList", fileSendService.userList());
			model.addAttribute("fileList", fileUploadService.getPersonalFileList(memberVO.getMemberNum()));
	
			return "send/write";
		}
		else return "redirect:/home";
	}

	// 파일 전송_Post
	@RequestMapping(value = "/send/write", method = RequestMethod.POST)
	public String write(@RequestParam String sendContent, SendVO sendVO) {
		String msg = "";
		try {
			
			sendContent = sendContent.replace("\r\n", "<br>");
			sendVO.setSendContent(sendContent);
			
			fileSendService.uploadSend(sendVO);
			msg = "전송이 완료되었습니다.";
		} catch (Exception e) {
			msg = "전송을 실패했습니다.";
		}

		return "redirect:/send/list";
	}
	
	// 받은 메일함 리스트 출력
	@RequestMapping(value = "/send/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session, MemberVO memberVO) {
		if(userService.logincheck(session) == 1) {
			memberVO = (MemberVO) session.getAttribute("memberVO");
			model.addAttribute("memberVO", memberVO);
	
			model.addAttribute("recivedMail", fileSendService.receivedMail(memberVO.getMemberNum()));
			
			return "send/list";
		}
		else return "redirect:/home";
	}
	
	// 메일 검색(제목, 내용)
	@RequestMapping(value = "/send/list", method = RequestMethod.POST)
	public String searchMailByTitle(String sendTitle, String sendContent, Model model, HttpSession session, MemberVO memberVO) {
		if(userService.logincheck(session) == 1) {
			memberVO = (MemberVO) session.getAttribute("memberVO");
			model.addAttribute("memberVO", memberVO);
			if(sendContent == null) {
				model.addAttribute("recivedMail", fileSendService.searchMailByTitle(memberVO.getMemberNum(), sendTitle));
			}
			else if(sendTitle == null){
				model.addAttribute("recivedMail", fileSendService.searchMailByContent(memberVO.getMemberNum(), sendContent));
			}
			else if(sendContent == "") {
				model.addAttribute("recivedMail", fileSendService.searchMailByContent(memberVO.getMemberNum(), " "));
			}
			return "send/list";
		}
		else return "redirect:/home";
	}

	// 메일 하나 상세 조회
	@RequestMapping(value = "/send/view/{sendNum}", method = RequestMethod.GET)
	public String view(@PathVariable int sendNum, Model model, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			model.addAttribute("viewMail", fileSendService.viewMail(sendNum));
			fileSendService.readCheck(sendNum);
			if((Integer) session.getAttribute("notRead") <= 0) {
				session.setAttribute("notRead", 0);
			} else {
				session.setAttribute("notRead", (Integer) session.getAttribute("notRead") - 1);
			}
			
			return "send/view";
		}
		else return "redirect:/home";
	}

	// 받은 파일 다운로드
	@RequestMapping(value = "/send/view/download/{sendNum}")
	public ResponseEntity<byte[]> viewMailDownload(@PathVariable int sendNum, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			JoinVO vo = fileSendService.viewMail(sendNum);
			final HttpHeaders headers = new HttpHeaders();
			if (vo != null) {
				headers.setContentDispositionFormData("attachment", vo.getFileName(), Charset.forName("UTF-8"));
				return new ResponseEntity<byte[]>(vo.getFileContent(), headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}
		}
		else return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	}
	
	// 받은 메일 삭제
	@RequestMapping(value="/send/delete/{sendNum}")
	public String mailDelete(@PathVariable int sendNum, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			fileSendService.delete(sendNum);
			return "redirect:/send/list";
		}
		else return "redirect:/home";
	}

}
