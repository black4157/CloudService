<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
${board.boardTitle}<br>
${board.boardContent}<br>
${board.boardDate}<br>
-----댓글------<br>
<table>
<c:forEach var="comment" items="${comment}">
<tr>
<td>${comment.commentNum }</td>
<td>${comment.contentNum }</td>
<td>${comment.commentContent }</td>
<td>${comment.memberNum }</td>
<td>${comment.commentDate }</td>
<td><a href='<c:url value="/board/boardReply/${board.contentNum }"/>'>본문보기</a></td>
</tr>
</c:forEach>
</table>

<c:url var= "actionURL" value='/board/boardReply' />
<form action ="${actionURL}" method="post">
	<textArea rows="5" cols="30" name="comment"> </textArea>
	<input type="submit" value="입력" >

</form>

</body>
</html>