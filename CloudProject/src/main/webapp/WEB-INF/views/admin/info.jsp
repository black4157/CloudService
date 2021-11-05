<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
<jsp:include page= "../include/menu.jsp">
	<h1>사원 상세 정보 조회</h1>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td>${memberVO.memberNum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${memberVO.name}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${memberVO.phone}</td>
		</tr>
		<tr>
			<th>직급</th>
			<td>${memberVO.position}</td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${memberVO.department}</td>
		</tr>
		<tr>
			<th>권한</th>
			<td>${memberVO.memberAuth}</td>		
		</tr>

	</table>
	<a href="/update/${memberVO.memberNum}">수정</a>
	<a href="/delete/${memberVO.memberNum}">삭제</a>
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</body>
</html>