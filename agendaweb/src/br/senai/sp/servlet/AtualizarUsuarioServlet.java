package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.UsuarioDao;
import br.senai.sp.model.Usuario;

@WebServlet("/AtualizarUsuarioServlet")
public class AtualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AtualizarUsuarioServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario = (Usuario) request.getSession().getAttribute("usuario");
		usuario.setNome(request.getParameter("txt-nome"));
		usuario.setEmail(request.getParameter("txt-email"));
		usuario.setSexo(request.getParameter("combo-sexo").substring(0, 1));
		usuario.setSenha(request.getParameter("txt-senha"));
		usuario.setDtNascimento(request.getParameter("txt-nascimento"));
		UsuarioDao dao = new UsuarioDao();
		dao.setUsuario(usuario);
		if(dao.atualizar()) {
			response.sendRedirect("sucesso-atualizar.jsp");
		}else {
			response.sendRedirect("atualizar-usuario.jsp");
		}
	}

}
