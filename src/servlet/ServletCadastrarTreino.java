package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Treino;


@WebServlet("/ServletCadastrarTreino")
public class ServletCadastrarTreino extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String data = dtf.format(now).toString();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Treino treino = new Treino();
		
		treino.setTitulo(title);
		treino.setDescricao(description);
		try {
			Date date = formatter.parse(data);
		treino.setDataTreino(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(treino.cadastrar()) {
			request.getSession().setAttribute("treino", treino);
			response.sendRedirect("coachArea.jsp");
		} else {
			response.sendRedirect("coachArea.jsp");
		}
	}

}
