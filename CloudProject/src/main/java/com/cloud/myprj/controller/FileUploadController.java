package com.cloud.myprj.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.service.IFileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	IFileUploadService fileUploadService;

	static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@RequestMapping(value="/upload")
	public String mainPage() {
		logger.info("홈 ~안녕");
		return "upload/uploadhome";
	}
	
	@RequestMapping(value="/upload/upload", method=RequestMethod.GET)
	public String uploadFile() {
		return "upload/upload";
	}
	
	@RequestMapping(value = "/upload/upload", method=RequestMethod.POST)
	public String uploadFile(@RequestParam(value = "dir", required = false, defaultValue = "/") String dir,
			@RequestParam MultipartFile file, RedirectAttributes redirectAttrs) {
		logger.info(file.getOriginalFilename());
		try {
			if (file != null && !file.isEmpty()) {
				logger.info("upload/ : " + file.getOriginalFilename());
				FileSaveVO saveFile = new FileSaveVO();
				saveFile.setFileManagedCode("p");
				saveFile.setMemberNum("S0000");
				saveFile.setFileName(file.getOriginalFilename());
				saveFile.setFileContent(file.getBytes());
				saveFile.setFileExplanation("");
				
				fileUploadService.uploadFile(saveFile);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload/uploadOk";
	}

	
	@RequestMapping(value="/upload/personal")
	public String getPersonalFile(Model model, MemberVO vo) {
		model.addAttribute("personalFile", fileUploadService.getPersonalFileList("S0000"));
		return "upload/personal";
	}
	
/*	@RequestMapping(value="/upload/movdToShare", method=RequestMethod.GET)
	public 
	*/
	
	@RequestMapping(value="/upload/movetoshare")
	public String moveToShare() {
		FileSaveVO vo = new FileSaveVO();
		vo = fileUploadService.getSelectFile("F000000001");
		vo.setFileManagedCode("s");
		fileUploadService.uploadFile(vo);
		return "upload/shareok";
	}
	
}
