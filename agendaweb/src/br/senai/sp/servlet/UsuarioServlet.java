package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.UsuarioDao;
import br.senai.sp.model.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("txt-nome"));
		usuario.setEmail(request.getParameter("txt-email"));
		usuario.setSenha(request.getParameter("txt-senha"));
		usuario.setSexo(request.getParameter("combo-sexo"));
		usuario.setDtNascimento(request.getParameter("txt-nascimento"));
		
		UsuarioDao dao = new UsuarioDao();
		dao.setUsuario(usuario);
		if(dao.gravar()) {
			response.sendRedirect("sucesso.html");
		}else {
			response.sendRedirect("novo-usuario.html");
		}
	}
}
