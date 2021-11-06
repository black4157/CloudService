<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
<link href="css/login.css" rel="stylesheet">
<title>클라우드 서비스</title>

</head>
<body>
	<div class="wrapper fadeInDown">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	
	    <!-- Icon -->
	    <div class="fadeIn first">
	      <img src="img/cloud.png" id="icon" alt="User Icon" />
	      <h1>Cloud Service</h1>
	    </div>
	
	    <!-- Login Form -->
	    <form action="/login" method="post">
	      <input type="text" id="login" class="fadeIn second" name="memberNum" placeholder="username">
	      <input type="password" id="password" class="fadeIn third" name="pwd" placeholder="password">
	      <input type="submit" class="fadeIn fourth" value="Log In">
	    </form>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a href="#" class="underlineHover" style="text-decoration: none;">환영합니다.</a>
	    </div>
	
	  </div>
	</div>
	<%-- <h1>
	로그인  
	</h1>
		<form action="/login" method="post">
			사원번호를 입력하세요 : <input name="memberNum"/><br>
			패스워드를 입력하세요 : <input type="password" name="pwd"/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
		</form>
		<%@ include file= "../down.jsp"%> --%>
	</body>
</html>