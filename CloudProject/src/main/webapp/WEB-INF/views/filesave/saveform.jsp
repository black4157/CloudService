<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 저장</title>
</head>
<body>
<c:url var="actionURL" value='/upload/new'/>
<form action="${actionURL}" method="post" enctype="multipart/form-data">
	<select name="dir">
		<option value="/private">/개인자료
		<option value="/public">/공유자료
	</select>
	<input type="file" name="file">
	<input type="submit" name="save">
	<input type="reset" name="cancel">
</form>
</body>
</html>