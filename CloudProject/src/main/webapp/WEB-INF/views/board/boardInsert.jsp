<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 작성</title>
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
						<form action="${actionURL}" method="post">
							<table class="table table-inbox table-hover">
								<tbody>
									<tr>
										<td class="view-message ">제목</td>
										<td class="view-message "><textArea rows="1" cols="100"
												name="boardTitle" id="boardTitle" style="resize: none;"></textArea></td>
									</tr>
									<tr>
										<td class="view-message ">내용</td>
										<td class="view-message "><textArea rows="10" cols="100"
												name="boardContent" id="boardContent" style="resize: none;"> </textArea></td>
									</tr>
								</tbody>
							</table>
							<input type="submit" value="등록" class="btn btn-compose"
								style="margin-top: 20px; width: 10%; float: right; height: 30px; padding: 0;">
						</form>
					</div>
				</div>
			</aside>
		</div>
	</div>
</body>
</html>