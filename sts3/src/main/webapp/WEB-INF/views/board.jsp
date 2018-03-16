<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<div style="padding:30px 0; margin:0 auto">
			<h3>게시판</h3>
			<hr />
			
			<table class="table">
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.title}</td>
						<td>${vo.writer}</td>
						<td>${vo.hit}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
