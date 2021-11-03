package com.cloud.myprj.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		return "redirect:/upload/personal";
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
	public String moveToShare(@RequestParam(value="fileCode", required=false, defaultValue="/") String fileCode) {
//		FileSaveVO vo = new FileSaveVO();
//		vo = fileUploadService.getSelectFile(fileCode);
//		vo.setFileManagedCode("s");
//		fileUploadService.uploadFile(vo);
		List<String> lstFileCode = new ArrayList<String>();
		String add="";
		for(int i=0;i<fileCode.length();i++) {
			if(",".equals(fileCode.substring(i,i+1))) {
				lstFileCode.add(add);	
				System.out.println("----------------------------"+add);
				add="";
			}else {
				add=add+fileCode.substring(i,i+1);
			}
		}
		lstFileCode.add(add);
		fileUploadService.uploadShareFile(lstFileCode);
		return "upload/shareok";
	}
	
	@RequestMapping(value="/upload/share")
	public String getShareFile(Model model, MemberVO vo) {
		model.addAttribute("shareFile",fileUploadService.getShareFileList("s"));
		return "upload/share";
	}
	
	@RequestMapping(value="/upload/delete/{fileCode}")
	public String deletePersonalFile(@PathVariable String fileCode) {
		fileUploadService.deletePersonalFile(fileCode);
		return "redirect:/upload/personal";
	}
	
	@RequestMapping(value="/upload/sharedelete/{fileCode}")
	public String deleteShareFile(@PathVariable String fileCode) {
		fileUploadService.deletePersonalFile(fileCode);
		return "redirect:/upload/share";
	}
	@RequestMapping(value="/dowload/{fileCode}")
	public ResponseEntity<byte[]> getImageFile(@PathVariable String fileCode) {
		FileSaveVO file = fileUploadService.getSelectFile(fileCode);
		final HttpHeaders headers = new HttpHeaders();
		if(file != null) {
			logger.info("getFile " + file.toString());
//			String[] mtypes = file.getFileContentType().split("/");
//			headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
//			headers.setContentLength(file.getFileSize());
			headers.setContentDispositionFormData("attachment", file.getFileName(), Charset.forName("UTF-8"));
			
			return new ResponseEntity<byte[]>(file.getFileContent(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}
}
