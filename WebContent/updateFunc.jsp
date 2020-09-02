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
			<a class="navbar-brand" href="#"><img src="./img/logoGym.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="./cadastrar.jsp">Add
							User</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ServletGetUsers?page=listUsers">List
							User</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ServletLogout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="card mt-5 mb-5">
			<h5 class="card-header">Funcionário</h5>
			<div class="card-body">
				<h5 class="card-title text-center">Formulário de funcionários</h5>
				<div class="row justify-content-center">
				<div class="col-sm-12 col-md-10 col-lg-8">
					<form action="ServletUpdateFunc?page=update" method="post">
						<div class="form-row">
							<div class="form-group col-sm-3">
								<label for="inputName">Name:</label> <input type="text"
									class="form-control" id="inputName" placeholder="first Name" name="firstName" value="<%= request.getAttribute("nome") %>" maxlength="40" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputLastName">Last name:</label> <input type="text"
									class="form-control" id="inputLastName" placeholder="Last Name" name="lastName" value="<%= request.getAttribute("sobrenome") %>" maxlength="40" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputCpf">Cpf:</label> 
								<input type="text" class="form-control" id="inputCpf" placeholder="cpf" name="cpf" value="<%= request.getAttribute("cpf") %>" onkeypress="mascaracpf(this)" onfocusout="myFunction(this)" maxlength="14" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputGender">Gender:</label> <select
									id="inputGender" class="form-control" name="gender">
									<option value="<%= request.getAttribute("gender") %>"><%= request.getAttribute("gender") %></option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="other">Other</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-1">
								<label for="inputAge">Age:</label> 
								<input type="text" class="form-control" id="inputAge" placeholder="Your Age" name="age" value="<%= request.getAttribute("age") %>" onfocusout="verAge(this)" maxlength="3" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputBirth">Date of birth:</label> 
								<input type="text" class="form-control" id="inputBirth" placeholder="Date of Birth" name="birth" value="<%= request.getAttribute("birth") %>" pattern="(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(1[0-2]|0[1-9])\/(19[0-9][0-9]|200[0-9]|201[0-9])" required>
							</div>
							<div class="form-group col-sm-8">
								<label for="inputAddr">Address:</label> <input type="text"
									class="form-control" id="inputAddr" placeholder="Your Address" name="address" value="<%= request.getAttribute("address") %>" maxlength="150" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-2">
								<label for="inputCity">City:</label> 
								<input type="text" class="form-control" id="inputCity" placeholder="City" name="city" value="<%= request.getAttribute("city") %>" maxlength="30" required>
							</div>
							<div class="form-group col-sm-2">
								<label for="inputState">State:</label> 
								<select id="inputState" class="form-control" name="state">
									<option value="<%= request.getAttribute("state") %>" selected><%= request.getAttribute("state") %></option>
									<option value="AC">AC</option>
									<option value="AL">AL</option>
									<option value="AP">AP</option>
									<option value="AM">AM</option>
									<option value="BA">BA</option>
									<option value="CE">CE</option>
									<option value="DF">DF</option>
									<option value="ES">ES</option>
									<option value="GO">GO</option>
									<option value="MA">MA</option>
									<option value="MG">MG</option>
									<option value="MS">MS</option>
									<option value="MT">MT</option>
									<option value="PA">PA</option>
									<option value="PB">PB</option>
									<option value="PE">PE</option>
									<option value="PI">PI</option>
									<option value="RR">PR</option>
									<option value="RJ">RJ</option>
									<option value="RN">RN</option>
									<option value="RO">RO</option>
									<option value="RR">RR</option>
									<option value="RS">RS</option>
									<option value="SC">SC</option>
									<option value="SE">SE</option>
									<option value="SP">SP</option>
									<option value="TO">TO</option>
								</select>
							</div>
							<div class="form-group col-sm-2">
								<label for="inputTelephone">Telephone:</label> <input type="text"
									class="form-control" id="inputTelephone" placeholder="Telephone" name="telephone" value="<%= request.getAttribute("telephone") %>" maxlength="12" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputEmail">E-mail:</label> <input type="email"
									class="form-control" id="inputEmail" placeholder="email" name="email" value="<%= request.getAttribute("email") %>" maxlength="50" required>
							</div>
							<div class="form-group col-sm-3">
								<label for="inputFunction">Função:</label> 
								<select id="inputFunction" class="form-control" name="funcao">
									<option value="<%= request.getAttribute("funcao") %>" selected><%= request.getAttribute("funcao") %></option>
									<option value="recepcionista">Recepcionista</option>
									<option value="gerente">Gerente</option>
									<option value="outro">Outro</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label for="inputUsername">username:</label> <input type="text"
									class="form-control" id="inputUsername" placeholder="username" name="username" value="<%= request.getAttribute("login") %>" maxlength="10" required>
							</div>
							<div class="form-group col-sm-6">
								<label for="inputPassword">password:</label> <input type="password"
									class="form-control" id="inputPassword" placeholder="password" name="password" value="<%= request.getAttribute("senha") %>" maxlength="10" required>
							</div>
						</div>
						<input type="hidden" name="funcID" value="<%= request.getAttribute("funcID") %>">
						<input type="submit" class="btn btn-primary" value="enviar">
						<h5><% if(request.getSession().getAttribute("erro")!= null){
							out.print(request.getSession().getAttribute("erro"));
							}
							request.getSession().setAttribute("erro", null);%></h5>
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
	
	<script>

		function mascaracpf(obj){
			execmascara(obj)
			}

		function execmascara(obj){
		    obj.value = cpf(obj.value)
		}

		function cpf(v){
		    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
		    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
		    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
		                                             //de novo (para o segundo bloco de números)
		    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
		    return v
		}

		function myFunction(obj){
			let string = obj.value
			let aux = "";
			for(var i = 0; i< string.length; i++){
				let character = string[i];
				character = character.replace(/[^0-9-.]/g, '');
				aux = aux + character;
				}
			obj.value = aux
			
			}

		filterInt = function (value) {
			  if(/^(\-|\+)?([0-9]+)$/.test(value))
			    return Number(value);
			  return NaN;
			}

		function verAge(obj){
			if(isNaN(filterInt(obj.value))){
				window.alert("Please enter valid age")
				obj.value = ""
				}else{
					console.log("foi sucesso")
					}
			}
		
		
	</script>
	
</body>
</html>