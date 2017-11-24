'use strict';

var app = angular.module('freedomModules', ['ngRoute', 'ngResource', 'ngSanitize', 'ui', 'ngCookies', 'userService']);  // This app variable says angular module 
                                                                                            // and its final variable
app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/login', {templateUrl: 'view/template/login', controller: 'LoginController'}).
	when('/listUser', {templateUrl: 'view/template/listUser', controller: 'UserListController'}).
	when('/addUser', {templateUrl: 'view/template/addUser', controller: 'AddUserController'}).
	when('/updateUser', {templateUrl: 'view/template/updateUser', controller: 'EditUserController'}).
	when('/databaseUser', {templateUrl: 'view/template/databaseUser', controller: 'DatabaseUserController'}).
	when('/databaseConfig', {templateUrl: 'view/template/databaseConfig', controller: 'DatabaseConfigController'}).
	when('/viewUsers', {templateUrl: 'view/template/viewUsers', controller: 'ViewUsersController'}).
	otherwise({redirectTo: '/databaseConfig'});

}]).factory('authHttpResponseInterceptor',['$q','$location', '$rootScope',function($q,$location, $rootScope){
	
    return {
        response: function(response){
            if (response.status === 401) {
                console.log("Response 401");
            }
            return response || $q.when(response);
        },
        responseError: function(rejection) {
            if (rejection.status === 401) {
            	console.log("Response Error 401", rejection);
            	$location.path('/login');
            	$('#sessionTimeoutModal').modal('show');
            }
            return $q.reject(rejection);
		}
	};
	
}]).config(['$httpProvider',function($httpProvider) {
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.interceptors.push('authHttpResponseInterceptor');
}]);

app.run(['$rootScope', '$location', function ($rootScope, $location) {

	$rootScope.$on('$routeChangeStart', function (event, next, current) {
	});
	
}]);

