package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Coach;


/**
 * Servlet implementation class ServletDeleteCoach
 */
@WebServlet("/ServletDeleteCoach")
public class ServletDeleteCoach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id	= Integer.parseInt(request.getParameter("coachID"));
		
		Coach coach = new Coach();
		coach.setId(id);
		
		if(coach.excluir()) {
			List<Coach>listCoach = new Coach().getListCoach();
			request.getSession().setAttribute("listCoach", listCoach);
			response.sendRedirect("listUsers.jsp");
		} else {
			response.sendRedirect("listUsers.jsp");
		}
	}


}
