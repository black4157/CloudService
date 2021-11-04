<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../head.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	사원들의 홈 페이지 입니다.<P>
	${memberVO.name } 님 로그인 되었습니다.<p>
	
	<a href="/logout">로그아웃 하기</a><p>
	<a href="/adminhome">관리자 홈페이지로 이동</a><p>

	<a href="/board/boardList">공지사항 보기</a><p>
	<a href="/send">전송하기</a><p>
	<a href="/upload/personal">개인폴더</a><p>
	<a href="/upload/share">공유폴더</a><p>
	<%@ include file= "../down.jsp"%>
</body>
</html>