<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../headBack.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	<c:url var="actionURL" value='/board/boardUpdate' />
	<form action="${actionURL}" method="post">
		제목 <input type="text" name="boardTitle" id="boardTitle"value="${board.boardTitle}"><br> 
		내용<textArea rows="5" cols="30" name="boardContent" id="boardContent"> ${board.boardContent}</textArea>
		<input type="hidden" name="boardcontentNum" id="boardcontentNum" value="${board.contentNum}"><br> 
		<input type="submit" value="등록">
	</form>
<%@ include file= "../down.jsp"%>
</body>
</html>