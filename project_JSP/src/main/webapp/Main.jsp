<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	#columns{
		display: grid;
		column-gap: 0px;
		grid-template-columns: 1fr 1fr 1fr;
		margin-top: 100px;
		font-family: Georgia, Serif;
		font-size: 50px;
	}
	#columns figure {
		margin:0;
		height: 700px;
		object-fit: cover;
		position: relative;
	}
	
	#columns figure img {
		width: 100%;
		height: 100%
		
	}
	
	#columns figcaption {
	color: #ffffff;
	position: absolute;
	left: 0; right: 0; top: 0; bottom: 0;
	z-index: 2;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-flow: column;
	background: rgba(55, 55, 55, 0.5);
	}
	
	figure:hover figcaption p{
	color: rgb(255, 214, 10);
	} 
</style>

<body>

<div id="columns">

	<div id="tool">
	<figure>
  	<img src="gunnar-sigurdarson-nzff_emVOfE-unsplash.jpg">
  	<a href="list.do">
  	<figcaption>
  	<p>Dev Tool</p>
  	</figcaption>
  	</a>
	</figure>
	</div>
  	
  	<div id="idea">
	<figure>
	<img src="junior-ferreira-7esRPTt38nI-unsplash.jpg">
	<figcaption>
	<p>Idea</p>
	</figcaption>
	</figure>
	</div>
	
	<div id="alert">
  	<figure>
	<img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/rapunzel.jpg">
	<figcaption>
	</figcaption>
	</figure>
	</div>
	
</div>

</body>
</html>