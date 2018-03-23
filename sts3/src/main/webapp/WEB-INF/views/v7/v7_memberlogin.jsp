<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v7_로그인</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form:form action="v7_memberlogin.do"	method="post" modelAttribute="vo">
		아이디<form:input type="text" path="mem_id" id="mem_id"/><br />
		암호<form:input type="password" path="mem_pw" /><br />
		
		<input type="submit" id="btn_login" value="로그인" />
		</form:form>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
	
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>
