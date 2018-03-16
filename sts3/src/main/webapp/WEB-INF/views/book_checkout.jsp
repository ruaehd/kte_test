<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<form:form action="book_checkout.do" method="post" modelAttribute="vo">
			<form:input type="text" path="checkout_no" placeholder="대출코드" />
			<form:input type="text" path="checkout_start_date" placeholder="시작일" />
			<form:input type="text" path="checkout_end_date" placeholder="종료일" />
			<form:select path="checkoutbook_code">
				<c:forEach var="tmp" items="${list}">
					<option value="${tmp.book_code}">${tmp.book_title}</option>
				</c:forEach>
			</form:select>
			<input type="submit" value="대출하기" />
		</form:form>
	</div>
</body>
</html>