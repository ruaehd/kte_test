<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<form:form action="student_login.do" method="post" modelAttribute="vo">
			<form:input type="text" path="std_id" placeholder="학번" />
			<form:input type="text" path="std_name" placeholder="이름" />
			<input type="submit" value="로그인" />
		</form:form>
	</div>
</body>
</html>