<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file= "../headBack.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
<a href='<c:url value="/board/boardInsert"/>'>공지사항 쓰기</a>
<table>
<c:forEach var="board" items="${boardList}">
<tr>
<td>${board.contentNum }</td>
<td>${board.boardTitle }</td>
<td>${board.boardContent }</td>
<td>${board.boardDate }</td>
<td><a href='<c:url value="/board/boardReply/${board.contentNum }"/>'>본문보기</a></td>
</tr>
</c:forEach>
</table>

<%@ include file= "../down.jsp"%>

</body>
</html>