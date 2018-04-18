<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품등록</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v2_iteminsert.do" method="post">
			<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>물품등록</h3>
				<hr />
				<table class="w3-table">
					<tr>
						<th>물품번호</th>
						<th>물품명</th>
						<th>가격</th>
						<th>수량</th>
					</tr>
					
					<c:forEach var="i" begin="1" end="2" step="1">
					<tr>
						<td><input type="text" name="no[]" value="${lastno+i}" readonly /></td>
						<td><input type="text" name="name[]" /></td>
						<td><input type="text" name="price[]" /></td>
						<td><input type="text" name="qty[]" /></td>
					</tr>
					
					</c:forEach>
					
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" id="btn_submit" class="w3-button w3-green w3-round" value="물품등록"/>
				</div>
					
			</div>
		</form>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	
	<script>
		$(function(){
		
		});
	</script>		

</body>
</html>