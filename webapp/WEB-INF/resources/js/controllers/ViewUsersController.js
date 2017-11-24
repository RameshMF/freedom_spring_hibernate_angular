app.controller('ViewUsersController', function($scope, $rootScope, $location, UserService) {

	$scope.sValueArray = [];
	$scope.updateFailedMsg = "Failed to Update Record";

	function loadInitialServices() {
		$rootScope.isLoading = true;
		UserService.getDBRecord({}, function (response) {
			$rootScope.isLoading = false;
			var data = [];
			if(response.object != null) {
				data = response.object;
			}
			loadUserTable(data);
		});
	}

	loadInitialServices();
	var flag = false;
	var count = 0;
	function loadUserTable(data) {

		$('#disableButton').prop('disabled', true);

		$('#viewUsersTable').DataTable({
			"aaData" : data, 
			"iDisplayLength" : 5,
			"aoColumns" : [
			               {
			            	   "sWidth": "50%",
			            	   "mData" : "keyname"
			               },
			               {
			            	   "sWidth": "50%",
			            	   "mData" : "value"
			               }]
		});

		$("#viewUsersTable tbody td").bind('click',function() {
			
			count++;
			if(count == 1){
				$('#disableButton').prop('disabled', true);
				flag = false;
			}
			if(count >= 2){
				$('#disableButton').prop('disabled', true);
				flag = true;
			}
			
		}); 
    

		$('#viewUsersTable tbody td').editable( function(sValue) {
			console.log("==sValue==",sValue);
			if(!flag){
				$('#disableButton').prop('disabled', false);	
				count = 0;
			}
			if(count == 0){
				$('#disableButton').prop('disabled', false);	
			}
			
			var oTable = $('#viewUsersTable').dataTable();
			var aPos = oTable.fnGetPosition(this);
			var aData = oTable.fnGetData( aPos[0] );
			if(sValue !=null && sValue != undefined) {
				if(aPos[1] == 0) {
					aData.keyname = sValue;
				} else {
					aData.value = sValue;
				}
				$scope.sValueArray = $.grep($scope.sValueArray, function(e){ 
					return e.id != aData.id; 
				});
				$scope.sValueArray.push(aData);
				console.log("aData",aData);
				console.log("=== $scope.sValueArray===",$scope.sValueArray);
			}
			aData[ aPos[1] ] = sValue;
			return sValue;
		}, { "onblur": 'submit' } );
	}

	$scope.updateUserRecord = function() {
		$rootScope.isLoading = true;
		UserService.updateDBRecord($scope.sValueArray, function (response) {
			$rootScope.isLoading = false;
			$scope.updateSuccessMsg = response.userMessage;
			$scope.sValueArray = [];
			if(response.status) {
				$scope.showMessage($scope.updateSuccessMsg);
			} else {
				$scope.showMessage($scope.updateFailedMsg);
			}
		});
	};

	$scope.showMessage = function(message) {
		$scope.successMessage = message;
		$('#viewMessageModal').modal('show');
		$('#viewMessageModal').removeClass('hide');
	};

	$scope.cancelUserRecord = function() {
		$location.path("listUser");
	};
});
