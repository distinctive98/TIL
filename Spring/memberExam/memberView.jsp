<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>회원 정보(스크립트 태그)</h1>
	<hr>
	<ul>
		<%MemberVO member = (MemberVO)request.getAttribute("info"); %>
		<li>회원 이름 : <%=member.getName() %></li>
		<li>회원 계정 : <%=member.getAccount() %></li>
		<li>회원 암호 : <%=member.getPassword() %></li>
		<li>회원 전화번호 : <%=member.getNumber() %></li>
	</ul>
	<hr>
	
	<hr>
	
	<h1>회원 정보(액션 태그)</h1>
	<hr>
	<ul>
		<!--useBean : 객체를 꺼내는(만드는) 태그(jsp에서 사용하는 자바객체를 Bean이라고 함 -->
		<jsp:useBean id="info" class="vo.MemberVO"  scope="request"/>
		<li>회원 이름 : <jsp:getProperty property="name" name="info"/></li>
		<li>회원 계정 : <jsp:getProperty property="account" name="info"/></li>
		<li>회원 암호 : <jsp:getProperty property="password" name="info"/></li>
		<li>회원 전화번호 : <jsp:getProperty property="number" name="info"/></li>
	</ul>
	<hr>
	
	<hr>
	
	<h1>회원 정보(EL)</h1>
	<hr>
	<ul>
		<!--Scope 찾는 순서 : page -> request -> session -> application -->
		<li>회원 이름 : ${ info.name }</li>
		<li>회원 계정 : ${ info.account }</li>
		<li>회원 암호 : ${ info.password }</li>
		<li>회원 전화번호 : ${ info.number }</li>
	</ul>
	<hr>
</body>
</html>