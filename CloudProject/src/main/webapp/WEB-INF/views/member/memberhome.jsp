<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>클라우드 서비스</title>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			
			<!-- 본문내용 -->
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="#" method="post" class="pull-right position" id="searchForm">
				    	<div class="input" id="searchDiv">
				    		<select id="sel" class="custom-select custom-select-lg mb-2">
								<option value="title">게시글 제목</option>
								<option value="content">게시글 내용</option>
							</select>
				    	</div>
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="boardTitle" class="sr-input" placeholder="게시글 제목">
				            <button type="button" class="btn sr-btn" id="searchBtn"><i class="fa fa-search"></i></button>
				        </div>
				    </form>
				</div>
			</aside>
		</div>
	</div>
</body>
</html>