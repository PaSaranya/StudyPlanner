<div class="modal fade" id="loginForm" tabindex="-1" role="dialog" aria-labelledby="formLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="formLabel">Login to jStudyPlanner</h4>
			</div>
			<form accept-charset="UTF-8" role="form" action="${pageContext.request.contextPath}/login" method="post">
				<div class="modal-body">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Username or E-mail" name="username" type="text" autofocus="autofocus">
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
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button class="btn btn-primary" type="submit">Login</button>
				</div>
			</form>
		</div>
	</div>
</div>