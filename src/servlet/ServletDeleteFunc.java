package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Funcionario;



/**
 * Servlet implementation class ServletDeleteFunc
 */
@WebServlet("/ServletDeleteFunc")
public class ServletDeleteFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("funcID"));

		Funcionario func = new Funcionario();
		func.setId(id);

		if (func.excluir()) {
			List<Funcionario> listFuncionario = new Funcionario().getListFuncionario();
			request.getSession().setAttribute("listFuncionario", listFuncionario);
			response.sendRedirect("listUsers.jsp");
		} else {
			response.sendRedirect("listUsers.jsp");
		}
	}

}
