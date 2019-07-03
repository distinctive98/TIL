<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getParameter("name") %> 님은 <%=request.getAttribute("grade")%>등급입니다. 양호한 성적이네요^^</h1>
	<a href="/mvc/htmlexam/eduForm.html">성적 입력 화면으로</a>
</body>
</html>