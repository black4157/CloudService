<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항</title>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			
			<!-- 본문내용 -->
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/board/boardList" method="post" class="pull-right position" id="searchForm">
				    	<div class="input" id="searchDiv">
				    		<select id="sel" class="custom-select custom-select-lg mb-2">
								<option value="title">게시글 제목</option>
								<option value="content">게시글 내용</option>
							</select>
				    	</div>
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="boardTitle" class="sr-input" placeholder="게시글 제목">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>
				<div class="inbox-body">
					<div class="mail-option">	
						<h2 style="display: inline-block;">공지사항</h2>	
						<c:if test="${memberVO.memberNum == 'S0001' }">
							<input type="button" value="공지사항 작성" id="share_check" class="btn btn-compose" onclick="location.href='/board/boardInsert'" style="margin-top: 20px; width: 15%; float:right; height: 30px; padding: 0;">
						</c:if>
						<table class="table table-inbox table-hover">
							<tbody>
							    <tr class="unread">
							        <td class="view-message dont-show">순서</td>
							        <td class="view-message" style="width:25%">제목</td>
							        <td class="view-message" style="width:25%">내용</td>
							        <td class="view-message">작성자</td>
							        <td class="view-message" style="text-align:left">날짜</td>
							    </tr>
							    <c:if test="${boardList == null }">
							    	<td>${msg }</td>
							    </c:if>
							    <c:forEach var="board" items="${boardList}">
								<tr class="">
									<td class="view-message dont-show">${board.contentNum }</td>
									<td class="view-message" style="width:25%"><a href="/board/boardReply/${board.contentNum }">${board.boardTitle }</a></td>
									<td class="view-message" style="width:25%">${board.boardContent }</td>
									<td class="view-message">관리자</td>
									<td class="view-message" style="text-align:left"><fmt:formatDate value="${board.boardDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
				'<input type="text" class="sr-input" name="boardTitle" placeholder="게시글 제목">' +
				'<input type="submit" class="btn sr-btn" value="검색">'
 			);
 			
 		} else if ($(this).val() == "content") {
 			$("#inputappendDiv").html(
				'<input type="text" class="sr-input" name="boardContent" placeholder="게시글 내용">' + 
				'<input type="submit" class="btn sr-btn" value="검색">'
 			);
 		}
 	});
</script>
</html>