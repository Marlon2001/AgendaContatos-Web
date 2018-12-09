package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;

@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AtualizarCompromissoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso c = new Compromisso();
		CompromissoDAO dao = new CompromissoDAO();
		
		c.setTitulo(request.getParameter("txt-titulo"));
		c.setPrioridade(Integer.parseInt(request.getParameter("combo-prioridade")));
		c.setData(request.getParameter("txt-data"));
		c.setHora_inicio(request.getParameter("txt-time-inicio"));
		c.setHora_fim(request.getParameter("txt-time-fim"));
		c.setStatus(Integer.parseInt(request.getParameter("combo-status")));
		c.setDescricao(request.getParameter("txt-descricao"));
		c.setCod_compromisso(Integer.parseInt(request.getParameter("txt-codigo")));
		dao.setCompromisso(c);
		if(dao.atualizar()) {
			response.sendRedirect("compromissos.jsp?status=0");
		}else {
			response.sendRedirect("erro-atualizar-compromisso.jsp");
		}
	}
}