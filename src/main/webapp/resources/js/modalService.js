app.service('modalService', function() {
	this.successModal = $("#successModal");
	
	this.successModalMessage = $("#successModalMessage");
	
	this.errorModal = $("#errorModal");
	
	this.errorModalMessage = $("#errorModalMessage");
    
	this.showSuccessModal = function(message) {
    	this.successModalMessage.text(message);
    	this.successModal.modal("show");
    }
    
    this.showErrorModal = function(message) {
    	this.errorModalMessage.text(message);
    	this.errorModal.modal("show");
    }
});