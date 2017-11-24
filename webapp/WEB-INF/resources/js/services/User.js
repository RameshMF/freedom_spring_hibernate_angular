angular.module('userService', [ 'ngResource' ]).factory('UserService',
		function($resource, $rootScope) {
	return $resource('', {}, {
		
		userAuthenticate: {
			url: 'user/authenticate',
			method : 'POST',
			isArray : false
		},
		
		getDatabaseConfiguration: {
			url: 'dbconfig/isConfigured',
			method : 'GET',
			isArray : false
		},
		
		saveDatabaseConfiguration : {
			url: 'dbconfig/addUpdate',
			method : 'POST',
			isArray : false
		},

		getActive: {
			url: 'dbconfig/getActive',
			method : 'GET',
			isArray : false
		},
		
		getAdminUsers: {
			url: 'user/getAdminUsers',
			method : 'GET',
			isArray : false
		},
		
		updateDBRecord : {
			url: 'dbconfig/updateActiveDbProp',
			method : 'POST',
			isArray : false
		},
		
		getDBRecord : {
			url: 'dbconfig/getActiveDbProp',
			method : 'GET',
			isArray : false
		}

	});
});
