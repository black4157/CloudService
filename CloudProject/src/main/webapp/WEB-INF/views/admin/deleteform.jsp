<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 삭제</title>
</head>
<body>
	<div class="container">
	   <div class="mail-box">
		 <jsp:include page="../include/menu.jsp" />
		 <aside class="lg-side">
             <div class="inbox-head">
                <form action="/list" method="post" class="pull-right position" id="searchForm">
                    <div class="input-append" id="inputappendDiv">
                        <input type="text" name="name" class="sr-input" placeholder="사원이름 검색">
                        <input type="submit" class="btn sr-btn" value="검색">
                    </div>
                </form>
            </div>
             <div class="inbox-body">
               <div class="mail-option">   
                <form action="/delete/${member.memberNum}" method="post" id="deleteForm">
                  <h2 style="display:inline-block;">사원 삭제</h2>   
                     <table class="table table-inbox table-hover">
                        <tbody>
                          <tr class="unread">
                            <td class="view-message ">사원번호</td>
							<td class="view-message ">${member.memberNum}</td>
                          </tr>
                         <tr class="unread">
                            <td class="view-message ">이름</td>
							<td class="view-message ">${member.name}</td>
                         </tr>
                         <tr class="unread">
                            <td class="view-message ">직급</td>
							<td class="view-message ">${member.position}</td>
                         </tr>
                         <tr class="unread">
                            <td class="view-message ">부서</td>
							<td class="view-message ">${member.department}</td>
                         </tr>
                        <tr class="unread">
                            <td class="view-message ">퇴사 승인</td>
							<td><input type="text" name="retire" value="T" readonly></td>
                         </tr>
                        </tbody>
                     </table>
                     </form>
	               </div>
	            </div>
	          <input type="button" value="뒤로가기" id="back" onclick="history.go(-1);" class="btn btn-compose" style="margin-top: -10px; margin-left: 20px; width: 10%; float:left; height: 30px; padding: 0;">
	          <input type="button" value="퇴사 승인" id="sign" class="btn btn-compose" style="margin-top: -10px; margin-right: 20px; width: 10%; float:right; height: 30px; padding: 0;">
         </aside>
	   </div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#sign").click(function(){
		if(confirm("삭제하시겠습니까?")){
			$("#deleteForm").submit();
			return true;
		} else {
			return false;
		}
	})
}); 
</script>
</html>