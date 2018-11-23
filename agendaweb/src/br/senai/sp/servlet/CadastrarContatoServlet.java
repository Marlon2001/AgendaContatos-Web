package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.model.Contato;
import br.senai.sp.model.Usuario;

@WebServlet("/CadastrarContatoServlet")
public class CadastrarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarContatoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		contato.setUsuario(usuario);
		contato.setNome(request.getParameter("txt-nome"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		contato.setEmail(request.getParameter("txt-email"));
		
		dao.setContato(contato);
		if(dao.gravar()) {
			response.sendRedirect("sucesso-cadastrar-contato.jsp");
		}else {
			response.sendRedirect("contatos.jsp");;
		}
	}
}
