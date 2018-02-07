<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
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
						<th>글번호</th>
						<td>${vo.no}</td>
						<th>작성자</th>
						<td>${vo.writer}</td>
					</tr>
					<tr>
						<th>글제목</th>
						<td>${vo.title}</td>
						<th>작성일</th>
						<td>${vo.date1}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">${vo.content}</td>
					</tr>
				</table>
				<hr />
				<div align="right">
					<a href="/khl91/board.do"><input type="button" class="btn btn-info" value="목록"/></a>
				</div>
			</div>

	</div>

</body>
</html>