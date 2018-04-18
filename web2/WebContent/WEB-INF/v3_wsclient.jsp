<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ws-client</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container" style="padding:30px 0">
		
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		<hr />
		
		<canvas id="myChart" width="400" height="400"></canvas>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/Chart.js"></script>
	<script>
		$(function(){
			//	var wsconn = new WebSocket("ws://211.110.165.201:8080/ws1/wsserver");
			//	var wsconn = new WebSocket("ws://192.168.2.29:8080/web2/wsserver");
			var wsconn = new WebSocket("ws://127.0.0.1/web2/wsserver");
			
			wsconn.onerror = function(event){
				$('#txt_out').append('error - '+event.data+'\n');
			};
			
			wsconn.onopen = function(event){
				$('#txt_out').append('접속됨'+'\n');
			};
			
			wsconn.onmessage = function(msg){
				console.log(data);
				var data =JSON.parse(msg.data);	//String => JSON
				
				//$('#txt_out').append(msg.data+'\n');
				$('#hit_'+data.no).text(data.hit);
				$('#txt_div').text(data.no+","+data.hit);
				//$('#txt_out').scrollTop($('#txt_out')[0].scrollHeight);
			};
			
			$.get('v3_json_boardqna.do?page=1'+'&txt=', function(data){
				console.log(data);
				var len = data.length;
				for(var i=0;i<len;i++){
					$('.table tbody').append(
						'<tr>'+
							'<td>'+data[i].no+'</td>'+
							'<td>'+data[i].title+'</td>'+
							'<td>'+data[i].writer+'</td>'+
							'<td id="hit_'+data[i].no+'">'+data[i].hit+'</td>'+
							'<td>'+data[i].date1+'</td>'+
						'</tr>'
					);
				}
			},'json');
		});
	</script>
</body>
</html>