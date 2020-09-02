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

import control.Atleta;

/**
 * Servlet implementation class ServletUpdateAtleta
 */
@WebServlet("/ServletUpdateAtleta")
public class ServletUpdateAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int id	= Integer.parseInt(request.getParameter("atletaID"));
		
		switch(page) {
		case "update":
			Atleta atleta = new Atleta();
			if(atleta.editar(id)) {
				String aux = atleta.getDataDeNascimento().toString();
				String nasc = aux.substring(aux.lastIndexOf("-")+1, aux.indexOf(" ")) + "/" + aux.substring(aux.indexOf("-")+1, aux.lastIndexOf("-")) + "/" + aux.substring(0, aux.indexOf("-"));
				request.setAttribute("nome", atleta.getNome().substring(0, atleta.getNome().indexOf(" ")));
				request.setAttribute("sobrenome", atleta.getNome().substring(atleta.getNome().indexOf(" ") + 1));
				request.setAttribute("cpf", atleta.getCpf());
				request.setAttribute("gender", atleta.getSexo());
				request.setAttribute("age", atleta.getIdade());
				request.setAttribute("birth", nasc);
				request.setAttribute("address", atleta.getEndereco());
				request.setAttribute("city", atleta.getCidade());
				request.setAttribute("state", atleta.getEstado());
				request.setAttribute("telephone", atleta.getTelefone());
				request.setAttribute("email", atleta.getEmail());
				request.setAttribute("categoria", atleta.getCategoria());
				request.setAttribute("login", atleta.getLogin());
				request.setAttribute("senha", atleta.getSenha());
				request.setAttribute("atletaID", id);
				request.getRequestDispatcher("updateAtleta.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("atletaID"));
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
			String categoria	= request.getParameter("categoria");
			String login		= request.getParameter("username");
			String senha		= request.getParameter("password");
			
			Atleta atleta = new Atleta(nome, cpf, age, dataDeNascimento, gender, address, city, state, telefone, email, login, senha, categoria, true);
			atleta.setId(id);
			
			if(atleta.atualizar()) {
				List<Atleta>listAtleta 	=  new Atleta().getListAtleta();
				request.getSession().setAttribute("listAtleta", listAtleta);
				response.sendRedirect("listUsers.jsp");
			}else {
				request.getSession().setAttribute("erro", atleta.getMsg());		
				doGet(request, response);
			}
			} catch (Exception e) {
				System.out.println("erro: " + e.toString());
				response.sendRedirect("employeeArea.jsp");
			}
			
		
	}

}
