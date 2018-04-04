<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>mongodb</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<form action="mongodb_insert.do" method="post">
			아이디<input type="text" name="id"/><br />
			암호<input type="password" name="pw" /><br />
			이름<input type="text" name="name" /><br />
			<input type="submit" value="회원가입" />
		</form>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>