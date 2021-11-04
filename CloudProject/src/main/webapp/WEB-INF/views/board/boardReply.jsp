<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
${board.boardTitle}<br>
${board.boardContent}<br>
${board.boardDate}<br>

<a href='<c:url value="/board/boardUpdate/${board.contentNum }"/>'>수정하기</a> 
<a href='<c:url value="/board/boardDelete?contentNum=${board.contentNum }"/>'>삭제하기</a>
<br>
-----댓글------<br>
<table>
<c:forEach var="comment" items="${commentList}">
<tr>
<td>${comment.commentContent }</td>
<td>${comment.memberNum }</td>
<td>${comment.commentDate }</td>
<td><a href='<c:url value="/board/boardCommentDelete?commentNum=${comment.commentNum }&contentNum=${comment.contentNum }"/>'>삭제</a></td>
</tr>
</c:forEach>
</table>
<c:url var= "actionURL" value='/board/boardReply' />
<form action ="${actionURL}" method="post">
	<textArea rows="5" cols="30" name="comment"> </textArea>
	<input type="hidden" name="contentNum" value="${board.contentNum}">
	<input type="submit" value="입력" >

</form>
<%@ include file= "../down.jsp"%>
</body>
</html>