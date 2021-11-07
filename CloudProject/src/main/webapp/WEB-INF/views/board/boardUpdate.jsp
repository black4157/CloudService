<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 수정</title>
</head>
<body>
<div class="container">
		<div class="mail-box">
			<jsp:include page="../include/menu.jsp" />
			<aside class="lg-side">
				<div class="inbox-head">
					<form action="/board/boardList" method="post"
						class="pull-right position" id="searchForm">
						<div class="input" id="searchDiv">
							<select id="sel" class="custom-select custom-select-lg mb-2">
								<option value="title">게시글 제목</option>
								<option value="content">게시글 내용</option>
							</select>
						</div>
						<div class="input-append" id="inputappendDiv">
							<input type="text" name="boardTitle" class="sr-input"
								placeholder="게시글 제목"> <input type="submit"
								class="btn sr-btn" value="검색">
						</div>
					</form>
				</div>
				<div class="inbox-body">
					<div class="mail-option">
						<h2 style="display: inline-block;">공지사항 작성</h2>
						<c:url var="actionURL" value='/board/boardUpdate' />
						<form action="${actionURL}" method="post" id="updateForm">
							<table class="table table-inbox table-hover">
								<tbody>
									<tr>
										<td class="view-message ">제목</td>
										<td class="view-message "><textArea rows="1" cols="100" name="boardTitle" id="boardTitle" style="resize: none;">${board.boardTitle} </textArea></td>
									</tr>
									<tr>
										<td class="view-message ">내용</td>
										<td class="view-message ">
											<textArea rows="10" cols="100" name="boardContent" id="boardContent" style="resize: none;">${board.boardContent} </textArea>
										</td>
									</tr>
								</tbody>
							</table>
							<input type="hidden" name="boardcontentNum" id="boardcontentNum" value="${board.contentNum}"> 
							<input type="button" value="수정" class="btn btn-compose" id="update_check" style="margin-top: 20px; width: 10%; float: right; height: 30px; padding: 0;">
						</form>
					</div>
				</div>
			</aside>
		</div>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$("#update_check").click(function(){
		if(confirm("수정하시겠습니까?")){
			$("#updateForm").submit();
			return true;
		} else {
			return false;
		}
	})
});
</script>
</html>