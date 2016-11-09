app
		.controller(
				'modifyEmployee',
				function($scope, employeeService, departmentService,
						projectService, roleService, modalService) {
					$scope.employee = {};

					$scope.employees = [];

					$scope.selectedEmployee = {};

					$scope.initialise = function() {

						$scope.employee = {
							employeeId : "",
							phoneNumber : "",
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
											console.log(error)
										});

						roleService
								.getAllRoles(
										function(data) {
											$scope.roles = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch role details from the server.")
											console.log(error)
										});

						employeeService
								.getAllEmployees(
										function(data) {
											$scope.employees = data;
										},
										function(error) {
											modalService
													.showErrorModal("Cannot fetch employee details from the server.")
											console.log(error);
										});
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
													.showErrorModal("Cannot fetch projects for selected department.")
											console.log(error)
										});
					};

					$scope.populateForm = function() {
						$scope.employees.forEach(function(item, index) {
							if (item.employeeId == $scope.employee.employeeId) {
								$scope.selectedEmployee = item;
							}
						});

						$scope.employee.phoneNumber = $scope.selectedEmployee.phoneNumber;
						$scope.employee.address = $scope.selectedEmployee.address;
						$scope.employee.departmentId = $scope.selectedEmployee.department.departmentId;
						$scope.setProjects();
						$scope.employee.projectId = $scope.selectedEmployee.project.projectId;
						$scope.employee.roleId = $scope.selectedEmployee.role.roleId;
					};

					$scope.modify = function() {
						if($scope.modifyEmployeeForm.$valid){
							employeeService
									.modifyEmployee(
											$scope.employee,
											function() {
												modalService
														.showSuccessModal("Selected employee modified successfully.")
												$scope.initialise();
											},
											function(error) {
												modalService
														.showErrorModal("Modification of the selected employee failed.")
												console.log(error);
											});
						} else{
							modalService.showErrorModal("Submitted form contains errors.");
						}
					};
				});