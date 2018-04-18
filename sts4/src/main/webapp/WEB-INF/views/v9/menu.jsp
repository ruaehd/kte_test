<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<ul class="list-group">
	<c:forEach var="str" items="${menu_list}" varStatus="i">
		<c:if test="${param.menu == i.index}">
			<a class="list-group-item active" href="v9_admin.do?menu=${i.index}">${str}</a>
		</c:if>
		<c:if test="${param.menu != i.index}">
			<a class="list-group-item" href="v9_admin.do?menu=${i.index}">${str}</a>	
		</c:if>
	</c:forEach>
</ul>
