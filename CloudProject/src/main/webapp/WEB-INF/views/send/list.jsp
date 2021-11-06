<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<html>
<head>
<title>받은 파일함</title>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/send/list" method="post" class="pull-right position" id="searchForm">
				        <div class="input" id="searchDiv">
							<select id="sel" class="custom-select custom-select-lg mb-2">
								<option value="title">메일 제목</option>
								<option value="content">메일 내용</option>
							</select>
				    	</div>
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="sendTitle" class="sr-input" placeholder="메일 제목">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>

				<div class="inbox-body" style="padding: 20px 0px 20px 40px;">
					<div class="mail-option">
						<h3>받은 파일함</h3>
						<table class="table table-inbox table-hover">
							<tbody>
								<tr class="unread">
									<td class="view-message dont-show">보낸사람</td>
									<td class="view-message " style="width:25%;">제목</td>
									<td class="view-message " style="width:25%;">내용</td>
									<td class="view-message ">받은 날짜</td>
									<td class="view-message  text-right">삭제</td>
								</tr>
								
								<c:forEach var="mailList" items="${recivedMail }">
									<tr class="">
										<c:if test="${mailList.readCheck == 'F' }">
											<td class="view-message dont-show">***${mailList.sender}</td>
										</c:if>
										<c:if test="${mailList.readCheck == 'T' }">
											<td class="view-message dont-show">${mailList.sender}</td>
										</c:if>
										<td class="view-message" style="width:25%;"><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
										<td class="view-message" style="width:25%;">${mailList.sendContent}</td>
										<td class="view-message"><fmt:formatDate value="${mailList.sendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td class="view-message text-right"><a href="/send/delete/${mailList.sendNum }" class="delete">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</aside>
		</div>
	</div>
</body>
<script>
 	$("select[id=sel]").change(function(){
 		if($(this).val() == "title"){
 			$("#inputappendDiv").html(
				'<input type="text" class="sr-input" name="sendTitle" placeholder="메일 제목">' +
				'<input type="submit" class="btn sr-btn" value="검색">'
 			);
 			
 		} else if ($(this).val() == "content") {
 			$("#inputappendDiv").html(
				'<input type="text" class="sr-input" name="sendContent" placeholder="메일 내용">' + 
				'<input type="submit" class="btn sr-btn" value="검색">'
 			);
 		}
 	});
 	
	$(".delete").click(function() {
		if (confirm("삭제하시겠습니까?")) {
			return true;
		} else {
			return false;
		}
	});
</script>
</html>
