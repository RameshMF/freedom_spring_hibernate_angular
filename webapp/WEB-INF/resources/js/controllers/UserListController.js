app.controller('UserListController', function UserListController($scope, $rootScope, $location, $window) {
	
	var userJson = [
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {
	                	"lastName": "ABM",
	                	"firstName":"Day Porter",
	                	"displayName":"ABM, Day Porter",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401258"
	                },
	                {
	                	"lastName": "Cote",
	                	"firstName":"Tom",
	                	"displayName":"Cote, Tom",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401014"      	
	                },
	                {
	                	"lastName": "DeBouver",
	                	"firstName":"Bruce",
	                	"displayName":"DeBouver, Bruce",
	                	"suite":"",
	                	"accessGroups":"Main: 19-Tel - 4 - 12 Acc Lev",
	                	"cards": "wg-21401016"
	                },
	                {
	                	"lastName": "Ibanez",
	                	"firstName":"Eddie",
	                	"displayName":"Ibanez, Eddie",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401365"
	                },
	                {	 "lastName": "Lenaburg",
	                	"firstName":"Christian",
	                	"displayName":"Lenaburg, Christian",
	                	"suite":"",
	                	"accessGroups":"Main: 7-Access Level 2",
	                	"cards": "wg-21401942"
	                }];


	var createLink = function (data, type, row, full) {
		return '<a href="#/updateUser" class="editButton">' + data.lastName +'</a>';

	};

	$('#usersTable').DataTable({
		"aaData" : userJson,
		"iDisplayLength" : 7,
		"aoColumns" : [
		               {
		            	   "data" : null,
		            	   "targets" : 0

		               },
		               {
		            	   "mData" : "firstName"
		               },
		               {
		            	   "mData" : "displayName"
		               },
		               {
		            	   "mData" : "suite"
		               },
		               {
		            	   "mData" : "accessGroups"
		               },
		               {
		            	   "mData" : "cards"
		               }
		               ],
		               'columnDefs' : [
		                               {
		                            	   'render' : createLink,
		                            	   'targets' : 0
		                               }
		                               ]
	});

	$scope.addUser = function() {
		$location.path("addUser");
	};
	
});
