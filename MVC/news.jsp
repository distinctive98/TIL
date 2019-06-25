<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.NewsVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	section {
		text-align : center;
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
	}
	
	tr:hover{
		background-color : gray;
		/* font-weight : bold; */
	}
	
	td:nth-child(2){
		width : 400px;
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
		});
	</script>

	<section>
	<%
		ArrayList<NewsVO> list = (ArrayList<NewsVO>)request.getAttribute("list");
		if(list != null) {
	%>
	
	<h1>뉴스 게시판</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	<%
		for(NewsVO vo : list) {
	%>
		<tr>
			<td><%=vo.getId() %></td>
			<td>
				<a href="/mvc/news?action=read&newsid=<%=vo.getId()%>"><%=vo.getTitle() %></a>
			</td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getWritedate() %></td>
			<td><%=vo.getCnt() %></td>
		</tr>
	<%
		}
	%>
	</table>
	<%
		}
	%>
	
	<button id="writeBtn" value="false">뉴스 작성</button>
	<div id="writeForm" style="display:none">
		<form method="post" action="/mvc/news">
			<input type="hidden" name="action" value="insert" id="hidden">
			<input type="hidden" name="id" id="id">
			<input type="text" name="writer" id="writer" placeholder="작성자명을 입력해주세요"><br>
			<input type="text" name="title" id="title" placeholder="제목을 입력해주세요"><br>
			<textarea name="content" id="content" placeholder="내용을 입력해주세요" rows="10" cols="50"></textarea><br>
			
			<div id="btnSet1">
				<button type="submit" id="btn1">저장</button>
				<button type="reset" id="btn2">재작성</button>
				<button type="button" id="btn3" onclick="$('#writeForm').css('display', 'none')">취소</button>
			</div>
			
			<div id="btnSet2">
				<button type="button" id="btn4">확인</button>
				<button type="submit" id="btn5">수정</button>
				<button type="button" id="btn6">삭제</button>
			</div>
		</form>
	</div>
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
				location.href = "/mvc/news?action=delete&newsid=<%=vo.getId()%>";
			});
		</script>
	<%
		}
	%>
	
	
</body>
</html>