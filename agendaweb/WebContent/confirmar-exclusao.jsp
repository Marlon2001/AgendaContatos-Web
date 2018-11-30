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
							<form action="ExcluirContatoServlet" method="get">
								
								<div class="card">
									<div class="card-header row bg-danger">
											<div class="col-md-1 pt-1"><img src="imagens/icon_alert.png"></div>
											<div class="col-md-11 text-left"><h1>Atenção!</h1></div>
									</div>
									<div class="card-body ">
										<h3 class="text-success"> Confirmar a exclusão do contato abaixo?</h3>
										<h5 class="text-danger pt-4"><%=nome%></h5>
										<h6 class="text-warning pt-4"><span class="font-weight-bold">OBS: </span>Após a confirmação desta ação, não poderá ser desfeita</h6>
										<input class="invisible" type="text" id="txt-codigo" name="txt-codigo" value="<%=codigo%>" hidden="hidden">
									</div>
									<div class="card-footer"></div>
								</div>
								
								<div class="card-footer">
									<button class="btn btn-danger" id="btn-deletar">Confirmar exclusão do contato</button>
									<a href="contatos.jsp" class="btn btn-success">Cancelar</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<% } %>