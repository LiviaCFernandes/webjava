<%@ page import= "entity.*, persistence.*, control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>


<%
try{
	if(request.getAttribute("usuario")==null){
		throw new Exception ("Login Invalido!");
	}
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	out.print("Logado: "+ usuario);
%>	

<h2>Listagem dos Usuários:</h2>	
<hr/>
	<c:forEach items="${usuarios}" var="linha">
	<li>${linha.nome},${linha.email}</li>
	</c:forEach>
	
<%	
}catch(Exception ex){
	request.setAttribute("msg", ex.getMessage());
	request.getRequestDispatcher("login").forward(request, response);
}
%>
