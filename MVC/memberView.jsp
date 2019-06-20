<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<hr>
	<ul>
		<%MemberVO info = (MemberVO)request.getAttribute("info"); %>
		<li>회원 이름 : <%=info.getName() %></li>
		<li>회원 계정 : <%=info.getAccount() %></li>
		<li>회원 암호 : <%=info.getPassword() %></li>
		<li>회원 전화번호 : <%=info.getNumber() %></li>
	</ul>
</body>
</html>