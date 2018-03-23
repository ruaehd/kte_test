<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v7_main</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<c:if test="${sessionScope.vo.mem_id eq null}">
			<a href="v7_memberlogin.do">로그인</a>
			<a href="#">아이디/비밀번호 찾기</a>
			<a href="v7_memberjoin.do">회원가입</a>
		</c:if>
		<c:if test="${sessionScope.vo.mem_id ne null}">
			${sessionScope.vo.mem_name}님 로그인
			<a href="v7_memberedit.do">회원정보 수정</a>
			<a href="#">비밀번호 변경</a>
			<a href="v7_memberlogout.do">로그아웃</a>
		</c:if>
		
		<a href="#">게시판</a>
		<a href="#">오시는 길</a>
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
