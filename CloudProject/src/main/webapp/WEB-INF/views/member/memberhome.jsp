<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 홈 페이지</title>
</head>
<body>
	사원들의 홈 페이지 입니다.<P>
	${memberVO.name } 님 로그인 되었습니다.<p>
	
	<a href="/logout">로그아웃 하기</a><p>
	<a href="/adminhome">관리자 홈페이지로 이동</a><p>
</body>
</html>