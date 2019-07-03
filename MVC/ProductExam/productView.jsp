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
	<h1>선택된 상품 정보는 다음과 같습니다.(스크립트태그)</h1>
	<hr>
	<%ProductVO info = (ProductVO)session.getAttribute("product"); %>
	<h2>선택된 사과의 개수 : <%=info.getApple() %></h2>
	<h2>선택된 바나나의 개수 : <%=info.getBanana() %></h2>
	<h2>선택된 한라봉의 개수 : <%=info.getOrange() %></h2>
	<hr>
	<a href="/mvc/htmlexam/product.html">상품 선택 화면</a>
	<hr>
	
	<hr>
	
	<h1>선택된 상품 정보는 다음과 같습니다.(액션태그)</h1>
	<hr>
	<jsp:useBean id="product" class="model.vo.ProductVO" scope="session"></jsp:useBean>
	<h2>선택된 사과의 개수 : <jsp:getProperty property="apple" name="product"/></h2>
	<h2>선택된 바나나의 개수 : <jsp:getProperty property="banana" name="product"/></h2>
	<h2>선택된 한라봉의 개수 : <jsp:getProperty property="orange" name="product"/></h2>
	<hr>
	<a href=<%=request.getHeader("referer")%>>상품 선택 화면</a>
	<hr>
	
	<hr>
	
	<h1>선택된 상품 정보는 다음과 같습니다.(EL)</h1>
	<hr>
	<h2>선택된 사과의 개수 : ${ sessionScope.product.apple }</h2>
	<h2>선택된 바나나의 개수 : ${ sessionScope.product.banana }</h2>
	<h2>선택된 한라봉의 개수 : ${ sessionScope.product.orange }</h2>
	<hr>
	<a href=<%=request.getHeader("referer")%>>상품 선택 화면</a>
	<hr>
</body>
</html>