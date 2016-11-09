app.service('departmentService', function($http) {
    this.getAllDepartments = function(successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/department/getAll",
    	}).then(function(response){
    		if(response.status == 200){
    			console.log(response.data)
    			successCallback(response.data);
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    }
});