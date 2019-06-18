<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		char[] weeks = {'일', '월', '화', '수', '목', '금', '토'};
		char week = weeks[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1];
		String name = request.getParameter("name");
		out.print("<h2>" + name + "님 반가워요.. 오늘은" + week + "요일입니다..");
	%>
</body>
</html>