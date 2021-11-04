package com.cloud.myprj.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.myprj.member.FileSaveVO;
import com.cloud.myprj.member.MemberVO;
import com.cloud.myprj.service.IFileUploadService;
import com.cloud.myprj.service.IUserService;

@Controller
public class FileUploadController {

	@Autowired
	IFileUploadService fileUploadService;

	@Autowired
	IUserService userService;

	static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value = "/upload")
	public String mainPage(HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			logger.info("홈 ~안녕");
			return "upload/uploadhome";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/upload", method = RequestMethod.GET)
	public String uploadFile(HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			return "upload/upload";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(value = "dir", required = false, defaultValue = "/") String dir,
			@RequestParam MultipartFile file, HttpServletRequest req) {
		logger.info(file.getOriginalFilename());
		try {
			HttpSession session = req.getSession();
			if (file != null && !file.isEmpty()) {
				logger.info("upload/ : " + file.getOriginalFilename());
				FileSaveVO saveFile = new FileSaveVO();
				saveFile.setFileManagedCode("p");
				saveFile.setMemberNum((String) session.getAttribute("memberNum"));
				saveFile.setFileName(file.getOriginalFilename());
				saveFile.setFileContent(file.getBytes());
				saveFile.setFileExplanation("");

				fileUploadService.uploadFile(saveFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/upload/personal";
	}

	@RequestMapping(value = "/upload/personal")
	public String getPersonalFile(Model model, MemberVO vo, HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			HttpSession session = req.getSession();
			model.addAttribute("personalFile", fileUploadService.getPersonalFileList((String) session.getAttribute("memberNum")));
			return "upload/personal";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/movetoshare")
	public String moveToShare(@RequestParam(value = "fileCode", required = false, defaultValue = "/") String fileCode, HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			List<String> lstFileCode = new ArrayList<String>();
			String add = "";
			for (int i = 0; i < fileCode.length(); i++) {
				if (",".equals(fileCode.substring(i, i + 1))) {
					lstFileCode.add(add);
					System.out.println("----------------------------" + add);
					add = "";
				} else {
					add = add + fileCode.substring(i, i + 1);
				}
			}
			lstFileCode.add(add);
			fileUploadService.uploadShareFile(lstFileCode);
			return "upload/shareok";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/share")
	public String getShareFile(Model model, MemberVO vo, HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			model.addAttribute("shareFile", fileUploadService.getShareFileList("s"));
			return "upload/share";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/delete/{fileCode}")
	public String deletePersonalFile(@PathVariable String fileCode, HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			fileUploadService.deletePersonalFile(fileCode);
			return "redirect:/upload/personal";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/upload/sharedelete/{fileCode}")
	public String deleteShareFile(@PathVariable String fileCode, MemberVO vo, RedirectAttributes attrs, HttpServletRequest req) {
		HttpSession session = req.getSession();
		vo = new MemberVO();
		if(userService.logincheck(req) == 1) {
			try {
				vo = userService.getMemberInfo((String) session.getAttribute("memberNum"));
				// 최고 권한자
				if ("S".equals(vo.getMemberAuth()) || "A".equals(vo.getMemberAuth())) {
					fileUploadService.deletePersonalFile(fileCode);
					attrs.addFlashAttribute("msg", "<script type=\"text/javascript\"> alert(\"삭제완료\")</script>");
	
				// 모두 삭제 가능
				} else if ("B".equals(vo.getMemberAuth())) {
					// 파일의 권한 취득
					FileSaveVO file = fileUploadService.getSelectFile(fileCode);
					// 파일 작성자와 사용자가 동일한경우 삭제
					if (file.getMemberNum().equals(vo.getMemberNum())) {
						fileUploadService.deletePersonalFile(fileCode);
						attrs.addFlashAttribute("msg", "<script type=\"text/javascript\"> alert(\"삭제완료\")</script>");
					} else {
						attrs.addFlashAttribute("msg", "<script type=\"text/javascript\"> alert(\"삭제 권한이 없습니다. 관리자에게 문의 해 주세요\")</script>");
						return "redirect:/upload/share";
					}
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/upload/share";
		}
		else return "redirect:/home";
	}

	@RequestMapping(value = "/download/{fileCode}")
	public ResponseEntity<byte[]> getImageFile(@PathVariable String fileCode, HttpServletRequest req) {
		if(userService.logincheck(req) == 1) {
			FileSaveVO file = fileUploadService.getSelectFile(fileCode);
			final HttpHeaders headers = new HttpHeaders();
			if (file != null) {
				logger.info("getFile " + file.toString());
				headers.setContentDispositionFormData("attachment", file.getFileName(), Charset.forName("UTF-8"));
	
				return new ResponseEntity<byte[]>(file.getFileContent(), headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}
		}
		else return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	}
}
