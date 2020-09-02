<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="control.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gymtastic - Admin</title>
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
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="./coachArea.jsp"><img src="./img/logoGym.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="./addWod.jsp">Adicionar Treino</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ServletGetWod?page=view">Ver Treino</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ServletLogout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="card mt-5 mb-5">
			<h5 class="card-header">Treino</h5>
			<div class="card-body">
				<h5 class="card-title text-center">Workout of the Day</h5>
				<div class="row justify-content-center">
				<div class="col-sm-12 col-md-10 col-lg-8">
					<form action="ServletCadastrarTreino" method="post">
						<div class="form-row">
							<div class="form-group col-sm-12">
								<label for="inputTitle">Titulo:</label> 
								<input type="text" class="form-control" id="inputTitle" placeholder="Titulo" name="title" maxlength="10">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-12">
								<label for="inputDescription">Descrição:</label> 
								<textarea class="form-control" id="inputDescription" placeholder="Descrição" name="description" rows="10" cols="20"></textarea>
							</div>
						</div>
						<input type="submit" class="btn btn-primary" value="enviar">
					</form>
				</div>
			</div>

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