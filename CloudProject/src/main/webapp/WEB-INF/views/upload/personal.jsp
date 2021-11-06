<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="UTF-8">
<html>
<head>
<title>개인 폴더</title>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/upload/personal" method="post" class="pull-right position" id="searchForm">
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="fileName" class="sr-input" placeholder="파일이름 검색">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>
				 <div class="inbox-body">
					<div class="mail-option">	
						<h2 style="display:inline-block;">개인 폴더</h2>	
						<input type="button" value="공유하기" id="share_check" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
						<c:url var="actionURL" value="/upload/movetoshare"/>
						<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal" id="shareForm">
							<table class="table table-inbox table-hover">
								<tbody>
							     <tr class="unread">
							     	<td class="inbox-small-cells"></td>
									<td class="view-message ">파일이름</td>
									<td class="view-message ">파일 설명</td>
									<td class="view-message ">업로드 날짜</td>
									<td class="view-message ">삭제</td>
								</tr>
								<c:forEach var="personalFile" items="${personalFile}">
								<tr class="">
									<td class="inbox-small-cells">
			                        	<input type="checkbox" class="mail-checkbox" value="${personalFile.fileCode}" name="fileCode">
			                        </td>
									<td class="view-message "><a href="<c:url value='/download/${personalFile.fileCode }'/>">${personalFile.fileName}</a></td>
									<td class="view-message ">${personalFile.fileExplanation}</td>
									<td class="view-message "><fmt:formatDate value="${personalFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td class="view-message "><a href="<c:url value='/upload/delete/${personalFile.fileCode}'/>" class = "delete">삭제</a>
								</tr>
								</c:forEach>
								</tbody>
							</table>
						</form>
						<hr class="my-2" style="border-top: 2px solid #eee">
						<form action="/upload/upload" method="post" enctype="multipart/form-data" style="margin-top:20px;">
							<input type="file" name="file" style="display:inline;">파일 설명
							<input type="text" name="text1">
							<input type="submit" value="파일업로드" class="upload_check">
						</form>
					</div>
				</div>
			</aside>
		</div>
	</div>
</body>

<script>
$(document).ready(function(){
	$("#share_check").click(function(){
		$("#shareForm").submit();
		alert("공유 완료했습니다.");
	});
});

$(document).ready(function(){
	$(".upload_check").click(function(){
		if(!$("input[name=file]").val()){
			alert("파일을 올려주세요.");
			return false;
		}
	});
}); 
</script>
</html>
