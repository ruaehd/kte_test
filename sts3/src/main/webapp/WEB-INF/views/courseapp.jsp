<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>수강신청</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<a href="student_main.do">메인</a>
		<form:form action="course_app.do" method="post" modelAttribute="vo">
			<form:input type="text" path="crs_code" readonly="true"/>
			<input type="text" value="${sessionScope.std_name}" readonly />
			<form:select path="dept_cd">
				<c:forEach var="tmp" items="${d_list}">
					<option value="${tmp.dept_cd}">${tmp.dept_name}</option>
				</c:forEach>
			</form:select>
			<form:select path="sjct_cd">
				<c:forEach var="tmp" items="${s_list}">
					<option value="${tmp.sjct_cd}">${tmp.sjct_name}</option>
				</c:forEach>
			</form:select>
			<input type="submit" value="수강신청" />
		</form:form>
	</div>
	
</body>
</html>