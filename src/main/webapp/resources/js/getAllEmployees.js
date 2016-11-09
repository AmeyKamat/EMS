app
		.controller(
				'getAllEmployees',
				function($scope, employeeService, modalService) {
					$scope.employees = [];

					$scope.initialise = function() {
						employeeService
								.getAllEmployees(
										function(data) {
											$scope.employees = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch employee details from the server.")
											console.log(error)
										})
					};
				});