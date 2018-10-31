package br.senai.sp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.model.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt-nome");
		System.out.println(request.getParameter("txt-email"));

//		System.out.println(request.getRemoteAddr());
//		System.out.println(request.getLocalName());
//		System.out.println(request.getLocalPort());
//		System.out.println(request.getRemotePort());
//		System.out.println(request.getProtocol());
//		System.out.println(request.getRequestedSessionId());
//		System.out.println(request.getScheme());
		
		response.sendRedirect("resultado.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
