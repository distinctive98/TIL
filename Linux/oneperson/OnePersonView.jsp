<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
</head>
<body>
	<div class="container text-center" style="width: 60%">
		<h1>1인 가구 정보</h1>
		<hr>
		<button type="button" onclick="print(1)" class="btn btn-primary btn-lg btn-block">1인 가구가 많은 순으로 전체 출력</button><br>
		<button type="button" onclick="print(2)" class="btn btn-primary btn-lg btn-block">1인 가구 명수 구별로 출력</button><br>
		<button type="button" onclick="print(3)" class="btn btn-primary btn-lg btn-block">1인 가구수가 제일 많은 동의 구, 동 출력</button><br>
		<button type="button" onclick="print(4)" class="btn btn-primary btn-lg btn-block">1인 가구수가 제일 많은 구 출력</button><br>
		<form method="get" action="/springedu/one/search">
			<div class="input-group mb-3">
		  		<input type="text" name="area" class="form-control" placeholder="점검하려는 구 입력" aria-label="Recipient's username" aria-describedby="button-addon2">
			  	<div class="input-group-append">
		    		<button class="btn btn-primary" type="submit" id="button-addon2">검색</button>
		  		</div>
			</div>
		</form>
		<hr>
	
		<c:choose>
			<c:when test="${select1 != null}">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">구</th>
							<th scope="col">동</th>
							<th scope="col">1인 가구 수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${select1}">
							<tr>
								<td>${vo.area1}</td>
								<td>${vo.area2}</td>
								<td>${vo.cnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${select2 != null}">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">구</th>
							<th scope="col">1인 가구 수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${select2}">
							<tr>
								<td>${vo.area1}</td>
								<td>${vo.cnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${select3 != null}">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">구</th>
							<th scope="col">동</th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="vo" items="${select3}">
							<tr>
								<td>${vo.area1}</td>
								<td>${vo.area2}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${select4 != null}">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">구</th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="vo" items="${select4}">
							<tr>
								<td>${vo.area1}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${search != null}">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">구</th>
							<th scope="col">동</th>
							<th scope="col">1인 가구 수</th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="vo" items="${search}">
							<tr>
								<td>${vo.area1}</td>
								<td>${vo.area2}</td>
								<td>${vo.cnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>
	</div>
	
	<script>
		function print(num){
			location.href = "/springedu/one/select?num="+num;
		};
	</script>
</body>
</html>