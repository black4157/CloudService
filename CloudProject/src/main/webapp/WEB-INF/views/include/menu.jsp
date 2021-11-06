<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="/css/home.css" rel="stylesheet">
<link rel="stylesheet prefetch" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- 메뉴바 -->
<aside class="sm-side">
    <div class="user-head">
        <a class="inbox-avatar" href="javascript:;">
            <img src="/img/member.png" width="64" height="64">
        </a>
        <div class="user-name">
            <h5>${memberVO.name }님 반갑습니다.</h5>
       </div>
   </div>
   <div class="inbox-body">
       <a href="/logout" class="btn btn-compose">로그아웃</a>
   </div>
   <ul class="inbox-nav inbox-divider">
      <li>
         <c:if test="${memberVO.memberNum == 'S0001' }">
            <a href=/adminhome><i class="fa fa-home"></i> 홈 </a>
         </c:if>
         <c:if test="${memberVO.memberNum != 'S0001' }">
            <a href=/memberhome><i class="fa fa-home"></i> 홈 </a>
         </c:if>
       </li>
       <li>
           <a href="/board/boardList"><i class="fa fa-bookmark-o"></i> 공지사항 보기 </a>
       </li>
       <li>
           <a href="/upload/personal"><i class="fa fa-inbox"></i> 개인폴더 </a>
       </li>
       <li>
           <a href="/upload/share"><i class=" fa fa-external-link"></i> 공유폴더 </a>
       </li>
       <li>
           <a href="/send/write"><i class="fa fa-envelope-o"></i> 파일 보내기 </a>
       </li>
       <li>
           <a href="/send/list"><i class="fa fa-envelope-o"></i> 받은 메일함 <span class="label label-danger pull-right">2</span></a>
       </li>
       <c:if test="${memberVO.memberNum == 'S0001' }">
       <li>
           <a href="/list"><i class="fa fa-envelope-o"></i> 사원 관리 <span class="label label-danger pull-right">2</span></a>
       </li>
       </c:if>
       <li>
           <a href="#"><i class=" fa fa-trash-o"></i> Trash</a>
       </li>
   </ul>
   
   <ul class="nav nav-pills nav-stacked labels-info" style="display: block; margin-top: 50px;">
      <li style="text-align:center;"><h4>소중한 팀원들</h4></li>
       <li> <a href="#"> <i class=" fa fa-circle text-success"></i>김주성</a></li>
       <li> <a href="#"> <i class=" fa fa-circle text-success"></i>김동영</a></li>
       <li> <a href="#"> <i class=" fa fa-circle text-success "></i>박주희 </a></li>
       <li> <a href="#"> <i class=" fa fa-circle text-success "></i>임윤정</a></li>
       <li> <a href="#"> <i class=" fa fa-circle text-success "></i>신동현</a></li>   
   </ul>
</aside>