<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gymnastic - Home page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/1f89205492.js" crossorigin="anonymous"></script>
	<link href="./css/style.css" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><img src="img/logoGym.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" href="#home">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#about">About</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#team">Team</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#connect">Connect</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Login</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!--- Image Slider -->

<div id="slides" class="carousel slide" data-ride="carousel" id="home">
	<ul class="carousel-indicators">
		<li data-target="#slides" data-slide-to="0" class="active"></li>
		<li data-target="#slides" data-slide-to="1"></li>
		<li data-target="#slides" data-slide-to="2"></li>
	</ul>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="img/backgroundGym1.jpg" alt="">
			<div class="carousel-caption">
				<h1 class="display-2">Gymtastic</h1>
				<h3>The way to challenge yourself.</h3>
				<button type="button" class="btn btn-outline-light btn-lg">Gallery</button>
				<button type="button" class="btn btn-primary btn-lg">Get Started</button>
			</div>
		</div>
		<div class="carousel-item">
			<img src="img/backgroundGym2.jpg" alt="">
		</div>
		<div class="carousel-item">
			<img src="img/backgroundGym3.jpg" alt="">
		</div>
	</div>

</div>


<!--- Jumbotron -->
<div class="container-fluid">
	<div class="row jumbotron">
		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
			<p class="lead">“During the hard times, it’s 
				important to focus on the things you can change in that moment instead of what you should have or could have done differently.” 
				– Annie Thorisdottir, Crossfit athlete
			</p>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
			<a href="#"><button type="button" class="btn btn-outline-secondary btn-lg"><img src="img/crossfitgames (1).ico">crossfit Games</button></a>
		</div>
	</div>
</div>

<!--- Welcome Section -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">Work Hard.</h1>
		</div>
		<hr>
		<div class="col-12">
			<p class="lead">Welcome to our crossfit box. We give the opportunity for everyone to overcome their challenges.
			</p>
		</div>
	</div>
</div>

<!--- Three Column Section -->
<div class="container-fluid padding">
	<div class="row text-center padding">
		<div class="col-xs-12 col-sm-6 col-md-4">
			<i class="fas fa-fire-alt"></i>
			<h3>Endurance</h3>
			<p>Train to take your breath to the limit.</p>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<i class="fas fa-calendar-check"></i>
			<h3>Discipline</h3>
			<p>Here the train goes beyond, everyone learns discipline.</p>
		</div>
		<div class="col-sm-12 col-md-4">
			<i class="fas fa-people-arrows"></i>
			<h3>Connect</h3>
			<p>We have a large comunity, you will meet lifetime friends.</p>
		</div>
	</div>
	<hr class="my-4">
</div>

<!--- Two Column Section -->
<div class="container-fluid padding">
	<div class="row padding">
		<div class="col-md-12 col-lg-6" id="about">
			<h2>About...</h2>
			<p>Operating a successful gym is a huge challenge for many owners in the industry. 
				In order for us to continuously generate unique experience while fullfilling our purpose, 
				the key is communication.
			</p>Here, we are engaged to attend your needs with the best professionals and technology available.
			<p>
			</p>
			<p>Step by step, you can achieve your goals, just need to believe.
			</p>
			<br>
			<a href="#"><button type="button" class="btn btn-primary">Learn more.</button></a>
		</div>
		<div class="col-lg-6">
			<img src="img/about.png" class="img-fluid">
		</div>
	</div>
</div>

<hr class="my-4">
<!--- Fixed background -->
<figure>
	<div class="fixed-wrap">
		<div id="fixed"></div>
	</div>
</figure>


<!--- Meet the team -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">MEET OUR COACHS</h1>
		</div>
		<hr>
	</div>
</div>
<!--- Cards -->
<div class="container-fluid padding" id="team">
	<div class="row padding">
		<div class="col-md-4">
			<div class="card">
				<img src="img/gymteam1.png" class="card-img-top">
				<div class="card-body">
					<h4 class="card-title">Takashi Ho</h4>
					<p class="card-text">Takashi has more than 5 years of experience in crossfit training and is
						a certified crossfit Games judge.
					</p>
					<a href="#" class="btn btn-outline-secondary">See profile</a>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card">
				<img src="img/gymteam2.png" class="card-img-top">
				<div class="card-body">
					<h4 class="card-title">Mary Jane</h4>
					<p class="card-text">Mary is a professional dancer and has shown
						proficiency training our athletes.
					</p>
					<a href="#" class="btn btn-outline-secondary">See profile</a>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card">
				<img src="img/gymteam3.png" class="card-img-top">
				<div class="card-body">
					<h4 class="card-title">Lucas Alves</h4>
					<p class="card-text">Lucas has experience in professional competitions
						and he is a former physical education professional.
					</p>
					<a href="#" class="btn btn-outline-secondary">See profile</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!--- Connect -->

<div class="container-fluid padding">
	<div class="row text-center padding">
		<div class="col-12" id="connect">
			<h2>Connect</h2>
		</div>
		<div class="col-12 social padding">
			<a href="#"><i class="fab fa-facebook"></i></a>
			<a href="#"><i class="fab fa-twitter"></i></a>
			<a href="#"><i class="fab fa-google-plus-g"></i></a>
			<a href="#"><i class="fab fa-instagram"></i></a>
			<a href="#"><i class="fab fa-youtube"></i></a>
		</div>
	</div>
</div>


<!--- Footer -->
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
