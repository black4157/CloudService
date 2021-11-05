<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
<jsp:include page= "../include/menu.jsp">
<c:url var= "actionURL" value='/board/boardInsert' />
<form action ="${actionURL}" method="post">
제목 <input type= "text" name = "boardTitle" id = "boardTitle"><br>
내용<textArea rows="5" cols="30" name = "boardContent" id = "boardContent"> </textArea>
<input type="submit" value="등록">
</form>
</body>
</html>