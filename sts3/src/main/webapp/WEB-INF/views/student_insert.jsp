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
		<form:form action="student_insert.do" method="post" modelAttribute="vo">
			<form:input type="text" path="std_id" placeholder="학번" />
			<form:input type="text" path="std_name" placeholder="이름" />
			<form:input type="text" path="std_tel" placeholder="전화번호" />
			<input type="submit" value="학생등록" />
		</form:form>
	</div>
</body>
</html>