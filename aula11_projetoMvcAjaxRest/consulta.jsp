<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@ page import="entity.*, persistence.*, dto.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>${msg}</h2>
<ul>
	<c:forEach items="${lista}" var="linha">
		<li>(${linha.usuario}) - (${linha.endereco})</li>
	</c:forEach>
</ul>

</body>
</html>