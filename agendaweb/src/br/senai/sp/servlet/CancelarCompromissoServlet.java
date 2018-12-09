package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;

@WebServlet("/CancelarCompromissoServlet")
public class CancelarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CancelarCompromissoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		CompromissoDAO dao = new CompromissoDAO();
		
		if(dao.mudarCompromisso(codigo, 1)) {
			response.sendRedirect("compromissos.jsp?status=1");
		}
	}

}
