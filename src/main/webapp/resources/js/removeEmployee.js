app
		.controller(
				'removeEmployee',
				function($scope, employeeService, modalService) {
					$scope.employeeId = "";

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
											console.log(error);
										})
					};

					$scope.remove = function() {
						if($scope.removeEmployeeForm.$valid){
							employeeService
									.removeEmployee(
											$scope.employeeId,
											function() {
												modalService
														.showSuccessModal("Selected employee removed successfully.")
												$scope.initialise();
											},
											function(error) {
												modalService
														.showErrorModal("Removal of the selected employee failed.")
												console.log(error)
											});
						} else {
							modalService.showErrorModal("Submitted form contains errors.");
						}
					};
				});