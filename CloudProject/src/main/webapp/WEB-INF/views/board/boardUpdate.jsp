<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
<jsp:include page= "../include/menu.jsp" />
	<c:url var="actionURL" value='/board/boardUpdate' />
	<form action="${actionURL}" method="post">
		제목 <input type="text" name="boardTitle" id="boardTitle"value="${board.boardTitle}"><br> 
		내용<textArea rows="5" cols="30" name="boardContent" id="boardContent"> ${board.boardContent}</textArea>
		<input type="hidden" name="boardcontentNum" id="boardcontentNum" value="${board.contentNum}"><br> 
		<input type="submit" value="등록" class="update_check">
	</form>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$(".update_check").click(function(){
		if(confirm("수정하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});
</script>
</html>