<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
	<%@ include file= "../include/head.jsp"%>
</head>
<body>
	<%@ include file= "../include/menu.jsp"%>
	
	<form action="/send/write" method="post" enctype="multipart/form-data" style="padding: 40px 0px 40px 40px;">
		<div style="width:100%;">
			<input type="text" name="sender" class="form-control mt-4 mb-2" value="${memberVO.name}" readonly style="width:30%; display:inline-block;"/>
			<select name="recipient" class="selectpicker" style="width:30%;">
				<c:forEach var="userList" items="${userList }">
					<c:if test="${userList.name != memberVO.name }">
						<c:if test="${userList.name != 'Admin'}"> 
							<option value="${userList.memberNum }">${userList.name }</option>
						</c:if>
					</c:if>
				</c:forEach>
			</select>
		</div>
	
	
	<div class="form-group">
		<textarea class="form-control" rows="10" name="bdContent"
			placeholder="내용을 입력해주세요" required
		></textarea>
	</div>
	<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
</form>	

		<p>
			받는이 : 
			
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
		<input type="submit" value="전송" class="send_check">
		<input type="reset" value="뒤로가기" onclick="history.go(-1);">

</body>

<script type="text/javascript">
$(document).ready(function(){
	$(".send_check").click(function(){
		if(confirm("전송하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
});

$('.selectpicker').selectpicker();
$('.selectpicker').selectpicker({
    style: 'btn-info',
    size: 4
});
</script>
</html>
