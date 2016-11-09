app.service('employeeService', function($http) {
    this.getAllEmployees = function(successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/employee/getAll",
    	}).then(function(response){
    		if(response.status == 200){
    			console.log(response.data)
    			successCallback(response.data);
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
    
    this.addEmployee = function(employee, successCallback, failureCallback){
    	$http({
    		method: "POST",
    		url: "/ems/employee/add",
    		data: employee
    	}).then(function(response){
    		if(response.status == 200){
    			successCallback();
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
    
    this.removeEmployee = function(employeeId, successCallback, failureCallback){
    	$http({
    		method: "DELETE",
    		url: "/ems/employee/remove",
    		params: { "employeeId": employeeId }
    	}).then(function(response){
    		if(response.status == 200){
    			successCallback();
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
    
    this.searchEmployee = function(searchCriteria, successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/employee/search",
    		params: searchCriteria
    	}).then(function(response){
    		if(response.status == 200){
    			successCallback(response.data);
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
    
    this.modifyEmployee = function(employee, successCallback, failureCallback){
    	$http({
    		method: "PUT",
    		url: "/ems/employee/modify",
    		data: employee
    	}).then(function(response){
    		if(response.status == 200){
    			successCallback();
    		}
    	}, function(error){
    		failureCallback(error);
    	});
    };
});