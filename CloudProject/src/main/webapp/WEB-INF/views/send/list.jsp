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
	<c:forEach var="mailList" items="${recivedMail }">
		<a href="/send/view/${mailList.send_num}">123123123</a>
	</c:forEach>
</body>
</html>
