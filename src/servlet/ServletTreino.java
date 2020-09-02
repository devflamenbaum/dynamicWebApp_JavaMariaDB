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

/**
 * Servlet implementation class ServletTreino
 */
@WebServlet("/ServletTreino")
public class ServletTreino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String treinoID = request.getParameter("treinoID");
		String titulo = request.getParameter("title");
		String description = request.getParameter("description");
		int id = Integer.parseInt(treinoID);
		Treino treino = new Treino();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String data = dtf.format(now).toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		
		
		switch(acao) {
		case "update":
			treino.setId(id);
			treino.setTitulo(titulo);
			treino.setDescricao(description);
//			treino.setDataTreino(data);
			try {
			Date date = formatter.parse(data);
				treino.setDataTreino(date);
		} catch (ParseException e) {
				e.printStackTrace();
			}
		if(treino.atualizar()) {
			request.getSession().setAttribute("treino", treino);
			response.sendRedirect("viewWod.jsp");
			}else {
				response.sendRedirect("coachArea.jsp");
			}
		break;
		case "delete":
			treino.setId(id);
			if(treino.deletar()) {
				request.getSession().setAttribute("treino", null);
				response.sendRedirect("viewWod.jsp");
			}else {
				response.sendRedirect("viewWod.jsp");
			}
			break;
			default:
				response.sendRedirect("coachArea.jsp");
		}
	}

}
