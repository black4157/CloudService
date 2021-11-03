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
	<form action="/signup" method="post">
		<table>
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
				<td>
					<select name="position">
						<option value="S1">부장</option>
						<option value="S2">차장</option>
						<option value="S3">과장</option>
						<option value="S4">대리</option>
						<option value="S5">사원</option>
						<option value="S6">인턴</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
					<select name="department">
						<option>개발</option>
						<option>영업</option>
						<option>마케팅</option>
						<option>인사</option>
						<option>기획</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>권한</td>
				<td><select name="memberAuth">
						<option>A</option>
						<option>B</option>
						<option>C</option>
					</select>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="저장"> 
		<input type="reset" value="취소">
	</form> 
</body>
</html>