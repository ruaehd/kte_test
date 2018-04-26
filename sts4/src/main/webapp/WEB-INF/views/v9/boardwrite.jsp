<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>게시판 글쓰기</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<div class="row" style="margin-top:20px">
			<form:form action="v9_boardwrite.do" method="post" modelAttribute="vo">
				<div class="col-md-12" style="border-right:0px solid #cccccc">
					<h4>글쓰기</h4>
					<hr />
					<div class="form-inline">
						<label style="width:120px">제목</label>
						<form:input type="text" path="title" class="form-control" placeholder="제목" />
					</div>
					<div class="form-inline">
						<label style="width:120px">내용</label>
						<form:textarea class="form-control" path="content" rows="6" placeholder="내용"></form:textarea>
					</div>
					<div class="form-inline">
						<label style="width:120px">작성자</label>
						<form:input type="text" path="writer" class="form-control" placeholder="작성자" />
					</div>
					
					<div>
						<input type="submit" class="btn btn-success" value="글쓰기"/>
					</div>
				</div>
			</form:form>
		</div>
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
