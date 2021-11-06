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
				<div class="inbox-body">
				    <div class="mail-option">	
					    <h1>${viewMail.sendTitle}</h1>
					    <table style="width: 100%; height: 500px;">
						<tr>
							<th class="view-message">보낸이</th>
							<td class="view-message"><input type="text" name="sender" class="form-control mt-4 mb-2" value="${viewMail.sender}" readonly style="width: 30%;"></td>
						</tr>
						<tr>
							<th class="view-message">받는이</th>
							<td class="view-message"><input type="text" name="recipient" class="form-control mt-4 mb-2" value="${viewMail.recipient}" readonly style="width: 30%;"></td>
						</tr>
						<tr>
							<th class="view-message">제목</th>
							<td class="view-message"><input type="text" name="sendTitle" class="form-control mt-4 mb-2" style="width: 100%; display: inline-block;" /></td>
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