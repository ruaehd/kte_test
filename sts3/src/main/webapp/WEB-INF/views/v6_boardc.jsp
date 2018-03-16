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
			<tr>
				<th>글번호</th>
				<td>${vo.brd_no}</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${vo.brd_title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${vo.brd_content}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${vo.brd_writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.brd_hit}</td>
			</tr>
		
			<tr>
				<th>날짜</th>
				<td>${vo.brd_date}</td>
			</tr>					
		</table>
		<c:if test="${pno != 0}">
			<a href="v6_boardc.do?brd_no=${pno}" class="btn btn-success">이전글</a>
		</c:if>
		<c:if test="${nno != 0}">
			<a href="v6_boardc.do?brd_no=${nno}" class="btn btn-success">다음글</a>
		</c:if>
		
		<a href="v6_board.do" class="btn btn-success">목록</a>
		
		<hr />
		<textarea rows="6" id="txt_content" class="form-control"></textarea>
		<div class="form-inline">
			<input type="text" id="txt_writer" class="form-control" placeholder="작성자">
			<input type="button" id="btn_reply" class="btn btn-primary" value="글쓰기">
		</div>
		<hr />
		<table class="table" id="table">
			<c:forEach var="tmp1" items="${brvo}">
				<tr>
					<td>${tmp1.rep_content}</td>
					<td>${tmp1.rep_writer}</td>
					<td>${tmp1.rep_date}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$('#btn_reply').click(function(){
				var result= confirm('등록 하시겠습니까?');
				
				if(result){
					var tc =$('#txt_content').val();
					var tw =$('#txt_writer').val();
					var bn = '${vo.brd_no}';
					
					//$.post('서버주소', {전달값}, function(data){
					//$.get('서버주소?전달값&전달값', function(data){
					$.post('ajax_v6_board_reply.do', {brd_no:bn, rep_content:tc, rep_writer:tw}, function(data){	
						$('#table').prepend(
							'<tr>'+
								'<td>'+ data.rep_content + '</td>' +
								'<td>'+ data.rep_writer + '</td>' +
								'<td>'+ data.rep_date + '</td>' +
							'</tr>'
						);
					}, 'json');
				}
			});
		});
	</script>	
</body>
</html>
