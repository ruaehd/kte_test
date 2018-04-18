<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공급업체</title>
	<link rel="stylesheet" href="css/w3.css" />
	<link rel="stylesheet" href="css/jquery-ui.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v3_delivery.do" method="post">
			
			<div style="margin:0px auto; padding:10px" align="right">
				<div>
					<a href="v3_provider.do" class="w3-button w3-blue w3-round" >공급업체</a>
					<a href="v3_product.do" class="w3-button w3-green w3-round" >상품</a>
					<a href="v3_delivery.do" class="w3-button w3-indigo w3-round" >납품</a>
					<a href="v3_member.do" class="w3-button w3-red w3-round" >회원</a>
					<a href="v3_sale.do" class="w3-button w3-teal w3-round" >판매</a>
					<c:if test="${sessionScope._no eq null}">
						<a href="v3_login.do" class="w3-button w3-black w3-round">로그인</a>
					</c:if>
					<c:if test="${sessionScope._no ne null}">
						<a href="v3_logout.do" class="w3-button w3-black w3-round">로그아웃</a>
					</c:if>
				</div>
			</div>
			
			<div style="margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>납품</h3>
				<hr />
				<table class="w3-table">
					<tr>
						<th>납품번호</th>
						<th>업체코드</th>
						<th>상품코드</th>
						<th>납품일자</th>
						<th>납품수량</th>
						<th>납품단가</th>
						<th>납품금액</th>
					</tr>
					<tr>
						<td><input type="text" name="no" value="${lastno}" readonly/></td>
						<td>
							<select class="w3-select" name="code_pv">
								<c:forEach var="tmp" items="${p_list}">
									<option value="${tmp}">${tmp}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select class="w3-select" name="code_pd">
								<c:forEach var="tmp" items="${d_list}">
									<option value="${tmp}">${tmp}</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="text" name="d_date" id="d_date"/></td>
						<td><input type="text" name="cnt" /></td>
						<td><input type="text" name="cost" /></td>
						<td><input type="text" name="price" /></td>
					</tr>
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" class="w3-button w3-green w3-round" value="물품등록"/>
				</div>
					
			</div>
		</form>
		<div style="margin:10px auto; border:solid 1px #ccc; padding:30px">
			<form action="#" method="post">
				<div align="right">
					<input type="submit" name="btn_edit" id="btn_update_chk" class="w3-button w3-indigo w3-round" value="선택수정"/>
					<input type="button" id="btn_delete_chk" class="w3-button w3-red w3-round" value="선택삭제"/>
				</div>
				
				<table class="w3-table w3-bordered">
					<tr>
						<th><input type="checkbox" id="chk_all" /></th>
						<th>납품번호</th>
						<th>업체코드</th>
						<th>상품코드</th>
						<th>납품일자</th>
						<th>납품수량</th>
						<th>납품단가</th>
						<th>납품금액</th>
						<th>날짜</th>
						<th>비고</th>
					</tr>
					
					<c:if test="${empty list}">
						<tr>
							<td colspan="10">자료가 없습니다.</td>
						</tr>
					</c:if>
					
					<c:if test="${!empty list}">
						<c:forEach var="vo" items="${list}">
							<tr>
								<td><input type="checkbox" class="chk" name="chk[]" value="" /></td> 
								<td>${vo.no}</td>
								<td>${vo.code_pv}</td>
								<td>${vo.code_pd}</td>
								<td>${vo.d_date}</td>
								<td>${vo.cnt}</td>
								<td>${vo.cost}</td>
								<td>${vo.price}</td>
								<td>${vo.date1}</td>
								<td>
									<a href="v3_deliveryedit.do?no=${vo.no}" class="w3-button w3-tiny w3-blue w3-round" >수정</a>
									<a href="v3_deliverydelete.do?no=${vo.no}" class="w3-button w3-tiny w3-red w3-round btn_delete">삭제</a>
								</td>
							</tr>	
						</c:forEach>
					</c:if>
				</table>
			</form>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script>
		$(function(){
			$('#d_date').datepicker({
				dateFormat : 'yymmdd'
			});
		});
	</script>		

</body>
</html>