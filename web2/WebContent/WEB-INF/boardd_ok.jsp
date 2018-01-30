<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 삭제</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script>
		$(function(){
			swal({
				  title: "삭제완료",
				  text: "삭제되었습니다.",
				  icon: "success",
				  button: "확인",
				})
			.then((value) => {
				window.location.href ='board.do';
			});
		});
	</script>
</body>
</html>