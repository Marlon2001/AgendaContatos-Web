package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;
import br.senai.sp.model.Usuario;

@WebServlet("/CadastrarCompromissoServlet")
public class CadastrarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarCompromissoServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Compromisso compromisso = new Compromisso();
		CompromissoDAO dao = new CompromissoDAO();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		compromisso.setUsuario(usuario);
		compromisso.setTitulo(request.getParameter("txt-titulo"));
		compromisso.setPrioridade(Integer.parseInt(request.getParameter("combo-prioridade")));
		compromisso.setData(request.getParameter("txt-data"));
		compromisso.setHora_inicio(request.getParameter("txt-time-inicio"));
		compromisso.setHora_fim(request.getParameter("txt-time-fim"));
		compromisso.setStatus(Integer.parseInt(request.getParameter("combo-status")));
		compromisso.setDescricao(request.getParameter("txt-descricao"));
		
		dao.setCompromisso(compromisso);
		if(dao.gravar()) {
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("cadastrar-contato.jsp");;
		}
    }
}
