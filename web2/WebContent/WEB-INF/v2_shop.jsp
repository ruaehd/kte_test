<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>shop</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	<div class="w3-container" style="padding:30px">
		<div>
			<c:if test="${sessionScope._id eq null}">
				<a href="v2_login.do" class="w3-button w3-blue w3-round">로그인</a>
				<a href="v2_custominsert.do" class="w3-button w3-green w3-round">회원가입</a>
			</c:if>
		
			<c:if test="${sessionScope._id ne null}">
				<label>${sessionScope._name}님 환영합니다.</label>
				<a href="v2_logout.do" class="w3-button w3-red w3-round">로그아웃</a>
				<a href="v2_cartlist.do" class="w3-button w3-indigo w3-round">장바구니</a>
			</c:if>
		</div>
		
		
		<div class="w3-row-padding">
			<c:forEach var="vo" items="${list}">
				<div class="w3-third" style="padding:10px">
					<img src="imgs/Tulips.jpg" style="width:100%" />
					<div style="border:solid 1px #ccc; padding:10px">
						<h5>${vo.name}</h5>
						<p>내용</p>
						<p>${vo.price1}원</p>
						<p>
							<select class="w3-select sel_cnt">
								<c:forEach var="i" begin="1" end="${vo.qty}">
									<option>${i}</option>
								</c:forEach>
							</select>
						</p>
						<div align="center">
							<a href="v2_cart.do?no=${vo.no}" class="w3-button w3-round w3-green btn_cart">장바구니</a>
							<a href="v2_order.do?no=${vo.no}" class="w3-button w3-round w3-blue btn_order">주문하기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	<script>
		$(function(){
			$('.btn_cart').click(function(){
				//기존에 fref에 있는 내용을 읽음 v2_cart?no=10
				var href = $(this).attr('href');
				//수량을 얻기위한 위치
				var idx = $(this).index('.btn_cart');
				//수량얻기
				var cnt = $('.sel_cnt').eq(idx).val();
				//기존 href에 &cnt=갯수를 포함해서 href변경
				$(this).attr('href', href+"&cnt="+cnt);
			});
			
			$('.btn_order').click(function(){
				//기존에 fref에 있는 내용을 읽음 v2_cart?no=10
				var href = $(this).attr('href');
				//수량을 얻기위한 위치
				var idx = $(this).index('.btn_order');
				//수량얻기
				var cnt = $('.sel_cnt').eq(idx).val();
				//기존 href에 &cnt=갯수를 포함해서 href변경
				$(this).attr('href', href+"&cnt="+cnt);
			});
			
		});
	</script>
</body>
</html>