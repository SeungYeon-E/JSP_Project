<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>

 <style>
 @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

 *{
     font-family:'Noto Sans KR', sans-serif;
 }
.back {
    position: relative;
    margin: auto;
    text-align: center;
}
.img-back {
    display:block; 
    margin-top: 10%;
    margin-left: 0%;
}
img{
    height: 550px;
}

.text{
	text-align: center;
	position: absolute;
    padding: 5px 10px;
	text-align: center;
	position: absolute;
	top: 15%;
	left: 25%;
}
.back h1 {
    color: red;
    font-size: 70pt;
    margin-bottom: -10%;
}

 </style>   
</head>
<body>
    <div class="back">
        <div class="img-back"> <img src="img/sorry.jpg"> </div>
        <div class="text">
            <h1> Error!!</h1> <br><br>
            <h4>페이지가 없거나 일시적인 오류입니다.<br><br>
            빠른시일내로 조치를 취하도록 하겠습니다.</h4> 
        </div>
</div>
</body>
</html>