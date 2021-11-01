package com.cloud.member;

import java.sql.Date;

public class BoardCommnetVO {

	private String commentNum;
	private String contentNum;
	private String commentContent;
	private String memberNum;
	private Date commentDate;
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	public void setContentNum(String contentNum) {
		this.contentNum = contentNum;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "BoardCommnetVO [commentNum=" + commentNum + ", contentNum=" + contentNum + ", commentContent="
				+ commentContent + ", memberNum=" + memberNum + ", commentDate=" + commentDate + "]";
	}

}
