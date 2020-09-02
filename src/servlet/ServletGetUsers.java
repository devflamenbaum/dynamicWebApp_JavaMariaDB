package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Atleta;
import control.Coach;
import control.Funcionario;

/**
 * Servlet implementation class ServletGetUsers
 */
@WebServlet("/ServletGetUsers")
public class ServletGetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		
		switch(page){
		case "listUsers":
			List<Atleta> 		listAtleta 		=  new Atleta().getListAtleta();
			List<Coach>			listCoach		=  new Coach().getListCoach();
			List<Funcionario>	listFuncionario	=  new Funcionario().getListFuncionario();
			request.getSession().setAttribute("listAtleta", listAtleta);
			request.getSession().setAttribute("listCoach", listCoach);
			request.getSession().setAttribute("listFuncionario", listFuncionario);
			response.sendRedirect("listUsers.jsp");
			break;
		}
	}


}
