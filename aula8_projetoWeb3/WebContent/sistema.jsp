<!Doctype html>
<html>
<head></head>
<body>
	<h2>Gravar Usuario</h2>
	<form method="post" action="Controle?cmd=gravar">
	Nome
	<input type="text" id="nome" name="nome" size="15"/>
	<br>
	Email 
	<input type="email" id="email" name="email" size="15"/>
	<br>
	<button type="submit">Enviar Dados</button>
	</form>
	
	
	
	<br>
	<h2>Ativar Usuario</h2>
	<form method="get" action="AtivarUsuario">
	Email 
	<input type="email" id="email" name="email" size="15"/>
	<br>
	<button type="submit">Ativar Conta</button>
	</form>
${msg}
</body>
</html>




<!-- jsp importacao -->
<!-- jsp ManagerBean -->
<!-- Ativar o jstl -->
<%@ page import="entity.*,persistence.*,java.util.*" %>
<jsp:useBean id="mb" class="manager.ManagerBean" scope="page">
</jsp:useBean>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Listar Usuario</h2>
<ul>
<c:forEach items="${mb.usuarios}" var="usuario">
	<li>${usuario.nome},${usuario.email}</li>
</c:forEach>
</ul>



