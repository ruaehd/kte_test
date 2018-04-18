<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>websocket_클라이언트</title>
</head>

<body>
	<div class="container">
		<input type="text" id="msg_box"/>
		<input type="button" id="btn_send" value="보내기" /><br />
		<div id="msg_member" style="border:1px solid #ccc">
			현재 접속자
		</div>
		<div id="msg_output" style="border:1px solid #ccc"></div>
	</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function() {
			var host = "ws://192.168.2.46:8080/sts4/wsserver.do?id=${sessionScope.SID}";
			var socket = new WebSocket(host);
			socket.onopen = function(){
				console.log('connect ok');
				
				$.get('http://192.168.2.46:8080/sts4/ajax_chatlist.do', function(data){
					var len = data.length;
					for(var i=0; i<len; i++){
						$('#msg_output').append(
							data[i].mem_id+']'+data[i].msg + '<br/>'		
						);	
					}
				});
			};
		
			
			socket.onmessage = function(msg){
				//String -> json object
				var jobj = JSON.parse(msg.data);
				console.log(jobj.id+","+jobj.cd+","+jobj.msg);
				
				if(jobj.cd == 1 || jobj.cd == 2) {
					$.get('http://192.168.2.46:8080/sts4/ajax_memberlist.do', function(data){
						var len = data.length;
						$('#msg_member').empty();
						for(var i=0;i<len;i++){
							$('#msg_member').append(data[i].id+"<br />");
						}
					},'json');
				}
				
				else if(jobj.cd == 3){
					
					$('#msg_output').prepend(jobj.id+":"+jobj.msg+'<br />');	
				}
				
			};
			
			$('#btn_send').click(function(){
				var msg = $('#msg_box').val();
				socket.send('{"id":"${sessionScope.SID}", "cd":3, "msg":"'+msg+'"}');
			});
			
		});	
	</script>	
</body>
</html>
