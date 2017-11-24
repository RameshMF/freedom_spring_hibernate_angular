app.controller('HeaderController', function HeaderController($scope, $rootScope, $location, $cookies, $window, UserService) {
	
	$scope.userLogout = function() {
		$('#logoutForm').submit();
	};

	$('.selectpicker').selectpicker({});

	$scope.showDatabaseConfig = function() {
		$location.path("databaseConfig");
	};
	
});
