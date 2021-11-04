<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file= "../head.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	<h1>send home</h1>
	
	<a href="/send/write">보내기</a><br>
	<a href="/send/list">받은 메일함</a><p>
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
	<%@ include file= "../down.jsp"%>
</body>
</html>
