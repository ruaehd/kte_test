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
		<form:form action="v7_memberedit.do" method="post" modelAttribute="obj">
			아이디<form:input type="text" id="mem_id" path="mem_id" readonly="true"/><br />
			이름<form:input type="text" path="mem_name" /><br />
			전화번호<form:input type="text" path="mem_tel" /><br />
			이메일<form:input type="text" path="mem_email" /><br />
			<input type="submit" id="btn_edit" value="회원수정" />
			<a href="v7_main.do">메인</a>
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
