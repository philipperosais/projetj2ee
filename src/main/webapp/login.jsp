<c:import url="header.jsp"></c:import>
</div>

<section class="banner-bottom py-5">
	<c:if test="${exist == 'false' }">
		<div class="alert alert-success" role="alert"> Votre compte a bien été créé !</div>
	</c:if>

	<c:if test="${logged == 'false' }">
		<div class="alert alert-warning" role="alert"> Echec de login !</div>
	</c:if>
	<div class="container">
		<div class="content-grid">
			<div class="text-center icon">
				<span class="fa fa-unlock-alt"></span>
			</div>
			<div class="content-bottom">
				<form action="<% request.getContextPath(); %>login" method="post">
					<div class="field-group">
						<div class="content-input-field">
							<input name="email" id="text1" type="text" value=""
								placeholder="Login" required="required">
						</div>
					</div>
					<div class="field-group">
						<div class="content-input-field">
							<input name="password" id="myInput" type="Password" placeholder="Password" required="required">
						</div>
					</div>
					<div class="content-input-field">
						<button type="submit" class="btn">Sign In</button>
					</div>
					<!-- <ul class="list-login">
						<li class="switch-slide"><label class="switch"> <input
								type="checkbox"> <span class="slider round"></span> keep
								Logged in
						</label></li>
						<li><a href="#" class="text-right">Forgot password?</a></li>
						<li class="clearfix"></li>
					</ul> -->
					<ul class="list-login-bottom mt-4 text-center">
						<li><a href="register.html">Don't have an Account?</a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
</section>
<!-- /login -->

<c:import url="footer.jsp"></c:import>