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
						<div class="card-header bg-dark text-white row">
							<div class="col-md-8"><h5>Meus Contatos</h5></div>
							<div class="col-md-4 text-right"><a class="text-white" href="cadastrar-contato.jsp">Adicionar novo contato</a></div>
						</div>	
						<div class="card-body">
							<table class="table table-bordered table-dark table-sm table-hover">
								<thead>
									<th>Código</th>
									<th>Nome</th>
									<th>E-mail</th>
									<th>Telefone</th>
									<th></th>
								</thead>
								<tbody>
									<% for(Contato c : contatos){	%>
									<tr>
										<th><%= String.format("%06d", c.getCodigo()) %></th>
										<td><a class="text-white" href="ConsultarContatoServlet?codigo=<%= c.getCodigo() %>"><%= c.getNome()%></a></td>
										<td><%= c.getEmail()%></td>		
										<td><%= c.getTelefone()%></td>
										<td><a title="Excluir contato" href="confirmar-exclusao.jsp?codigo=<%= c.getCodigo() %>&nome=<%= c.getNome() %>"><img src="imagens/icon_delete.png"></a></td>
									</tr>
									<% } %>
								</tbody>
							</table>
						</div>
						<div class="card-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<% } %>