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

input[type="submit"] {
	margin-top: 10px;
	text-align: center;
	width: 30%;
	height: 32px;
	background: #16a085;
	border: none;
	border-radius: 2px;
	color: #FFF;
}

input[type="submit"]:hover, input[type="submit"]:focus {
	opacity: 0.8;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

input[type="submit"]:active {
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
	height: 600px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
	content: "";
	display: table;
	clear: both;
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
<body>
	<section>
		<article>
			<div class="container">
				<div class="row">
					<form action="TipInsertBoard.do" method="post"
						enctype="multipart/form-data">
						<table class="table table-bordered"
							style="text-align: left; border: 1px solid #dddddd">
							<tr>
								<th colspan="2"
									style="background-color: #eee; text-align: center;">아이디어 작성하기</th>
							</tr>
							<tr>
								<th>글 제목 *</th>
								<td><input type="text" name="T_TITLE" placeholder="글 제목"
									class="form-control"></td>
							</tr>
							<tr>
							<th>카테고리 *</th>
							<td><select name="T_CATEGORY">
									<option value="none">선택하세요</option>
									<option value="코드" selected="selected">코드</option>
									<option value="프로토타입" selected="selected">프로토타입</option>
									<option value="정보" selected="selected">정보</option>
									<option value="기타" selected="selected">기타</option>
							</select></td>
							</tr>

							<tr>
								<th>사진추가 *</th>
								<td><input type="file" name="T_IMAGE" multiple></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea cols="50" rows="20" name="T_CONTENT"
										class="form-control" placeholder="내용을 입력하세요."></textarea></td>
							</tr>
						</table>
						<input type="submit" value="확인" style="background-color: #dddddd">
					</form>
				</div>
			</div>
		</article>
	</section>
	<footer><%@include file="Footer.jsp"%></footer>
</body>
</html>