<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<strong>Sistema de Produtos</strong>
			</h2>
		</div>
		<!-- FECHA JUMBROTRON -->
		<div class="row">
			<div class="col-md-5" style="border: 1px solid #ddd">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title" class="text-center">
							Formulário de Cadastro
							</div><!-- title -->
					</div><!-- heading -->
					<div class="panel-body">
						<form method="post" action="Controle?cmd=gravar" role="form-inline">
							<label for="nome">Nome do Produto:</label> 
							<input type="text"
								name="nome" id="nome" placeholder="Digite o nome do produto"
								required="required" title="Nome do Produto" class="form-control">
							<label for="marca">Nome da Marca:</label> 
							<input type="text"
								name="marca" id="marca" placeholder="Digite o nome da marca"
								required="required" title="Nome da Marca" class="form-control">
							<label for="preco">Preço do Produto:</label> 
							<input type="number" name="preco" id="preco" placeholder="Digite o preço do produto"
								required="required" title="Preço do Produto"
								class="form-control"> 
							<label for="promocao">Promoção do Produto:</label> 
							<input type="number" name="promocao" id="promocao"
								placeholder="Digite a promocao do produto" required="required"
								title="Promoção do Produto" class="form-control"> 
							<br>
							<button type="submit" class="btn btn-success">Cadastrar</button>
						</form>
						${msg}
					</div>
					<!-- body -->
				</div>
			</div>

			<div class="col-md-7" style="border:1px solid #ddd">
				<div class="panel-body">
					<table class="table table-hover table-striped">
						<thread>
						<tr>
							<th>Nome do Produto</th>
							<th>Nome da Marca</th>
							<th>Preço do Produto</th>
							<th>Promoção do Produto</th>
						</tr>
						</thread>
						<tbody>
							<c:ForEach items="${mb.produtos}" var="linha">
								<tr>
									<td>${linha.nome}</td>
									<td>${linha.marca}</td>
									<td>${linha.preco}</td>
									<td>${linha.promocao}</td>
								</tr>
							</c:ForEach>
						</tbody>
					</table>
				</div><!-- body -->
			</div>
		</div><!-- row -->
	</div><!-- FECHA CONTAINER -->
</body>
</html>