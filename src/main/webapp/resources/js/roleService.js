app.service('roleService', function($http) {
    this.getAllRoles = function(successCallback, failureCallback) {
    	$http({
    		method: "GET",
    		url: "/ems/role/getAll",
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