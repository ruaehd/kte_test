<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>물품등록</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form action="insertitem.do" method="post">
			<table>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>재고수량</th>
				</tr>
				<c:forEach var="i" begin="1" end="5" step="1">
					<tr>
						<td><input type="text" name="no[]" value="${no+i}" readonly/></td>
						<td><input type="text" name="name[]" /></td>
						<td><input type="text" name="price[]" /></td>
						<td><input type="text" name="qty[]" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="등록" />
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
