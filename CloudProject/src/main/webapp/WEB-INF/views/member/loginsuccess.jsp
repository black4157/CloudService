<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<form action="/logout" >
		${memberVO.name }님 로그인 되었습니다.
		<input type="submit" value="로그아웃">
	</form>

</body>
</html>