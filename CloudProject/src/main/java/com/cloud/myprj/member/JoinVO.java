package com.cloud.myprj.member;

import java.sql.Timestamp;
import java.util.Arrays;

public class JoinVO {
	private int sendNum;
	private String sender;
	private String recipient;
	private String sendTitle;
	private String fileCode;
	private String sendContent;
	private String readCheck;
	private Timestamp sendDate;

	private String fileManagedCode;
	private String fileName;
	private byte[] fileContent;
	private String fileExplanation;
	private String deleteTF;
	public int getSendNum() {
		return sendNum;
	}
	public void setSendNum(int sendNum) {
		this.sendNum = sendNum;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSendTitle() {
		return sendTitle;
	}
	public void setSendTitle(String sendTitle) {
		this.sendTitle = sendTitle;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(String readCheck) {
		this.readCheck = readCheck;
	}
	public Timestamp getSendDate() {
		return sendDate;
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	public String getFileManagedCode() {
		return fileManagedCode;
	}
	public void setFileManagedCode(String fileManagedCode) {
		this.fileManagedCode = fileManagedCode;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getFileExplanation() {
		return fileExplanation;
	}
	public void setFileExplanation(String fileExplanation) {
		this.fileExplanation = fileExplanation;
	}
	public String getDeleteTF() {
		return deleteTF;
	}
	public void setDeleteTF(String deleteTF) {
		this.deleteTF = deleteTF;
	}
	@Override
	public String toString() {
		return "JoinVO [sendNum=" + sendNum + ", sender=" + sender + ", recipient=" + recipient + ", sendTitle="
				+ sendTitle + ", fileCode=" + fileCode + ", sendContent=" + sendContent + ", readCheck=" + readCheck
				+ ", sendDate=" + sendDate + ", fileManagedCode=" + fileManagedCode + ", fileName=" + fileName
				+ ", fileContent=" + Arrays.toString(fileContent) + ", fileExplanation=" + fileExplanation
				+ ", deleteTF=" + deleteTF + "]";
	}
	

}
