<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>수강신청목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>등록일</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.std_id}</td>
					<td>${vo.std_name}</td>
					<td>${vo.std_tel}</td>
					<td>${vo.std_date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>