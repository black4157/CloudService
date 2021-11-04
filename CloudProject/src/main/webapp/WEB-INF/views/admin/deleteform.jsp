<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>사원 삭제</h1>
<form action="/delete/${memberVO.memberNum}" method="post">
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td>${memberVO.memberNum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${memberVO.name }</td>
		</tr>	
		<tr>
			<th>직급</th>
			<td>${memberVO.position }</td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${memberVO.department }</td>
		</tr>
		<tr>
			<th>퇴사 승인</th>
			<td><input type="text" name="retire" value="T" readonly></td>
		</tr>
	</table>
	<input type="submit" value="퇴사 승인"> 
	<input type="reset" value="취소">
</form>
<%@ include file= "../down.jsp"%>
</body>
</html>