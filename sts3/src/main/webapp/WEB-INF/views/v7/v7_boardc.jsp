<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<% pageContext.setAttribute("nl", "\n"); %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v7_main</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		글번호 : <label>${vo.brd_no}</label><br />
		글제목 : <label>${vo.brd_title}</label><br />
		글내용 : <label>${fn:replace(vo.brd_content, nl, "<br />")}</label><br />
		조회수 : <label><fmt:formatNumber value="${vo.brd_hit}" pattern="#,###" /></label><br />
		작성자 : <label>${vo.mem_id}</label><br />
		날짜 : <label><c:set var ="arr" value="${fn:split(vo.brd_date, '')}" />${arr[0]}</label><br />
		이미지1 : <img src="selectImg.do?no=${vo.brd_no}&idx=1" width="50px" height="50px"><br />
		이미지2 : <img src="selectImg.do?no=${vo.brd_no}&idx=2" width="50px" height="50px"><br />
		이미지3 : <img src="selectImg.do?no=${vo.brd_no}&idx=3" width="50px" height="50px"><br />
		
		<a href="v7_board.do?code=${param.code}" class="btn btn-primary btn-sm">글목록</a>
		<a href="" class="btn btn-primary btn-sm">이전글</a>
		<a href="" class="btn btn-primary btn-sm">다음글</a>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
	
	<script>
		$(function() {
			
		});
	</script>	
</body>
</html>
