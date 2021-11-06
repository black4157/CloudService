<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			</aside>
		</div>
	</div>
</body>
</html>