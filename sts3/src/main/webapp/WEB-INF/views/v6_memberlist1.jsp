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
		<form:form action="v6_memberupdate1.do" modelAttribute="mlist" method="post">
			<table class="table">
				<tr>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>가입일</th>
				</tr>
				<c:forEach var="vo" items="${mlist.list}" varStatus="i">
					<tr>
						<td><form:input type="text" path="list[${i.index}].mem_id" readonly="true" /></td>
						<td><form:input type="text" path="list[${i.index}].mem_pw" /></td>
						<td><form:input type="text" path="list[${i.index}].mem_name" /></td>
						<td><input type="text" value="${vo.mem_date}" readonly /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" class="btn btn-success" value="전체수정" />
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
