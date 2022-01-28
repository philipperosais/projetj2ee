<c:import url="header.jsp"></c:import>
</div>

<c:if test="${exist }">
	<div class="alert alert-danger" role="alert">Email déjà existant !</div>
</c:if>

<section class="banner-bottom py-5">
	<div class="container">
		<div class="content-grid">
			<div class="text-center icon">
				<span class="fa fa-user-circle-o"></span>
			</div>
			<div class="content-bottom">
				<form action="<% request.getContextPath(); %>register" method="post">
					<div class="field-group">
						<div class="content-input-field">
							<input name="firstname" id="text1" type="text" value="" placeholder="Firstname" required="required">
						</div>
					</div>
					<div class="field-group">

						<div class="content-input-field">
							<input name="name" id="text2" type="text" value="" placeholder="Name" required="required">
						</div>
					</div>
					<div class="field-group">

						<div class="content-input-field">
							<input name="email" id="text3" type="email" value="" placeholder="Mail" required="required">
						</div>
					</div>
					<div class="field-group">
						<div class="content-input-field">
							<input name="password" id="text4" type="password" placeholder="Password" required="required">
						</div>
					</div>
					<div class="content-input-field">
						<button type="submit" class="btn">Sign Up</button>
					</div>
					<div class="list-login-bottom text-center mt-lg-5 mt-4">
						<a href="#" class="">By clicking Signup, I agree to your terms</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<c:import url="footer.jsp"></c:import>