<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>사원 리스트</title>
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
                  <h2 style="display:inline-block;">사원 관리</h2>   
                  <input type="button" value="사원 추가" onclick="location.href='/signup'" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
                     <table class="table table-inbox table-hover">
                        <tbody>
                          <tr class="unread">
                           <td class="view-message ">사원번호</td>
                           <td class="view-message ">이름</td>
                           <td class="view-message ">전화번호</td>
                           <td class="view-message ">직급</td>
                           <td class="view-message ">부서</td>
                        </tr>
                        <c:forEach var="member" items="${memberList}">
                        <tr class="">
                           <td class="view-message "><a href="/info/${member.memberNum}">${member.memberNum}</a></td>
                           <td class="view-message ">${member.name}</td>
                           <td class="view-message ">${member.phone}</td>
                           <td class="view-message ">${member.position}</td>
                           <td class="view-message ">${member.department}</td>
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
$(document).ready(function(){
   $("#add_person").click(function(){
      $("#shareForm").submit();
   });
});
</script>
</html>