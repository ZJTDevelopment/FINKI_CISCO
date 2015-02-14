app.controller('userController', function($scope, $http) {

	$scope.user = {};
	$scope.login = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:9966/FINKI_CISCO/login',
			data : $scope.user
		}).success(function(data, status, headers, config) {
			window.alert("OK");
		}).error(function(data, status, headers, config) {
			window.alert(data);
		});
	}
});