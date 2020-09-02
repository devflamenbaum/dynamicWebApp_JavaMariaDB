package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Atleta;

/**
 * Servlet implementation class ServletDeletarAtleta
 */
@WebServlet("/ServletDeleteAtleta")
public class ServletDeleteAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id	= Integer.parseInt(request.getParameter("atletaID"));
		
		Atleta atleta = new Atleta();
		atleta.setId(id);
		
		if(atleta.excluir()) {
			List<Atleta>listAtleta = new Atleta().getListAtleta();
			request.getSession().setAttribute("listAtleta", listAtleta);
			response.sendRedirect("listUsers.jsp");
		} else {
			response.sendRedirect("listUsers.jsp");
		}
	}

}
