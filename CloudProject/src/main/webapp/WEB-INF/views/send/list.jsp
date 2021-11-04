<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file= "../headBack.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	<h1>받은 메일함</h1>
	<table border="1">
		<tr>
			<th>보낸사람</th>
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
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
	<%@ include file= "../downback.jsp"%>

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
