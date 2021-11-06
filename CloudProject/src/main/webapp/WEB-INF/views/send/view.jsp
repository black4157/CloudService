<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" %>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>	
<%@ page session="false"%>

<html>
<head>
<title>받은 파일 확인</title>
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

<body>
	<div class="container">
		<div class="mail-box">
			 
		<jsp:include page = "../include/menu.jsp" />
		
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
				    <table style="width: 100%; height: 300px;">
						<tr>
							<th class="view-message">보낸이</th>
							<td class="view-message">${viewMail.sender}</td>
						</tr>
						<tr>
							<th class="view-message ">받은 날짜</th>
							<td class="view-message"><fmt:formatDate value="${viewMail.sendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
						<tr>
							<th class="view-message">내용</th>
							<td class="view-message">${viewMail.sendContent}</td>
						</tr>
						<tr>
							<th class="view-message">파일</th>
							<td class="view-message"><a href="<c:url value='/send/view/download/${viewMail.sendNum}' />">${viewMail.fileName}</a></td>
						</tr>
					</table>
				</div>
			</div>
			</aside>
		</div>
	</div>
</body>
	
</html>