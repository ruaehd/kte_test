<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>	<!-- 세션사용 -->
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
	<link rel="stylesheet" href="resources/css/navbar.css" />
</head>
<body>
	<div class="container">
	  <!-- Topper w/ logo -->
	  <div class="row hidden-xs topper">
	    <div class="col-xs-7 col-sm-7">
	      <a href="/khl91"><img am-TopLogo alt="SECUREVIEW"  src="http://blog.convertify.io/assets/images/logo--hero.png" class="img-responsive"></a>
	    </div>
	    <div class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-0 text-right ">
	      <c:if test="${sessionScope._email eq null}">
	      	<p><a href="login.do">로그인</a> / <a href="join.do">회원가입</a></p>
	      </c:if>
	      <c:if test="${sessionScope._email ne null}">
	      	<p>${sessionScope._name}님 / <a href="logout.do">로그아웃</a></p>
	      </c:if>
	    </div>
	  </div> <!-- End Topper -->
	  <!-- Navigation -->
	  <div class="row">
	    <nav class="navbar navbar-inverse" role="navigation">
	      <div class="container">
	        <!-- Brand and toggle get grouped for better mobile display -->
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand visible-xs-inline-block nav-logo" href="/"><img src="/images/logo-dark-inset.png" class="img-responsive" alt=""></a>
	        </div>
	
	        <!-- Collect the nav links, forms, and other content for toggling -->
	        <div class="collapse navbar-collapse navbar-ex1-collapse">
	          <ul class="nav navbar-nav js-nav-add-active-class">
	            <li><a href="/index.html">Home</a></li>
	            <li class="active"><a href="/markets.html">Markets</a></li>
	            <li><a href="/buy.html">Buy</a></li>
	            <li><a href="/svstrike.html">svStrike</a></li>
	            <li><a href="/training.html">Training</a></li>
	            <li><a href="/khl91/board.do">게시판</a></li>
	            <li class="visible-xs-block"><a href="/about.html">About Us</a></li>
	            <li class="visible-xs-block"><a href="/careers.html">Careers</a></li>
	            <li class="visible-xs-block"><a href="/press-release.html">Press Release</a></li>
	            <li class="visible-xs-block"><a href="https://susteen7.zendesk.com/hc/en-us">Support</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Company <b class="caret"></b></a>
	              <ul class="dropdown-menu" role="menu">
	                <li><a href="about.html">About Us</a></li>
	                <li><a href="careers.html">Careers</a></li>
	                <li><a href="press-release.html">Press Release</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right hidden-xs">
	            <a type="button" class="navbar-btn btn btn-gradient-blue" am-latosans="bold" href="https://susteen7.zendesk.com/hc/en-us">Support</a>
	          </ul>
	        </div><!-- /.navbar-collapse -->
	      </div>
	    </nav>
	  </div>
	</div>
	
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script>
		$(function(){
			
		});
	</script>
</body>
</html>
