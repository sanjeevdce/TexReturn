var app = angular.module('loginApp', ['ngMessages', 'ngRoute', 'ngStorage']);

app.service('credentialValidator', ['$http', '$window', '$localStorage', function ($http, $window, $localStorage) {
    this.validateCredential = function(formData, loginUrl){
        var fd = angular.toJson(formData);
		console.log(fd);
		
		// move below line into success section...
        $window.location.href = 'form16.html';
		
		$http.post(loginUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(data){
			// clear all the contents and show success message...
			if(data.validationStatus){ // if true then success, redirect to home page...
				
			} else {
				// show entered credentials in correct message...
				
			}
        })
        .error(function(){
			
        });
    }
}]);

app.controller('loginCtrl', ['$scope', 'credentialValidator', '$localStorage', '$window', function($scope, credentialValidator, $localStorage, $window){
    $scope.validateCredentials = function(){
        var loginUrl = "";  
		credentialValidator.validateCredential($scope.model, loginUrl);
    };
}]);

// create the controller and inject Angular's $scope
app.controller('resetCtrl', function($scope) {
	
});

// configure our routes
app.config(function($routeProvider) {
	$routeProvider
	
		// route for the home page
		.when('/', {
			templateUrl : 'login.html',
			controller  : 'loginCtrl'
		})
		
		// route for the home page
		.when('/login', {
			templateUrl : 'login.html',
			controller  : 'loginCtrl'
		})

		// route for the search page
		.when('/search', {
			templateUrl : 'search.html',
			controller  : 'searchController'
		});
});