<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

	#container {
		background-color: rgb(250, 250, 250);
		color: 333333;
		font-family: Georgia, Serif;
	}
	
 	#profile {
  		
   		font-size: 30px;
   		margin-left:180px;
   		margin-top:100px;
  	}
  	
  	#post {
  		margin-left:100px;
  		margin-right:100px;
  	}
  
  	#columns{
  		margin-left:100px;
  		margin-right:100px;
		column-width:150px;
		
		column-gap: 0;
	}
	#columns figure{
		display: inline-block;
		margin:1px;
		margin-bottom: 15px;
	}
	
	#columns figure img{
		width: 100%;
		height:150px;
		object-fit: cover;
	}
 
</style>
<body>
	<div id = "container">
			<br><br>
		<div id ="profile">
			NAME <button>Edit Profile</button>
			<br><br>
		</div>
	

		<div id = "post">
		<hr style="color:#zzxcvc";>
			0 posts
		</div>
			<br>
	</div>
	
	<div id="columns">

<!-- 반복문으로 변경하기 -->
	<figure>
  	<img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/rapunzel.jpg">
  	<figcaption></figcaption>
	</figure>
  	
	<figure>
	<img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/rapunzel.jpg">
	<figcaption></figcaption>
	</figure>
	
  	<figure>
	<img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/belle.jpg">
	<figcaption></figcaption>
	</figure>
	
</div>
</body>
</html>