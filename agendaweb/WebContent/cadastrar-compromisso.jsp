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
						<div class="card-header bg-dark text-white"><h5>Cadastrar Compromisso</h5></div>
						<div class="card-body">
							<form action="CadastrarCompromissoServlet" method="get" id="form-compromisso">
								<div class="card">
									<div class="card-header">
										<div class="align-item-center">
											<h4>Dados do seu compromisso</h4>
										</div>
									</div>
									<div class="card-body">
										<div id="painelErros">
											<p class="card-title font-weight-bold text-danger .h5" id="avisoErro"></p>
											<ul id="erros"></ul>
										</div>
										<fieldset class="form-group">
											<div class="row">
												<div class="col-md-8">
													<label for="txt-titulo">Titulo:</label>
													<input class="form-control" type="text" id="txt-titulo" name="txt-titulo">
												</div>
												<div class="col-md-4">
													<label for="combo-prioridade">Prioridade:</label>
													<select class="form-control" id="combo-prioridade" name="combo-prioridade">
														<option value="0">Alta</option>
														<option value="1">Normal</option>
														<option value="2">Baixa</option>
													</select>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label for="txt-data">Data:</label>
													<input class="form-control" type="date" id="txt-data" name="txt-data">
												</div>
												<div class="col-md-2">
													<label for="txt-time">Hora inicio:</label>
													<input class="form-control" type="time" id="txt-time-inicio" name="txt-time-inicio">
												</div>
												<div class="col-md-2">
													<label for="txt-time">Hora fim:</label>
													<input class="form-control" type="time" id="txt-time-fim" name="txt-time-fim">
												</div>
												<div class="col-md-4">
													<label for="combo-status">Status:</label>
													<select class="form-control" id="combo-status" name="combo-status">
														<option value="0">Em andamento</option>
														<option value="1">Cancelado</option>
														<option value="2">Concluido</option>
													</select>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<label for="txt-descricao">Descrição do compromisso:</label>
													<textarea class="form-control" id="txt-descricao" name="txt-descricao" rows="4"></textarea>
												</div>
											</div>
										</fieldset>
									</div>
									<div class="card-footer">
										<button class="btn btn-success" id="btn-adicionar">Salvar compromisso</button>
										<a href="compromissos.jsp?status=0" class="btn btn-warning">Cancelar</a>
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