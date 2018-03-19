<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>메인_v6</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<c:if test="${sessionScope.vo.mem_id eq null}">
			<a href="v6_memberlogin2.do">로그인</a>
		</c:if>
		
		<c:if test="${sessionScope.vo.mem_id ne null}">
			${sessionScope.vo.mem_name}님 로그인.
			<a href="v6_memberlogout2.do">로그아웃</a>
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
