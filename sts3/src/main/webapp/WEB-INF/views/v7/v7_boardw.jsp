<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v7_main</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form:form action="v7_boardw.do?code=${param.code}" method="post" modelAttribute="vo" enctype="multipart/form-data">
			글번호<form:input type="text" path="brd_no" readonly="true"/><br />
			글제목<form:input type="text" path="brd_title"/><br />
			글내용<form:textarea path="brd_content"/><br />
			아이디<form:input type="text" path="mem_id" readonly="true"/><br />
			<input type="file" name="img1" /><br />
			<input type="file" name="img2" /><br />
			<input type="file" name="img3" /><br />
			<input type="submit" value="글쓰기"/><br />
			<a href="v7_main.do">메인</a><br />
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