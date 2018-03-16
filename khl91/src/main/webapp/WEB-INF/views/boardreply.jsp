<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
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
		
	  	
			<div style="width:800px; padding:30px 0; margin:10px auto">
				<h3>댓글</h3>
				<hr />
				<form:form action="boardreply.do" method="post" modelAttribute="brvo">		
					<div align="center">
						<div class="form-inline" style="margin-bottom:10px">
							<label style="width:100px">글번호</label>
							<form:input type="text" path="no" style="width:50%" class="form-control" readonly="true"/>
						</div>
						<div class="form-inline" style="margin-bottom:10px">
							<label style="width:100px">내용</label>
							<form:textarea path="content" style="width:50%; resize:none" class="form-control" rows="6"/>
						</div>
						<div class="form-inline" style="margin-bottom:10px">
							<label style="width:100px">작성자</label>
							<form:input type="text" path="writer" style="width:50%" class="form-control"/>
						</div>
						<div class="form-inline" style="margin-bottom:10px">
							<label style="width:100px">게시글 번호</label>
							<form:input type="text" path="board_no" style="width:50%" class="form-control" readonly="true"/>
						</div>
					</div>
					<hr />
					<div align="right">
						<input type="submit" class="btn btn-success" value="글쓰기"/>
						<a href="/khl91/board.do"><input type="button" class="btn btn-info" value="취소"/></a>
					</div>
				</form:form>
				
			</div>

	</div>

</body>
</html>