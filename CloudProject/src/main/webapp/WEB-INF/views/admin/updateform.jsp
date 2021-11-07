<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 변경</title>
</head>
<body style="overflow: visible;">
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
               	     <form action="/update/${member.memberNum}" method="post" class="update">   
                  <h2 style="display:inline-block;">사원 번호</h2>   
                     <table class="table table-inbox table-hover">
                        <tbody>
                          <tr class="unread">
                            <td class="view-message ">사원번호</td>
							<td class="view-message ">${member.memberNum}</td>
							<td></td>
							<td></td>
                          </tr>
                         <tr class="unread">
                          <td class="view-message ">수정할 사원번호</td>
						  <td class="view-message "><input type="text" name="memberNum" value="${member.memberNum}" readonly></td>
						  <td></td>
						  <td></td>
                         </tr>
                         <tr class="unread">
                            <td class="view-message ">비밀번호</td>
							<td class="view-message ">${member.pwd}</td>
							<td></td>
							<td></td>
                         </tr>
                         <tr class="unread">
                            <td class="view-message ">수정할 비밀번호</td>
							<td class="view-message "><input type="password" name="pwd" value="${member.pwd }"  id="pwd" required></td>
							<td class="view-message "><div id="pwd_check"></div></td>
							<td></td>
                         </tr>
                         <tr class="unread">
                            <td class="view-message ">수정할 비밀번호 확인</td>
							<td class="view-message "><input type="password" name="pwd2" value="${member.pwd }" id="pwd2"></td>
							<td class="view-message "><div id="pwd2_check"></div></td>
							<td></td>
                         </tr>
                         <tr class="unread">
							<td class="view-message ">이름</td>
							<td class="view-message ">${member.name}</td>
							<td></td>
							<td></td>
					  	 </tr>
					  	 <tr class="unread">
							<td class="view-message ">수정할 이름</td>
							<td class="view-message "><input type="text" name="name" value="${member.name }" required></td>
							<td></td>
							<td></td>
					 	 </tr>
					 	 <tr class="unread">
							<td class="view-message ">전화번호</td>
							<td class="view-message ">${member.phone}</td>
							<td></td>
							<td></td>
						 </tr>
						 <tr class="unread">
							<td class="view-message ">수정할 전화번호</td>
							<td class="view-message "><input type="text" name="phone" value="${member.phone }" id="phone" required></td>
							<td class="view-message "><div id="phone_check"></div></td>
							<td></td>
				 		 </tr>
				 		 <tr class="unread">
							<td class="view-message ">직급</td>
							<td class="view-message ">${member.position}</td>
							<td></td>
							<td></td>
						</tr>
                        <tr class="unread">
							<td class="view-message ">수정할 직급</td>
							<td class="view-message "><select name="position" required>
									<option value="S1">부장</option>
									<option value="S2">차장</option>
									<option value="S3">과장</option>
									<option value="S4">대리</option>
									<option value="S5" selected>사원</option>
									<option value="S6">인턴</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">부서</td>
							<td class="view-message ">${member.department}</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">수정할 부서</td>
							<td class="view-message "><select name="department" required>
									<option>개발</option>
									<option>영업</option>
									<option>마케팅</option>
									<option>인사</option>
									<option>기획</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">권한</td>
							<td class="view-message ">${member.memberAuth}</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">수정할 권한</td>
							<td class="view-message "><select name="memberAuth" required>
									<option>A</option>
									<option selected>B</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">퇴사 여부</td>
							<td class="view-message ">${member.retire}</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="unread">
							<td class="view-message ">수정할 퇴사 여부</td>
							<td class="view-message "><select name="retire" required>
									<option>T</option>
									<option selected>F</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
                        </tbody>
                     </table>
                   </form>
               </div>
            </div>
          <input type="button" value="저장" id="save" class="btn btn-compose" style="margin-top: -10px; margin-right: 20px; width: 10%; float:right; height: 30px; padding: 0;">
          <input type="button" value="뒤로가기" id="back" onclick="history.go(-1);" class="btn btn-compose" style="margin-top: -10px; margin-left: 20px; width: 10%; float:left; height: 30px; padding: 0;">
         </aside>
	   </div>
	</div>
</body>
<script>
/*
	<input type="button" value="수정" class="btn"> 
	<input type="reset" value="취소">
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</form> */

	var pwdR = /^[A-Za-z0-9]{8,20}/;
	var phoneR = /^01([0|1|6|7|8|9]?)?-([0-9]{4})-([0-9]{4})$/;
	var phoneN = /^[A-Za-z | ㄱ-ㅎ | ㅏ-ㅣ | 가-힣 ]{1}/;
	
	var check_arr = new Array(3).fill(false);
	var validAll = true;
	
	// 비밀번호 정규식 체크
	$('#pwd').blur(function(){
		if(pwdR.test($('#pwd').val())){
			$('#pwd').css('color', 'black');
			console.log('비밀번호 정규식 만족');
			check_arr[0] = true;
		}
		else{
			$('#pwd').css('color', 'red');
			console.log('비밀번호 정규식 불일치');
			$('#pwd_check').text('비밀번호는 8~20자리의 문자, 숫자만 허용됩니다.').css('font-size', '10px');
			check_arr[0] = false;
		}
	});
	
	// 비밀번호 일치 체크
	$('#pwd2').blur(function(){
		if($('#pwd').val() != $(this).val()){
			$('#pwd2').css('color', 'red');
			console.log('비밀번호 불일치');
			$('#pwd2_check').text('비밀번호가 일치하지 않습니다.').css('font-size', '10px');
			check_arr[1] = false;
		}
		else{
			$('#pwd2').css('color', 'black');
			console.log('비밀번호 일치');
			$('#pwd2_check').text('비밀번호가 일치합니다.').css('font-size', '10px');
			check_arr[1] = true;
		}
	});
	
	// 전화번호 숫자만 허용
	$("#phone").keyup(function(){numCheck($(this));});
	
    function numCheck(selector){
        var tempVal = selector.val();
        selector.val(tempVal.replace(phoneN,""));
     }
	
	// 전화번호 정규식 체크
	$('#phone').blur(function(){
		if(phoneR.test($(this).val())){
			$('#phone').css('color', 'black');
			console.log('전화번호 정규식 만족');
			check_arr[2] = true;
		}
		else{
			$('#phone').css('color', 'red');
			console.log('전화번호 정규식 불일치');
			$('#phone_check').text('전화번호는 01x-xxxx-xxxx 형식으로 작성해주세요.').css('font-size', '10px');
			check_arr[2] = false;
		}
	});

	$("#save").click(function(){
		for(var i = 0; i < check_arr.length; i++){
			if(check_arr[i] == false){
				validAll = false;
				console.log(check_arr[i]);
			}
			else {
				console.log(check_arr[i]);
				console.log(validAll);
			}
		}
		if(validAll == true){
			if(confirm("수정하시겠습니까?")){
				$(".update").submit();
				return true;
			} else{
				return false;
			}
		}
		else alert("사원 정보 저장 조건을 모두 만족해주세요.");
	});

	
</script>
</html>