<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<c:choose>
		<c:when test="${ pageContext.request.method=='GET' }">
			<h2>궁금한 지역을 검색하세요</h2>
			<hr>
			<form method="POST" action="lating.jsp">
				<span>지역이름 : </span><input type="text" name="area">
				<button type="submit">검색하기</button>
			</form>
		</c:when>
		<c:otherwise>
			<c:catch var="err">
				 <c:import var="xmldata" 
				 	url="https://maps.googleapis.com/maps/api/geocode/xml?language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE">
				 	<c:param name="address" value="${ param.area }"></c:param>
				 </c:import>
				 <x:parse xml="${ xmldata }" varDom="xdata"></x:parse>
				 <h2>${ param.area }의 정보는 다음과 같습니다.</h2>
				 <hr>
				 <x:if select="$xdata//status='OK'">				
				 	<x:forEach select="$xdata//result">
				 		<span>주소 : </span><x:out select="formatted_address"/><br>
				 		<span>위도 : </span><x:out select="geometry/location/lat"/><br>
				 		<span>경도 : </span><x:out select="geometry/location/lng"/><br>
				 		<hr>
				 	</x:forEach>
				 </x:if>
				 <x:if select="$xdata//status!='OK'">
				 	<h3>${ param.area }, 이 지역은 존재하지 않습니다.</h3>
				 </x:if>
			</c:catch>
			<c:if test="${ !empty err }">
				<h3>오류 발생 : ${ err }</h3>
			</c:if>
			<hr>
			<a href="${ header.referer }">입력화면으로</a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>