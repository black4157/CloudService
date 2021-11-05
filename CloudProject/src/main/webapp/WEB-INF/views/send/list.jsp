<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file= "../include/head.jsp"%>

</head>
<body>
<%@ include file= "../include/menu.jsp"%>

	
	<div class="inbox-body">
		              <div class="mail-option">		
		              	<h3>받은 메일함</h3>
		                <table class="table table-inbox table-hover">
		                 <tbody>
		                   <tr class="unread">
		                       <td class="inbox-small-cells">
		                           <input type="checkbox" class="mail-checkbox">
		                       </td>
		                       <td class="view-message dont-show">보낸사람</td>
		                       <td class="view-message ">제목</td>
		                       <td class="view-message ">받은 날짜</td>
		                       <td class="view-message  text-right">삭제</td>
		                   </tr>
		                   
		                   <c:forEach var="mailList" items="${recivedMail }">
		                   <tr class="">
		                       <td class="inbox-small-cells">
		                           <input type="checkbox" class="mail-checkbox">
		                       </td>
		                       <td class="view-message dont-show">${mailList.sender}</td>
		                       <td class="view-message"><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
		                       <td class="view-message">${mailList.sendDate}</td>
		                       <td class="view-message text-right"><a href="/send/delete/${mailList.sendNum }" class="delete">삭제</a></td>
		                   </tr>
		                   </c:forEach>
		                   
						</tbody>
		               </table> 
		               <input type="button" value="뒤로가기" onclick="history.go(-1);">
		           	</div>
		           </div>
<%-- 	<table border="1">
		<tr>
			<th>보낸사람</th>
			<th>제목</th>
			<th>받은 날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="mailList" items="${recivedMail }">
			<tr>
				<td>${mailList.sender}</td>
				<td><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
				<td>${mailList.sendDate}</td>
				<td><a href="/send/delete/${mailList.sendNum }" class="delete">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="뒤로가기" onclick="history.go(-1);"> --%>

</body>
<script>
	$(".delete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		} else{
			return false;
		}
	});
</script>
</html>
