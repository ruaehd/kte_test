<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
	<script>
		$(function(){
			alert('${msg}');
			window.location.href='${url}';
		});
	</script>
</body>
</html>