package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Atleta;
import control.Coach;
import control.Funcionario;


/**
 * Servlet implementation class ServletAuthentication
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String tipo		= request.getParameter("type");
		
		switch(tipo) {
		case "athlete":{
			Atleta atleta = new Atleta();
			
//			System.out.println(athlete.toString());
			
			atleta.setLogin(username);
			atleta.setSenha(password);
			
			//athlete = athlete.authenticate();
			if(atleta.authenticate()) {
 				request.getSession().invalidate();
				
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(1000);
				newSession.setAttribute("nome", atleta.getNome());
				response.sendRedirect("atletaArea.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		}
			break;
		case "coach":
			Coach coach = new Coach();
			
			coach.setLogin(username);
			coach.setSenha(password);
			
			if(coach.authenticate()) {
				request.getSession().invalidate();
				
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(1000);
				newSession.setAttribute("nome", coach.getNome());
				response.sendRedirect("coachArea.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
			break;
		case "employee":
			control.Funcionario employee = new Funcionario();
			
			employee.setLogin(username);
			employee.setSenha(password);
			
			if( employee.authenticate()) {
				request.getSession().invalidate();
				
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(1000);
				newSession.setAttribute("nome", employee.getNome());
				response.sendRedirect("employeeArea.jsp");
			} else if(employee.getLogin().equals("admin")&&employee.getSenha().equals("vasco")) {
				
				request.getSession().invalidate();
				
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(1000);
				newSession.setAttribute("nome", "Administrador");
				response.sendRedirect("employeeArea.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
			break;
		}

	}

}
