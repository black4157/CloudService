<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 입력</title>
</head>
<body>
	<h1>사원 정보 입력</h1>
	<form action="insert" method="post">
		<table>
			<tr>
				<td>사원번호</td>
				<td><input type="text" name="memberNums"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>직급</td>
				<td><input type="text" name="position"></td>
			</tr>
			<tr>
				<td>부서</td>
				<td><input type="text" name="department"></td>
			</tr>
		</table>
		
		<input type="submit" value="저장"> 
		<input type="reset" value="취소">
	</form> 
</body>
</html>