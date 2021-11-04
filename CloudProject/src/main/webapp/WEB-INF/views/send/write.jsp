<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file= "../headBack.jsp"%>
</head>
<body>
<%@ include file= "../up.jsp"%>
	<form action="/send/write" method="post" enctype="multipart/form-data">
		<%-- <input type="text" name="send" value="${memberVO.name }" readonly> --%>
		<p>
			보낸이 : <input type="text" name="sender" readonly value="${memberVO.memberNum}" />
		</p>
		<p>
			받는이 : 
			<select name="recipient">
				<c:forEach var="userList" items="${userList }">
					<c:if test="${userList.name != memberVO.name }">
						<c:if test="${userList.name != 'Admin'}"> 
							<option value="${userList.memberNum }">${userList.name }</option>
						</c:if>
					</c:if>
					
				</c:forEach>
			</select>
		</p>
		
		<p> 제목 : 
			<input type="text" name="sendTitle" />
		</p>
		<p>
		
			파일 : 
			<select name="fileCode">
				<c:forEach var="fileList" items="${fileList }">
					<option value="${fileList.fileCode }">${fileList.fileName }</option>
				</c:forEach>
			</select>

		</p>
		<p>
			설명
			<textarea name="sendContent" rows="5" cols="100"></textarea>
		</p>
		<input type="submit" value="전송">
		<input type="reset" value="뒤로가기" onclick="history.go(-1);">
	</form>
<%@ include file= "../down.jsp"%>
</body>
</html>
