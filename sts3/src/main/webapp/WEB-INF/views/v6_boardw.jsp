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
		<form:form action="v6_boardw.do"
			method="POST" modelAttribute="vo">
			글번호:<form:input type="글번호" path="brd_no" /><br />
			글제목:<form:input type="글제목" path="brd_title" /><br />
			글내용:<form:textarea rows="6" path="brd_content"></form:textarea><br />
			작성자:<form:input type="작성자" path="brd_writer" /><br />
			<input type="submit" class="btn btn-success" value="글쓰기" />
		</form:form>	
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>
