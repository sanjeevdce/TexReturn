var taxRetApp = angular.module('taxRetApp', ['naif.base64', 'ngMessages', 'ngRoute']);

taxRetApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

taxRetApp.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(formData, file, uploadUrl){
        var fd = angular.toJson(formData);
		console.log(fd);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
			// clear all the contents and show success message...
        })
        .error(function(){
			// retain all the field values, so that the user can send the data again...
        });
    }
}]);

taxRetApp.controller('taxRetCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        var uploadUrl = "";  
		//console.log(file);
		fileUpload.uploadFileToUrl($scope.model, file, uploadUrl);
    };
}]);

taxRetApp.directive('blacklist', function (){ 
   return {
      require: 'ngModel',
      link: function(scope, elem, attr, ngModel) {
          var blacklist = attr.blacklist.split(',');
          ngModel.$parsers.unshift(function (value) {
             ngModel.$setValidity('blacklist', blacklist.indexOf(value) === -1);
             return value;
          });
      }
   };
});



// configure our routes
taxRetApp.config(function($routeProvider) {
	$routeProvider
	
		// route for the home page
		.when('/', {
			templateUrl : 'formupload.html',
			controller  : 'taxRetCtrl'
		})
		
		// route for the home page
		.when('/home', {
			templateUrl : 'formupload.html',
			controller  : 'taxRetCtrl'
		})

		// route for the search page
		.when('/search', {
			templateUrl : 'search.html',
			controller  : 'searchController'
		});
});

// create the controller and inject Angular's $scope
taxRetApp.controller('searchController', function($scope) {
	// fetch the list of uploaded information from the server...
	var uploadedData = [
		{"name": "ABC", "financialyear": "1234", "docType": "form16", "myFile": ""},
		{"name": "XYZ", "financialyear": "4321", "docType": "taxreturns", "myFile": ""}
	];
	$scope.uploadedData = uploadedData;
});