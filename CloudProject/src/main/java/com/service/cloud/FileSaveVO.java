package com.service.cloud;

import java.sql.Date;
import java.util.Arrays;

public class FileSaveVO {

	private String fileCode;
	private String fileManagedCode;
	private String memberNum;
	private String fileName;
	private byte[] fileContent;
	private String fileExplanation;
	private Date uploadDate;
	private Date updateDate;
	private String deleteTF;
	private String filePath;
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public void setFileManagedCode(String fileManagedCode) {
		this.fileManagedCode = fileManagedCode;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public void setFileExplanation(String fileExplanation) {
		this.fileExplanation = fileExplanation;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setDeleteTF(String deleteTF) {
		this.deleteTF = deleteTF;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "FileSaveVO [fileCode=" + fileCode + ", fileManagedCode=" + fileManagedCode + ", memberNum=" + memberNum
				+ ", fileName=" + fileName + ", fileContent=" + Arrays.toString(fileContent) + ", fileExplanation="
				+ fileExplanation + ", uploadDate=" + uploadDate + ", updateDate=" + updateDate + ", deleteTF="
				+ deleteTF + ", filePath=" + filePath + "]";
	}
	
	

}
