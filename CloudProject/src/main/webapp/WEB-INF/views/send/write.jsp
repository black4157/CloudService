<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>파일보내기</title>
</head>
<style>
table tr {
	margin: 20px 0px;
}

table tr th {
	width: 20%;
}
#fileSelect{
	width: 50%; 
	padding: 6px 12px; 
	font-size: 14px;
}
</style>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/upload/share" method="post" class="pull-right position" id="searchForm">
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="fileName" class="sr-input" placeholder="파일이름 검색">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>

				<form action="/send/write" method="post" enctype="multipart/form-data" style="padding: 40px 0px 40px 40px;">
					<table style="width: 100%; height: 500px;">
						<tr>
							<th>보낸이</th>
							<td><input type="text" name="sender" class="form-control mt-4 mb-2" value="${memberVO.name}" readonly style="width: 30%;"></td>
						</tr>
						<tr>
							<th>받는이</th>
							<td>
								<select name="recipient" class="custom-select custom-select-lg mb-2" style="width: 30%; display: inline-block; padding: 6px 12px; font-size: 14px;">
										<c:forEach var="userList" items="${userList }">
											<c:if test="${userList.name != memberVO.name }">
												<c:if test="${userList.name != 'Admin'}">
													<option value="${userList.memberNum}">${userList.name }(${userList.memberNum })</option>
												</c:if>
											</c:if>
										</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="sendTitle" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요" style="width: 100%; display: inline-block;" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea class="form-control" rows="10" name="sendContent" placeholder="내용을 입력해주세요" style="resize: none;"></textarea></td>
						</tr>
						<tr>
							<th>파일</th>
							<td>
								<select name="fileCode" id="fileSelect">
									<c:forEach var="fileList" items="${fileList }">
										<option value="${fileList.fileCode }">${fileList.fileName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<button type="submit" class="btn btn-secondary mb-3" id="send_check" style="float: right;">파일 보내기</button>
				</form>
			</aside>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#send_check").click(function() {
			if (confirm("전송하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		})
	});
</script>
</html>
