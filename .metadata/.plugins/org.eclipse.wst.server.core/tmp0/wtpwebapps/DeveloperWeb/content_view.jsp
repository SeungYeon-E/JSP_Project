<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form action="modify.do" method="post">
		<div>
			<h1>개발자 필수 용품 - 맥북</h1>
		</div>
		<div>
			<h6>By 이승연 -</h6>
		</div>
		<div>
			<p>${content_view.pContent}</p>
		</div>
	</form>
</body>
</html>