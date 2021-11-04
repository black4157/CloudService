<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".delete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});

</script>
</head>
<body>
<c:url var="actionURL" value="/upload/movetoshare"/>
		<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal">
		<table border="1">
			<tr>
				<th>파일코드</th>
				<th>파일이름</th>
				<th>업데이트 날짜</th>
				<th>파일 설명</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="shareFile" items="${shareFile}">
			<tr>
				<td>${shareFile.fileCode}</td>
				<td><a href="<c:url value='/dowload/${shareFile.fileCode}'/>">${shareFile.fileName}</a></td>
				<td>${shareFile.updateDate}</td>
				<td>${shareFile.fileExplanation}</td>
				<td><a href="<c:url value='/upload/sharedelete/${shareFile.fileCode}'/>" class = "delete">삭제</a>
			</tr>
			</c:forEach>
		</table>
		</form>
		${msg}
		<form action="/upload">
			<input type="submit" value="돌아가기">
		</form>
</body>
</html>