<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>도서대출목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>대출번호</th>
				<th>대출시작일</th>
				<th>대출종료일</th>
				<th>도서명</th>
				<th>대출자</th>
				<th>반납</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.checkout_no}</td>
					<td>${vo.checkout_start_date}</td>
					<td>${vo.checkout_end_date}</td>
					<td>${vo.book_title}</td>
					<td>${vo.member_name}</td>
					<td><a href="book_checkoutdel.do?code=${vo.checkout_no}" class="btn btn-success">반납</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>