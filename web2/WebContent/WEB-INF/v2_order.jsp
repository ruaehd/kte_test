<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문하기</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	<div class="w3-container" style="padding:30px">
		
		<div align="right">
			<c:if test="${sessionScope._id eq null}">
				<a href="v2_login.do" class="w3-button w3-blue w3-round">로그인</a>
				<a href="v2_custominsert.do" class="w3-button w3-green w3-round">회원가입</a>
			</c:if>
		
			<c:if test="${sessionScope._id ne null}">
				<label>${sessionScope._name}님 환영합니다.</label>
				<a href="v2_logout.do" class="w3-button w3-red w3-round">로그아웃</a>
			</c:if>
		</div>
		
		<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
		<h3>주문하기</h3>
		<hr />
			<table class="w3-table w3-bordered">
				<tr>
					<th>번호</th>
					<th>물품명</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
					<th>날짜</th>
				</tr>
				
				<c:forEach var="vo" items="${list}" varStatus="j">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td><label id="price_${j.index}">${vo.price}</label>원</td>
						<td>
							<select class="w3-select sel_cnt">
								<c:forEach var="i" begin="1" end="${vo.qty}">
									<c:if test="${vo.cnt == i}">
										<option selected>${i}</option>
									</c:if>
									
									<c:if test="${vo.cnt != i}">
										<option>${i}</option>
									</c:if>	
								</c:forEach>
							</select>
						</td>
						<td>
							<div id="sum_${j.index}">
								<fmt:formatNumber value="${vo.price*vo.cnt}" pattern="#,###" />원
							</div>
						</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	<script>
		
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}

	
		$(function(){
			$('.sel_cnt').change(function(){
				var idx = $(this).index('.sel_cnt');
				var cnt = $(this).val();
								
				var price = $('#price_'+idx).text();
				var sum = cnt * price;
				
				$('#sum_'+idx).text(numberWithCommas(sum)+'원');			

			});
		});
	</script>
</body>
</html>