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
import control.Funcionario;

/**
 * Servlet implementation class ServletUpdateFunc
 */
@WebServlet("/ServletUpdateFunc")
public class ServletUpdateFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int id	= Integer.parseInt(request.getParameter("funcID"));
		
		switch(page) {
		case "update":
			Funcionario func = new Funcionario();
			if(func.editar(id)) {
				String aux = func.getDataDeNascimento().toString();
				String nasc = aux.substring(aux.lastIndexOf("-")+1, aux.indexOf(" ")) + "/" + aux.substring(aux.indexOf("-")+1, aux.lastIndexOf("-")) + "/" + aux.substring(0, aux.indexOf("-"));
				if(func.getNome().contains(" ")) {
					request.setAttribute("nome", func.getNome().substring(0, func.getNome().indexOf(" ")));
					request.setAttribute("sobrenome", func.getNome().substring(func.getNome().indexOf(" ") + 1));
				}else {
					request.setAttribute("nome", func.getNome());
					request.setAttribute("sobrenome", " ");
				}
				request.setAttribute("cpf", func.getCpf());
				request.setAttribute("gender", func.getSexo());
				request.setAttribute("age", func.getIdade());
				request.setAttribute("birth", nasc);
				request.setAttribute("address", func.getEndereco());
				request.setAttribute("city", func.getCidade());
				request.setAttribute("state", func.getEstado());
				request.setAttribute("telephone", func.getTelefone());
				request.setAttribute("email", func.getEmail());
				request.setAttribute("funcao", func.getFuncao());
				request.setAttribute("login", func.getLogin());
				request.setAttribute("senha", func.getSenha());
				request.setAttribute("funcID", id);
				request.getRequestDispatcher("updateFunc.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("funcID"));
		try {
			String nome = request.getParameter("firstName").trim() + " " + request.getParameter("lastName").trim();
			nome = nome.trim();
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
			String funcao		= request.getParameter("funcao");
			String login		= request.getParameter("username");
			String senha		= request.getParameter("password");
			
			Funcionario funcionario = new Funcionario(nome, cpf, age, dataDeNascimento, gender, address, city, state, telefone, email, login, senha, funcao);
			funcionario.setId(id);
			
			if(funcionario.atualizar()) {
				List<Funcionario>listFuncionario 	=  new Funcionario().getListFuncionario();
				request.getSession().setAttribute("listFuncionario", listFuncionario);
				response.sendRedirect("listUsers.jsp");
			}else {
				request.getSession().setAttribute("erro", funcionario.getMsg());		
				doGet(request, response);
			}
			} catch (Exception e) {
				System.out.println("erro: " + e.toString());
				response.sendRedirect("employeeArea.jsp");
			}
			
	}

}
