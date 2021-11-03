<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<c:url var="actionURL" value='/board/boardUpdate' />
	<form action="${actionURL}" method="post">
		제목 <input type="text" name="boardTitle" id="boardTitle"value="${board.boardTitle}"><br> 
		내용<textArea rows="5" cols="30" name="boardContent" id="boardContent"> ${board.boardContent}</textArea>
		<input type="hidden" name="boardcontentNum" id="boardcontentNum" value="${board.contentNum}"><br> 
		<input type="submit" value="등록">
	</form>

</body>
</html>