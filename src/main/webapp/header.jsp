<!DOCTYPE html>
<html lang="en">

<head>

<!-- Meta tag Keywords -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Découvrez notre s�lection des plus grandes marques de maroquinerie: 20.000 sacs et bagages &amp; 160 marques. Livraison et retour gratuits sous 30 jours." />
<meta name="keywords"
	content="Baggage Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<meta name="title"
	content="Sac à main, sac � dos, bagages et accessoires | Homme &amp; Femme  | Miss Glamour" />
<title>Miss Glamour</title>
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Favicon -->
<link rel="apple-touch-icon" sizes="180x180" href="images/favicon-apple.png">
<link rel="icon" type="image/ico" sizes="48x48" href="images/favicon.ico">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
<!-- Custom-Files -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">

</head>

<body>

	<%-- LIEN DU MENU  --%>
	<c:url value="/index" var="index" scope="request">${requestScope.url}</c:url>
	<c:url value="/about" var="about" scope="request">${requestScope.url}</c:url>
	<c:url value="/coming" var="coming" scope="request">${requestScope.url}</c:url>
	<c:url value="/single" var="single" scope="request">${requestScope.url}</c:url>
	<c:url value="/shop" var="shop" scope="request">${requestScope.url}</c:url>
	<c:url value="/contact" var="contact" scope="request">${requestScope.url}</c:url>
	<c:url value="/register" var="register" scope="request">${requestScope.url}</c:url>
	<c:url value="/login" var="login" scope="request">${requestScope.url}</c:url>
	<%-- FIN LIEN MENU --%>

	<div class="main-sec inner-page">
		<header class="py-sm-3 pt-3 pb-2" id="home">
			<div class="container">
				<!-- nav -->
				<div class="top-w3pvt d-flex">
					<div id="logo">
						<h1>
							<a href="${index}"><label class="sub-des">Miss Glamour</label></a>
						</h1>
					</div>

					<div class="container forms ml-auto">
						<div class="row justify-content-end">
							<c:if test="${user != null}">
								<c:out value="Bienvenue ${user.firstname} ${user.name}" />
							</c:if>
						</div>
						<div class="row justify-content-end">
							<c:if test="${user == null}">
								<a href="${login}" class="btn"><span class="fa fa-user-circle-o"></span> Sign In</a>
								<a href="${register}" class="btn"><span class="fa fa-pencil-square-o"></span> Sign Up</a>
							</c:if>
							<c:if test="${user != null}">
								<a href="${login}" class="btn"><span class="fa fa-sign-out"></span>Log Out</a>
								<a href="#" class="btn shopping-bag"><span class="fa fa-shopping-bag"><div id="bubble"></div></span> Cart</a>
							</c:if>
						</div>
					</div>
				</div>
				<div class="nav-top-wthree">
					<nav>
						<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
						<input type="checkbox" id="drop" />
						<ul class="menu">
							<li><a class="nav-link active" aria-current="page" href="${index}">Home</a></li>
							<li><a class="nav-link active" aria-current="page" href="${about}">About Us</a></li>
							<li>
								<label for="drop-2" class="toggle">
									Dropdown<span class="fa fa-angle-down" aria-hidden="true"></span>
								</label> <a href="#">Dropdown <span class="fa fa-angle-down" aria-hidden="true"></span></a> <input type="checkbox" id="drop-2" />
								<ul>
									<li><a class="nav-link active" aria-current="page" href="${coming}" class="drop-text">Services</a></li>
									<li><a class="nav-link active" aria-current="page" href="${about}" class="drop-text">Features</a></li>
									<li><a class="nav-link active" aria-current="page" href="${single}" class="drop-text">Single Page</a></li>
								</ul>
							</li>
							<li><a class="nav-link active" aria-current="page" href="${shop}">Collections</a></li>
							<li><a class="nav-link active" aria-current="page" href="${contact}">Contact</a></li>
						</ul>
					</nav>
					<!-- //nav -->

					<div class="search-form ml-auto">
						<div class="form-w3layouts-grid">
							<form action="#" method="post" class="newsletter">
								<input class="search" type="search" placeholder="Search here..."
									required="required">
								<button class="form-control btn" value="">
									<span class="fa fa-search"></span>
								</button>
							</form>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</header>