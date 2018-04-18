<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>websocket_클라이언트</title>
</head>

<body>
	<div class="container">
		<form:form action="login.do" modelAttribute="vo" method="post">
			<form:input type="text" path="id"/><br/>
			<form:input type="password" path="pw"/><br/>
			<input type="submit" value="로그인"/>
		</form:form>
	</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function() {
		
			
		});
	</script>	
</body>
</html>
