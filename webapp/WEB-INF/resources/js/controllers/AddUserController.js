app.controller('AddUserController', function AddUserController($scope, $rootScope, $location) {
	
	$('.go_in').click(function() {
		return !$('.all_options option:selected').remove().appendTo('.chosen_options');
	});
	$('.go_out').click(function() {
		return !$('.chosen_options option:selected').remove().appendTo('.all_options'); 
	});

	$('.floorAccessAdd').click(function() {
		return !$('.all_floor_options option:selected').remove().appendTo('.chosen_floor_options');
	});

	$('.floorAccessRemove').click(function() {
		return !$('.chosen_floor_options option:selected').remove().appendTo('.all_floor_options '); 
	});

	$scope.addNewUser = function() {
		$location.path("listUser");
	};

	$scope.cancelUser = function() {
		$location.path("listUser");
	};
	
});
