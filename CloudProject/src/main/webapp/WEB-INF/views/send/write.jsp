<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="/send/write" method="post" enctype="multipart/form-data">
		<%-- <input type="text" name="send" value="${memberVO.name }" readonly> --%>
		<p>
			보낸이 : <input type="text" name="sender" readonly value="${memberVO.memberNum}" />
		</p>
		<p>
			받는이 : 
			<select name="recipient">
				<c:forEach var="userList" items="${userList }">
					<c:if test="${userList.name != memberVO.name }">
						<option value="${userList.memberNum }">${userList.name }</option>
					</c:if>
					
				</c:forEach>
			</select>
		</p>
		
		<p> 제목 : 
			<input type="text" name="sendTitle" />
		</p>
		<p>
		
			파일 : 
			<select name="fileCode">
				<c:forEach var="fileList" items="${fileList }">
					<option value="${fileList.fileCode }">${fileList.fileName }</option>
				</c:forEach>
			</select>

		</p>
		<p>
			설명
			<textarea name="sendContent" rows="5" cols="100"></textarea>
		</p>
		<input type="submit" value="전송">
		<input type="reset" value="뒤로가기" onclick="history.go(-1);">
	</form>
<%@ include file= "../down.jsp"%>
</body>
</html>
