<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
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
				<c:if test="${sessionScope._email eq null}">
					<p><a href="login.do">로그인</a> / <a href="join.do">회원가입</a></p>
				</c:if>
				<c:if test="${sessionScope._email ne null}">
					<p>${sessionScope._name}님 / <a href="logout.do">로그아웃</a></p>
				</c:if>
			</div>
		</div> <!-- End Topper -->
	  
		<div style="padding:30px 0; margin:0 auto">
			<h3>게시판</h3>
			<hr />
			<table class="table">
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>

					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.no}</td>
							<td><a href="boardcontent.do?no=${vo.no}">${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.hit}</td>
							<td>${vo.date1}</td>
						</tr>
					</c:forEach>

			</table>
			<hr />
			<ul id="pagination-demo" class="pagination-sm"></ul>
			<div align="right">
				<a href="boardwrite.do"><input type="button" class="btn btn-success" value="글쓰기"/></a>
			</div>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.11.1.js"></script>
	<script src="http://ihongss.com/assets/js/jquery.twbsPagination-1.3.1.js"></script>
	<script>
		$(function(){
			$('#pagination-demo').twbsPagination({
				totalPages: 35,
				visiblePages: 7,
				href:'?page={{number}}',
				//initiateStartPageClick : false,
				onPageClick: function (event, page) {
					/* window.location.href="board.do?page="+ page; */
			        }
			    });
		});
	</script>
</body>
</html>