<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>수강신청목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
	
		<c:if test="${sessionScope.std_id eq null}">
			<a href="student_login.do">로그인</a>
			<a href="student_insert.do">회원가입</a>
		</c:if>
		<c:if test="${sessionScope.std_id ne null}">
			${sessionScope.std_name}님 로그인 
			<a href="course_app.do">수강신청</a>
			<a href="course_applist.do">수강신청목록</a>
			<a href="student_logout.do">로그아웃</a>
		</c:if>
	</div>
</body>
</html>