<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>admin</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/admin.css" />

</head>
<body>

	<div id="throbber" style="display:none; min-height:120px;"></div>
	<div id="noty-holder"></div>
	<div id="wrapper">
	    <!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <!-- Brand and toggle get grouped for better mobile display -->
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	                <span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="http://cijulenlinea.ucr.ac.cr/dev-users/">
	                <img src="http://placehold.it/200x50&text=LOGO" alt="LOGO">
	            </a>
	        </div>
	        <!-- Top Menu Items -->
	        <ul class="nav navbar-right top-nav">
	            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
	                </a>
	            </li>            
	            <li class="dropdown">
	                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin User <b class="fa fa-angle-down"></b></a>
	                <ul class="dropdown-menu">
	                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
	                    <li><a href="#"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
	                    <li class="divider"></li>
	                    <li><a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
	                </ul>
	            </li>
	        </ul>
	        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	        <div class="collapse navbar-collapse navbar-ex1-collapse">
	            <ul class="nav navbar-nav side-nav">
	                <li>
	                    <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-search"></i> 상품관리 <i class="fa fa-fw fa-angle-down pull-right"></i></a>
	                    <ul id="submenu-1" class="collapse">
	                        <li><a href="v3_admin.do?menu=1&smenu=1"><i class="fa fa-angle-double-right"></i> 상품배치</a></li>
	                        <li><a href="v3_admin.do?menu=1&smenu=2"><i class="fa fa-angle-double-right"></i> 이미지등록</a></li>
	                        <li><a href="#"><i class="fa fa-angle-double-right"></i> SUBMENU 1.3</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="#" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-star"></i>  MENU 2 <i class="fa fa-fw fa-angle-down pull-right"></i></a>
	                    <ul id="submenu-2" class="collapse">
	                        <li><a href="#"><i class="fa fa-angle-double-right"></i> SUBMENU 2.1</a></li>
	                        <li><a href="#"><i class="fa fa-angle-double-right"></i> SUBMENU 2.2</a></li>
	                        <li><a href="#"><i class="fa fa-angle-double-right"></i> SUBMENU 2.3</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="investigaciones/favoritas"><i class="fa fa-fw fa-user-plus"></i>  MENU 3</a>
	                </li>
	                <li>
	                    <a href="sugerencias"><i class="fa fa-fw fa-paper-plane-o"></i> MENU 4</a>
	                </li>
	                <li>
	                    <a href="faq"><i class="fa fa-fw fa fa-question-circle"></i> MENU 5</a>
	                </li>
	            </ul>
	        </div>
	        <!-- /.navbar-collapse -->
	    </nav>
	
	    <div id="page-wrapper">
	        <div class="container-fluid">
	            <!-- Page Heading -->
	            <div class="row" id="main" >
	                <div class="col-sm-12 col-md-12 well" id="content">
	                    <c:if test="${param.menu ==1 && param.smenu==1}">
	                    	<h4>상품배치</h4>
	                    	<hr />
	                    	<div class="row" id="row">
		                    	<c:forEach var="vo" items="${list}">
		                    		<div class="col-md-4" id="${vo.code}">
		                    			<div class="alert alert-success">
		                    				<img src="v3_productgetimg.do?code=${vo.code}" width="70px" height="70px" /><br />
		                    				상품코드 : ${vo.code} <br /> 
		                    				상품명 : ${vo.name}
		                    			</div>
		                    		</div>	
		                    	</c:forEach>
	                    	</div>
	                    </c:if>
	                    
	                    <c:if test="${param.menu ==1 && param.smenu==2}">
	                		<h4>이미지 등록</h4>
	                    	<hr />
	                		<table class="table">
	                			<tr>
	                				<th>이미지</th>
	                				<th>상품코드</th>
	                				<th>상품명</th>
	                				<th>제조사</th>
	                				<th>판매단가</th>
	                				<th>소비자가</th>
	                				<th>재고수량</th>
	                				<th>등록일</th>
	                				<th>이미지</th>
	                			</tr>
	                			
	                			<c:forEach var="vo" items="${list}">
		                			<tr>
		                				<td><img src="v3_productgetimg.do?code=${vo.code}" width="70px" height="70px" /></td>
		                				<td>${vo.code}</td>
		                				<td>${vo.name}</td>
		                				<td>${vo.company}</td>
		                				<td>${vo.price}</td>
		                				<td>${vo.price_c}</td>
		                				<td>${vo.qty}</td>
		                				<td>${vo.date1}</td>
		                				<td>
		                					<form action="v3_admin_update_img1.do" method="post" enctype="multipart/form-data">
			                					<input type="hidden" name="code" value="${vo.code}" />
			                					<input type="file" name="file" />
			                					<input type="file" name="file1" />
			                					<input type="file" name="file2" />
			                					<input type="file" name="file3" />
			                					<input type="file" name="file4" />
			                					<input type="submit" class="btn btn-primary" value="등록" />
		                					</form>
		                				</td>
		                			</tr>
	                			</c:forEach>
	                		</table>
	                	</c:if>
	                </div>
	            </div>
	            <!-- /.row -->
	          	<c:if test="${param.menu ==1 && param.smenu==1}">
		            <form action="v3_admin.do?menu=1&smenu=1" method="post">
		            	<input type="hidden" name="items_idx" id="items_idx"/>
		            	<input type="submit" class="btn btn-success" value="변경적용" />
		            </form>
		        </c:if>
	        </div>
	        <!-- /.container-fluid -->
	    </div>
	    <!-- /#page-wrapper -->
	</div><!-- /#wrapper -->

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script>
		$(function(){
			$('#row').sortable({
				//정렬에 변화가 생기면
				update:function(event, ui){
					//id가 row이고 자식중에서 class가 col-md-4인 것을 반복
					var items = $('#row .col-md-4').map(function(i,e){
						//반복하면서 id값을 읽음
						var cd= $(this).attr('id');
											
						return cd;
					}).get();	
					$('#items_idx').val(items.toString());
					console.log(items.toString());
				}
							
			});

		    $('[data-toggle="tooltip"]').tooltip();
		    $(".side-nav .collapse").on("hide.bs.collapse", function() {                   
		        $(this).prev().find(".fa").eq(1).removeClass("fa-angle-right").addClass("fa-angle-down");
		    });
		    $('.side-nav .collapse').on("show.bs.collapse", function() {                        
		        $(this).prev().find(".fa").eq(1).removeClass("fa-angle-down").addClass("fa-angle-right");        
		    });
		})    
	</script>
</body>
</html>