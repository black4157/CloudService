<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
	<%@ include file= "../include/menu.jsp"%>
	<h1>사원 상세 정보 조회</h1>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td>${member.memberNum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<th>직급</th>
			<td>${member.position}</td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${member.department}</td>
		</tr>
		<tr>
			<th>권한</th>
			<td>${member.memberAuth}</td>		
		</tr>

	</table>
	<a href="/update/${member.memberNum}">수정</a>
	<a href="/delete/${member.memberNum}">삭제</a>
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</body>
</html>