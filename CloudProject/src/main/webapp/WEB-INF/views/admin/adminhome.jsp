<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>관리자 홈페이지</title>
</head>
<body>
   <div class="container">
      <div class="mail-box">
  		 <jsp:include page="../include/menu.jsp" />
  		 
  		 <aside class="lg-side">
		    <div class="inbox-head" style="text-align: right; font-size:25px; padding: 10px 25px 10px 10px;">
			    <div class="mail-option" style="margin: 10px 0px 0px 0px"> 
					<span id="dpTime"></span>
				</div>
			</div>
			<div class="inbox-body">
				<div class="mail-option">
					<h2>최신글</h2>
					<table class="table table-inbox table-hover" style="width: 100%;">
						<tr class="unread" style="background:#f7f7f7;">
							<th class="view-message">작성자</th>
							<th class="view-message">작성일</th>
							<th class="view-message">제목</th>
							<th class="view-message">내용</th>
						</tr>
						<c:forEach var="list" items="${selectFive }">
						<tr>
							<td class="view-message">관리자</td>
							<td class="view-message"><fmt:formatDate value="${list.boardDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td class="view-message"><a href="/board/boardReply/${list.contentNum }">${list.boardTitle}</a></td>
							<td class="view-message" style="text-align:left;">${list.boardContent}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</aside>
		</div>
	</div>
</body>

<script type="text/javascript">

    setInterval("dpTime()",1000);
    function dpTime(){
       	var now = new Date();
       	day = now.getDate();
        hours = now.getHours();
        minutes = now.getMinutes();
        seconds = now.getSeconds();
 
        if(day < 10) day = "0" + day;
        
        if (hours > 12){
            hours -= 12;
        ampm = "오후 ";
        }else{
            ampm = "오전 ";
        }
        if (hours < 10){
            hours = "0" + hours;
        }
        if (minutes < 10){
            minutes = "0" + minutes;
        }
        if (seconds < 10){
            seconds = "0" + seconds;
        }
        
		document.getElementById("dpTime").innerHTML = 
			now.getFullYear() + "년 " + now.getMonth() + "월 " + day + "일 " + 
			ampm + hours + ":" + minutes + ":" + seconds;
    }
</script>
 

</html>