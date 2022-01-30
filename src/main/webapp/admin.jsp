<!DOCTYPE html>
<html lang="en">

<head>
<title>Administration du site Miss Glamour</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />

<!-- //Meta tag Keywords -->
<!-- Custom-Files -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/styleAdmin.css" type="text/css"
	media="all" />
<!-- Style-CSS -->
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome-icons -->

</head>

<body>
	<div class="main-sec inner-page">
		<header class="py-sm-3 pt-3 pb-2" id="home">
			<div class="container">
				<!-- nav -->
				<div class="top-w3pvt d-flex">
					<div id="logo">
						<h1>
							<a href="index.html">
								<label class="sub-des mt-4">MISS GLAMOUR</label>
							</a>
						</h1>
					</div>

					<p class="col-6 text-center">PAGE ADMINISTRATEUR</p>

					<div class="forms ml-auto">
						<a href="loginAdmin.html" class="btn"><span class="fa fa-user-circle-o"></span> Sign In</a>
						<a href="registerAdmin.html" class="btn"><span class="fa fa-pencil-square-o"></span> Sign Up</a>
					</div>
				</div>
				<!-- //nav -->
			</div>
		</header>
	</div>
	
	<!-- bar chart -->
	<c:if test="${articleCreated == 'true'}">
		<div class="alert alert-success" role="alert"> L'article <c:out value="${article.name}"/> a bien été ajouté !</div>
	</c:if>
	<c:if test="${exist == 'false' }">
		<div class="alert alert-success" role="alert"> Votre compte a bien été créé !</div>
	</c:if>
	
	<!-- bar chart -->
	<div class="text-center mt-3">
		<h2>LES 3 MEILLEURES VENTES</h2>
	</div>

	<div class="card-body" id="container">
		<!-- bar chart -->
		<div class="row">
			<div class="col-9">
				<canvas id="barchart"></canvas>
			</div>
			<div class="col-3">
				<form method="post" action="<%request.getContextPath(); %>admin">
					<select class="form-control" name="purchaseYear">
		        		<option selected>Sélectionnez une année</option>
		        		<c:forEach items="${purchases}" var="purchase">
		      		  		<option><c:out value="${purchase.purchaseDate}" /></option>
		      			</c:forEach>
		      		</select>
		      		<button type="submit" class="btn btn-primary" name="submit">Choisir cette année</button>
	      		</form>
			</div>
		</div>
	</div>
	<!-- //bar chart -->

	<!-- list of articles-->
	<div class="text-center mt-3">
		<h2>LISTES DES ARTICLES EN LIGNE</h2>
	</div>
	<div class=container>
		<c:if test="${empty articles}">
			<div class="alert alert-info" role="alert">Pas d'article disponible pour le moment</div>
		</c:if>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Marque</th>
					<th scope="col">Quantité</th>
					<th scope="col">Photo</th>
					<th scope="col">Prix</th>
					<th scope="col">Couleur</th>
					<th scope="col">Description</th>
					<th scope="col">Pays de production</th>
					<th scope="col">Dimensions</th>
					<th scope="col">Note moyenne</th>
					<th scope="col">Modifier</th>
					<th scope="col">Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="article">
					<c:if test = "${article.isVisible == true}" >
						<tr>
							<td><c:out value="${article.name}"></c:out></td>
							<td><c:out value="${article.brand}"></c:out></td>
							<td><c:out value="${article.quantity}"></c:out></td>
							<td><img alt="image du sac ${article.name}" src="images/${article.photo}" style="width: 100px; height: 100px"></td>
							<td><c:out value="${article.price}"></c:out></td>
							<td><c:out value="${article.color}"></c:out></td>
							<td><c:out value="${article.description}"></c:out></td>
							<td><c:out value="${article.placeProduction}"></c:out></td>
							<td><c:out value="${article.sizes}"></c:out></td>
							<td><c:out value="${article.averageScore}"></c:out></td>
							<td><a href=""><i class="fa fa-edit"></i></a></td>
							<td><a href=""><i class="fa fa-trash-o"></i></a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		
		<%-- Ajout article --%>
		<form method="post" action="<% request.getContextPath(); %>admin">
			<table>
				<tbody>
					<tr>
						<td>
							<input type="text" class="form-control" name="name" required placeholder="Nom">
						</td>
						<td>	
							<input type="text" class="form-control" name="brand" required placeholder="Marque">
						</td>
						<td>
							<input type="text" class="form-control" name="quantity" required placeholder="Quantité">
						</td>
						<td>
							<input type="file" class="form-control" name="photo" required placeholder="Photo">
						</td>
						<td>
							<input type="text" class="form-control" name="price" required placeholder="Prix">
						</td>
						<td>
							<input type="text" class="form-control" name="color" required placeholder="Couleur">
						</td>
						<td>
							<input type="text" class="form-control" name="description" required placeholder="Description">
						</td>
						<td>
							<input type="text" class="form-control" name="placeProduction" required placeholder="Provenance">
						</td>
						<td>
							<input type="text" class="form-control" name="sizes" required placeholder="Dimensions">
						</td>
						<td>
							<input type="hidden" class="form-control" name="isVisible" value="true">
						</td>
						<td>
							<button type="submit" class="btn btn-primary" name="submit">Valider</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- list of articles-->

	<!-- footer -->
	<div class="footer_agileinfo_topf py-5">
		<div class="container py-md-5">
			<div class="row">
				<div class="col-lg-3 footer_wthree_gridf mt-lg-5">
					<label class="sub-des2">MISS GLAMOUR</label>
				</div>

				<div class="col-lg-3 footer_wthree_gridf mt-md-0 mt-sm-4 mt-3">
					<ul class="footer_wthree_gridf_list">
						<li><a href="loginAdmin.html"><span
								class="fa fa-angle-right" aria-hidden="true"></span> Login </a></li>

						<li><a href="registerAdmin.html"><span
								class="fa fa-angle-right" aria-hidden="true"></span>Register</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- //footer -->

	<!-- copyright -->
	<div class="cpy-right text-center py-3">
		<p>
			<a>Page Admin du site Miss Glamour</a>
		</p>

	</div>
	<!-- //copyright -->

	<script src="js/jquery-3.6.0.min.js"></script>

	<!-- chart js -->
	<script src="js/Chart.min.js"></script>
	<!-- //chart js -->

	<!-- Scripts of Barchart -->
	<script src="js/bar.js"></script>
	<!-- //Scripts of Barchart -->

	<script src="js/scriptAdmin.js"></script>

</body>

</html>