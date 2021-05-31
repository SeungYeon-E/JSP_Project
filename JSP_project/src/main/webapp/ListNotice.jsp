<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<script src="https://unpkg.com/@webcreate/infinite-ajax-scroll/dist/infinite-ajax-scroll.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.search {
    	position: relative;
    	text-align: center;
    	width: 900px;
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
	
	
 	.noticeContainer {
		margin: 200px;
		margin-top: 20px;
		margin-bottom: 0px;
	}
	
		
	.noticeTitle {
		margin-left: 50px;
		
	}
	
	.content {
		margin: 50px;
		margin-top: 8px;
		text-overflow: ellipsis;
		color: rgb(117,117,117);
	}
	.views {
		color: rgb(117,117,117);
	} 
</style>
</head>
<body>
	<div>
	<c:forEach items="${list}" var="dto">
		<div OnClick="location.href ='ContentViewNotice.do?n_num=${dto.num }'" class="noticeContainer">
			<div class = "textArea">
				<div class = "noticeTitle">
					<h2> ${dto.title } </h2>
				</div>
				<div class = "content">
					${dto.content }
				</div>
				<hr class = "line">
			</div>
		</div>
	</c:forEach>
	</div>

		<div class="pager">
			<a href="<%session.getAttribute("do");%>?page=next" class="pager__next"></a>
			</div>
		<script>
		let ias = new InfiniteAjaxScroll('.columns', {
		 item: '.textArea',
		 next: '.pager__next',
		 pagination: '.pager',
		 
		});
		</script>
	<%@include file ="Footer.jsp" %> 
</body>
</html>