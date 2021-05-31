<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="Header.jsp" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
	    alert('정보가 수정되었습니다.');
	});	
</script> 

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("address1").value = roadAddr;

            }
        }).open();
    }
</script>
<script>
    //유효성검사
function editSumbit(){
      $.validator.addMethod("regx",function(value,elemqnt,regexpr){
          return regexpr.test(value);
      });  
      $("#edit").validate({
          //validation이 끝난 이후의 submit 직전 추가 작업할 부분
                submitHandler: function() {
              var f = confirm("프로필수정을 하시겠습니까?");
              if(f){
                  return true; 
              } else {
                  return false;
              }
          },
          //규칙
          rules: {
              name: {
                  required : true,
                  regx : /^[가-힣a-zA-z]{1,30}$/
              },
              tel: {
                  required : true,
                    regx : /^[0-9]{11,12}$/
              },
              address1: {
                  required : true
              },
              git: {
                  maxlength : 20
              },
          },
          
          //규칙체크 실패시 출력될 메시지
          messages : {
                name: {
                    required : "필수입력사항입니다.",
                    regx : "이름은 한글,영어 1~30자입니다"
                },
                tel: {
                  required : "필수입력사항입니다.",
                  regx : "-없이 숫자11~12자리입니다"
                },
                address1: {
                  required : "필수입력사항입니다.",
                },
                git: {
                  maxlength : "최대 {0}글자 이하입니다."
                },
            }
      });
    }
</script>  
 <script>  
function pwdchangeSubmit(){
      $.validator.addMethod("regx",function(value,elemqnt,regexpr){
          return regexpr.test(value);
      }); 
    $("#pwdchange").validate({
          //validation이 끝난 이후의 submit 직전 추가 작업할 부분
                submitHandler: function() {
              var f = confirm("비밀번호를 수정 하시겠습니까?");
              if(f){
                  return true; 
              } else {
                  return false;
              }
          },
          //규칙
          rules: {
              pwd: {
                  required : true,
                  regx : /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{6,20}$/
              },
              pwd2: {
                  required : true,
                  equalTo : pwd
              },
          },
          
          //규칙체크 실패시 출력될 메시지
          messages : {
                pwd: {
                    required : "필수입력사항입니다.",
                    regx : "비밀번호는 문자,숫자,특수문자 포함 6~20자입니다"
                },
                pwd2: {
                    required : "필수입력사항입니다.",
                    equalTo : "비밀번호가 맞지 않습니다."
                },
            }
      });
    }
</script>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
    *{margin:0; padding: 0; box-sizing: border-box;}
    
    body {
      margin: 0;
      padding: 0;
      background:rgb(250,250,250);
      color: #222;
      font-family: 'Noto Sans KR', sans-serif;
    }
    
    #profile-container {
		position: relative;
		top: 50%;
		left: 50%;
		width: 600px;
		height: 100%;
		margin-left: -400px;
		margin-top: 60px;
		margin-bottom: 60px;		
	}

    #profile-container a {
      text-decoration: none;
    }
    input[type="text"],
    input[type="password"] {
      display: block;
      box-sizing: border-box;
      margin-bottom: 20px;
      margin-top: 5px;
      padding: 10px;
      width: 350px;
      height: 32px;
      border: none;
      border-bottom: 1px solid #AAA;
      font-weight: 400;
      font-size: 12px;
      transition: 0.2s ease;
    }
    
    label.error{
    display: block;
    color: red;
    font-size: 3pt;
    margin-top: -13px;
    margin-bottom: 5px;
    
	}
	
    
   #button_address{
      display: block;
      width: 60px;
      height: 25px;
      margin-top: -25px;
      margin-left: 100px;
      margin-bottom: 10px;
      padding: 0px;
      color: #FFF;
      font-size: 10px;
      background: #136de4;
      border: none;
      border-radius: 2px;
      
    }

    #button_address:hover,
    #button_address:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    #button_address:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }

    #button_withdraw {
      display: block;
      width: 60px;
      height: 25px;
      margin-top: -50px;
      padding: 0px;
      color: #FFF;
      font-size: 10px;
      background: #16a085;
      border: none;
      border-radius: 2px;
      
    }



    input[type="submit"] {
      margin-top: 7px;
      text-align: center;
      width: 350px;
      height: 32px;
      background: #16a085;
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    input[type="submit"]:hover,
    input[type="submit"]:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    input[type="submit"]:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    hr {
		margin: 35px;
		margin-bottom:60px;
        margin-left: -10px;
	}
</style>
<meta charset="UTF-8">
<title>마이프로필 수정</title>
</head>
	<body>
		<div id="profile-container">
			<form id ="edit" name="edit" action="edit.do" method="post">
                <h2>개인정보 수정</h2><br>
                Email<br>
                <input type="text" name="email" id="email" value="${profile.userEmail}" readonly />
                이름<br>
                <input type="text" name="name" id="name" value="${profile.userName}"  />
                핸드폰번호<br>
                <input type="text" name="tel" id="tel" value="${profile.phoneNumber}"  />
                도로명 주소<input type="button" id="button_address" onclick="sample4_execDaumPostcode()" value="주소 찾기">
                <input type="text" name="address1" id="address1"  value="${profile.userAddress}"  readonly />
                <input type="text" name="address2" id="address2" placeholder="상세주소를 입력해주세요.(주소 수정시 입력)" />
                GitHub아이디(선택)<br>
                <input type="text" name="git" id="git" value="${profile.userGit}"  placeholder="GitHub아이디를 입력해주세요." />
    
				<input type="submit" value="프로필 수정" onclick="editSumbit()">

        </form>
			<hr>
		<form id ="pwdchange" name="pwdchange" action="changePassword.do" method="post">
             <h2>비밀번호 수정</h2><br>
              비밀번호<br>
              <input type="password" name="pwd" id="pwd" placeholder="문자,숫자,특수문자가 포함된 비밀번호를 입력해주세요." />
              비밀번호 확인<br>
              <input type="password" name="pwd2" id="pwd2" placeholder="입력한 비밀번호를 입력해주세요" />
              <input type="submit" value="비밀번호 수정"  onclick="pwdchangeSubmit()">
        </form>
			<hr>
			<form name="delete" action="deleteAccount.do" method="post">
				<input type="submit" id="button_withdraw" value="계정삭제">
			</form>
		</div>
	</body>
	<%@include file ="Footer.jsp" %> 
</html>