package com.cloud.myprj.member;

import java.sql.Timestamp;

public class SendVO {
	private int sendNum;
	private String sender;
	private String recipient;
	private String fileCode;
	private String sendContent;
	private String readCheck;
	private Timestamp sendDate;
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
	@Override
	public String toString() {
		return "SendVO [sendNum=" + sendNum + ", sender=" + sender + ", recipient=" + recipient + ", fileCode="
				+ fileCode + ", sendContent=" + sendContent + ", readCheck=" + readCheck + ", sendDate=" + sendDate
				+ "]";
	}
	

}
