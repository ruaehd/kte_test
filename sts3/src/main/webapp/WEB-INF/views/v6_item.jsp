<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">	
		<select id="item1" class="form-control">
			<c:forEach var="tmp" items="${list}">
				<option  value="${tmp.itma_no}">${tmp.itma_name}</option>		
			</c:forEach>
		</select>
		<select id="item2" class="form-control">
			<option>중분류</option>		
		</select>
		<select id="item3" class="form-control">
			<option>소분류</option>		
		</select>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			var item_change = function(){
				var str = $('#item1').val();
				//alert(str);
				$.post('ajax_v6_item_b.do', {itema_code:str}, function(data){
					$('#item2').empty();
					var len = data.length;
					for(var i=0; i<len; i++){
						$('#item2').append(
							'<option value="'
								+ data[i].itmb_no + '">'+data[i].itmb_name +
							'</option>'
						);
					};
					item_change1();
				}, 'json');
			}

			item_change();
			
			
			//대분류가 변경되면
			$('#item1').change(function(){
				item_change();
			});
			
			var item_change1 = function(){
				var str = $('#item2').val();
				$.post('ajax_v6_item_c.do', {itemb_code:str}, function(data){
					$('#item3').empty();
					var len = data.length;
					for(var i=0; i<len; i++){
						$('#item3').append(
							'<option value="'
								+ data[i].itmc_no + '">'+data[i].itmc_name +
							'</option>'
						);
					};
				}, 'json');
			}
			

			
			$('#item2').change(function(){
				item_change1();
			});
		});
	</script>
</body>
</html>
