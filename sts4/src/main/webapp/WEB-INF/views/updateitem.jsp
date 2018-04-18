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
		<form:form action="updateitem.do" modelAttribute="vo" method="post">
		<table class="table">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>재고수량</th>
				<th>날짜</th>
			</tr>	
			<c:forEach var="tmp" items="${vo.list}" varStatus="i">
			<tr>
				<td><form:input type="text" path="list[${i.index}].no" readonly="true" /></td>
				<td><form:input type="text" path="list[${i.index}].name" /></td>
				<td><form:input type="text" path="list[${i.index}].price" /></td>
				<td><form:input type="text" path="list[${i.index}].qty" /></td>
				<td><form:input type="text" path="list[${i.index}].date1" readonly="true" /></td>
			</tr>	
			</c:forEach>
		</table>
		<input type="submit" class="btn btn-success" value="수정" />	
		</form:form>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>
