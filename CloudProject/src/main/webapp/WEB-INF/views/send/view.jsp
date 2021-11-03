<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	${viewMail[0].send_num}
	${viewMail[0].sender}
	${viewMail[0].recipient}
	${viewMail[0].file_name}
	${viewMail[0].file_content}

	

</body>
</html>
