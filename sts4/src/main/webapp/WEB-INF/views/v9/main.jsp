<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v9_마켓</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<nav class="navbar navbar-fixed-top navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="v9_board.do">게시판</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${sessionScope._id eq null}">
						<li><a href="v9_customerlogin.do">로그인</a></li>
						<li><a href="v9_customerjoin.do">회원가입</a></li>
					</c:if>
					<c:if test="${sessionScope._id ne null}">
						<li><a href="v9_customerlogout.do">로그아웃</a></li>
						<li><a href="#">회원정보수정</a></li>
						<li><a href="#">비밀번호찾기</a></li>
					</c:if>
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</nav><!-- /.navbar -->
    
	<div class="container" style="margin-top:70px">
	
	
	
		<jsp:include page="footer.jsp"></jsp:include>
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
