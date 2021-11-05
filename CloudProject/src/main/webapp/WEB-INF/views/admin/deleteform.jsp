<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
<jsp:include page= "../include/menu.jsp">
<h1>사원 삭제</h1>
<form action="/delete/${memberVO.memberNum}" method="post">
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td>${memberVO.memberNum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${memberVO.name }</td>
		</tr>	
		<tr>
			<th>직급</th>
			<td>${memberVO.position }</td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${memberVO.department }</td>
		</tr>
		<tr>
			<th>퇴사 승인</th>
			<td><input type="text" name="retire" value="T" readonly></td>
		</tr>
	</table>
	<input type="submit" value="퇴사 승인" class="delete_check"> 
	<input type="reset" value="취소">
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</form>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$(".delete_check").click(function(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});

</script>
</html>