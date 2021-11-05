<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file="../include/head.jsp"%>

</head>
<body>
	<%@ include file="../include/menu.jsp"%>

	<div class="inbox-body">
		<div class="mail-option">
			<h3>받은 메일함</h3>
			<form action="/send/list" method="post">
				<table class="table table-inbox table-hover">
					<tbody>
						<tr class="unread">
							<td class="view-message dont-show">보낸사람</td>
							<td class="view-message " style="width:25%;">제목</td>
							<td class="view-message ">받은 날짜</td>
							<td class="view-message  text-right">삭제</td>
						</tr>

						<c:forEach var="mailList" items="${recivedMail }">
							<tr class="">
								<td class="view-message dont-show">${mailList.sender}</td>
								<td class="view-message" style="width:25%;"><a href="/send/view/${mailList.sendNum}">${mailList.sendTitle}</a></td>
								<td class="view-message"><fmt:formatDate value="${mailList.sendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="view-message text-right"><a href="/send/delete/${mailList.sendNum }" class="delete">삭제</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<select id="sel">
					<option value="title">메일 제목</option>
					<option value="content">메일 내용</option>
				</select>
				<div class="input">
					<input type="text" name="sendTitle" placeholder="메일 제목">
				</div>
				<input type="submit" value="검색"> <input type="button"
					value="뒤로가기" onclick="history.go(-1);">
			</form>
		</div>
	</div>
</body>
<script>
	$("select[id=sel]").change(function() {
		if ($(this).val() == "title") {
			$(".input").html("");
			$(".input").html('<input type="text" name="sendTitle" placeholder="메일 제목">');
		} else if ($(this).val() == "content") {
			$(".input").html("");
			$(".input").html('<input type="text" name="sendContent" placeholder="메일 내용">');
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
