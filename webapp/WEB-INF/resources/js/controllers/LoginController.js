app.controller('LoginController', function LoginController($scope, $rootScope, $location, $cookies, UserService) {
	
	$rootScope.isLoading = false;
	$scope.user = {};
	
	$scope.userlogin = function() {
		var valid = $('#loginForm').valid();
		if(valid) {
			$('#loginForm').submit();
		}
	};

	$(document).ready(function() {
		var freedomCredential = $cookies.getObject('freedomCredential');
		if (freedomCredential != undefined && freedomCredential.isRemember && freedomCredential.isRemember != '') {
			$('#rememberMe').attr('checked', 'checked');
			$scope.user.username = freedomCredential.userName;
			$scope.user.password = freedomCredential.password;
		} else {
			$('#rememberMe').removeAttr('checked');
			$scope.user.username = '';
			$scope.user.password = '';
		}
	});
	
});
