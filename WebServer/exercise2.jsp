<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String[] habits = request.getParameterValues("habit");
		String color = request.getParameter("color");
		String[] foods = request.getParameterValues("food");
		String opinion = request.getParameter("opinion");
		String secret1 = request.getParameter("secret1");
		String secret2 = request.getParameter("secret2");
	%>
	
	<h2>전달된 내용</h2>
	<hr>
	
	<ul>
		<li> 이름 : <%=name%>
		<li> 암호 : <%=password %>
		<li> 나이 : <%=age %>
		<li> 성별 : <%=gender %>
		<li> 취미 : 
		<%
			if(habits==null)
				out.print("없음");
			else{
				for(int i=0; i<habits.length; i++)
					out.print(habits[i] + (i == habits.length-1 ? "" : ", "));
			}
		%>
		<li> 좋아하는 색 : <%=color.equals("") ? "없음" : color %>
		<li> 좋아하는 음식 :
		<%
			if(foods==null)
				out.print("없음");
			else{
				for(int i=0; i<foods.length; i++)
					out.print(foods[i] + (i == foods.length-1 ? "" : ", "));
			}
		%>
		<li> 의견 : <%=opinion %>
		<li> 비밀1 : <%=secret1 %>
		<li> 비밀2 : <%=secret2 %>
	</ul>
	
	<hr>
	<a href=<%=request.getHeader("referer")%>>입력화면으로</a>
</body>
</html>