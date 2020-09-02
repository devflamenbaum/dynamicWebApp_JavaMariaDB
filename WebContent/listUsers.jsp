<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="control.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gymtastic - list Users</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/1f89205492.js"
	crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
</head>
<body>
<%
if(request.getSession().getAttribute("nome") == null){
	response.sendRedirect("login.jsp");
}
%>
	<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/employeeArea.jsp"><img
				src="${pageContext.request.contextPath}/img/logoGym.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/cadastrar.jsp">Add
							User</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/ServletGetUsers?page=listUsers">List
							User</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ServletLogout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="card mt-5">
			<h5 class="card-header">Atletas</h5>
			<div class="card-body">
				<h5 class="card-title">Relação de atletas</h5>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">Idade</th>
							<th scope="col">Sexo</th>
							<th scope="col">Categoria</th>
							<th scope="col" class="text-right">Ação</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Atleta> listAtleta = (List<Atleta>) session.getAttribute("listAtleta");
						String tempURLUa;
						String tempURLDa;
						if (!listAtleta.isEmpty()) {
							for (int i = 0; i < listAtleta.size(); i++) {
								out.print("<tr>");
								out.print("<th scope=\"row\">" + listAtleta.get(i).getId() + "</td>");
								out.print("<td>" + listAtleta.get(i).getNome() + "</td>");
								out.print("<td>" + listAtleta.get(i).getIdade() + "</td>");
								out.print("<td>" + listAtleta.get(i).getSexo() + "</td>");
								out.print("<td>" + listAtleta.get(i).getCategoria() + "</td>");
								tempURLUa = request.getContextPath() + "/ServletUpdateAtleta?page=update&atletaID=" + listAtleta.get(i).getId();
								tempURLDa = request.getContextPath() + "/ServletDeleteAtleta?page=update&atletaID=" + listAtleta.get(i).getId();
								out.print("<td class=\"float-right\"><a href=" + tempURLUa + " class=\"badge badge-warning\">Editar</a> <a href=" + tempURLDa + " class=\"badge badge-danger\">Deletar</a></td>");
								out.print("</tr>");
							}
						}
						%>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="card mt-5">
			<h5 class="card-header">Coachs</h5>
			<div class="card-body">
				<h5 class="card-title">Relação de Coachs</h5>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">Idade</th>
							<th scope="col">Sexo</th>
							<th scope="col">Telefone</th>
							<th scope="col" class="text-right">Ação</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Coach> listCoach = (List<Coach>) session.getAttribute("listCoach");
						String tempURLUc;
						String tempURLDc;
						if (!listCoach.isEmpty()) {
							for (int i = 0; i < listCoach.size(); i++) {
								out.print("<tr>");
								out.print("<th scope=\"row\">" + listCoach.get(i).getId() + "</td>");
								out.print("<td>" + listCoach.get(i).getNome() + "</td>");
								out.print("<td>" + listCoach.get(i).getIdade() + "</td>");
								out.print("<td>" + listCoach.get(i).getSexo() + "</td>");
								out.print("<td>" + listCoach.get(i).getTelefone() + "</td>");
								tempURLUc = request.getContextPath() + "/ServletUpdateCoach?page=update&coachID=" + listCoach.get(i).getId();
								tempURLDc = request.getContextPath() + "/ServletDeleteCoach?page=update&coachID=" + listCoach.get(i).getId();
								out.print("<td class=\"float-right\"><a href=" + tempURLUc + " class=\"badge badge-warning\">Editar</a> <a href=" + tempURLDc + " class=\"badge badge-danger\">Deletar</a></td>");
								out.print("</tr>");
							}
						}
						%>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="card mt-5 mb-5">
			<h5 class="card-header">Funcionarios</h5>
			<div class="card-body">
				<h5 class="card-title">Relação de Funcionarios</h5>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">Idade</th>
							<th scope="col">Sexo</th>
							<th scope="col">Função</th>
							<th scope="col" class="text-right">Ação</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Funcionario> listFuncionario = (List<Funcionario>) session.getAttribute("listFuncionario");
						String tempURLUf;
						String tempURLDf;
						if (!listFuncionario.isEmpty()) {
							for (int i = 0; i < listFuncionario.size(); i++) {
								out.print("<tr>");
								out.print("<th scope=\"row\">" + listFuncionario.get(i).getId() + "</td>");
								out.print("<td>" + listFuncionario.get(i).getNome() + "</td>");
								out.print("<td>" + listFuncionario.get(i).getIdade() + "</td>");
								out.print("<td>" + listFuncionario.get(i).getSexo() + "</td>");
								out.print("<td>" + listFuncionario.get(i).getFuncao() + "</td>");
								tempURLUf = request.getContextPath() + "/ServletUpdateFunc?page=update&funcID=" + listFuncionario.get(i).getId();
								tempURLDf = request.getContextPath() + "/ServletDeleteFunc?page=update&funcID=" + listFuncionario.get(i).getId();
								out.print("<td class=\"float-right\"><a href=" + tempURLUf + " class=\"badge badge-warning\">Editar</a> <a href=" + tempURLDf + " class=\"badge badge-danger\">Deletar</a></td>");
								out.print("</tr>");
							}
						}
						%>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<footer>
		<div class="container-fluid padding">
			<div class="row text-center">
				<div class="col-md-4">
					<h5>Gymtastic</h5>
					<hr class="light">
					<p>+55-021-33210929</p>
					<p>gymtastic@gmail.com</p>
					<p>281 Av. Borges de Medeiros</p>
					<p>Rio de Janeiro, Lagoa, 22.981-001</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<h5>Our Hours</h5>
					<hr class="light">
					<p>Monday/Fri: 9am - 22pm</p>
					<p>Saturday: 10am - 5pm</p>
					<p>Sunday: closed</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<h5>Service Area</h5>
					<hr class="light">
					<p>City, State, 00000</p>
					<p>City, State, 00000</p>
					<p>City, State, 00000</p>
				</div>
				<div class="col-12">
					<hr class="light-100">
					<h5>&copy; Gymtastic.com</h5>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>