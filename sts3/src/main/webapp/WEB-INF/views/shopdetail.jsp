<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>상품목록</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link href="resources/css/mycss2.css" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet">

</head>
<body>

	<div class="container">

		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<script async
						src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- e commers -->
					<ins class="adsbygoogle" style="display: block"
						data-ad-client="ca-pub-9155049400353686" data-ad-slot="5554792257"
						data-ad-format="auto"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>

					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="get_blob_img1.do?code=${vo.code}&idx=img1" />
							</div>
							<div class="tab-pane" id="pic-2">
								<img src="get_blob_img1.do?code=${vo.code}&idx=img2" />
							</div>
							<div class="tab-pane" id="pic-3">
								<img src="get_blob_img1.do?code=${vo.code}&idx=img3" />
							</div>
							<div class="tab-pane" id="pic-4">
								<img src="get_blob_img1.do?code=${vo.code}&idx=img4" />
							</div>
							<div class="tab-pane" id="pic-5">
								<img src="get_blob_img1.do?code=${vo.code}&idx=img5" />
							</div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
							<li class="active"><a data-target="#pic-1" data-toggle="tab"><img
									src="get_blob_img1.do?code=${vo.code}&idx=img1" /></a></li>
							<li><a data-target="#pic-2" data-toggle="tab"><img
									src="get_blob_img1.do?code=${vo.code}&idx=img2" /></a></li>
							<li><a data-target="#pic-3" data-toggle="tab"><img
									src="get_blob_img1.do?code=${vo.code}&idx=img3" /></a></li>
							<li><a data-target="#pic-4" data-toggle="tab"><img
									src="get_blob_img1.do?code=${vo.code}&idx=img4" /></a></li>
							<li><a data-target="#pic-5" data-toggle="tab"><img
									src="get_blob_img1.do?code=${vo.code}&idx=img5" /></a></li>
						</ul>

					</div>
					
					<div class="details col-md-6">
						<form action="order.do?code=${vo.code}" method="post" id="form">
							<h3 class="product-title">${vo.name}</h3>
							
							<p class="product-description">${vo.content}</p>
							<h4 class="price">
								가격 <span>${vo.price}</span>
							</h4>
							<h4 class="price">
								수량 <select name="cnt">
									<c:forEach var="i" begin="1" end="100">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>
							</h4>
							<div class="action">
								<input type="submit"class="like btn btn-default" value="구매하기">
								<button class="add-to-cart btn btn-default" type="button" id="btn_cart">장바구니</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			//id가 btn_cart인 것이 클릭되면
			$('#btn_cart').click(function(){
				//id가 form인 것의 action속성값을 cart.do?code=${vo.code}로 변경
				$('#form').attr('action', 'cart.do?code=${vo.code}');
				//form태그가 submit버튼이 눌려진 것처럼 처리
				$('#form').submit();
			});
		});
	</script>

</body>
</html>
