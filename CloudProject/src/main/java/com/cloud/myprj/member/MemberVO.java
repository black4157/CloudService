package com.cloud.myprj.member;

public class MemberVO {
	private String memberNum;
	private String pwd;
	private String name;
	private String phone;
	private String position;
	private String deparment;
	private String memberAuth;
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getPosition() {
		return position;
	}
	public String getDeparment() {
		return deparment;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", position=" + position + ", deparment=" + deparment + ", memberAuth=" + memberAuth + "]";
	}

	
}
