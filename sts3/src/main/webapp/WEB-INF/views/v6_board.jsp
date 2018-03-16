<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>게시판_v6</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty aaa}">
				<tr>
					<td colspan="5">자료가 없습니다.</td>
				</tr>
				</c:if>
				
				<c:if test="${!empty aaa}">
					<c:forEach var="vo" items="${aaa}">
					<form class="form" action="v6_boardc.do?brd_no=${vo.brd_no}" method="POST"></form>
					<tr>
						<td>${vo.brd_no}</td>
						<td><a href="#" class="href">${vo.brd_title}</a></td>
						<td>${vo.brd_writer}</td>
						<td align="right">${vo.brd_hit}</td>
						<td>${vo.brd_date}</td>
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<a href="v6_boardw.do" class="btn btn-success">글쓰기</a>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			//태그중에서 class가 href인 것이 클릭되면
			$('.href').click(function(){
				//class가 href인것 중에서 클릭된 것의 위치(0부터 시작)
				var idx = $(this).index('.href');	
				
				//class가 form인것의 idx가 일치하는 1개를 
				//input type="submit" 버튼을 클릭한것 처럼 처리.
				$('.form').eq(idx).submit();
			});
		});
	</script>	
</body>
</html>
