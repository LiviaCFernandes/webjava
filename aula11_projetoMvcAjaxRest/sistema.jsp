<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- script que busca pelo cep no correios -->
<script>
$(document).ready(function(){
	$("#accordion").accordion(); 
	$("#cep").on('blur', function(){
		var cep = $(this).val();
		$.getJSON('http://api.postmon.com.br/v1/cep/' + cep, function(data){
			$("#logradouro").val(data.logradouro);
			$("#bairro").val(data.bairro);
			$("#cidade").val(data.cidade);
			$("#estado").val(data.estado);
		}).fail(function(ex){
			alert("Cep nao encontrado!");
		});
	});
});
</script>

</head>
<body>
	<div id="accordion">
		<h3>Cadastro de Usuario e Endereço</h3>
	</div>
	<br>
	<div>
	<form method="post" action="Controle?cmd=gravar">
		Nome
		<input type="text" name="nome" id="nome" size="35" required="required" />
		<br>
		Email
		<input type="text" name="email" id="email" size="50" required="required" />
		<br>
		Cep
		<input type="text" name="cep" id="cep" size="25" required="required" />
		<br>
		Logradouro
		<input type="text" name="logradouro" id="logradouro" size="55" required="required" />
		<br>
		Bairro
		<input type="text" name="bairro" id="bairro" size="35" required="required" />
		<br>
		Cidade
		<input type="text" name="cidade" id="cidade" size="35" required="required" />
		<br>
		Estado
		<input type="text" name="estado" id="estado" size="2" required="required" />
		<br>
		<button id="btn1" type="submit">Enviar os Dados</button>
	</form>
${msg}
</div>
</body>
</html>