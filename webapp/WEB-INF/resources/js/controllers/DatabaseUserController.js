app.controller('DatabaseUserController', function($scope, $rootScope, $location, UserService) {
	
	function loadInitialServices() {
		$rootScope.isLoading = true;
		UserService.getAdminUsers({}, function (response) {
			$rootScope.isLoading = false;
			var data = [];
			if(response.object != null) {
				data = response.object;
			}
			loadUserTable(data);
		});
	}
	
	loadInitialServices();
	
	function loadUserTable(data) {

		$('#databaseUserTable').DataTable({
			"aaData" : data,
			"iDisplayLength" : 5,
			"aoColumns" : [
			               {
			            	   "mData" : "lastName"
			               },
			               {
			            	   "mData" : "firstName"
			               },
			               {
			            	   "mData" : "business"
			               },
			               {
			            	   "mData" : "sites"
			               },
			               {
			            	   "mData" : "userLanguage"
			               }
			               ]
		});
	}
	
});
