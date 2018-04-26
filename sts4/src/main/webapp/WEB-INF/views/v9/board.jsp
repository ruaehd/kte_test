<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>게시판목록</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	
	<div class="container">
		<div class="form-inline" style="margin-top:5px;margin-bottom:5px" 	align="right">
			<label> ${sessionScope._name}님 로그인</label> 
			<a href="v9_customerlogout.do" class="btn btn-default">로그아웃</a>
		</div>
		
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.no}</td>
					<td><a href="v9_boardcontent.do?no=${tmp.no}">${tmp.title}</a></td>
					<td>${tmp.writer}</td>
					<td>${tmp.hit}</td>
					<td>${tmp.date}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="v9_boardwrite.do" class="btn btn-success">글쓰기</a>
	</div>
	
		
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.twbsPagination-1.3.1.js"></script>
	<script>
		$(function(){
		
		});
	</script>	
</body>
</html>
