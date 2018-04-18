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
		<form action="v3_deliveryedit.do" method="post">
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
						<td><input type="text" name="no" value="${vo.no}" readonly/></td>
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
						<td><input type="text" name="d_date" id="d_date" value="${vo.d_date}"/></td>
						<td><input type="text" name="cnt" value="${vo.cnt}"/></td>
						<td><input type="text" name="cost" value="${vo.cost}"/></td>
						<td><input type="text" name="price" value="${vo.price}"/></td>
					</tr>
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" class="w3-button w3-green w3-round" value="물품등록"/>
				</div>
					
			</div>
		</form>
		
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