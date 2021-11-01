package com.cloud.myprj.member;

import java.sql.Timestamp;

public class BoardVO {

	private String contentNum;
	private String boardTitle;
	private String boardContent;
	private Timestamp boardDate;
	public void setContentNum(String contentNum) {
		this.contentNum = contentNum;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public String getContentNum() {
		return contentNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public Timestamp getBoardDate() {
		return boardDate;
	}
	@Override
	public String toString() {
		return "BoardVO [contentNum=" + contentNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + "]";
	}
	

	
}
