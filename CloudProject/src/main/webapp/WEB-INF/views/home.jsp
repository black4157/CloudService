<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  The time on the server is ${serverTime}. </P>
<P>  The time on the server is ${serverTime}. </P>

	<form action="/login" method="post">
		사원번호를 입력하세요 : <input name="memberNum"/>
		패스워드를 입력하세요 : <input type="password" name="pwd"/>
		<input type="submit" value="로그인"/>
		<input type="reset" value="취소"/>
	
	</form>

<a href='<c:url value="/board/boardList"/>'>공지사항 쓰기</a>
</body>
</html>
