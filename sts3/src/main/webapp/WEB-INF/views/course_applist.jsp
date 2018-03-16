<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>수강신청목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<a href="student_main.do">메인</a>
		<table class="table">
			<tr>
				<th>수강신청번호</th>
				<th>학과명</th>
				<th>교과목명</th>
				<th>신청자</th>
				<th>날짜</th>
				<th>취소</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.crs_code}</td>
					<td>${vo.dept_name}</td>
					<td>${vo.sjct_name}</td>
					<td>${vo.std_name}</td>
					<td>${vo.crs_date}</td>
					<td><a href="course_appdel.do?code=${vo.crs_code}" class="btn btn-success">취소</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>