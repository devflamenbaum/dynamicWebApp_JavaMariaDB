package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Treino;

/**
 * Servlet implementation class ServletGetWod
 */
@WebServlet("/ServletGetWod")
public class ServletGetWod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String data = dtf.format(now).toString();
		Treino treino = new Treino().getTreino(data);
		request.getSession().setAttribute("treino", treino);
		
		switch(page) {
		case "view":
			response.sendRedirect("viewWod.jsp");
			break;
		case "viewAtleta":
			response.sendRedirect("viewWodA.jsp");
			break;
		}
	}

}
