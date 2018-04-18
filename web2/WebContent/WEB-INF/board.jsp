<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class=w3-container>
		<div style="width:1500px; margin:10px auto; padding:30px">
			<h3>게시판</h3>
			<hr />
			<table class="w3-table w3-bordered">
				<tr>
					<th style="width:10%">글번호</th>
					<th style="width:50%">제목</th>
					<th style="width:10%">작성자</th>
					<th style="width:10%">조회수</th>
					<th style="width:20%">날짜</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.no}</td>
						<td><a href="boardc.do?no=${vo.no}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.hit}</td>
						<td>${vo.writedate}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
				<div class="w3-bar" align="center">
					<a href="#" class="w3-button">&laquo;</a>
					<c:forEach var="i" begin="1" end="${tot}">
				  		<a href="#" class="w3-button">${i}</a>
				  	</c:forEach>
					<a href="#" class="w3-button">&raquo;</a>
				</div>

			<a href="boardw.do" class="w3-button w3-blue w3-round w3-right">글쓰기</a>	
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
	
	</script>
</body>
</html>