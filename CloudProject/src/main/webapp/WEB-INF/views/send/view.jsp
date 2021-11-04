<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<title>클라우드</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Blueprint: A basic template for a responsive multi-level menu" />
<meta name="keywords" content="blueprint, template, html, css, menu, responsive, mobile-friendly" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="favicon.ico">
<!-- food icons -->
<link rel="stylesheet" type="text/css" href="css/organicfoodicons.css" />
<!-- demo styles -->
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!-- menu styles -->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<script src="js/modernizr-custom.js"></script>

</head>

<body>
<%@ include file= "../up.jsp"%>
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

<%@ include file= "../down.jsp"%>
</body>

</html>
