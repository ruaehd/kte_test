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
				<td>${vo.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${vo.content}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${vo.writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.hit}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${vo.date}</td>
			</tr>
		</table>
		<c:if test="${prev !=0 }">
			<a href="v9_boardcontent.do?no=${prev}" class="btn btn-success">이전글</a>
		</c:if>
		<c:if test="${next !=0 }">
			<a href="v9_boardcontent.do?no=${next}" class="btn btn-success">다음글</a>
		</c:if>
		<a href="v9_board.do" class="btn btn-default">목록</a>
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
