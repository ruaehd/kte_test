<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>질문 및 답변</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top:30px">
			<div class="col-md-3" >
				<ul class="list-group">
					<li class="list-group-item">질문 및 답변</li>
					<li class="list-group-item">배송문의</li>
					<li class="list-group-item">반품안내</li>
				</ul>
			</div>
			<div class="col-md-9" style="border-left:1px solid #ccc">
				<div class="form-inline" style="margin:10px 0" align="right">
					<input type="text" id="txt_search" class="form-control" placeholder="검색어" />
					<input type="button" id="btn_search" class="btn btn-success" value="검색" />
				</div>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
					
					<c:if test="${empty list}">
						<tr>
							<td colspan="5" style="text-align:center">자료가 없습니다.</td>
						</tr>
					</c:if>
					
					<c:if test="${!empty list}">
						<c:forEach var="vo" items="${list}">
							<tr>
								<td>${vo.no}</td>
								<td><a href="v3_boardqnahit.do?no=${vo.no}">${vo.title}</a></td>
								<td>${vo.writer}</td>
								<td>${vo.hit}</td>
								<td>${vo.date1}</td>
							</tr>
						</c:forEach>	
					</c:if>
				</table>
				<div align="center">
					<ul id="mypagination" class="pagination"></ul>
				</div>
				<hr />
				<div align="right">
					<a href="v3_boardqnawrite.do" class="btn btn-primary">글쓰기</a>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.twbsPagination-1.3.1.js"></script>
	<script>
		$(function(){
			$('#mypagination').twbsPagination({
				totalPages:'${tot}',
				visiblePages:5,
				href : '?page={{number}}&txt=${param.txt}'
			});
			
			$('#btn_search').click(function(){
				//검색어를 받아와서 txt에 넣음
				var txt = $('#txt_search').val();
				//주소창을 변경
				window.location.href = "v3_boardqna.do?page=1&txt=" + encodeURIComponent(txt)	//한글변환		
			});

		});
	</script>
</body>
</html>