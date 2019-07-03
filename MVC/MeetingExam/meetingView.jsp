<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	td {
		border-bottom : 1px dotted gray;
	}
	
	tr:hover{
		background-color : gray;
		/* font-weight : bold; */
	}
	
	td:nth-child(3){
		width : 400px;
		
	}
</style>

<body>
	<%
		ArrayList<MeetingVO> list = (ArrayList<MeetingVO>)request.getAttribute("list");
		if(list != null){
	%>
	
	<h2>Meeting Schedule List</h2>
	<hr>
	
	<table>
	
	<% 
		for(MeetingVO vo : list){ 
	%>		
		<tr>
			<td><%=vo.getId() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getMeetingDate() %></td>
			<td><a href='/mvc/meeting?id=<%=vo.getId()%>'><img src="/mvc/images/delete.png" width="30"></a></td>
		</tr>
	<% 
		} 
	%>
	
	</table>
	
	<%
		} else {
	%>
		<h2> ${msg} </h2>
	<%
		}
	%>
	
	<hr>
	
	<a href='${ header.referer }'>방명록 홈 화면으로 가기</a>
</body>
</html>