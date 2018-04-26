<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>판매자 관리페이지</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	
	<div class="row" style="padding-left:10px; padding-right:10px">
		<div class="col-md-12">
			<div>
				<ul class="nav nav-tabs">
					<c:forEach var="str" items="${menu_name}" varStatus="i">
						<c:if test="${i.first}">
							<li class="active">
								<a href="#${menu_url[i.index]}" data-toggle="tab">${str}</a>
							</li>
						</c:if>
						<c:if test="${!i.first}">
							<li>
								<a href="#${menu_url[i.index]}" data-toggle="tab">${str}</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<div class="tab-content">
					<c:forEach var="str" items="${menu_url}" varStatus="i">
						<c:if test="${i.first}">
							<div class="tab-pane active" id="${str}">
								${menu_name[i.index]}
								
								<table class="table">
									<tr>
										<th>코드</th>
										<th>상품명</th>
										<th>설명</th>
										<th>가격</th>
										<th>재고수량</th>
										<th>날짜</th>
									</tr>		
									<c:forEach var="tmp" items="${list}">
										<tr>
											<td>${tmp.code}</td>
											<td>${tmp.name}</td>
											<td>${tmp.content}</td>
											<td>${tmp.price}</td>
											<td>${tmp.qty}</td>
											<td>${tmp.date}</td>
										</tr>
									</c:forEach>						
								</table>
							</div>
						</c:if>
						<c:if test="${!i.first}">
							<div class="tab-pane" id="${str}">${menu_name[i.index]}</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
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
