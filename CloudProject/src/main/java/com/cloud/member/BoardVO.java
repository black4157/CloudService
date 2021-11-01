package com.cloud.member;

import java.sql.Date;

public class BoardVO {

	private String contentNum;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	public void setContentNum(String contentNum) {
		this.contentNum = contentNum;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "BoardVO [contentNum=" + contentNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + "]";
	}
	

	
}
