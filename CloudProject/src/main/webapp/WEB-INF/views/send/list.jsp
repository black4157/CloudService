<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>받은 메일함</h1>
	<table border="1">
		<tr>
			<th>본낸사람</th>
			<th>제목</th>
			<th>받은 날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="mailList" items="${recivedMail }">
			<tr>
				<td>${mailList.sender}</td>
				<td><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
				<td>${mailList.sendDate}</td>
				<td><a href="/send/delete/${mailList.sendNum }" class="delete">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file= "../down.jsp"%>
</body>

<script>
	$(".delete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		} else{
			return false;
		}
	});
</script>
</html>
