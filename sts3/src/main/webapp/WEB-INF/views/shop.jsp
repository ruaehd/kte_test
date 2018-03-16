<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>상품목록</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link href="resources/css/mycss.css" rel="stylesheet" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
	<div class="container">
		<div class="row">

			<c:forEach var="vo" items="${list}">
				<div class="col-md-4">

					<div class="product-item">
						<div class="pi-img-wrapper">
							<h3>
								<a href="shop-item.html">상품코드 : ${vo.code}</a>
							</h3>
							<img src="get_blob_img.do?code=${vo.code}"
								class="img-responsive" alt="Berry Lace Dress">
							<div>
								<a href="#" class="btn">Zoom</a> <a href="shop_detail.do?code=${vo.code}" class="btn">View</a>
							</div>
						</div>
						<h3>
							<a href="shop-item.html">상품명 : ${vo.name}</a>
						</h3>
						<div class="pi-price">가격 : ${vo.price}</div>
						<a href="javascript:;" class="btn add2cart">Add to cart</a>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<hr />
	<div class="container">
		<div class="row">
			<div class="form-inline">
				<c:forEach var="vo" items="${list}">
					<div class="col-md-4"
						style="width: 300px; border: solid 1px #ccc; margin: 10px">
						<p>${vo.code}</p>
						<p>${vo.name}</p>
						<p>${vo.content}</p>
						<p>${vo.price}</p>
						<p>${vo.qty}</p>
						<p>${vo.date1}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2028d6af91e6cdd61e23fc95d8e4dcf4"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new daum.maps.Map(container, options);
	</script>

<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</body>
</html>
