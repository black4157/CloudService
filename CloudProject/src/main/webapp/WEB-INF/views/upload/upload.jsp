<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>

<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>

<jsp:include page= "../include/menu.jsp">

<form action="/upload/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="file" />
	<input type="submit" value="전송">
</form>
</body>
</html>
