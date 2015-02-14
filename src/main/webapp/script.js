'use strict';

var app = angular.module('FINKI_CISCO', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/test', {
		templateUrl : 'views/test.jsp'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
