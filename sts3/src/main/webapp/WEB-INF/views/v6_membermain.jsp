<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>v6_member</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<c:if test="${sessionScope.map.id eq null}">
			<a href="v6_memberlogin.do">로그인</a>
		</c:if>
		<c:if test="${sessionScope.map.id ne null}">
			${sessionScope.map.name}님 로그인
			<a href="v6_memberlogout.do">로그아웃</a>
		</c:if>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
		});
	</script>
</body>
</html>
