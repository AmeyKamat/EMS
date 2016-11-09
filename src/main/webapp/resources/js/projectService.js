app.service('projectService', function($http) {
    this.getAllProjects = function(successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/project/getAll",
    	}).then(function(response){
    		if(response.status == 200){
    			console.log(response.data)
    			successCallback(response.data);
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
    
    this.getProjectsByDepartment = function(departmentId, successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/project/getByDepartment",
    		params: {"departmentId": departmentId}
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