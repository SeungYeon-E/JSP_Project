<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function modifyComment() {
		var form = document.commenttext;
		//Empty Check
		if (form.cContent.value.trim() == "") {
			alert("comment를 입력하세요!");
			form.cContent.focus();
			return false;
		}
		form.submit();
	}
</script>
<head>
<meta charset="UTF-8">
<title>comment modify</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<form action="CommentModifyItem.do" name="commenttext" method="post">
		<div class="container">
			<input type="hidden" name="ccNo" size="20" value="${commentcontent_view.ccNo}">
			<input type="text" name="cContent" size="50" value="${commentcontent_view.cContent}">
			<button type="button" onclick="modifyComment();" class="btn btn-primary pull-right">수정하기</button>
			<button type="reset" class="btn btn-primary pull-right">되돌리기</button>
		</div>
	</form>
</body>
</html>