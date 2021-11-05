<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
	<jsp:include page = "../include/menu.jsp" />
	<div class="inbox-body">
	<div class="mail-option">	
	<h2>공지사항</h2>	
	<form action="/board/boardList" method="post">
	  <table class="table table-inbox table-hover">
	   <tbody>
	     <tr class="unread">
	         <td class="view-message dont-show">순서</td>
	         <td class="view-message" style="width:25%">제목</td>
	         <td class="view-message" style="width:25%">내용</td>
	         <td class="view-message">작성자</td>
	         <td class="view-message" style="text-align:left">날짜</td>
	     </tr>
	     
	     <c:forEach var="board" items="${boardList}">
		 <tr class="">
		    <td class="view-message dont-show">${board.contentNum }</td>
			<td class="view-message" style="width:25%"><a href='<c:url value="/board/boardReply/${board.contentNum }"/>'>${board.boardTitle }</a></td>
			<td class="view-message" style="width:25%">${board.boardContent }</td>
			<td class="view-message">관리자</td>
			<td class="view-message" style="text-align:left"><fmt:formatDate value="${board.boardDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		</c:forEach>
		</tbody>
	    </table>
	    <select id="sel">
			<option value="title">게시글 제목</option>
			<option value="content">게시글 내용</option>
		</select>
		<div class="input">
			<input type="text" name="boardTitle" placeholder="게시글 제목">
		</div>

		<input type="submit" value="검색">
		</form> 
		</div>
	</div>
<%-- <jsp:include page = "../include/menu.jsp" />
<c:if test="${memberVO.memberNum eq 'S0001'}" >
<a href='<c:url value="/board/boardInsert"/>'>공지사항 쓰기</a>
</c:if>
<table>
<c:forEach var="board" items="${boardList}">
<tr>
<td>${board.contentNum }</td>
<td>${board.boardTitle }</td>
<td>${board.boardContent }</td>
<td>${board.boardDate }</td>
<td><a href='<c:url value="/board/boardReply/${board.contentNum }"/>'>본문보기</a></td>
</tr>
</c:forEach>
</table>
<input type="button" value="뒤로가기" onclick="history.go(-1);"> --%>

</body>
<script>
 	$("select[id=sel]").change(function(){

 		 if($(this).val() == "title"){
 			$(".input").html("");
 			$(".input").html('<input type="text" name="boardTitle" placeholder="게시글 제목">');
 			
 		} else if ($(this).val() == "content") {
 			$(".input").html("");
 			$(".input").html('<input type="text" name="boardContent" placeholder="게시글 내용">');
 		}
 	});
</script>
</html>