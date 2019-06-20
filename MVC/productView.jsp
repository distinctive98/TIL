<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	h1{
		font-size : 3em;
	}
	
	a{
		font-size : 2em;
		background : linear-gradient(to right, yellow, green);
	}
</style>

</head>
<body>
	<h1>선택된 상품 정보는 다음과 같습니다.</h1>
	<hr>
	<%ProductVO info = (ProductVO)session.getAttribute("product"); %>
	<h2>선택된 사과의 개수 : <%=info.getApple() %></h2>
	<h2>선택된 바나나의 개수 : <%=info.getBanana() %></h2>
	<h2>선택된 한라봉의 개수 : <%=info.getOrange() %></h2>
	<hr>
	<a href="/mvc/htmlexam/product.html">상품 선택 화면</a>
</body>
</html>