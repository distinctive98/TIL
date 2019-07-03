<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.NewsVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
	body {
		background: linear-gradient(45deg, #399E98 25%, #3aa19b 25%, #3aa19b 50%, #399E98 50%, #399E98 75%, #3aa19b 75%, #3aa19b);
  		background-size:100px 100px;
	}
	
	section {
		text-align : center;
		background-color : white;
		margin-top : 50px;
		padding-top : 15px;
		padding-bottom : 30px;
		border-radius : 200px;
	}
	
	input {
		width : 370px;
	}
	
	a {
		text-decoration : none;
	}
	
	table {
		width : 60%;
		margin : 0 auto;
		
	}
	
	td {
		border-bottom : 1px dotted gray;
		height : 30px;
	}
	
	tr:hover{
		background-color : #bfbfbf;
		/* font-weight : bold; */
	}
	
	td:nth-child(2){
		width : 300px;
		padding-left : 10px;
	}
	
	tr:nth-child(1){
		background-color : #00b3b3;
	}
	
	#writeBtn, #newsBtn{
		margin-bottom : 10px;
	}
	
	.writeInput{
		margin-bottom : 5px;
	}
</style>

</head>
<body>
	<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#writeBtn").click(function(){
				if($("#writeBtn").val() == "true"){
					$('#writeForm').css("display", "none");
					$("#writeBtn").val("false");
				} else {
					$('#writeForm').css("display", "block");
					$("#writeBtn").val("true");
				}
				$("#btnSet1").css("display", "block");
				$("#btnSet2").css("display", "none");
			});
			
			$("#newsBtn").click(function(){
				location.href = "http://70.12.113.182:8000/mvc/news";
			});
		});
	</script>

	<section>
	<%
		ArrayList<NewsVO> list = (ArrayList<NewsVO>)request.getAttribute("list");
		if(list != null) {
	%>
	<h1><a href="http://70.12.113.182:8000/mvc/news"><span style="color:#009999">NEWS</span></a></h1>
	<table>
		<tr style="font-weight:bold">
			<td>번호</td>
			<td style="text-align:left">제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	<%
		for(NewsVO vo : list) {
	%>
		<tr>
			<td><%=vo.getId() %></td>
			<td style="text-align:left">
				<a href="http://70.12.113.182:8000/mvc/news?action=read&newsid=<%=vo.getId()%>"><%=vo.getTitle() %></a>
			</td>
			<td>
				<a href="http://70.12.113.182:8000/mvc/news?action=listwriter&writer=<%=vo.getWriter()%>"><%=vo.getWriter() %></a>
			</td>
			<td><%=vo.getWritedate() %></td>
			<td><%=vo.getCnt() %></td>
		</tr>
	<%
		}
	%>
	</table>
	
	<br>
	
	<form method="get" action="http://70.12.113.182:8000/mvc/news">
		<select name="searchType">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="hidden" name="action" value="search">
		<input type="text" name="key"/>
		<button type="submit">뉴스검색</button>
	</form>
	
	<br>
	
	<% 
		String isSearch = (String)request.getAttribute("isSearch");
		if(isSearch != null) {
	%>
		<button id="newsBtn" class="btn btn-secondary">뉴스 홈</button>
	<%
		}
	%>
	
	<button id="writeBtn" value="false" class="btn btn-secondary">뉴스 작성</button>
	
	<div id="writeForm" style="display:none">
		<form method="post" action="http://70.12.113.182:8000/mvc/news">
			<input type="hidden" name="action" value="insert" id="hidden">
			<input type="hidden" name="id" id="id">
			<input type="text" name="writer" id="writer" class="writeInput" placeholder="작성자명을 입력해주세요"><br>
			<input type="text" name="title" id="title" class="writeInput" placeholder="제목을 입력해주세요"><br>
			<textarea name="content" id="content" class="writeInput" placeholder="내용을 입력해주세요" rows="10" cols="50"></textarea><br>
			
			<div id="btnSet1">
				<button type="submit" id="btn1" class="btn btn-light">저장</button>
				<button type="reset" id="btn2" class="btn btn-light">재작성</button>
				<button type="button" id="btn3" class="btn btn-light" onclick="$('#writeForm').css('display', 'none')">취소</button>
			</div>
			
			<div id="btnSet2">
				<button type="button" id="btn4" class="btn btn-light">확인</button>
				<button type="submit" id="btn5" class="btn btn-light">수정</button>
				<button type="button" id="btn6" class="btn btn-light">삭제</button>
			</div>
		</form>
	</div>
	
	<%
		}
	%>
	
	</section>
	
	<%
		NewsVO vo = (NewsVO)request.getAttribute("listOne");
		if(vo != null){
	%>
		
		<script>
			$("#writeBtn").css("display", "none");
			$("#writeForm").css("display", "block");
			
			$("#hidden").val("update");
			$("#id").val("<%=vo.getId()%>")
			$("#writer").val("<%=vo.getWriter()%>");
			$("#title").val("<%=vo.getTitle()%>");
			$("#content").val("<%=vo.getContent()%>");
			
			$("#btnSet1").css("display", "none");
			$("#btnSet2").css("display", "block");
			
			$("#btn4").click(function(){
				$("#writeBtn").css("display", "inline");
				$("#writeForm").css("display", "none");
				
				$("#hidden").val("insert");
				$("#id").val("")
				$("#writer").val("");
				$("#title").val("");
				$("#content").val("");
			});
			
			$("#btn6").click(function(){
				location.href = "http://70.12.113.182:8000/mvc/news?action=delete&newsid=<%=vo.getId()%>";
			});
		</script>
	<%
		}
	%>
	
	
</body>
</html>