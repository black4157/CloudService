package com.cloud.myprj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.member.SendVO;
import com.cloud.myprj.service.IFileSendService;
import com.cloud.myprj.service.IFileUploadService;

@Controller
public class SendController {

	static final Logger logger = LoggerFactory.getLogger(SendController.class);
	
	@Autowired
	IFileSendService fileSendService;
	
	@Autowired
	IFileUploadService fileUploadService;
	
	@RequestMapping(value="/send")
	public String send(Model model) {
		model.addAttribute("fileList", fileUploadService.getPersonalFileList("S0000"));

		return "send/write";
	}
	
	@RequestMapping(value="/send/write", method=RequestMethod.POST)
	public String write(SendVO sendVO /*http세션으로 membernum받기*/) {
		
		fileSendService.uploadSend(sendVO);
		
		return "send/list";
	}
}
