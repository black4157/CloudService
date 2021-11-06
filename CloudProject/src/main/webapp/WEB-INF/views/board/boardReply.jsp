<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 확인</title>
<style>
	table tr {
		border-bottom: 1px solid #eee;
	}
	table tr th{
		width: 20%;
	}
	
	table tr td{
		width: 70%;
	}
</style>
</head>
<body style="overflow: visible;">
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page="../include/menu.jsp" />
			
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/send/list" method="post" class="pull-right position" id="searchForm">
				        <div class="input" id="searchDiv">
							<select id="sel" class="custom-select custom-select-lg mb-2">
								<option value="title">메일 제목</option>
								<option value="content">메일 내용</option>
							</select>
				    	</div>
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="sendTitle" class="sr-input" placeholder="메일 제목">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>
				<div class="inbox-body" style="padding: 20px 0px 20px 40px;">
				    <div class="mail-option">	
					    <h1>${viewMail.sendTitle}</h1>
					    <table style="width: 100%; height: 400px;">
							<tr>
								<th class="view-message">작성자</th>
								<td class="view-message">관리자</td>
							</tr>
							<tr>
								<th class="view-message ">작성일</th>
								<td class="view-message"><fmt:formatDate value="${board.boardDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<th class="view-message">제목</th>
								<td class="view-message">${board.boardTitle}</td>
							</tr>
							<tr style="vertical-align: top;">
								<th class="view-message" style="padding-top:40px;">내용</th>
								<td class="view-message" style="height:200px; padding-top:40px;">${board.boardContent}</td>
							</tr>
						</table>
					</div>
				</div>
				<c:if test="${memberVO.memberNum eq 'S0001'}">
					<a href='<c:url value="/board/boardUpdate/${board.contentNum }"/>'>수정하기</a>
					<a href='<c:url value="/board/boardDelete?contentNum=${board.contentNum }"/>'>삭제하기</a>
				</c:if>
				
				<div style="padding: 20px 0px 20px 40px;">
					<c:url var="actionURL" value='/board/boardReply' />
					<form action="${actionURL}" method="post">
						<h4>댓글</h4>
						<textArea rows="2" cols="50" name="comment"></textArea>
						<input type="hidden" name="contentNum" value="${board.contentNum}">
						<input type="submit" value="댓글쓰기"> 
					</form>
				</div>
				
				
				<div style="padding: 20px 0px 20px 40px; height:100%;">
					<table>
						<tr  style="width:90%;">
							<th style="width:15%;">작성자</th>
							<th style="width:60%;">내용</th>
							<th style="width:15%;">작성시간</th>
						</tr>
						<c:forEach var="comment" items="${commentList}">
						<!-- <img src="/img/member.png" width="32"/> -->
							<tr style="width:90%;">
								<td style="width:15%;">${comment.memberNum }</td>
								<td style="width:60%;">${comment.commentContent }</td>
								<td style="width:15%;"><fmt:formatDate value="${comment.commentDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<c:if test="${memberVO.memberNum eq 'S0001'}">
									<td><a href='<c:url value="/board/boardCommentDelete?commentNum=${comment.commentNum }&contentNum=${comment.contentNum }"/>'>삭제</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>
			</aside>
		</div>
	</div>
</body>
</html>