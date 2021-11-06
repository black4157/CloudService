<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page = "../include/head.jsp" />
	<link href="css/login.css" rel="stylesheet">
	<title>클라우드 서비스</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="img/cloud.png" id="icon" alt="User Icon" />
				<h1>Cloud Service</h1>
			</div>
			
			<form action="/login" method="post">
				<input type="text" id="login" class="fadeIn second" name="memberNum" placeholder="username"> 
				<input type="password" id="password" class="fadeIn third" name="pwd" placeholder="password"> 
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>
			<div id="formFooter">
				<a href="#" class="underlineHover" style="text-decoration: none;">환영합니다.</a>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function(){
		var msg = "${msg}";
		console.log(msg);
		if(msg){
			alert(msg);
		}
	});
</script>
</html>