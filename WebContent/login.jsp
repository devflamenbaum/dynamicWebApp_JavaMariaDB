<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gymnastic - Login Page</title>
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
<link href="./css/login.css" rel="stylesheet">
</head>
<body>
	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				<div class="col-12 user-img">
					<img src="img/logoGym.png">
				</div>
				<form class="col-12" action="${pageContext.request.contextPath}/ServletAuth" method="post">
					<div class="form-group">
						<input type="text" class="form-control text-center"
							name="username" placeholder="Enter the username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control text-center"
							name="password" placeholder="Enter the password">
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" id="athlete"
							name="type" value="athlete" checked="checked"> <label
							class="form-check-label" for="male">Athlete</label> <input
							class="form-check-input" type="radio" id="coach" name="type"
							value="coach"> <label class="form-check-label"
							for="female">Coach</label> <input class="form-check-input"
							type="radio" id="employee" name="type" value="employee">
						<label class="form-check-label" for="employee">Employee</label>
					</div>
					<input type="submit" class="btn btn-primary" value="Login">
				</form>
				<div class="col-12 forgot">
					<a href="index.jsp">Home</a><span> |</span> <a href="#">Forgot
						password?</a>
				</div>
			</div>
		</div>

	</div>



</body>
</html>