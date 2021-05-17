<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="ContentView.css">
</head>
<body>

	<%-- 	<table border="0">
		<form action="modify.do" method="post">
			<tr>
				<td>번호</td>
				<td><input type="text" name="bId" value="${content_view.pNo}" readonly="readonly"></td>
				<!-- <input type="hidden" name="bId" value="${content_view.bId}"> -->
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="20" value="${content_view.userEmail}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value="${content_view.pTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="bContent" >${content_view.pContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list.do">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="delete.do?bId=${content_view.bId}">삭제</a></td>
			</tr>
		</form>
	
	</table> --%>
	<!-- 상세페이지 -->
	<form action="modify.do" method="post">
		<div>
			<h1>Title ${content_view.pTitle}</h1>
		</div>
		<div>
			<div><h6>By ${content_view.userEmail}</h6></div>
			<div><h6>date ${content_view.wRegistDate}</h6></div>
		</div>
		<div>
			<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list.do">목록보기</a>
			&nbsp;&nbsp;&nbsp;<a href="delete.do?bId=${content_view.bId}">삭제</a>
		</div>
		<div>
			<p>내용 ${content_view.pContent}</p>
		</div>
		<%-- <div>
			<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list.do">목록보기</a>
			&nbsp;&nbsp;&nbsp;<a href="delete.do?bId=${content_view.bId}">삭제</a>
		</div> --%>
	</form>
	<!-- 댓글입력 -->
	<form action="comment.do" method="post">
		<div>
			<h4>댓글달기</h4>
		</div>
		<div>
			<input type="text" name="bName" size="20" value="${content_view.userEmail}">
			<input type="text" name="ccomment" size="20">
			<input type="submit" value="확인">
		</div>
		<%-- <div>
			<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list.do">목록보기</a>
			&nbsp;&nbsp;&nbsp;<a href="delete.do?bId=${content_view.bId}">삭제</a>
		</div> --%>
	</form>
	
	<table border="1">
		<form action="moditycomment.do" method="post">
		<tr>
			<th>이름</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${comment_view}" var="comment"><!-- 리스트커멘드에서 정해줌 아이템즈는  -->
		<tr>
			<td>${comment.userEmail}</td>
			<td>${comment.cContent}"</td>
			<td>${comment.cRegisDate}"</td>
			<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;<%-- <a href="commentdelete.do?bId=${comment.userEmail}">삭제</a> --%></td>
		</tr>
		</c:forEach>
		<tr>
		
		</tr>
		</form>
	</table>
</body>
</html>