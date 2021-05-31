<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<style>
	
	#container {
		color: 333333;
		font-family: Georgia, Serif;
	
	}
	
 	#profile {
 		display: inline-block;
   		font-size: 30px;
   		margin-left:180px;
   		margin-top:100px;
  	}
  	
  	#post {
  		margin-left:100px;
  		margin-right:100px;
  	}
  
  	#columns{
		column-width:200px;
		column-gap: 0;
		margin: 100px;
	}
	#columns figure{
		display: inline-block;
		margin:1px;
		margin-bottom: 15px;
	}
	
	#columns figure img{
		width: 100%;
		height:200px;
		object-fit: cover;
	}
	
	.buttons {
		display: inline-block;
		margin: 20px;
		margin-left:100px;
	}
	
	#line {
		margin-left: 100px;
		margin-right: 100px;
		margin-top:20px;
	}
	.pagination {
	width: 100%;
	margin: 50px;
	text-align: center;
	}
	
	.buttons a{
		margin: 20px;
		color: gray;
	}
	
	
</style>

<body style="background-color:rgb(250,250,250);"> 
	<div id = "container">
		<div id ="profile">
			${myprofile.userName }
			<a href="https://github.com/${myprofile.userGit }">${myprofile.userGit }</a> 
			<a href = "editView.do" id = "edit">
				&#9881;
			</a>
				<div id = "counts">
				${count} Item posts
				</div>
		</div>
	
		<hr id= "line" style="color:#zzxcvc">
	</div>
	<div class = "buttons">
			<a href = "profile.do">All Posting</a>
			<a href = "profileOnlyTool.do">My Item</a>
			<a href = "profileOnlyIdea.do">My Idea&Tip</a>
			<a href = "ItemInfoView.do">Add Item</a>
			<a href = "TipViewBoard.do">Add Tip</a>
			<%String admin = (String)session.getAttribute("admin");
			int adminNum = Integer.parseInt(admin);
			if(adminNum == 1){%>
			<a href = "NoticeView.do">Add Notice</a><%}%>
		</div>
		
		<div id="columns">
			<c:forEach items="${myList}" var="dto">
				<figure>
  					<a href="ContentViewItem.do?i_num=${dto.num }"><img src=${dto.image }></a>
				</figure>
			</c:forEach>
		</div>
	
		<div class="pagination">
		<c:forEach items="${pageList }" var="page">
			<a href="<%session.getAttribute("do");%>?page=${page }">${page }</a>
		</c:forEach>
		</div>
</body>
</html>
<%@include file ="Footer.jsp" %> 