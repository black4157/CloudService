<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>

</head>
<h1>제목 : ${viewMail.sendTitle}</h1>
<body>
	${viewMail.fileName}
	<a href="<c:url value='/send/view/download/${viewMail.sendNum}' />">파일 다운로드</a>

</body>

</html>
