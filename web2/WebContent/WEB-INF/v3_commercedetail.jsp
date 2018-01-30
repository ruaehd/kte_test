<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>물품상세</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/commercedetail.css" />
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    
</head>
<body>
	<div class="container">
	   
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
<!-- 				    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
e commers
<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-9155049400353686"
     data-ad-slot="5554792257"
     data-ad-format="auto"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script> -->
				    
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="v3_productgetimg1.do?code=${param.code}&idx=0" /></div>
						  <div class="tab-pane" id="pic-2"><img src="v3_productgetimg1.do?code=${param.code}&idx=1" /></div>
						  <div class="tab-pane" id="pic-3"><img src="v3_productgetimg1.do?code=${param.code}&idx=2" /></div>
						  <div class="tab-pane" id="pic-4"><img src="v3_productgetimg1.do?code=${param.code}&idx=3" /></div>
						  <div class="tab-pane" id="pic-5"><img src="v3_productgetimg1.do?code=${param.code}&idx=4" /></div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
						  <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="v3_productgetimg1.do?code=${param.code}&idx=0" /></a></li>	
						  <li><a data-target="#pic-2" data-toggle="tab"><img src="v3_productgetimg1.do?code=${param.code}&idx=1" /></a></li>
						  <li><a data-target="#pic-3" data-toggle="tab"><img src="v3_productgetimg1.do?code=${param.code}&idx=2" /></a></li>
						  <li><a data-target="#pic-4" data-toggle="tab"><img src="v3_productgetimg1.do?code=${param.code}&idx=3" /></a></li>
						  <li><a data-target="#pic-5" data-toggle="tab"><img src="v3_productgetimg1.do?code=${param.code}&idx=4" /></a></li>
						</ul>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title"> ${vo.name} </h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">Suspendisse quos? Tempus cras iure temporibus?</p>
						<h4 class="price">current price: <span>${vo.price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<h5 class="sizes">sizes:
							<span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span>
							<span class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						
						<h5 class="colors">colors:
							<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
							<span class="color green"></span>
							<span class="color blue"></span>
						</h5>
						
						<h5 class="colors">qty:
							<span>
								<select>
									<c:forEach var="i" begin="1" end="${vo.qty}">
										<option>${i}</option>
									</c:forEach>	
								</select>
							</span>
						</h5>
						
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button">add to cart</button>
							<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div role="tabpanel">
		  <!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
		    	<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">상품상세</a></li>
		   		<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">상품평</a></li>
		   		<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">상품문의</a></li>
		  		<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">배송/교환/반품 안내</a></li>
			</ul>
  				<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">...</div>
				<div role="tabpanel" class="tab-pane" id="profile">...</div>
				<div role="tabpanel" class="tab-pane" id="messages">...</div>
				<div role="tabpanel" class="tab-pane" id="settings">...</div>
			</div>
		</div>
	
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>