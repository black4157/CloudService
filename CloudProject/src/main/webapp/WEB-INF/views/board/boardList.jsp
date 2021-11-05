<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	  <table class="table table-inbox table-hover">
	   <tbody>
	     <tr class="unread">
	         <td class="view-message dont-show">순서</td>
	         <td class="view-message">제목</td>
	         <td class="view-message">내용</td>
	         <td class="view-message">날짜</td>
	     </tr>
	     
	     <c:forEach var="board" items="${boardList}">
		 <tr class="">
		    <td class="view-message dont-show">${board.contentNum }</td>
			<td class="view-message"><a href='<c:url value="/board/boardReply/${board.contentNum }"/>'>${board.boardTitle }</a></td>
			<td class="view-message">${board.boardContent }</td>
			<td class="view-message">${board.boardDate }</td>
		</tr>
		</c:forEach>
		</tbody>
	    </table> 
		</div>
	</div>
 		      </aside>
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
</html>