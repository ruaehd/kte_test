<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>테이블</title>
</head>

<body>
	<div class="container">
		<table id="table" border=1>
			<tr>
				<th>단어</th>
				<th>사용회수</th>
			</tr>
		</table>
	</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function() {
			$.get('http://192.168.2.46:8080/sts4/ajax_wordcount.do', function(data){
				console.log(data);
				var data = JSON.parse(data);
				var len = data.length;
				
				for(var i=0; i<len; i++){
					$('#table').append(
						'<tr>' +
							'<td>'+data[i]._id+'</td>' +
							'<td>'+data[i].value+'</td>' +
						'</tr>'	
					);	
				}
				
			});
		});	
	</script>	
</body>
</html>
