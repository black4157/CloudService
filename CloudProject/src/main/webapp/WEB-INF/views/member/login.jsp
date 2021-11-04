<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../head.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
<h1>
로그인  
</h1>
	<form action="/login" method="post">
		사원번호를 입력하세요 : <input name="memberNum"/><br>
		패스워드를 입력하세요 : <input type="password" name="pwd"/>
		<input type="submit" value="로그인"/>
		<input type="reset" value="취소"/>
	</form>
	<%@ include file= "../down.jsp"%>
</body>
</html>