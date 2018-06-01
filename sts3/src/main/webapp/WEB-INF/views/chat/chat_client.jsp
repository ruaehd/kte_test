<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>websocket_클라이언트</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<input type="text" id="msg_box"/>
		<input type="button" id="btn_send" value="보내기" /><br />
		<div id="msg_output"></div>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			var host = "ws://192.168.2.24:8080/mvc/wsserver.do";
			var socket = new WebSocket(host);
			socket.onopen = function(){
				console.log('connect ok');
			};
			
			socket.onmessage = function(msg){
				console.log(msg.data);
				$('#msg_output').prepend(msg.data+'<br />');
			};
			
			$('#btn_send').click(function(){
				var msg = $('#msg_box').val();
				socket.send(msg);
			});
		});
	</script>	
</body>
</html>
