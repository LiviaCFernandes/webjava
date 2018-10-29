<!Doctype html>
<html>
<head>
</head>
<body>
<fieldset style = "width:350px;height:250px">
	<h2>Sistema de Locação de Filme</h2>
	<form method="post" action="Controller?cmd=cadastroI">
		<br>Nome
		<input type="text" name="name" id="nome" required="required" pattern="[a-z A-Z]{2,50}" placeholder="nome"
   title="Entre com o Nome no Padrao">
		<br>Email
		<input type="text" name="email" id="email" required="required" pattern=".+@.+z\.[a-z]+" placeholder="email"
   title="Entre com o Email no Padrao">
		<br>
		<button type="submit">Cadastrar</button>
	</form>
</fieldset>	
</body>
</html>