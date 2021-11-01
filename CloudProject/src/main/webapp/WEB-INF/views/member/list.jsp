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
<h1>사원 목록</h1>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>직급</th>
			<th>부서</th>
		</tr>
		<c:forEach var="mem" items="${memList}"> <!-- var와 items 변경시 컨트롤+F 로 변경 -->
		<tr>
			<td>${mem.memberNums}</td>
			<td>${mem.name}</td>
			<td>${mem.phone}</td>
			<td>${mem.position}</td>
			<td>${mem.department}</td>
			<td>
				<a href="memupdate?memum=${mem.memberNums}">수정</a>
				<a href="memdelete?memnum=${mem.memberNums}">수정</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>