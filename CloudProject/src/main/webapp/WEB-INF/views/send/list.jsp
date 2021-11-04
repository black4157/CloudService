<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>받은 메일함</h1>
	<table border="1">
		<tr>
			<th>본낸사람</th>
			<th>받는사람</th>
			<th>제목</th>
			<th>받은 날짜</th>
			<c:if test="${mailList.memberNum = 'S0001' }">
				<th>삭제</th>
			</c:if>
		</tr>
		<c:forEach var="mailList" items="${recivedMail }">
			<a href="/send/view/${mailList.sendNum}">${mailList.sendTitle }</a>
			<tr>
				<td>${mailList.sender}</td>
				<td>${mailList.recipient}</td>
				<td><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
				<td>${mailList.sendDate}</td>
				<c:if test="${mailList.memberNum = 'S0001' }">
					<th><a href="/send/delete" class="delete">삭제</a></th>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>

<script>
	$(".delete").click(function(){
		$.ajax({
			
		});
	});
</script>
</html>
