<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".delete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});

</script>
</head>
<body>
<%@ include file= "../up.jsp"%>
<c:url var="actionURL" value="/upload/movetoshare"/>
		<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal">
		<table border="1">
			<tr>
				<th>파일코드</th>
				<th>파일이름</th>
				<th>업데이트 날짜</th>
				<th>파일 설명</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="shareFile" items="${shareFile}">
			<tr>
				<td>${shareFile.fileCode}</td>
				<td><a href="<c:url value='/dowload/${shareFile.fileCode}'/>">${shareFile.fileName}</a></td>
				<td>${shareFile.updateDate}</td>
				<td>${shareFile.fileExplanation}</td>
				<td><a href="<c:url value='/upload/sharedelete/${shareFile.fileCode}'/>" class = "delete">삭제</a>
			</tr>
			</c:forEach>
		</table>
		</form>
		${msg}
		<form action="/upload">
			<input type="submit" value="돌아가기">
		</form>
			<%@ include file= "../down.jsp"%>
</body>
</html>