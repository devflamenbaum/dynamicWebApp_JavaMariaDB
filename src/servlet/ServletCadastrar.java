package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Atleta;
import control.Coach;
import control.Funcionario;

/**
 * Servlet implementation class ServletCadastrar
 */
@WebServlet("/ServletCadastrar")
public class ServletCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("type");
		
		if(request.getParameter("cpf").length() < 14) {
			request.getSession().setAttribute("erro", "Erro ao cadastrar. Cpf tem que ter 11 números");
			response.sendRedirect("cadastrar.jsp");
			return;
		}
				
		
		switch(tipo) {
		case "atleta":
			cadastrarAtleta(request,response);
			break;
		case "coach":
			cadastrarCoach(request,response);
			break;
		case "funcionario":
			cadastrarFuncionario(request,response);
			break;
		default:
			response.sendRedirect("cadastrar.jsp");
		}
	}


	private void cadastrarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			String login		= request.getParameter("username");
			String senha		= request.getParameter("password");
			String funcao		= request.getParameter("funcao");
			Funcionario func = new Funcionario(nome, cpf, age, dataDeNascimento, gender, address, city, state, telefone, email, login, senha, funcao);
			
			if(func.cadastrar()) {
				response.sendRedirect("employeeArea.jsp");
			}else {
				request.getSession().setAttribute("erro", func.getMsg());
				response.sendRedirect("cadastrar.jsp");
			}
		} catch (Exception e) {
			System.out.println("erro: " + e.toString());
			request.getSession().setAttribute("erro", "Erro ao cadastrar." + e.toString());
			response.sendRedirect("cadastrar.jsp");
		}
		
	}


	private void cadastrarCoach(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
			String login		= request.getParameter("username");
			String senha		= request.getParameter("password");
			String certificado	= request.getParameter("certificado");
			Coach coach = new Coach(nome, cpf, age, dataDeNascimento, gender, address, city, state, telefone, email, login, senha, certificado);
			
			if(coach.cadastrar()) {
				response.sendRedirect("employeeArea.jsp");
			}else {
				request.getSession().setAttribute("erro", coach.getMsg());
				response.sendRedirect("cadastrar.jsp");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("erro", "Erro ao cadastrar." + e.toString());
			response.sendRedirect("cadastrar.jsp");
		}
	}


	private void cadastrarAtleta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
		
		if(atleta.cadastrar()) {
			response.sendRedirect("employeeArea.jsp");
		}else {
			request.getSession().setAttribute("erro", atleta.getMsg());
			response.sendRedirect("cadastrar.jsp");
		}
		} catch (Exception e) {
			System.out.println("erro: " + e.toString());
			request.getSession().setAttribute("erro", "Erro ao cadastrar." + e.toString());
			response.sendRedirect("cadastrar.jsp");
		}
		
		
		
	}

}
