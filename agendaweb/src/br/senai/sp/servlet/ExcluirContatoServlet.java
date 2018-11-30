package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ContatoDAO;

@WebServlet("/ExcluirContatoServlet")
public class ExcluirContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExcluirContatoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoDAO dao = new ContatoDAO();
		int codigo = Integer.parseInt(request.getParameter("txt-codigo"));
		
		if(dao.deletar(codigo)) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("erro-deletar.jsp");
		}
		
	}
}
