<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	
	<div class="w3-container">
		<div style="width:800px; margin:10px auto; padding:30px; border:1px solid #ccc;">
			<h3>게시글</h3>
			<hr />
			
			<div>
				<table class="w3-table w3-bordered">
					<tr>
						<th style="width:10%">글제목</th>
						<td style="width:40%">${vo.title}</td>
						<th style="width:10%">작성자</th>
						<td style="width:40%">${vo.writer}</td>
					</tr>
				
					<tr>
						<th>작성일</th>
						<td>${vo.writedate}</td>
						<th>조회수</th>
						<td>${vo.hit}</td>
					</tr>
				
					<tr>
						<th>내용</th>
						<td colspan="3">${vo.content}</td>
					</tr>
				</table>
			
			</div>
			
			<hr />
			
			<div class="w3-row">
				<div class="w3-col" style="width:40%">
					<a href="boarde.do?no=${vo.no}" class="w3-button w3-tiny w3-blue w3-round">수정</a>
					<a href="#" class="w3-button w3-tiny w3-red w3-round" id="btn_delete">삭제</a>
				</div>
				<div class="w3-rest">
					<div class="w3-right">
					
						<c:if test="${prev!=0}">
							<a href="boardc.do?no=${prev}" class="w3-button w3-tiny w3-brown w3-round">이전글</a>
						</c:if>
						<c:if test="${prev==0}">
							<a href="#" class="w3-button w3-tiny w3-brown w3-round w3-disabled" >이전글</a>
						</c:if>
						
						<a href="board.do" class="w3-button w3-tiny w3-green w3-round">목록</a>
						
						<c:if test="${next!=0}">
							<a href="boardc.do?no=${next}" class="w3-button w3-tiny w3-brown w3-round">다음글</a>
						</c:if>
						<c:if test="${next==0}">
							<a href="#" class="w3-button w3-tiny w3-brown w3-round w3-disabled">다음글</a>
						</c:if>
						
					</div>	
				</div>
			</div>
		</div>
	</div>



	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script>
		$(function(){
			$('#btn_delete').click(function(){
				swal({
					title: "삭제",
					text: "정말 삭제 하시겠습니까",
					icon: "warning",
					buttons: true,
					dangerMode: true,
					})
					.then((willDelete) => {
					if (willDelete) {
					  	window.location.href='boardd.do?no=${vo.no}'
						} 
					});
				});	
			});
	</script>
</body>
</html>