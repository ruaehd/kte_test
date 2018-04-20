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
		<div class="col-md-10" style="border-left:1px solid #cccccc">
			<c:if test="${param.menu == 0}">
				<h4>판매자 관리</h4>
				
				<div align="right" style="margin-bottom:5px">
					<a href="#" id="btn_insert" class="btn btn-success">판매자 등록</a> 
				</div>
				
				<table class="table">
					<tr>
						<th>번호</th>
						<th>사업자번호</th>
						<th>상호</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>등록일</th>
						<th>
							<select id="sel_bc" class="form-control">
								<option value="all">전체</option>
								<c:forEach var="vo" items="${bc_list}">
								<option value="${vo.code}" 
									${param.sel_bc==vo.code ? 'selected="selected"':''}>${vo.name}</option>
								</c:forEach>
							</select>
						</th>
						<th>비고</th>
					</tr>
					<c:forEach var="vo" items="${sel_list}" varStatus="i">
					<tr>
						<td>${(param.page-1)*10+i.count}</td>
						<td>${vo.cr_number}</td>
						<td>${vo.name}</td>
						<td>${vo.tel}</td>
						<td>${vo.addr}</td>
						<td>${vo.date}</td>
						<td>${vo.br_name}</td>
						<td>
							<a href="#" class="btn btn-xs btn-info">수정</a>
							<a href="#" class="btn btn-xs btn-danger">삭제</a>
						</td>
					</tr>
					</c:forEach>
				</table>
				<div align="center">
					<ul id="pagination" class="pagination"></ul>
				</div>
			</c:if>
		</div>
	</div>
	
	<div class="row" style="margin:10px">
		<div class="col-md-12">
			<hr />
			<div align="right">
				<label>2018 &copy; kte</label>
			</div>
		</div>
	</div>	
	
	<c:if test="${param.menu == 0}">
		<form:form action="v9_insertseller.do" modelAttribute="vo0" method="post">
		<div class="modal fade" id="insertmodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4>판매자등록</h4>
					</div>
					<div class="modal-body">
						<div class="form-inline" style="margin-top:3px; margin-bottom:3px">
							<label style="width:120px">사업자등록번호</label>
							<form:input type="text" path="cr_number" class="form-control" placeholder="사업자등록번호" />
						</div>
						
						<div class="form-inline" style="margin-top:3px; margin-bottom:3px">
							<label style="width:120px">상호</label>
							<form:input type="text" path="name" class="form-control" placeholder="상호" />
						</div>
						
						<div class="form-inline" style="margin-top:3px; margin-bottom:3px">
							<label style="width:120px">전화번호</label>
							<form:input type="text" path="tel" class="form-control" placeholder="전화번호" />
						</div>
						
						<div class="form-inline" style="margin-top:3px; margin-bottom:3px">
							<label style="width:120px">주소</label>
							<form:input type="text" path="addr" style="width:380px" class="form-control" placeholder="주소" />
						</div>
						
						<div class="form-inline" style="margin-top:3px; margin-bottom:3px">
							<label style="width:120px">업태</label>
							<form:select path="code" class="form-control">
								<c:forEach var="vo" items="${bc_list}">
								<form:option value="${vo.code}">${vo.name}</form:option>
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
		
		<form action="v9_deleteseller.do" method="get">
			<div class="modal fade" id="deletemodal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4>판매자삭제</h4>
						</div>
						<div class="modal-body">
							<div class="form-inline">
								사업자번호 : <input type="text" name="cr_number" class="form-control" 
									id="cr_number_update_modal" readonly/>
								<br /><br />
								<label>삭제 하시겠습니까?</label>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="삭제" />
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		
		<form action="v9_updateseller.do" method="post">
			<div class="modal fade" id="updatemodal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4>판매자수정</h4>
						</div>
						<div class="modal-body">
							<div class="form-inline">
								<label style="width:120px">사업자번호</label>							
								<input type="text" name="update_cr_number" class="form-control" 
									id="update_cr_number" readonly/>
							</div>
							<div class="form-inline">
								<label style="width:120px">상호</label>							
								<input type="text" name="update_name" class="form-control" 
									id="update_name"/>
							</div>	
							<div class="form-inline">
								<label style="width:120px">전화번호</label>							
								<input type="text" name="update_tel" class="form-control" 
									id="update_tel"/>
							</div>
							<div class="form-inline">
								<label style="width:120px">주소</label>							
								<input type="text" name="update_addr" class="form-control" 
									id="update_addr"/>
							</div>	
							<div class="form-inline">
								<label style="width:120px">등록일</label>							
								<input type="text" name="update_date" class="form-control" 
									id="update_date" readonly/>
							</div>
							<div class="form-inline">
								<label style="width:120px">업종</label>							
								<select name="update_bc_name" id="update_bc_name" class="form-control">
									<c:forEach var="vo" items="${bc_list}">
										<option value="${vo.code}" class="form-control">
											${vo.name}
										</option>
									</c:forEach>
								</select>
							</div>					
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="수정" />
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
	</c:if>
	
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.twbsPagination-1.3.1.js"></script>
	<script>
		$(function(){
			$('.btn-info').click(function(){
				//버튼 클릭 위치 얻기
				var idx = $(this).index('.btn-info');
				
				//java list -> js 2차원 배열로 변경 
				var arr = new Array();
				<c:forEach var="vo" items="${sel_list}">
					var arr1 = new Array();
					arr1.push("${vo.cr_number}");
					arr1.push("${vo.name}");
					arr1.push("${vo.tel}");
					arr1.push("${vo.addr}");
					arr1.push("${vo.date}");
					arr1.push("${vo.br_name}");
					arr1.push("${vo.code}");
					arr.push(arr1);
				</c:forEach>
				console.log(arr);
				
				$('#update_cr_number').val(arr[idx][0]);
				$('#update_name').val(arr[idx][1]);
				$('#update_tel').val(arr[idx][2]);
				$('#update_addr').val(arr[idx][3]);
				$('#update_date').val(arr[idx][4]);
				$('#update_bc_name').val( arr[idx][6] ).prop("selected", true);
				$('#updatemodal').modal('show');
			});
				
			
			$('.btn-danger').click(function(){
				var idx = $(this).index('.btn-danger');
				var arr = new Array();
				<c:forEach var="vo" items="${sel_list}">
					arr.push("${vo.cr_number}");
				</c:forEach>
				
				$('#cr_number_update_modal').val(arr[idx]);
				$('#deletemodal').modal('show');
			});
			
			$('#sel_bc').change(function(){
				var str = $(this).val();
				window.location.href
					="v9_admin.do?menu=${param.menu}&page=1&sel_bc="+str
			});
			
			$('#pagination').twbsPagination({
				totalPages:'${sel_list_cnt}',
				visiblePages:10,
				href:'?menu=${param.menu}&page={{number}}&sel_bc=${param.sel_bc}'
			});
			
			$('#btn_insert').click(function(){
				$('#insertmodal').modal('show');	
			});			
		});
	</script>	
</body>
</html>
