<%@page import="com.jspproject.bbs.dto.NoticeDto"%>
<%@page import="com.jspproject.bbs.command.NoticeInsertCommand"%>
<%@page import="com.jspproject.bbs.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@include file = "Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
<style>
* {
  box-sizing: border-box;
}
    input[type="button"] {
      margin-top: 10px;
      text-align: center;
      width: 30%;
      height: 32px;
      background: #008CBA;
      border: none;
      border-radius: 2px;
      color: #FFF;
    }

    input[type="button"]:hover,
    input[type="button"]:focus {
      opacity: 0.8;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }
    input[type="button"]:active {
      opacity: 1;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
      transition: 0.1s ease;
    }

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

*{
    margin: 0px;
    padding: 0px;
    list-style: none;
    text-decoration:none;
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

table{
  border-collapse: separate;
  border-spacing: 0 10px;
}


/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 1000px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>

		<script type="text/javascript">
			//Empty Check
			function checkUpdate(){
				var form = document.NoticeUpdate
				if(form.N_TITLE.value==""){
					alert("제목을 입력해주세요!"); //alert에 있는 명령은 중요한 것 쓰지 않고 사소한 것만 쓰기!!
					form.N_TITLE.focus();
					return false;
				}

				else if(form.N_CONTENT.value==""){
					alert("내용을 입력해주세요!");
					form.N_CONTENT.focus();
					return false;
				}
				
			//Length Check
		
			/* else if(form.N_CONTENT.value.length <50000){
				alert("내용은 50000자 이하로 입력해야 합니다.");
				form.N_CONTENT.select();
				return false;
				} */
			else{
				alert("수정에 성공하셨습니다.");
			}
				form.submit();
			}
			
		</script>
	<article>
    <section>
   <form action="NoticeUpdate.do" method="post" name="NoticeUpdate">
  				 <input type="hidden" value="${read.n_num }" name="N_NUM">
  				 <div style="text-align: center;">
						<h2>공지사항 수정하기</h2>
						<br>
						</div>
			<table class="table table-bordered" style="margin-left: auto; margin-right: auto; text-align: left;" width=1300 border=0 cellpadding=2>
						<!-- <tr>
							<th colspan="2"
								style="background-color: #eee; text-align: center;">공지사항 작성하기</th>
						</tr> -->
                <tr>
                <th>글 제목 </th>
			 <td><input type="text" name="N_TITLE"  placeholder="글 제목" style="margin: 0px; width: 1160px;"  value="${read.n_title }"></td>
			 </tr>
			 
	   		<tr> 
	     	   <th>내용</th>
                    <td><textarea style="margin: 0px; width: 1160px; height: 386px;" name="N_CONTENT" placeholder="내용을 입력하세요.">${read.n_content }</textarea></td>
                </tr>	
                </table>
                <div style="text-align: center;">
				 <input type="button" value="확인" onclick="checkUpdate()">
				 </div>
		</form>
</section>
</article>
<footer><%@include file = "Footer.jsp" %></footer>   
</body>
</html>