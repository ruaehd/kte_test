<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원삭제</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<form:form action="v6_memberdeletelist.do" modelAttribute="mlist" method="post">
			<table class="table">
				<tr>
					<th>체크</th>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>가입일</th>
				</tr>
				<c:forEach var="vo" items="${list}" varStatus="i">
					<tr>
						<td><input name="chk[]" type="checkbox" value="${vo.mem_id}"/></td>
						<td>${vo.mem_id}</td>
						<td>${vo.mem_pw}</td>
						<td>${vo.mem_name}</td>
						<td>${vo.mem_date}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" class="btn btn-success" value="전체삭제" />
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
