<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>v1_join</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:600px; padding:30px 0; margin:0 auto">
			<form:form action="v1_select.do" modelAttribute="mvo" method="post" id="form">
				<form:select class="" path="select" items="${list}" />
				<hr />
				
				<form:select class="" path="selectmulti" items="${list}" />
				<input type="submit" class="btn btn-success" value="수정" />
			
			</form:form>
		</div>
	</div>
	
	
</body>
</html>
