app
		.controller(
				'searchEmployee',
				function($scope, employeeService, departmentService,
						projectService, roleService) {
					$scope.searchCriteria = {
						"employeeId" : "",
						"emailId" : "",
						"name" : ""
					};

					$scope.employees = [];

					$scope.search = function() {
						employeeService
								.searchEmployee(
										$scope.searchCriteria,
										function(data) {
											$scope.employees = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch employee details from the server.")
											console.log(error)
										});
					};
				});