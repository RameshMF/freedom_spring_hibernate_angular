<div id="main-wrapper">
    <div class="row">
        <div class="col-md-3 center">
            <div class="login-box">
                <p class="logo-name text-center">FREEDOM</p>
                <p class="text-center">Please login into your account.</p>
                <form id="loginForm" action="<%=request.getContextPath()%>/user/authenticate" method="POST">
                    <div class="form-group" ng-class="{ 'has-error' : userLoginForm.username.$invalid && !userLoginForm.username.$pristine }">
                        <input class="form-control" ng-model="user.username" placeholder="Username" name="username" type="text" required autofocus>
                        <p ng-show="userLoginForm.username.$invalid && !userLoginForm.username.$pristine" class="help-block">Username is required!</p>
                    </div>
                    <div class="form-group" ng-class="{ 'has-error' : userLoginForm.password.$invalid && !userLoginForm.password.$pristine }">
                        <input class="form-control" ng-model="user.password" placeholder="Password" name="password" type="password" required>
                        <p ng-show="userLoginForm.password.$invalid && !userLoginForm.password.$pristine" class="help-block">Password is required!</p>
                    </div>
                    <div class="checkbox form-group">
                       <label>
                           <input id='rememberMe' name="remember" type="checkbox" value="Remember Me">Remember Me
                       </label>
                    </div>
                    <div class="form-group text-center">
  						<button type="button" ng-click="userlogin()" class="btn btn-sm btn-success btn-block">LOGIN</button>
   					</div>
                </form>
                <p class="text-center m-t-xs text-sm">Copyright &copy; 2002-2015 Viscount Systems Inc.</p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

$('#loginForm').validate({
	rules: {
		username: {
			required: true,
		},
		password: {
			required: true,
		}
	},
	highlight: function (element) {
		$(element).closest('.form-group').removeClass('success').addClass('error');
	},
	messages: {
		username: {
			required: "Please provide user name"
		},
		password: {
			required: "Please provide password"
		}
	}
});
</script>