<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>관리자</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="row" style="margin:10px">
		<div class="col-md-2">
			<jsp:include page="menu.jsp"></jsp:include>
		</div>
		<div class="col-md-10">
			<c:if test="${param.menu==0}">
				<h4>판매자 관리</h4>
				<div align="right">
					<a href="#" class="btn btn-primary" id="btn_insert">판매자등록</a>
				</div>
				<hr />
				<table class="table">
					<tr>
						<th>사업자번호</th>
						<th>상호</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>등록일</th>
						<th>업태</th>
						<th>비고</th>
					</tr>
						<c:forEach var="tmp" items="${slist}">
							<tr>
								<td>${tmp.cr_number}</td>
								<td>${tmp.name}</td>
								<td>${tmp.tel}</td>
								<td>${tmp.addr}</td>
								<td>${tmp.date}</td>
								<td>${tmp.bc_name}</td>
								<td></td>
							</tr>
						</c:forEach>
				</table>
				<div align="center">
					<ul id="pagination" class="pagination"></ul>
				</div>
			</c:if>
		</div>
	</div>
	
	<c:if test="${param.menu==0}">
		<form:form action="v9_insertseller.do" modelAttribute="vo0" method="post">
			<div class="modal fade" id="insertmodal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4>판매자 등록</h4>
						</div>
						<div class="modal-body">
							<div class="form-inline" style="margin-bottom:5px">
								<label style="width:120px">사업자 번호</label>
								<form:input type="text" class="form-control" path="cr_number" placeholder="사업자등록번호"/>
							</div>
							<div class="form-inline" style="margin-bottom:5px">
								<label style="width:120px">상호</label>
								<form:input type="text" class="form-control" path="name" placeholder="상호"/>
							</div>
							<div class="form-inline" style="margin-bottom:5px">
								<label style="width:120px">전화번호</label>
								<form:input type="text" class="form-control" path="tel" placeholder="전화번호"/>
							</div>
							<div class="form-inline" style="margin-bottom:5px">
								<label style="width:120px">주소</label>
								<form:input type="text" class="form-control" path="addr" placeholder="주소"/>
							</div>
							<div class="form-inline" style="margin-bottom:5px">
								<label style="width:120px">업태</label>
								<form:select class="form-control" path="code">
									<c:forEach var="vo" items="${bc_list}">
										<option value="${vo.code}">${vo.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="등록" />
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:if>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="https://cdnjs.loli.net/ajax/libs/twbs-pagination/1.3.1/jquery.twbsPagination.min.js"></script>
	
	<script>
		$(function() {
			
			$('#pagination').twbsPagination({
				totalPages:15,
				visiblePages:10,
				href:'?menu=${param.menu}&page={{number}}'
			});
			
			$('#btn_insert').click(function(){
				$('#insertmodal').modal('show');
			})
		});
	</script>	
</body>
</html>
