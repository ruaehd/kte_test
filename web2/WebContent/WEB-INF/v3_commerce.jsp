<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>V3_관리자</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/admin.css" />
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css' />
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.1/css/font-awesome.css' />
	<link rel='stylesheet prefetch' href='https://cdn.rawgit.com/michalsnik/aos/2.1.1/dist/aos.css' />
	<link rel="stylesheet" href="css/commerce.css" />
</head>
<body>
	
	<div>
		<a href="v3_boardqna.do" class="btn btn-success">질문 및 답변</a>
		<a href="#" class="btn btn-success">반품안내</a>
	</div>
	
	<div class="group group-three" style="height:380px">
		<div class="group--container">	
			<div class="group--title" data-aos="zoom-out-up" data-aos-offset="500">
				<h2>Air Max Premium</h2>
				<div class="group--subtitle">
				   If the Shoe Fits Hover It. 
				</div>
			</div>
		</div>
	</div>
		
			
	<div class="group group-three">
		<div class="group--container">	
			<c:forEach var="vo" items="${list}" varStatus="i">
				
				<c:if test="${i.index %3 == 0}">
					<div class="card--style2 card--one" data-aos="fade-up">
						<div class="shoe--info">
							<span class="shoe--name">
								${vo.name}<br />
								${vo.company}
							</span>
							<span class="shoe--price">
								${vo.price }
							</span>
						</div> 
				
						<div class="shoe">
						  <a href="v3_commercedetail.do?code=${vo.code}"><img src="v3_productgetimg.do?code=${vo.code}" alt="nike air max premium red" /></a>
						</div>
				
						 <div class="shoe--colors">
							<ul class="colors">
							  <li data-color="#F5624D"></li>
							  <li data-color="#CC231E" class="active-color" ></li>
							  <li data-color="#34A65F"></li>
							</ul>
						 </div>
					</div>
				</c:if>
				
				<c:if test="${i.index %3 == 1}">
					<div class="card--style2 card--two" data-aos="fade-up">
						<div class="shoe--info">
							<span class="shoe--name">
								${vo.name}<br />
								${vo.company}
							</span>
							<span class="shoe--price">
								${vo.price }
							</span>
						</div> 
						
						<div class="shoe">
						    <a href="v3_commercedetail.do?code=${vo.code}"><img src="v3_productgetimg.do?code=${vo.code}" alt="nike air max essential black" /></a>
						</div>
				
						<div class="shoe--colors">
							<ul class="colors">
								  <li data-color="#F5624D"></li>
								  <li data-color="#CC231E" class="active-color" ></li>
								  <li data-color="#34A65F"></li>
							</ul>
						</div>
					</div>
				</c:if>
				
				<c:if test="${i.index %3 == 2}">
					<div class="card--style2 card--three" data-aos="fade-up">
					  
						<div class="shoe--info">
							<span class="shoe--name">
								${vo.name}<br />
								${vo.company}
							</span>
							<span class="shoe--price">
								${vo.price}
							</span>
						</div> 
						
						<div class="shoe">
							<a href="v3_commercedetail.do?code=${vo.code}"><img src="v3_productgetimg.do?code=${vo.code}" alt="nike air max 90" /></a>
						</div>
						
						<div class="shoe--colors">
							<ul class="colors">
								  <li data-color="#F5624D"></li>
								  <li data-color="#CC231E" class="active-color" ></li>
								  <li data-color="#34A65F"></li>
							</ul>
						</div>
					</div>
				</c:if>
				
				<div style="height:400px"></div>
			</c:forEach>
		</div>
	</div>	

	<div class="group group-three" style="height:190px">
		<div class="group--container">
			<div class="shop-all">
				<button class="button">shop collection</button>
			</div>
		</div>
	</div>
			

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script>
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
	<script src='https://cdn.rawgit.com/michalsnik/aos/2.1.1/dist/aos.js'></script>
	
	<script>// Variables
	var colorButton = $(".colors li");
	
	colorButton.on("click", function(){
		// console.log('clicked');
		
		// Remove class from currently active button
		$(".colors > li").removeClass("active-color");
		
		// Add class active to clicked button
		$(this).addClass("active-color");
		
		// Get background color of clicked
		var newColor = $(this).attr("data-color");
		// alert(newColor);
		
		// Change background of everything with class .bg-color
		$(".merry-christmas").css("background-color", newColor);
		
		// Change color of everything with class .text-color
		// $(".text-color").css("color", newColor);
	});
	AOS.init({
	  duration: 1200,
	});
</script>
</body>
</html>
