<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 정보</title>
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
                  <h2 style="display:inline-block;">사원 상세 정보 조회</h2>   
                     <table class="table table-inbox table-hover">
                        <tbody>
                          <tr class="unread">
                           <td class="view-message ">사원정보</td>
                           <td class="view-message ">${member.memberNum}</td>
                       	  </tr>
                       	  <tr class="unread">
                           <td class="view-message ">이름</td>
                           <td class="view-message ">${member.name}</td>
                       	  </tr>
                       	  <tr class="unread">
                           <td class="view-message ">전화번호</td>
                           <td class="view-message ">${member.phone}</td>
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
                           <td class="view-message ">권한</td>
                           <td class="view-message ">${member.memberAuth}</td>
                       	  </tr>
                        </tbody>
                     </table>
               </div>
            </div>
            <input type="button" value="삭제" onclick="location.href='/delete/${member.memberNum}'" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
            <input type="button" value="수정" onclick="location.href='/update/${member.memberNum}'" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
         </aside>
      </div>
	</div>
</body>
</html>