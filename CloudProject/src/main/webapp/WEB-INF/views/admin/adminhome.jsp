<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../head.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	관리자의 홈 페이지 입니다.<p>
	${memberVO.name } 님 로그인 되었습니다.<p>
	
	<a href="/logout">로그아웃 하기</a><p>
	<a href="/board/boardList">공지사항 보기</a><p>
	<a href="/list">사원 리스트 보기</a><p>
	<a href="/signup">사원 추가하기</a><p>
	<a href="/send">전송하기</a><p>
	<a href="/upload/personal">개인폴더</a><p>
	<a href="/upload/share">공유폴더</a><p>	<p>
	<p>
	<a href="/memberhome">사원 홈 페이지로 이동</a><p>
	<%@ include file= "../down.jsp"%>
</body>
</html>