<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<h1>사원 정보 수정</h1>
<form action="/update/${memberVO.memberNum}" method="post">





<table border="1">
<tr>
<td>사원번호</td>
<td>${memberVO.memberNum}</td>
</tr>
<tr>
<td>수정할 사원번호</td>
<td><input type="text" name="memberNum" value="${memberVO.memberNum}" readonly></td>
</tr>
<tr>
<td>비밀번호</td>
<td>${memberVO.pwd}</td>
</tr>
<tr>
<td>수정할 비밀번호</td>
<td><input type="text" name="pwd" value="${memberVO.pwd }"></td>
</tr>
<tr>
			<td>이름</td>
			<td>${memberVO.name}</td>
		</tr>
<tr>
			<td>수정할 이름</td>
			<td><input type="text" name="name" value="${memberVO.name }"></td>
		</tr>

<tr>
			<td>전화번호</td>
			<td>${memberVO.phone}</td>
		</tr>
<tr>
			<td>수정할 전화번호</td>
			<td><input type="text" name="phone" value="${memberVO.phone }"></td>
		</tr>
<tr>
			<td>직급</td>
			<td>${memberVO.position}</td>
		</tr>
<tr>
			<td>수정할 직급</td>
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
			<td>${memberVO.department}</td>
		</tr>
		<tr>
			<td>수정할 부서</td>
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
			<td>${memberVO.memberAuth}</td>		
		</tr>
		<tr>
			<td>수정할 권한</td>
			<td><select name="memberAuth">
					<option>A</option>
					<option>B</option>
					<option>C</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>퇴사 여부</td>
			<td>${memberVO.retire}</td>		
		</tr>
		<tr>
			<td>수정할 퇴사 여부</th>
			<td><select name="retire">
					<option>F</option>
					<option>T</option>
				</select>
			</td>
		</tr>
</table>
	
	<input type="submit" value="수정"> 
	<input type="reset" value="취소">
</form>
</body>
</html>