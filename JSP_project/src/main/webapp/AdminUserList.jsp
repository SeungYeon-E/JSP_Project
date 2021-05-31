<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file ="Header.jsp" %> 
<!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<script type="text/javascript">
/* 버튼 숨기기 */
function buttonHide() {
	
	const table = document.getElementById('userList');
	var deletebtns = document.getElementsByName("deleteuser");
	var recoverbtns = document.getElementsByName("recoveruser");
	
	for (var i = 0; i < deletebtns.length; i++) {
		var str = table.rows[i + 1].cells[6].innerHTML;
		if (str == "") {
			recoverbtns[i].style.display = "none";
		}else{
			deletebtns[i].style.display = "none";
		}
		console.log("btn:" + i + ";value:" + deletebtns[i].value+"date;" + str);
	}
}
/* USER DELETE */
function deleteUser(user_email) {
	var retVal = confirm("회원 탈퇴하시겠습니까?");
	if (retVal == true) {
		var url = "AdminUserDelete.do?user_email=" + user_email;
		open(url,"AdminUserDelete","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
	} else {
		return false;
	}
}
/* USER RECOVER */
function recoverUser(user_email) {
	var retVal = confirm("회원 복구하시겠습니까?");
	if (retVal == true) {
		var url = "AdminUserRecover.do?user_email=" + user_email;
		open(url,"AdminUserRecover","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
	} else {
		return false;
	}
}
</script>
<style>
a:link {
	color: black;
	text-decoration: none;
}

table, th, td {
	width: 	1400px;
	height: 45px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

h3 {
	text-align: center;
}

div {
	text-align: center;
	align-items: center;
}
.ADDRESS{
 	width: 3200px;
}
.name{
	width: 500px;
}

.layer {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 100px;
	height: 100px;
	background: #f00;
	margin: -50px 0 0 -50px;
}

	.footer_info {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}
	/* search 수정 */
	.search {
    	position: relative;
    	text-align: center;
    	width: 70%;
    	margin: 0 auto;
    	font-family: Georgia, Serif;
		font-size: 30px;
	}
	
	input {
    	width: 100%;
    	border-radius: 20px;
    	border: 1px solid #bbb;
    	margin: 10px 0;
    	padding: 10px 12px;
    	font-family: fontAwesome;
	}
	
	.box {
    display: inline;
    width: auto;
    border-radius: 0;
    margin: auto;
    text-align: center;
    color: #bbb;
	}
	
	#title {
	border-bottom: 1px solid #bbb;
	}
	
	
</style>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<br>
	<br>
	
	<h3>회원관리</h3>
	<br>
	<br>
		<form action="AdminUserSearch.do" method="post">
			<div class="search">
    			<script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    			<input type="text" name="searched" placeholder="&#xf002; search" >
    		</div>
    	</form>
    <br>
	<br>
	<table id="userList">
		<tr id="title" >
			<th>EMAIL</th>
			<th class = "name">NAME</th>
			<th class = "ADDRESS" >ADDRESS</th>
			<th>TEL</th>
			<th>GIT</th>
			<th>CREATE</th>
			<th>DELETE</th>
			<th>USERINFO</th>
			<th></th>
		</tr>
		<c:forEach items="${user_list}" var="userList">
			<!-- 리스트커멘드에서 정해줌 아이템즈는  -->
			<tr>
				<td id="user_email">${userList.email}</td>
				<td class = "name">${userList.name}</td>
				<td class = "ADDRESS" >${userList.adress}</td>
				<td>${userList.tel}</td>
				<td>${userList.git}</td>
				<td>${userList.createdate}</td>
				<td>${userList.deletedate}</td>
				<td> <c:if test="${userList.admin eq 0 && empty userList.deletedate}">  
				회원
				</c:if>
				<c:if test="${userList.admin eq 1 && empty userList.deletedate}">  
				관리자
				</c:if>
				<c:if test="${userList.admin eq 0 && !empty userList.deletedate}">  
				탈퇴회원
				</c:if>
				</td>
				<td>
					<button type="button" onclick="deleteUser(this.id);" name="deleteuser" id="${userList.email}" value="${userList.email}" class="btn btn-primary pull-right">탈퇴하기</button>
					<button type="button" onclick="recoverUser(this.id);" name="recoveruser" id="${userList.email}" value="${userList.email}" class="btn btn-primary pull-right">복구하기</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9" align="center">
				<c:forEach items="${pageList }" var="page">
					<a href="AdminUserlist.do?page=${page }">${page }</a>
				</c:forEach>
			</td>
		</tr>
	</table>
	<script type="text/javascript">buttonHide();</script>
</body>
</html>
<%@include file="/Footer.jsp"%>