<%@page import="com.jspproject.bbs.dto.ItemInfoDto"%>
<%@page import="com.jspproject.bbs.command.ItemInfoInsertCommand"%>
<%@page import="com.jspproject.bbs.dao.ItemInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@include file="Header.jsp"%>

<style>
* {
	box-sizing: border-box;
}

input[type="button"] {
	margin-top: 10px;
	text-align: center;
	width: 30%;
	height: 32px;
	background: #008CBA;
	border: none;
	border-radius: 2px;
	color: #FFF;
}

input[type="button"]:hover, 
input[type="button"]:focus {
	opacity: 0.8;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

input[type="button"]:active {
	opacity: 1;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	margin: 0px;
	padding: 0px;
	list-style: none;
	text-decoration: none;
	color: black;
	font-family: 'Noto Sans KR', sans-serif;
}

article {
	float: center;
	padding: 20px;
	width: 100%;
	background-color: white;
	height: 640px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
	content: "";
	display: table;
	clear: both;
}


table{
  border-collapse: separate;
  border-spacing: 0 5px;
}
file{
	margin: 0px; 
	width: 1130px;
}
/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 1000px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>

<script type="text/javascript">
			function checkTip(){
				var form = document.TipInsert
				
				if(form.T_TITLE.value==""){
					alert("제목을 입력해주세요!"); //alert에 있는 명령은 중요한 것 쓰지 않고 사소한 것만 쓰기!!
					form.T_TITLE.focus();
					return false;
				}
				
				else if(form.T_CATEGORY.value==""){
					alert("카테고리를 선택해주세요!");
					form.T_CATEGORY.focus();
					return false;
				}
				
				else if(form.T_IMAGE.value==""){
					alert("사진을 첨부해주세요!");
					form.T_IMAGE.focus();
					return false;
				}
				
				else if(form.T_CONTENT.value==""){
					alert("내용을 입력해주세요!");
					form.T_CONTENT.focus();
					return false;
				}
				
			//Length Check
		
		/* 	else if(form.T_CONTENT.value.length < 50000){
				alert("내용은 50000자 이하로 입력해야 합니다.");
				form.T_CONTENT.select();
				return false;
				} */
			else{
				alert("게시글 입력에 성공하셨습니다.");
			}
				form.submit();
			}
			
		</script>

<body>
	<section>
		<article>
			<div class="container">
				<div class="row">
					<form action="TipInsertBoard.do" name="TipInsert" method="post"
						enctype="multipart/form-data">
						<div style="text-align: center;">
						<h2>아이디어 작성하기</h2>
						<br>
						</div>
						<table
							style="margin-left: auto; margin-right: auto; text-align: left;" width=1300 border=0 cellpadding=2>
							<!-- <tr>
								<th colspan="2"
									style="background-color: #eee; text-align: center;">아이디어 작성하기</th>
							</tr> -->
							<tr>
								<th>글 제목 </th>
								<td><input type="text" name="T_TITLE" placeholder="글 제목" style="margin: 0px; width: 1160px;" class="form-control"></td>
							</tr>
							<tr>
							<th>카테고리 </th>
							<td><select name="T_CATEGORY"  style="margin: 0px; width: 1160px;">
									<option value="none">선택하세요</option>
									<option value="코드" selected="selected">코드</option>
									<option value="프로토타입" selected="selected">프로토타입</option>
									<option value="정보" selected="selected">정보</option>
									<option value="기타" selected="selected">기타</option>
							</select></td>
							</tr>

							<tr>
								<th>사진추가 </th>
								<td><input type="file" name="T_IMAGE" multiple></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea  style="margin: 0px; width: 1160px; height: 386px;" name="T_CONTENT"
										class="form-control" placeholder="내용을 입력하세요."></textarea></td>
							</tr>
						</table>
						<div style="text-align: center;">
						<input type="button" value="확인" onclick="checkTip()">
						</div>
					</form>
				</div>
			</div>
		</article>
	</section>
	<footer><%@include file="Footer.jsp"%></footer>
</body>
</html>