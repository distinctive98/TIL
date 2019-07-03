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
	
	<h2>Meeting Schedule List(2)</h2>
	<hr>
	
	<table>
	
	<% 
		for(MeetingVO vo : list){ 
	%>		
		<tr>
			<td><%=vo.getId() %></td>
			<td class='<%= vo.getId() %>'><%=vo.getName() %></td>
			<td class='<%= vo.getId() %>'><%=vo.getTitle() %></td>
			<td class='<%= vo.getId() %>'><%=vo.getMeetingDate() %></td>
			<td><a href='/mvc/meeting?action=delete&id=<%=vo.getId()%>'><img src="/mvc/images/delete.png" width="30"></a></td>
			<td>		
				<img onclick="displayUpdateForm('<%=vo.getId() %>')" src="/mvc/images/edit.png" width="30">			
			</td>
		</tr>
	<% 
		} 
	%>
	
	</table>
	
	<%
		} 
		if(request.getAttribute("msg") != null) {
	%>
		<script> 
		alert('${msg}');
		</script>
	<%
		}
	%>
	
	<hr>
	<button onclick="displayDiv(1);">미팅 정보 작성</button>
	<button onclick="displayDiv(2);">미팅 정보 검색</button>
	<script>
		
		function displayDiv(type) {
			if(type==1) {
				document.getElementById("write").style.display='block';
				document.getElementById("search").style.display='none';
			} else if(type==2) {
				document.getElementById("write").style.display='none';
				document.getElementById("search").style.display='block';
			}
		}
		
		function displayUpdateForm(cv){
			var doms = document.getElementsByClassName(cv);
			document.getElementById("write").style.display = 'block';
			document.getElementById("name").value = doms[0].textContent;
			document.getElementById("title").value = doms[1].textContent;
			document.getElementById("divT").textContent = "미팅정보 수정";
			document.querySelector("#write [type=submit]").value="수정";
			document.querySelector("#write [type=hidden]").value=cv;
			//document.getElementById("action").value = "update";
			
			var str = doms[2].textContent;
			var ary = str.split(/\D+/g);
			var meeting_dt = ary[0]+"-"+ary[1]+"-"+ary[2]+"T"+ary[3]+":"+ary[4];
			document.getElementById("meetingDateTime").value = meeting_dt;
		}
	</script>
	<div id="write" style="display:none">
	<hr>
	<h2 id="divT">미팅정보 작성</h2>
		<form method="post" action="/mvc/meeting">
			<input type="hidden" name="action" value="insert" id="action">
			<span>미팅 대상 : </span><input type="text" name="name" id="name"><br>
			<span>미팅 목적 : </span><input type="text" name="title" id="title"><br>
			<span>미팅 시간 : </span><input type="datetime-local" name="meetingDateTime" id="meetingDateTime"><br>
			<input type="submit" value="등록">
			<input type="reset" value="재작성">
			<hr>
			<a href='${ header.referer }'>방명록 홈 화면으로 가기</a>
		</form>
	</div>
	<div id="search" style="display:none">
		<form method="get" action="/mvc/meeting">
			<span>정보 검색 : </span><input type="text" name="keyword">
			<input type="submit" value="검색">
			<hr>
			<a href='${ header.referer }'>방명록 홈 화면으로 가기</a>
		</form>
	</div>
	
</body>
</html>