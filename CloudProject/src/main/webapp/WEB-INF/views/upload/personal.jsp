<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="UTF-8">
<html>
<head>
<title>개인 폴더</title>
<style>
.input-select-wrap{transform:translateY(-50%);height:70px;line-height:70px;margin-top:60px;transition:.3s all ease-out; display:inline-block;}
#fileSelect{color:transparent;position:relative;width:100%;height:100%;margin:0 auto;display:block;cursor:pointer}
.fileUpload p,.fileUpload span{display:inline-block;vertical-align:middle;transition:.3s all ease-out}
.fileUpload span{background:#f95536}
#fileSelect::-webkit-file-upload-button{visibility:hidden}
.fileUpload{position:absolute;width:100%;height:100%}
.fileUpload span{opacity:.8;height:40px;width:40px;line-height:40px;color:#fff;text-align:center;border-radius:50%;font-size:24px;margin-right:10px}
.fileUpload p{font-weight:400;line-height:30px;height:30px;font-size:18px}
.fileUpload p:after{content:"Add up to 100MB";display:block;height:0;font-weight:400;text-align:left;color:#999;line-height:10px;font-size:14px;margin-top:5px;opacity:0;transition:.3s all ease-out;transform:translateY(-18px)}
.input-select-wrap:hover .fileUpload p:after{opacity:1;height:10px;transform:translateY(0)}
.input-select-wrap:hover .fileUpload p{height:50px}
.input-select-wrap:hover .fileUpload span{opacity:1}
</style>
</head>
<body>
	<div class="container">
		<div class="mail-box">
			 
			<jsp:include page = "../include/menu.jsp" />
			<aside class="lg-side">
			    <div class="inbox-head">
				    <form action="/upload/personal" method="post" class="pull-right position" id="searchForm">
				        <div class="input-append" id="inputappendDiv">
				            <input type="text" name="fileName" class="sr-input" placeholder="파일이름 검색">
				            <input type="submit" class="btn sr-btn" value="검색">
				        </div>
				    </form>
				</div>
				 <div class="inbox-body">
					<div class="mail-option">	
						<h2 style="display:inline-block;">개인 폴더</h2>	
						<input type="button" value="공유하기" id="share_check" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
						<c:url var="actionURL" value="/upload/movetoshare"/>
						<form action="${actionURL}" method="post" enctype="multipart/form-data" class="form-horizontal" id="shareForm">
							<table class="table table-inbox table-hover">
								<tbody>
							     <tr class="unread">
							     	<td class="inbox-small-cells"></td>
									<td class="view-message ">파일이름</td>
									<td class="view-message ">파일 설명</td>
									<td class="view-message ">업로드 날짜</td>
									<td class="view-message ">삭제</td>
								</tr>
								<c:forEach var="personalFile" items="${personalFile}">
								<tr class="">
									<td class="inbox-small-cells">
			                        	<input type="checkbox" class="mail-checkbox" value="${personalFile.fileCode}" name="fileCode">
			                        </td>
									<td class="view-message "><a href="<c:url value='/download/${personalFile.fileCode }'/>">${personalFile.fileName}</a></td>
									<td class="view-message ">${personalFile.fileExplanation}</td>
									<td class="view-message "><fmt:formatDate value="${personalFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td class="view-message "><a href="<c:url value='/upload/delete/${personalFile.fileCode}'/>" class = "delete">삭제</a>
								</tr>
								</c:forEach>
								</tbody>
							</table>
						</form>
						<hr class="my-2" style="border-top: 2px solid #eee">
						<form action="/upload/upload" method="post" enctype="multipart/form-data">
							<div class="input-select-wrap">
							    <div class="fileUpload">
									<span>+</span><p>Add your files</p>
							    </div>
							    <input type='file' id="fileSelect" name="file">
							</div>
							<div id="result" style="display: inline-block; vertical-align: top; margin-top:30px;"></div>
							<div>
								<input type="text" name="text1" placeholder="파일 설명">
								<input type="submit" value="파일업로드" class="upload_check">
							</div>
						</form>
					</div>
				</div>
			</aside>
		</div>
	</div>
</body>

<script>
$(document).ready(function(){
	$("#share_check").click(function(){
		$("#shareForm").submit();
		alert("공유 완료했습니다.");
	});
	
	$(".upload_check").click(function(){
		if(!$("input[name=file]").val()){
			alert("파일을 올려주세요.");
			return false;
		}
	});
	
	$("#fileSelect").change(function(){
		var files = $("input[name='file']")[0].files;
		console.log(files[0].name);
		$("#result").html('<h6>' + files[0].name + '</h6>');
	});
});

</script>
</html>
