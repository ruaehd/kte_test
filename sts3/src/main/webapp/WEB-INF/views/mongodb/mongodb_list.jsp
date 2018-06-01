<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>mongodb_목록</title>
	<link rel="stylesheet" href="resources/css/bootstrap-4.0.0.css" />
</head>

<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
			</tr>

			<c:forEach var="tmp" items="${list}">
			<tr>
				<td>${tmp.id}</td>
				<td>${tmp.pw}</td>
				<td>${tmp.name}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	
	<script>
		$(function() {

		});
	</script>	
</body>
</html>
