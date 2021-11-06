<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= "../include/head.jsp"%>
</head>
<body>
<div class="container">
   <div class="mail-box">
       <%@ include file= "../include/menu.jsp"%>
        <aside class="lg-side">
             <div class="inbox-head">
                <form action="/list" method="post" class="pull-right position" id="searchForm">
                    <div class="input-append" id="inputappendDiv">
                        <input type="text" name="name" class="sr-input" placeholder="사원이름 검색">
                        <input type="submit" class="btn sr-btn" value="검색">
                    </div>
                </form>
            </div>
            <form action="/signup" method="post" class="signup">
             <div class="inbox-body">
               <div class="mail-option">   
                  <h2 style="display:inline-block;">사원 정보 입력</h2>   
                     <table class="table table-inbox table-hover">
                        <tbody>
                            <tr>
                     <td class="biew-message ">비밀번호</td>
                     <td class="biew-message "><input type="password" name="pwd" id="pwd" required></td>
                        <td class="biew-message "><div id="pwd_check"></div></td>
                       </tr>
                       <tr>
                     <td class="biew-message ">비밀번호 확인</td>
                     <td class="biew-message "><input type="password" name="pwd2" id="pwd2"></td>
                     <td class="biew-message "><div id="pwd2_check"></div></td>
                    </tr>
                    <tr>
                     <td class="biew-message ">이름</td>
                     <td class="biew-message "><input type="text" name="name" required></td>
                     <td></td>
                    </tr>
                    <tr>
                     <td class="biew-message ">전화번호</td>
                     <td class="biew-message "><input type="text" name="phone" id="phone" placeholder="01x-xxxx-xxxx" required></td>
                     <td class="biew-message "><div id="phone_check"></div></td>
                    </tr> 
                        <tr>
                     <td>직급</td>
                     <td>
                        <select name="position" required>
                           <option value="S1">부장</option>
                           <option value="S2">차장</option>
                           <option value="S3">과장</option>
                           <option value="S4">대리</option>
                           <option value="S5" selected>사원</option>
                           <option value="S6">인턴</option>
                        </select>
                     </td>
                     <td></td>
                  </tr>
                  <tr>
                     <td>부서</td>
                     <td>
                        <select name="department" required>
                           <option>개발</option>
                           <option>영업</option>
                           <option>마케팅</option>
                           <option>인사</option>
                           <option>기획</option>
                        </select>
                     </td>
                     <td></td>
                  </tr>
                  <tr>
                     <td>권한</td>
                     <td><select name="memberAuth" required>
                           <option>A</option>
                           <option>B</option>
                        </select>
                     </td>
                     <td></td>
                  </tr>
                        </tbody>
                     </table>
               </div>
            </div>
          <input type="reset" value="취소" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:left; height: 30px; padding: 0;">
          <input type="button" value="저장" onclick="location.href='/signup'" class="btn btn-compose" style="margin-top: 20px; width: 10%; float:right; height: 30px; padding: 0;">
          </form>
          </aside>
      </div>
   </div>
</body>
<script>
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
   
   $(".btn").click(function(){
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
         $(".signup").submit();
      }
      else alert("사원 정보 저장 조건을 모두 만족해주세요.");
   });
</script>
</html>