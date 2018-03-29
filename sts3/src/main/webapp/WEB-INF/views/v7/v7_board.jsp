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
		<c:forEach var="vo" items="${code}">
			<a href="v7_board.do?code=${vo.brd_cd_no}">${vo.brd_cd_title}</a>
		</c:forEach>
		<table class="table">
			<tr>
				<th>이미지</th>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="tmp" items="${list}">
				<tr>
					<td><img src="selectImg.do?no=${tmp.brd_no}&idx=1" width="50px" height="50px"></td>
					<td>${tmp.brd_no}</td>
					<td><a href="v7_boardc.do?no=${tmp.brd_no}&code=${param.code}">${tmp.brd_title}</a></td>
					<td>${tmp.mem_id}</td>
					<td>${tmp.brd_hit}</td>
					<td>${tmp.brd_date}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="v7_boardw.do?code=${param.code}" class="btn btn-success">글쓰기</a>
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
