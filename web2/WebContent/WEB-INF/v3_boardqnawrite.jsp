<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>질문 작성</title>

	<link rel="stylesheet" href="css/bootstrap-4.0.0.min.css" />
	<link rel="stylesheet" href="css/summernote-bs4.css">
	
</head>
<body>
	<div class="container">
		<div style="width: 600px; border: 1px solid #ccc; padding:30px; margin: 30px auto;">
			<form action="" method="post">
				<h3>질문 작성</h3>
				<hr />
				<div class="form-inline" style="margin-bottom: 10px">
					<label style="width:100px">글번호</label>
					<input type="text" class="form-control" style="width:300px" name="no" value="${lastno+1}" readonly/>
				</div>
				<div class="form-inline" style="margin-bottom: 10px">
					<label style="width:100px">제목</label>
					<input type="text" class="form-control" style="width:300px" name="title" />
				</div>
				<div class="form-inline" style="margin-bottom: 10px">
					<label style="width:100px">작성자</label>
					<input type="text" class="form-control" style="width:300px" name="writer" />
				</div>
				<div class="form-inline" style="margin-bottom: 10px">
					<label style="width:100px">비밀번호</label>
					<input type="password" class="form-control" style="width:300px" name="pw" />
				</div>
				<div class="form-inline" style="margin-bottom: 10px">
					<label style="width:100px">내용</label>
					<textarea name="content" class="form-control" style="width:300px; resize:none" rows="6" id="content" name="content"></textarea>
				</div>
				
				<hr />
				<div align="right">
					<input type="submit" class="btn btn-success" value="글쓰기" />
				</div>
			</form>
		</div>
	</div>
	
	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap-4.0.0.min.js"></script>
	<script src="js/summernote-bs4.js"></script>
	
	<script>
	$(function(){
			$('#content').summernote({
		        placeholder: '내용을 입력하세요.',
		        tabsize: 2,
		        height: 300
		 });
	});
	</script>

</body>
</html>