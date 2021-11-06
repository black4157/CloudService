package com.cloud.myprj.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
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
	
	// 파일 업로드 홈
	@RequestMapping(value = "/upload")
	public String mainPage(HttpSession session) {
		if(userService.logincheck(session) == 1) {
			return "redirect:/home";
		}
		else return "redirect:/home";
	}

	// 파일 업로드_Get
	@RequestMapping(value = "/upload/upload", method = RequestMethod.GET)
	public String uploadFile(HttpSession session) {
		if(userService.logincheck(session) == 1) {
			return "upload/upload";
		}
		else return "redirect:/home";
	}

	// 파일 업로드_Post
	@RequestMapping(value = "/upload/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(value = "text1", required = false, defaultValue = "") String fileExplanation, 
			@RequestParam MultipartFile file, HttpSession session) {
		logger.info(file.getOriginalFilename());
		try {
			if (file != null && !file.isEmpty()) {
				logger.info("upload/ : " + file.getOriginalFilename());
				FileSaveVO saveFile = new FileSaveVO();
				saveFile.setFileManagedCode("p");
				saveFile.setMemberNum((String) session.getAttribute("memberNum"));
				saveFile.setFileName(file.getOriginalFilename());
				saveFile.setFileContent(file.getBytes());
				saveFile.setFileExplanation(fileExplanation);

				fileUploadService.uploadFile(saveFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/upload/personal";
	}

	// 개인 폴더
	@RequestMapping(value = "/upload/personal")
	public String getPersonalFile(Model model, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			model.addAttribute("personalFile", fileUploadService.getPersonalFileList((String) session.getAttribute("memberNum")));
			return "upload/personal";
		}
		else return "redirect:/home";
	}
	
	// 개인 폴더 검색_파일 이름
	@RequestMapping(value = "/upload/personal", method=RequestMethod.POST)
	public String searchPersonalFileByFileName(String fileName, Model model, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			model.addAttribute("personalFile", fileUploadService.searchPersonalFileByFileName(((String) session.getAttribute("memberNum")), fileName));
			return "upload/personal";
		}
		else return "redirect:/home";
	}

	// 공유 폴더로 옮기기
	@RequestMapping(value = "/upload/movetoshare")
	public String moveToShare(@RequestParam(value = "fileCode", required = false, defaultValue = "/") String fileCode, HttpSession session) {
		if(userService.logincheck(session) == 1) {
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
			return "redirect:/upload/personal";
		}
		else return "redirect:/home";
	}

	// 공유 폴더
	@RequestMapping(value = "/upload/share")
	public String getShareFile(Model model, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			model.addAttribute("shareFile", fileUploadService.getShareFileList("s"));
			return "upload/share";
		}
		else return "redirect:/home";
	}
	
	// 공유 폴더 검색_파일 이름
	@RequestMapping(value = "/upload/share", method=RequestMethod.POST)
	public String getShareFile(String fileName, Model model, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			model.addAttribute("shareFile", fileUploadService.searchShareFileByFileName("s", fileName));
			return "upload/share";
		}
		else return "redirect:/home";
	}

	// 개인 폴더의 파일 삭제
	@RequestMapping(value = "/upload/delete/{fileCode}")
	public String deletePersonalFile(@PathVariable String fileCode, HttpSession session) {
		if(userService.logincheck(session) == 1) {
			fileUploadService.deletePersonalFile(fileCode);
			return "redirect:/upload/personal";
		}
		else return "redirect:/home";
	}

	// 공유 폴더의 파일 삭제
	@RequestMapping(value = "/upload/sharedelete/{fileCode}")
	public String deleteShareFile(@PathVariable String fileCode, MemberVO vo, RedirectAttributes attrs, HttpSession session) {
		vo = new MemberVO();
		if(userService.logincheck(session) == 1) {
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

	// 파일 다운로드
	@RequestMapping(value = "/download/{fileCode}")
	public ResponseEntity<byte[]> getImageFile(@PathVariable String fileCode, HttpSession session) {
		if(userService.logincheck(session) == 1) {
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
