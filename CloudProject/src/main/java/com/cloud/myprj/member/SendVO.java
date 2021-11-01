package com.cloud.myprj.member;

import java.sql.Date;

public class SendVO {

	private String sender;
	private String recipient;
	private String fileCode;
	private String sendContent;
	private String readCheck;
	private Date sendDate;
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getSender() {
		return sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public String getFileCode() {
		return fileCode;
	}
	public String getSendContent() {
		return sendContent;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public String getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(String readCheck) {
		this.readCheck = readCheck;
	}
	@Override
	public String toString() {
		return "SendVO [sender=" + sender + ", recipient=" + recipient + ", fileCode=" + fileCode + ", sendContent="
				+ sendContent + ", readCheck=" + readCheck + ", sendDate=" + sendDate + "]";
	}
	


}
