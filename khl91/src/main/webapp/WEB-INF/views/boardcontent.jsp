<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="resources/css/navbar.css" />
</head>
<body>
	 
	<div class="container">
	
		<div class="row hidden-xs topper">
			<div class="col-xs-7 col-sm-7">
				<a href="/khl91"><img am-TopLogo alt="SECUREVIEW"  src="http://blog.convertify.io/assets/images/logo--hero.png" class="img-responsive"></a>
			</div>
			<div class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-0 text-right ">
				
			</div>
		</div> <!-- End Topper -->
		
	  	
			<div style="width:800px; padding:30px 0; margin:10px auto">
				<h3>게시글</h3>
				<hr />
				<table class="table">
					<tr>
						<th style="width:10%">글번호</th>
						<td style="width:40%">${vo.no}</td>
						<th style="width:10%">작성자</th>
						<td style="width:40%">${vo.writer}</td>
					</tr>
					<tr>
						<th>글제목</th>
						<td>${vo.title}</td>
						<th>작성일</th>
						<td>${vo.date1}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">${fn:replace(vo.content, newLineChar, "<br />")}</td>
					</tr>
					<tr>
						<th>이미지1</th>
						<td colspan="3"><img src="boardimg.do?no=${vo.no}&idx=1" width="200px"></td>
					</tr>
					<tr>
						<th>이미지2</th>
						<td colspan="3"><img src="boardimg.do?no=${vo.no}&idx=2" width="200px"></td>
					</tr>
					<tr>
						<th>이미지3</th>
						<td colspan="3"><img src="boardimg.do?no=${vo.no}&idx=3" width="200px"></td>
					</tr>
				</table>
				<hr />
				<div align="right">
					<a href="board.do" class="btn btn-info">목록</a>
					<a href="boarddelete.do?no=${vo.no}" class="btn btn-danger">삭제</a>
					<a href="boardreply.do?no=${vo.no}" class="btn btn-success">댓글</a>
				</div>
			</div>

	</div>

</body>
</html>