<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.dao.ContatoDAO"%>
<%@page import="br.senai.sp.model.Usuario"%>
<%@page import="br.senai.sp.model.Contato"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null){
		response.sendRedirect("login.html");
	}else{
		ContatoDAO dao = new ContatoDAO();
		ArrayList<Contato> contatos = new ArrayList<>();
		contatos = dao.getContatos(usuario.getCodUsuario());
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
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
						<div class="card-header text-left bg-danger text-white row">
							<div class="col-md-12"><h5>Exclusão de contato</h5></div>
						</div>	
						<div class="card-body">
							<form action="ExcluirContatoServlet?codigo<%= codigo %>&nome<%= nome %>" method="get">
								
							</form>
						</div>
						<div class="card-footer">
							<button class="btn btn-danger" id="btn-deletar">Confirmar exclusão do contato</button>
							<a href="contatos.jsp" class="btn btn-success">Cancelar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<% } %>