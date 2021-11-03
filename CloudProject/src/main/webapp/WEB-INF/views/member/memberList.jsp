<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
	${memberNum} <p>
	${name }<p>
	${phone}<p>
	${position}<p>
	${department}<p>
	${memberAuth}<p>

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
			<td>${member.memberNum}</td>
			<td>${member.name}</td>
			<td>${member.phone}</td>
			<td>${member.position}</td>
			<td>${member.department}</td>
			<td>
				<a href="memupdate?memmum=${member.memberNum}">수정</a>
				<a href="memdelete?memnum=${member.memberNum}">삭제</a> 
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>