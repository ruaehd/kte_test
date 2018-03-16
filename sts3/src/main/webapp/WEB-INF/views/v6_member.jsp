<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>v6_member</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<form:form action="v6_member.do" method="post" modelAttribute="vo"><br />
			<form:input type="text" path="mem_id" placeholder="아이디"/><br />
			<form:input type="password" path="mem_pw" placeholder="비밀번호"/><br />
			<form:input type="text" path="mem_name" placeholder="이름"/><br />
			<c:forEach var="tmp" items="${vo.list}" varStatus="i">
				<form:input type="hidden" path="list[${i.index}].memc_title" />
				<form:checkbox path="list[${i.index}].memc_title1"/>${tmp.memc_title}<br />
			</c:forEach><br />

			<input type="submit" class="btn btn-success" value="가입"/>
		</form:form>
		 
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
		});
	</script>
</body>
</html>
