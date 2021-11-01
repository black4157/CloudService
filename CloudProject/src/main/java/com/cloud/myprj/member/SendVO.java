package com.cloud.myprj.member;

import java.sql.Date;

public class SendVO {

	private String sender;
	private String recipient;
	private String fileCode;
	private String sendContent;
	private String check;
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
	public void setCheck(String check) {
		this.check = check;
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
	public String getCheck() {
		return check;
	}
	public Date getSendDate() {
		return sendDate;
	}
	@Override
	public String toString() {
		return "SendVO [sender=" + sender + ", recipient=" + recipient + ", fileCode=" + fileCode + ", sendContent="
				+ sendContent + ", check=" + check + ", sendDate=" + sendDate + "]";
	}

}