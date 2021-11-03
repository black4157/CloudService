<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
</head>
<body>
<h1>사원 정보 수정</h1>
	<form action="update" method="post">
		<table>
			<tr>
				<th>사원번호</th>
				<td><input type="text" name="memberNum" value="${member.memberNum}" readonly></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${member.name}" readonly></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" value="${member.phone}"></td>
			</tr>
			<tr>
				<th>직급</th>
				<td><input type="text" name="position" value="${member.position}"></td>
			</tr>
			<tr>
				<th>부서</th>
				<td><input type="text" name="department" value="${member.department}"></td>
			</tr>
		</table>
		
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>