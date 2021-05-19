<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function modifyComment() {
		var ccNo = document.getElementById("ccNo").value;
		var url = "commentModify.do?ccNo=" + ccNo;
		var form = document.commentWrite
		//Empty Check
		if(form.ccomment.value == ""){
			alert("comment를 입력하세요!");
			form.ccomment.focus();
			return false;
		}
		
		open(
				url,
				"commentModify",
				"roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
		form.submit();
	}
	function buttonHide() {
		var myEmail = sessionStorage.getItem("email");
		var btns = document.getElementsByName("commentModify");
		for(var i = 0;i<btns.length;i++){
			if(myEmail != btns[i].value){
				btns[i].style.display="none";
				console.log("btn:"+i+";value:"+btns[i].value);
			}
		}
	}
</script>
<style>
table, th, td {
	border: 1px solid #bcbcbc;
	width: 1200px;
	height: 50px;
	margin-left: auto;
	margin-right: auto;
}

h1 {
	text-align: center;
}

div {
	text-align: center;
	align-items: center;
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
</style>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<!-- <link rel="stylesheet" href="ContentviewItem.css"> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<body>

	<!-- 아이디 구별하기 -->
	<%
	String userID = null;
	if (session.getAttribute("email") != null) {
		userID = (String) session.getAttribute("userID");
	}
	int bbsID = 0;
	if (request.getParameter("bbsID") != null) {
		bbsID = Integer.parseInt(request.getParameter("bbsID"));
	}
	if (session.getAttribute("email") == null) {
	}
	%>

	<jsp:include page="./Header.jsp"></jsp:include>

	<!-- 상세페이지 -->
	<div class="container">
		<br /> <br />
		<form action="modify.do" method="post">
			<h3 class="m-2">
				<b>${content_view.iTitle}</b>
			</h3>
			<br />

			<h6 class="m-2">
				By <i>${content_view.userEmail}</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Date <i>${content_view.wRegistDate}</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Views <i>${content_view.iHits}</i>
			</h6>
			<div>

				<input type="submit" value="수정" class="btn btn-primary pull-right">&nbsp;&nbsp;&nbsp;
				<a href="list.do" class="btn btn-primary pull-right">목록보기</a>&nbsp;&nbsp;&nbsp;
				<a href="ContentViewItemdelete.do?bId=${content_view.iNo}"
					class="btn btn-primary pull-right">삭제</a>
			</div>
			<hr />
			<div class="form-group">
				<div class="m-2">${content_view.iContent}</div>
			</div>
		</form>

		<hr />

		<!-- 댓글 박스 -->
		<div class="row bootstrap snippets">
			<div class="col-md-12">
				<div class="comment-wrapper">
					<div class="panel panel-info">
						<div class="panel-heading m-2">
							<b>Comment</b>
						</div>
						<div class="panel-body">
							<!-- 댓글입력 -->
							<form action="CommentWriteItem.do" method="post" name="commentWrite">
								<input type="text" name="ccomment" id="reply__write__form"
									class="form-control" placeholder="write a comment...">
								<br> <input type="hidden" name="bId"
									value="${content_view.iNo}"> <input type="submit"
									value="댓글입력" class="btn btn-primary pull-right">
								<div class="clearfix"></div>
							</form>
							<hr />
							<div class="media-body">
								<!-- 댓글 리스트 시작-->
								<form action="moditycomment.do" method="post" name="commentList">
									<table border="1">
										<tr>
											<th>이름</th>
											<th>내용</th>
											<th>날짜</th>
											<th></th>
										</tr>
										<c:forEach items="${comment_view}" var="comment">
											<!-- 리스트커멘드에서 정해줌 아이템즈는  -->
											<input type="hidden" id="ccNo" value="${comment.ccNo}">
											<tr>
												<td>${comment.userEmail}</td>
												<td>${comment.cContent}</td>
												<td>${comment.cRegistDate}</td>
												<td>
												<button type="button" onclick="modifyComment();" name="commentModify" value="${comment.userEmail}">수정하기</button>
												<input type="submit" value="수정"
													class="btn btn-primary pull-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="commentdelete.do?bId=${comment.ccNo}"
													class="btn btn-primary pull-right">삭제</a></td>
											</tr>
										</c:forEach>
									</table>
								</form >
								<script type="text/javascript">buttonHide();</script>
								<!-- 댓글 아이템 -->

								<strong class="text-primary">${comment.userEmail}</strong>
								<p>${comment.cContent}</p>
								<p>${comment.cRegistDate}</p>
							</div>

							<!-- 댓글 리스트 끝-->
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- 댓글 박스 끝 -->
	</div>

	<jsp:include page="./Footer.jsp"></jsp:include>

</body>
</html>

