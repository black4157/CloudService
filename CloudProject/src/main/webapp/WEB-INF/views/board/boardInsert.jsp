<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 추가</title>
</head>
<body>

<c:url var= "actionURL" value='/board/boardInsert' />
<form action ="${actionURL}" method="post">
번호 <input type= "text" name = "num" id = "num"><br>
제목 <input type= "text" name = "boardTitle" id = "boardTitle"><br>
내용<input type= "text" name = "boardContent" id = "boardContent"><br>
<input type="submit" value="등록">
</form>

</body>
</html>