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
			<form:form action="v1_radiobutton.do" modelAttribute="mvo" method="post" id="form">
				<form:radiobuttons class="" path="radio" items="${list}" />
				<hr />
				
				<c:forEach var="tmp" items="${list}">
					<div>
						<form:radiobutton path="radio" value="${tmp}" />${tmp}
					</div>
				</c:forEach>
				
				<input type="submit" class="btn btn-success" value="수정" />
			
			</form:form>
		</div>
	</div>
	
	
</body>
</html>
