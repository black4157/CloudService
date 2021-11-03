<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<form action="/send/write" method="post" enctype="multipart/form-data">
		<%-- <input type="text" name="send" value="${memberVO.name }" readonly> --%>
		<p>
			보낸이 : <input type="text" name="sender" />
		</p>
		<p>
			받는이 : <input type="text" name="recipient" />
		</p>

		<p>
			파일 : 
			<datalist>
				<c:forEach var="List" items="${fileList }">
					<option>${List.fileName}</option>
				</c:forEach>
			</datalist>

		</p>
		<p>
			설명
			<textarea name="sendcontent" rows="5" cols="100"></textarea>
		</p>
		<input type="submit" value="전송">
	</form>

</body>
</html>
