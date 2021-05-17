<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
 <style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
    *{margin:0; padding: 0; box-sizing: border-box;}
    
    body {
      margin: 0;
      padding: 0;
      background: #DDD;
      color: #222;
      font-family: 'Noto Sans KR', sans-serif;
    }
    
    #login-box {
      position: relative;
      margin: 5% auto;
      width: 400px;
      height: 600px;
      background: #FFF;
      padding:20px 40px;
      box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.3);
    }
    #login-box a {
      text-decoration: none;
    }
   
   h1 {
      margin: 0 0 25px 0;
      font-weight: 300;
      font-size: 28px;
      text-align: center;
      }
    
    input[type="text"],
    input[type="password"] {
      display: block;
      box-sizing: border-box;
      margin-bottom: 15px;
      padding: 10px;
      width: 100%;
      height: 32px;
      border: none;
      border-bottom: 1px solid #AAA;
      font-weight: 400;
      font-size: 12px;
      transition: 0.2s ease;
    }
    
    .addressSearch{
      display: block;
      width: 70px;
      height: 20px;
      margin-top: -68px;
      margin-left: 40px;
      color: black;
      font-size: 10px;
     
    }

    input[type="submit"] {
      margin-top: 60px;
      text-align: center;
      width: 100%;
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
    
</style>  

    <title>회원가입</title>
</head>
<body>
    <div id="login-box">
      <h1>회원가입</h1> 
      <form action="">
        <span>이메일</span><br>
        <input type="text" name="email" placeholder="이메일을 입력해주세요." />
        <span>비밀번호</span><br>
        <input type="password" name="password" placeholder="비밀번호를 입력해주세요" />
        <span>비밀번호 확인</span><br>
        <input type="password" name="password2" placeholder="입력한 비밀번호를 입력해주세요" />
        <span>이름</span><br>
        <input type="text" name="username" placeholder="이름을 입력해주세요." />
        <span>핸드폰번호</span><br>
        <input type="text" name="phone" placeholder="-없이 핸드폰번호를 입력해주세요." />
        <span>주소</span><br>
        <input type="text" name="address" placeholder="주소찾기를 눌러주세요." />
        <a href=""><button class="addressSearch" type="button">주소찾기</button></a>
        <input type="submit" name="signup" value="회원가입" />
     </form>
   </div>
        
</body>
</html>