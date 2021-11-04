<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>

</head>

<body>
	<h1>제목 : ${viewMail.sendTitle}</h1>
	<table>
		<tr>
			<td>보낸이</td>
			<td>${viewMail.sender}</td>
		</tr>
		<tr>
			<td>보낸시간</td>
			<td><fmt:formatDate value="${viewMail.sendDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${viewMail.sendContent}</td>
		</tr>
		
		<tr>
			<td>받은 파일</td>
			<td><a href="<c:url value='/send/view/download/${viewMail.sendNum}' />">${viewMail.fileName}</a></td>
		</tr>
		<tr>
	</table>


</body>

</html>
