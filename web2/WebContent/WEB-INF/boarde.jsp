<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	
	<div class="w3-container">
		<form action="boarde.do" method="post">
			<div style="width:800px; margin:10px auto; padding:30px; border:1px solid #ccc;">
				<h3>게시글 수정</h3>
				<hr />
				
				<div>
					<input type="hidden" name="no" value="${vo.no}" />
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>글제목</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="title" class="w3-input w3-border w3-round" value="${vo.title}" />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>작성자</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="writer" class="w3-input w3-border w3-round" value="${vo.writer}" />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>내용</p>
					</div>
					<div class="w3-rest">
						<textarea class="w3-input w3-border w3-round" name="content" rows="6" style="resize:none">${vo.content}</textarea>
					</div>
				</div>
				<hr />
				
				<div align="right">
					<input type="submit" class="w3-button w3-blue w3-round" value="수정"/>
					<a href="boardc.do?no=${vo.no}"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>
			
			</div>
		</form>
	</div>



	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			
		});
	</script>
</body>
</html>