<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section{
		text-align : center;
	}

	h1{
		font-size : 3em;
	}
	
	a {
		text-decoration : none;
		font-size : 2em;
	}
</style>
</head>
<body>
	<section>
		<%if(request.getAttribute("result").equals("success")){%>
			<h1 style="color : blue">당첨!! 추카포카</h1>
			<img src="http://70.12.113.182:8000/sedu/images/lottoSuccess.jpg">		
		<%}else{ %>
			<h1 style="color : red">떨어짐</h1>
			<img src="http://70.12.113.182:8000/sedu/images/lottoFail.jpg">
			<br>
			<a href="http://70.12.113.182:8000/sedu/html/lottoForm1.html">로또 재응모</a>
		<%}%>
	</section>
</body>
</html>