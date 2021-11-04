<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>클라우드</title>
</head>
<body>
<h1>
로그인  
</h1>

	<form action="/login" method="post">
		사원번호를 입력하세요 : <input name="memberNum"/><br>
		패스워드를 입력하세요 : <input type="password" name="pwd"/>
		<input type="submit" value="로그인"/>
		<input type="reset" value="취소"/>
	
	</form>

</body>
</html>
