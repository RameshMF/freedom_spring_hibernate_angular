app.controller('DatabaseConfigController', function($scope, $rootScope, $location, $cookies, UserService) {
	
	$rootScope.isAuthenticatedUser = false;
	$scope.noDbConfigMsg = "Your Database Configuration is not Set";
	if($("#userInfo_accountId").val().length > 0) {
		getActiveDatabaseConfig();
	} else {
		$location.path('login');
		$scope.showMessage($scope.noDbConfigMsg);
	}
	
	($cookies.getObject('globalsUser'));
	
	$rootScope.activeDatabase = {};

	$scope.submitDatabaseConfig = function() {
		$rootScope.isLoading = true;
		if($rootScope.activeDatabase.isSsl) {
			$rootScope.activeDatabase.isSsl = 1;
		} else {
			$rootScope.activeDatabase.isSsl = 0;
		}
		UserService.saveDatabaseConfiguration($rootScope.activeDatabase, function (response) {
			$rootScope.isLoading = false;
			$scope.successMsg = response.userMessage;
			if($scope.isAuthenticatedUser) {
				$scope.showMessage($scope.successMsg);
			} else {
				$location.path('login');
			}
		});
		$rootScope.isLoading = false;
	};
	
	$scope.showMessage = function(message) {
		$scope.successMessage = message;
		$('#MessageModal').modal('show');
		$('#MessageModal').removeClass('hide');
	};

	function getActiveDatabaseConfig() {	
		$rootScope.isLoading = true;
		UserService.getActive({}, function (response) {
			$rootScope.isLoading = false;
			if(response.status) {
				$scope.isPageShow = true;
				$rootScope.isAuthenticatedUser = true;
				$rootScope.activeDatabase = response.object; 
			}
		});
	}
	
});
