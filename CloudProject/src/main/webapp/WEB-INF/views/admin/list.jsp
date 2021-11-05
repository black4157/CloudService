<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
	<%@ include file= "../include/menu.jsp"%>
	<form action="/list" method="post">
			<h1>사원 목록</h1>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>직급</th>
			<th>부서</th>
		</tr>
		<c:forEach var="member" items="${memberList}"> <!-- var와 items 변경시 컨트롤+F 로 변경 -->
		<tr>
							<!-- @PathVariable -->
			<td><a href="/info/${member.memberNum}">${member.memberNum}</a></td>
			<td>${member.name}</td>
			<td>${member.phone}</td>
			<td>${member.position}</td>
			<td>${member.department}</td>
		</tr>
		</c:forEach>
	</table>
		<input type="text" name="name" placeholder="사원 이름">
		<input type="submit" value="검색">
	</form>
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</body>
</html>