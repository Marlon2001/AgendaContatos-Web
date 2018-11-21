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
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<title>Agenda Elêtronica</title>
		<meta charset="UTF-8">
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
						<div class="card-header bg-dark text-white"><h5>Bem-Vindo</h5></div>
						<div class="card-body">
							<form action="AtualizarUsuarioServlet" method="post" id="form-usuario">
								<div class="card">
									<div class="card-header">
										<div class="row align-item-center">
											<div class="col-md-1"><img src="imagens/useradd48.png"></div>
											<div class="col-md-11"><h2 class="text-primary">Atualizar usuário</h2></div>
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
													<div class="col-md-5">
														<label for="txt-nome">Nome:</label>
														<input class="form-control" type="text" id="txt-nome" name="txt-nome" value="<%= usuario.getNome() %>">
													</div>
													<div class="col-md-4">
														<label for="txt-nascimento">Dt. Nascimento:</label>
														<input class="form-control" type="date" id="txt-nascimento" name="txt-nascimento" value="<%= usuario.getDtNascimento() %>">
													</div>
													<div class="col-md-3">
														<label for="combo-sexo">Sexo:</label>
														<select class="form-control" id="combo-sexo" name="combo-sexo">
															<option>Selecione</option>
															<option <%= usuario.getSexo().equals("F") ? "selected" : "" %>>Feminino</option>
															<option <%= usuario.getSexo().equals("M") ? "selected" : "" %>>Masculino</option>
														</select>
													</div>
												</div>
											</fieldset>
											<fieldset class="form-group">
												<legend class="text-primary">Dados de acesso</legend>
												<div class="row">
													<div class="col-md-6">
														<label for="txt-email">E-mail:</label>
														<input class="form-control" type="email" id="txt-email" name="txt-email" value="<%= usuario.getEmail() %>">
													</div>
													<div class="col-md-3">
														<label for="txt-senha">Senha:</label>
														<input class="form-control" type="password" id="txt-senha" name="txt-senha">
													</div>
													<div class="col-md-3">
														<label for="txt-repetirSenha">Repetir senha:</label>
														<input class="form-control" type="password" id="txt-repetirSenha" name="txt-repetirSenha">
													</div>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="card-footer">
										<button class="btn btn-success" id="btn-adicionar">Atualizar usuario</button>
										<a href="index.jsp" class="btn btn-warning">Cancelar</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/formulario.js"></script>
	</body>
</html>
<% } %>