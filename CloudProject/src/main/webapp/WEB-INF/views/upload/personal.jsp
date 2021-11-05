<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="UTF-8">
<html>
<head>
	<%@ include file= "../include/head.jsp"%>    
</head>
<body>
	<%@ include file= "../include/menu.jsp"%>
	
	 <div class="inbox-body">
		<div class="mail-option">	
		<h1 style="display:inline-block;">개인 폴더</h1>	
		<input type="submit" value="공유하기" id="share_check" class="btn btn-compose" style="margin-top: 30px; width: 10%; float:right; height: 30px; padding: 0;">
			<c:url var="actionURL" value="/upload/movetoshare"/>
			<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal">
				<table class="table table-inbox table-hover">
					<tbody>
				     <tr class="unread">
				     	<td class="inbox-small-cells"></td>
						<td class="view-message ">파일이름</td>
						<td class="view-message ">업데이트 날짜</td>
						<td class="view-message ">파일 설명</td>
						<td class="view-message ">삭제</td>
					</tr>
					<c:forEach var="personalFile" items="${personalFile}">
					<tr class="unread">
						<td class="inbox-small-cells">
                        	<input type="checkbox" class="mail-checkbox">
                        </td>
						<td class="view-message "><a href="<c:url value='/download/${personalFile.fileCode }'/>">${personalFile.fileName}</a></td>
						<td class="view-message "><fmt:formatDate value="${personalFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td class="view-message ">${personalFile.fileExplanation}</td>
						<td class="view-message "><a href="<c:url value='/upload/delete/${personalFile.fileCode}'/>" class = "delete">삭제</a>
					</tr>
					</c:forEach>
					</tbody>
				</table>
					
				
			</form>
			<form action="/upload/upload" method="post" enctype="multipart/form-data" style="margin-top:20px;">
				<input type="file" name="file" style="display:inline;">파일 설명
				<input type="text" name="text1">
				<input type="submit" value="파일업로드" class="upload_check">
			</form>
		</div>
	</div>
</body>

<script>
$(document).ready(function(){
	$("#share_check").click(function(){
		alert("공유 완료했습니다.");
	});
});

/* $(document).ready(function(){
	$(".upload_check").click(function(){
		if(input[id=s] == null)
			alert("파일을 올려주세요.");
	});
}); */
</script>
</html>
