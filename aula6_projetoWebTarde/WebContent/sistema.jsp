<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<!-- para gravar irei mandar para Controle?cmd=gravar -->
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Cadastrar Usuario</a></li>
			<li><a href="#tabs-2">Login do Usuario</a></li>
		</ul>
	
		
	<div id="tabs-1">
		<form method="post" action="Controller?cmd=gravar">
			<br>*Login<br>
			<input type="text" name="login" id="login" required="required" pattern="[a-z A-Z]{2,50}" title="Entre com o login no padrao"/>
			<br/>*Senha<br>
			<input type="password" name="senha" id="senha" required="required" pattern="[a-zA-Z0-9]{3,50}" title="Entre com a senha no padrao"/>
			<br><button type="submit">Enviar os dados</button>
		</form> 		
	</div>
	

	<div id="tabs-2">
		<p>
		<form method="post" action="Controller?cmd=logar">
			<br>*Login<br>
			<input type="text" name="login" id="login" required="required" pattern="[a-z A-Z]{2,50}" title="Entre com o login no padrao"/>
			<br/>*Senha<br>
			<input type="password" name="senha" id="senha" required="required" pattern="[a-zA-Z0-9]{3,50}" title="Entre com a senha no padrao"/>
			<br><button type="submit">Logar</button>
		</form> 
	</div>
	
	
	
	
	</div>
	${msg}
<script>
$(document).ready(function(){
	$("#tabs").tabs();
});
</script>
</body>
</html>