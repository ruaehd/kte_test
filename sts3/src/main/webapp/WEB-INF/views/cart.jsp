<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>장바구니</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<div style="padding:30px 0; margin:0 auto">
			<h3>장바구니</h3>
			<hr />
			
			<table class="table">
				<tr>
					<th>번호</th>
					<th>상품코드</th>
					<th>상품명</th>
					<th>주문자</th>
					<th>수량</th>
					<th>가격</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.item_no}</td>
						<td>${vo.i_name}</td>
						<td>${vo.m_name}</td>
						<td>${vo.cnt}</td>
						<td>${vo.price}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>
