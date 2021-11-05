<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" %>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>	
<%@ page session="false"%>

<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>

<body>
<%@ include file= "../include/menu.jsp"%>


<div class="inbox-body">
    <div class="mail-option">	
    <h1>제목 : ${viewMail.sendTitle}</h1>
    	
      <table class="table table-inbox table-hover">
  <!--      <tbody>
         <tr class="unread">
             <td class="inbox-small-cells">
                 <input type="checkbox" class="mail-checkbox">
             </td>
             <td class="view-message  dont-show">순번</td>
             <td class="view-message ">제목</td>
             <td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
             <td class="view-message  text-right">올린시간</td>
         </tr>
         <tr class="unread">
             <td class="inbox-small-cells">
                 <input type="checkbox" class="mail-checkbox">
             </td>
             <td class="view-message dont-show">Google Webmaster </td>
             <td class="view-message">Improve the search presence of WebSite</td>
             <td class="view-message inbox-small-cells"></td>
             <td class="view-message text-right">March 15</td>
         </tr>
    	 </tbody>
     </table> 
 	</div>
 </div>


	<table> -->
		<tr class="unread">
			<td class="view-message"> 보낸이</td>
			<td class="view-message">${viewMail.sender}</td>
		</tr>
		<tr class="unread">
			<td class="view-message">보낸시간</td>
			<td class="view-message"><fmt:formatDate value="${viewMail.sendDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr class="unread">
			<td class="view-message">내용</td>
			<td class="view-message">${viewMail.sendContent}</td>
		</tr>
		
		<tr class="unread">
			<td class="view-message">받은 파일</td>
			<td class="view-message"><a href="<c:url value='/send/view/download/${viewMail.sendNum}' />">${viewMail.fileName}</a></td>
		</tr>
	</table>
</div>
 </div>

</body>
	
</html>

