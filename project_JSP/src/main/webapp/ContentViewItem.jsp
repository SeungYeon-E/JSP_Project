<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<script type="text/javascript">
	/* var myEmail = sessionStorage.getItem("email");*/
	/* 로그인된 아이디 세션값받기 */
	var myEmail = '<%=(String)session.getAttribute("email")%>';
	
	console.log("="+myEmail);
	/* 게시물 삭제 */
	function deleteContent() {
		var retVal = confirm("게시물 삭제하시겠습니까?")
		if(retVal == true){
			var iNo = document.getElementById("deletecontent").value;
			var url = "ContentViewItemdelete.do?iNo=" + iNo;
			open(url,"deleteContent",
					"roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
		}else{
			return false;
		}
	}
	/* 버튼 숨기기 */
	function buttonHide() {
		console.log(myEmail);
		const table = document.getElementById('comlist');
		var mdibtns = document.getElementsByName("modifycomment");
		var delbtns = document.getElementsByName("deletecomment");
		
		for(var i=0; i<table.rows.length-1; i++){
			var str = table.rows[i+1].cells[0].innerHTML;
			if(myEmail != str){
				mdibtns[i].style.display="none";
				delbtns[i].style.display="none";
				console.log("btn:"+i+";value:"+mdibtns[i].value+str);
			}
		}
		
		var modifyContent = document.getElementById("modifyContent");
		var template = '${content_view.userEmail}';
		if(myEmail != template){
			modifyContent.style.display="none";
			console.log("="+template);
		}
		
		var deletecontent = document.getElementById("deletecontent");
		if(myEmail != template){
			deletecontent.style.display="none";
		}
		
		var writecomment = document.getElementById("writecomment");
		var commenttext = document.getElementById("commenttext");
		if(myEmail == "null"){
			writecomment.style.display="none";
			commenttext.style.display="none";
		}
	}
	
	/* 댓글 */
	function writeComment() {
		var form = document.commentWrite
		//Empty Check
		if(form.ccomment.value == ""){
			alert("comment를 입력하세요!");
			form.ccomment.focus();
			return false;
		}
		form.submit();
	}
	/* 댓글 수정 */
	function modifyComment() {
		var ccNo = document.getElementById("ccNo").value;
		var url = "CommentModifyItem.do?ccNo=" + ccNo;
		open(
				url,
				"CommentModifyItem",
				"roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
	}
	/* 댓글 삭제 */
	function deleteComment() {
		var form = document.commentList
		//Empty Check
		if(form.ccomment.value == ""){
			alert("comment를 입력하세요!");
			form.ccomment.focus();
			return false;
		}
		form.submit();
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
				<input type="submit" value="수정" id="modifyContent" class="btn btn-primary pull-right">&nbsp;&nbsp;&nbsp;
				<a href="list.do" class="btn btn-primary pull-right">목록</a>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="deleteContent()" id="deletecontent" value="${content_view.iNo}" class="btn btn-primary pull-right">삭제</button>
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
								<input type="hidden" id="bId" value="${content_view.iNo}">
								<input type="text" name="ccomment" id="commenttext"
									class="form-control" placeholder="write a comment...">
								<br>
									<button type="button" onclick="writeComment()" id="writecomment" name ="bId" value="${content_view.iNo}" class="btn btn-primary pull-right">댓글입력</button>
								<div class="clearfix"></div>
							</form>
							<hr />
							<div class="media-body">
								<!-- 댓글 리스트 시작-->
								<form action="#" method="post" name="commentList">
									<table id="comlist" border="1">
										<tr>
											<th>이름</th>
											<th>내용</th>
											<th>날짜</th>
											<th></th>
										</tr>
										<c:forEach items="${comment_view}" var="comment">
											<!-- 리스트커멘드에서 정해줌 아이템즈는  -->
											<tr>
												<td>${comment.userEmail}</td>
												<td>${comment.cContent}</td>
												<td>${comment.cRegistDate}</td>
												<td>
												<button type="button" onclick="modifyComment();" name="modifycomment" value="${comment.ccNo}" class="btn btn-primary pull-right">수정하기</button>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<button type="button" onclick="deleteComment();" name="deletecomment" value="${comment.ccNo}" class="btn btn-primary pull-right">삭제하기</button>
											</tr>
										</c:forEach>
									</table>
								</form >
								<script type="text/javascript">buttonHide();</script><!-- 다출력후 숨기기 위해서!! -->
								<br />
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

