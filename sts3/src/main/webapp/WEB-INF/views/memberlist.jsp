<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<div style="padding:30px 0; margin:0 auto">
			<h3>회원목록</h3>
			<hr />
			
			<table class="table">
				<tr>
					<th>이메일</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>가입일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.email}</td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
