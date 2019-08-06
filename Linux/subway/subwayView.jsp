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
</head>
<body>

	<div class="container text-center" style="width:60%">
	<h1>지하철정보</h1>
	<hr>
		<c:if test="${vo != null}">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Line</th>
						<th scope="col">Time</th>
						<th scope="col">Ride</th>
						<th scope="col">Takeoff</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${vo}">
						<tr>
							<th scope="row">${vo.line}</th>
							<td>${vo.time}</td>
							<td>${vo.ride}</td>
							<td>${vo.takeoff}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>