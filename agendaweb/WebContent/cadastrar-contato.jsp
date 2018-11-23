<%@page import="br.senai.sp.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<% 
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<title>Agenda Elêtronica</title>
	</head>
	<body>
		<!-- CABEÇALHO DA PAGINA -->
		<%@include file="header.html"%>
		
		<!-- CONTEUDO DA PAGINA -->
		<div class="container mt-3">
			<div class="row">
				<!-- COLUNA ESQUERDA -->
				<div class="col-md-3">			
					<%@include file="painel-usuario.jsp"%>
					<%@include file="painel-menu.html"%>
				</div>
				
				<!-- COLUNA DIREITA -->
				<div class="col-md-9">
					<div class="card">
						<div class="card-header bg-dark text-white"><h5>Cadastrar Contato</h5></div>
						<div class="card-body">
							<form action="CadastrarContatoServlet" method="get" id="form-contato">
								<div class="card">
									<div class="card-header">
										<div class="row align-item-center">
											<div class="col-md-1"><img src="imagens/useradd48.png"></div>
											<div class="col-md-11"><h2 class="text-primary">Adicionar novo contato</h2></div>
										</div>
									</div>
									<div class="card-body">
										<div id="painelErros">
											<p class="card-title font-weight-bold text-danger .h5" id="avisoErro"></p>
											<ul id="erros"></ul>
										</div>
										<div>
											<fieldset class="form-group">
												<legend class="text-primary">Dados Gerais</legend>
												<div class="row">
													<div class="col-md-6">
														<label for="txt-nome">Nome:</label>
														<input class="form-control" type="text" id="txt-nome" name="txt-nome">
													</div>
													<div class="col-md-6">
														<label for="txt-nascimento">Telefone:</label>
														<input class="form-control" type="text" id="txt-telefone" name="txt-telefone">
													</div>
												</div>
											</fieldset>
											<fieldset class="form-group">
												<legend class="text-primary">Dados de acesso</legend>
												<div class="row">
													<div class="col-md-12">
														<label for="txt-email">E-mail:</label>
														<input class="form-control" type="email" id="txt-email" name="txt-email">
													</div>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="card-footer">
										<button class="btn btn-success" id="btn-adicionar">Atualizar contato</button>
										<a href="contatos.jsp" class="btn btn-warning">Cancelar</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/contato.js"></script>
	</body>
</html>
<% } %>