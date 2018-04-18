<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>물품삭제</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form action="deleteitem.do" method="post">
			<table class="table">
				<tr>
					<th>선택</th>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>재고수량</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<th><input type="checkbox" name=chk[] value="${vo.no}"/></th>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td>${vo.price}</td>
						<td>${vo.qty}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="선택삭제" />
		</form>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>
