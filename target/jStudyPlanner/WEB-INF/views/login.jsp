<form accept-charset="UTF-8" role="form" action="${pageContext.request.contextPath}/login" method="post">
	<fieldset>
		<div class="form-group">
			<input class="form-control" placeholder="Username or E-mail" name="username" type="text">
		</div>
		<div class="form-group">
			<input class="form-control" placeholder="Password" name="password" type="password" value="">
		</div>
		<div class="checkbox">
			<label>
				<input name="remember" type="checkbox" value="Remember Me"> Remember Me
			</label>
		</div>
		<a href="#">Forgot Password?</a>
	</fieldset>
	<button class="btn btn-primary" type="submit">Login</button>
</form>