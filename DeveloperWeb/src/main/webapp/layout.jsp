<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height:1280px;">
    <div style="height:10%; width:100%; display: inline-flex;">
       <div style="float:left; width:30%"></div>
       <div style="float:left; width:40%"><h1>마음만은 TOP 개발자</h1></div>
       <div style="float:left; width:30%"></div>
    </div>
    <div style="height:10%">
       menu
    </div>
    <div class="content" style="height:70%; width:100%; display: inline-flex;">
    <div style="float:left; width:30%"></div>
       <div style="float:left; width:40%"><jsp:include page="./content_view.jsp"></jsp:include></div>
       <div style="float:left; width:30%"></div>
    </div>
    <div style="height:10%">
       bottom
    </div>
</body>
</html>