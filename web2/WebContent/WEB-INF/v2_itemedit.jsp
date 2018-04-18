<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품수정</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v2_itemedit.do" method="post">
			<div style="width:600px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>물품수정</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>물품번호</p>
					</div>
					<div class="w3-rest">
						<input type="hidden" name="no" value="${vo.no}">
						${vo.no}
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>물품명</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="name" class="w3-input w3-border w3-round" value="${vo.name}" />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>가격</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="price" class="w3-input w3-border w3-round" value="${vo.price}" />
					</div>
				</div>
							
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>수량</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="qty" class="w3-input w3-border w3-round" value="${vo.qty}" />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>등록일</p>
					</div>
					<div class="w3-rest">
						${vo.date1}
						
					</div>
				</div>
				
				<hr />
				
				<div align="right">
					<input type="submit" id="btn_edit" class="w3-button w3-blue w3-round" value="수정"/>
					<a href="v2_iteminsert1.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
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