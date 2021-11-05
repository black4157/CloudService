<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="/css/home.css" rel="stylesheet">
<link rel="stylesheet prefetch" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<div class="container">
		 <div class="mail-box">
			 
		<!-- 메뉴바 -->
	       <aside class="sm-side">
	           <div class="user-head">
	               <a class="inbox-avatar" href="javascript:;">
	                   <img  width="64" hieght="60" src="http://bootsnipp.com/img/avatars/ebeb306fd7ec11ab68cbcaa34282158bd80361a7.jpg">
	               </a>
	               <div class="user-name">
	                   <h5>${sessionScope.memberVO.name }님 반갑습니다.</h5>
	                  
	               </div>
<!--                           <a class="mail-dropdown pull-right" href="javascript:;">
	                              <i class="fa fa-chevron-down"></i>
	                          </a> -->
	           </div>
	           <div class="inbox-body">
	               <a href="#myModal" data-toggle="modal"  title="Compose" class="btn btn-compose">
	                   Compose
	               </a>
	           </div>
	           <ul class="inbox-nav inbox-divider">
	               <li class="active">
	                   <a href="/board/boardList"><i class="fa fa-bookmark-o"></i> 공지사항 보기 </a>
	               </li>
	               <li>
	                   <a href="/upload/personal"><i class="fa fa-inbox"></i> 개인폴더 </a>
	               </li>
	               <li>
	                   <a href="/upload/share"><i class=" fa fa-external-link"></i> 공유폴더</a>
	               </li>
	               <li>
	                   <a href="/send/write"><i class="fa fa-envelope-o"></i> 메일 쓰기 </a>
	               </li>
	               <li>
	                   <a href="/send/list"><i class="fa fa-envelope-o"></i> 받은 메일함 <span class="label label-danger pull-right">2</span></a>
	               </li>
	               <li>
	                   <a href="#"><i class=" fa fa-trash-o"></i> Trash</a>
	               </li>
	           </ul>
	
	           <ul class="nav nav-pills nav-stacked labels-info ">
	               <li> <h4>Buddy online</h4> </li>
	               <li> <a href="#"> <i class=" fa fa-circle text-success"></i>name <p>I do not think</p></a>  </li>
	               <li> <a href="#"> <i class=" fa fa-circle text-danger"></i>name<p>Busy with coding</p></a> </li>
	               <li> <a href="#"> <i class=" fa fa-circle text-muted "></i>name <p>I out of control</p></a>
	               </li><li> <a href="#"> <i class=" fa fa-circle text-muted "></i>name<p>I am not here</p></a>
	               </li><li> <a href="#"> <i class=" fa fa-circle text-muted "></i>name<p>I do not think</p></a>
	               </li>
	           </ul>
	
	           <div class="inbox-body text-center">
	               <div class="btn-group">
	                   <a class="btn mini btn-primary" href="javascript:;">
	                       <i class="fa fa-plus"></i>
	                   </a>
	               </div>
	               <div class="btn-group">
	                   <a class="btn mini btn-success" href="javascript:;">
	                       <i class="fa fa-phone"></i>
	                   </a>
	               </div>
	               <div class="btn-group">
	                   <a class="btn mini btn-info" href="javascript:;">
	                       <i class="fa fa-cog"></i>
	                   </a>
	               </div>
	           </div>
	       </aside>
	       
	       <!-- 본문내용 -->
	       <aside class="lg-side">
	           <div class="inbox-head">
              <!--  <h3>공지사항</h3> -->
	               <form action="#" class="pull-right position">
	                   <div class="input-append">
	                       <input type="text" class="sr-input" placeholder="Search Mail">
	                       <button class="btn sr-btn" type="button"><i class="fa fa-search"></i></button>
	                   </div>
	               </form>
	           </div>
	           <!-- 
	           <div class="inbox-body">
	              <div class="mail-option">		
	                <table class="table table-inbox table-hover">
	                 <tbody>
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
	                   <tr class="">
	                       <td class="inbox-small-cells">
	                           <input type="checkbox" class="mail-checkbox">
	                       </td>
	                       <td class="view-message dont-show">JW Player</td>
	                       <td class="view-message">Last Chance: Upgrade to Pro for </td>
	                       <td class="view-message inbox-small-cells"></td>
	                       <td class="view-message text-right">March 15</td>
	                   </tr>
	                   <tr class="">
	                       <td class="inbox-small-cells">
	                           <input type="checkbox" class="mail-checkbox">
	                       </td>
	                       <td class="view-message dont-show">Tim Reid, S P N</td>
	                       <td class="view-message">Boost Your Website Traffic</td>
	                       <td class="view-message inbox-small-cells"></td>
	                       <td class="view-message text-right">April 01</td>
	                   </tr>
	                   <tr class="">
	                       <td class="inbox-small-cells">
	                           <input type="checkbox" class="mail-checkbox">
	                       </td>
	                       <td class="view-message dont-show">Freelancer.com <span class="label label-danger pull-right">urgent</span></td>
	                       <td class="view-message">Stop wasting your visitors </td>
	                       <td class="view-message inbox-small-cells"></td>
	                       <td class="view-message text-right">May 23</td>
	                   </tr>
	                   
	              	 </tbody>
	               </table> 
	           	</div>
	           </div> 
	      </aside>
	 </div>
</div>-->