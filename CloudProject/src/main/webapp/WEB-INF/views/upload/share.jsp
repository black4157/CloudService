<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>

</head>
<body>
<%@ include file= "../include/menu.jsp"%>
	<div class="inbox-body">
		<div class="mail-option">	
		<h2>공유 폴더</h2>	
		<c:url var="actionURL" value="/upload/movetoshare"/>
		<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal">
		<table class="table table-inbox table-hover">
			<tbody>
		     <tr class="unread">
				<td class="view-message ">파일이름</td>
				<td class="view-message ">파일 설명</td>
				<td class="view-message ">업데이트 날짜</td>
				<td class="view-message ">삭제</td>
			</tr>
			<c:forEach var="shareFile" items="${shareFile}">
			<tr class="">
				<td class="view-message "><a href="<c:url value='/download/${shareFile.fileCode}'/>">${shareFile.fileName}</a></td>
				<c:if test="${shareFile.fileExplanation == null}">
					<td class="view-message ">설명이 없어요ㅠ</td>
				</c:if>
				<c:if test="${shareFile.fileExplanation != null}">
					<td class="view-message ">${shareFile.fileExplanation}</td>
				</c:if>
				
				<td class="view-message "><fmt:formatDate value="${shareFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="view-message "><a href="<c:url value='/upload/sharedelete/${shareFile.fileCode}'/>" class = "delete">삭제</a>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</form>
		<form action = "/upload/share" method="post">
			<input type="text" name="fileName" placeholder="파일 이름">
			<input type="submit" value="검색">
		</form>
		${msg}
		</div>
	</div>
</body>

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
</html>