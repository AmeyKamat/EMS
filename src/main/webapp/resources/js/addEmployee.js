app
		.controller(
				'addEmployee',
				function($scope, employeeService, departmentService,
						projectService, roleService, modalService) {
					$scope.employee = {};

					$scope.initialise = function() {
						console.log("a")
						$scope.employee = {
							name : "",
							emailId : "",
							phoneNumber : "",
							dateOfBirth : "",
							address : "",
							departmentId : "",
							projectId : "",
							roleId : ""
						};

						departmentService
								.getAllDepartments(
										function(data) {
											$scope.departments = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch department details from the server.")
											console.log(error);
										});

						roleService
								.getAllRoles(
										function(data) {
											$scope.roles = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch role details from the server.")
											console.log(error);
										});
					};

					$scope.setEmailId = function() {
						$scope.employee.emailId = $scope.employee.name != "" ? $scope.employee.name.split(
								" ").join(".").toLowerCase()
								+ "@barclays.com": "";
					};

					$scope.setProjects = function() {
						projectService
								.getProjectsByDepartment(
										$scope.employee.departmentId,
										function(data) {
											$scope.projects = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch project for the selected department.")
											console.log(error);
										});
					};

					$scope.add = function() {
						if ($scope.addEmployeeForm.$valid) {
							employeeService
									.addEmployee(
											$scope.employee,
											function() {
												modalService
														.showErrorModal("Selected employee added successfully.");
												$scope.initialise();
											},
											function(error) {
												modalService
														.showErrorModal("Addition of the employee failed.")
												console.log(error);
											});
						} else {
							modalService
									.showErrorModal("Submitted form contains errors.")
						}
					}

				});