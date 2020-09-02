package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Coach;

/**
 * Servlet implementation class ServletUpdateCoach
 */
@WebServlet("/ServletUpdateCoach")
public class ServletUpdateCoach extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int id	= Integer.parseInt(request.getParameter("coachID"));
		
		switch(page) {
		case "update":
			Coach coach = new Coach();
			if(coach.editar(id)) {
				String aux = coach.getDataDeNascimento().toString();
				String nasc = aux.substring(aux.lastIndexOf("-")+1, aux.indexOf(" ")) + "/" + aux.substring(aux.indexOf("-")+1, aux.lastIndexOf("-")) + "/" + aux.substring(0, aux.indexOf("-"));
				request.setAttribute("nome", coach.getNome().substring(0, coach.getNome().indexOf(" ")));
				request.setAttribute("sobrenome", coach.getNome().substring(coach.getNome().indexOf(" ") + 1));
				request.setAttribute("cpf", coach.getCpf());
				request.setAttribute("gender", coach.getSexo());
				request.setAttribute("age", coach.getIdade());
				request.setAttribute("birth", nasc);
				request.setAttribute("address", coach.getEndereco());
				request.setAttribute("city", coach.getCidade());
				request.setAttribute("state", coach.getEstado());
				request.setAttribute("telephone", coach.getTelefone());
				request.setAttribute("email", coach.getEmail());
				request.setAttribute("certificado", coach.getCertificados());
				request.setAttribute("login", coach.getLogin());
				request.setAttribute("senha", coach.getSenha());
				request.setAttribute("coachID", id);
				request.getRequestDispatcher("updateCoach.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("coachID"));
		try {
			String nome = request.getParameter("firstName") + " " + request.getParameter("lastName");
			String cpf  = request.getParameter("cpf");
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);		 
			String date = request.getParameter("birth");
			Date dataDeNascimento = formatter.parse(date);
			String address 		= request.getParameter("address");
			String city			= request.getParameter("city");
			String state		= request.getParameter("state");
			String telefone		= request.getParameter("telephone");
			String email		= request.getParameter("email");
			String certificado	= request.getParameter("certificado");
			String login		= request.getParameter("username");
			String senha		= request.getParameter("password");
			
			Coach coach = new Coach(nome, cpf, age, dataDeNascimento, gender, address, city, state, telefone, email, login, senha, certificado);
			coach.setId(id);
			
			if(coach.atualizar()) {
				List<Coach>listCoach = new Coach().getListCoach();
				request.getSession().setAttribute("listCoach", listCoach);
				response.sendRedirect("listUsers.jsp");
			}else {
				request.getSession().setAttribute("erro", coach.getMsg());		
				doGet(request, response);
			}
			} catch (Exception e) {
				System.out.println("erro: " + e.toString());
				response.sendRedirect("employeeArea.jsp");
			}
			
		
	}

}
