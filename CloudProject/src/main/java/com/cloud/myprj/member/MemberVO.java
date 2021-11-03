package com.cloud.myprj.member;

public class MemberVO {
	private String memberNum;
	private String pwd;
	private String name;
	private String phone;
	private String position;
	private String department;
	private String memberAuth;
	private String retire;
	
	
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
	public String getRetire() {
		return retire;
	}
	public void setRetire(String retire) {
		this.retire = retire;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", position=" + position + ", department=" + department + ", memberAuth=" + memberAuth + ", retire="
				+ retire + "]";
	}
	
}
