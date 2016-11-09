var app = angular.module("EMSApp", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/add", {
        templateUrl : "resources/views/addEmployee.html"
    })
    .when("/getAll", {
        templateUrl : "resources/views/getAllEmployees.html"
    })
    .when("/remove", {
        templateUrl : "resources/views/removeEmployee.html"
    })
    .when("/search", {
        templateUrl : "resources/views/searchEmployee.html"
    })
    .when("/modify", {
        templateUrl : "resources/views/modifyEmployee.html"
    });
});