<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<form action="/usuario" method="post">
	Login
	<input type="text" name="login" id="login" required="required" placeholder="Login">
	<br/>
	Senha
	<input type="password" name="senha" id="senha" required="required" placeholder="Senha">
	<br/>
	Foto
	<input type="text" name="foto" id="foto" required="required" placeholder="Foto">
	<br/>
	<button type="submit">Enviar dados</button>
	</form>
	<br/>
	${msg}
	<br/>
	<a href="/listarservice"><button type="submit">Listar Service</button></a>
	<br/>
	<a href="/listar"><button type="submit">Listar</button></a>
	<br/>

	<h2>Consultar Usuário</h2>
	<table style="width:600px;height:250px">
		<thead>
			<tr>
				<td>Id</td>
				<td>Login</td>
				<td>Foto</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.login}</td>
					<td><img src="${item.foto}" width="150px" height="150px"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>