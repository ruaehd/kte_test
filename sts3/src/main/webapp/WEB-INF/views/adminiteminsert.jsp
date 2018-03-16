<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>상품등록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="admin_item_insert.do" modelAttribute="vo" method="post" enctype="multipart/form-data" class="form-horizontal">
				<h3>상품등록</h3>
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="code">상품코드</label>
					<div class="col-sm-5">
						<div class="form-inline">
							<select class="form-control" id="sel1">
								<option value="a">농산물</option>
								<option value="b">가공식품</option>
							</select>
							<select class="form-control" id="sel2">
								<option value="a">사과</option>
								<option value="b">배</option>
								<option value="c">귤</option>
							</select>
							<form:input type="text" class="form-control" id="code" path="code" readonly="true"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="name">상품명</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="name" path="name" placeholder="상품명을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="content">상품설명</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="content" path="content" placeholder="상품설명을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="price">상품가격</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="price" path="price" placeholder="상품가격을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="qty">상품수량</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="qty" path="qty" placeholder="상품수량을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">상품이미지</label>
					<div class="col-sm-5">
						<c:forEach begin="1" end="5" var="i">
							<input type="file" class="form-control" name="file_${i}" placeholder="상품이미지를 입력하세요" />
						</c:forEach>
					</div>
				</div>
				
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit"class="btn btn-success" value="상품등록" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			var s1 = $('#sel1').val();
			var s2 = $('#sel2').val();
			$('#code').val(s1+"-"+s2+"-");
			
			$('#sel1').change(function(){
				var s1 = $('#sel1').val();
				var s2 = $('#sel2').val();
				$('#code').val(s1+"-"+s2+"-");
			});
			
			$('#sel2').change(function(){
				var s1 = $('#sel1').val();
				var s2 = $('#sel2').val();
				$('#code').val(s1+"-"+s2+"-");
			});
		});
	</script>
	
</body>
</html>
