<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<!DOCTYPE html>
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
				
			</div>
		</div> <!-- End Topper -->
		
	  	<form:form action="boardwrite.do" modelAttribute="bvo" method="post">
			<div style="width:800px; padding:30px 0; margin:10px auto">
				<h3>글쓰기</h3>
				<hr />
				<div align="center">
					<div class="form-inline" style="margin-bottom:10px">
						<label style="width:100px">글번호</label>
						<form:input type="text" path="no" style="width:50%" class="form-control" readonly="true"/>
					</div>
					<div class="form-inline" style="margin-bottom:10px">
						<label style="width:100px">글제목</label>
						<form:input type="text" path="title" style="width:50%" class="form-control" autofocus="autofocus"/>
					</div>
					<div class="form-inline" style="margin-bottom:10px">
						<label style="width:100px">작성자</label>
						<form:input type="text" path="writer" style="width:50%" class="form-control" readonly="true"/>
					</div>
					<div class="form-inline" style="margin-bottom:10px">
						<label style="width:100px">내용</label>
						<form:textarea rows="6" path="content" style="width:50%" class="form-control" ></form:textarea>
					</div>
				</div>
				<hr />
				<div align="right">
					<input type="submit" class="btn btn-success" value="글쓰기"/>
					<a href="/khl91/board.do"><input type="button" class="btn btn-info" value="취소"/></a>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>