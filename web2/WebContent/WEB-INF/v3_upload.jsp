<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>

	<div class="container">
		<form action="v3_json_upload.do" method="post" enctype="multipart/form-data">
			<input type="text" name="code" />
			<input type="file" name="file1" />
			<input type="submit" value="업로드" />
		</form>
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			
		});
	</script>
</body>
</html>