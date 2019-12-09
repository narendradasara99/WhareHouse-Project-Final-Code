$(document).ready(function() {
	// 1 hide the error section
	$("#orderCodeError").hide();
	$("#shipmentModeError").hide();
	$("#vendorError").hide();
	$("#referenceNumberError").hide();
	$("#qualityCheckError").hide();
	$("#descriptionError").hide();

/////////////////////////////////////////////////////////////////////////////////	
	
	// 2 create boolean variable
	var orderCodeError = true;
	var shipmentModeError = true;
	var vendorError = true;
	var referenceNumberError = true;
	var qualityCheckError = true;
	var descriptionError = true;

//////////////////////////////////////////////////////////////////////////////////////	
	
	
	





	// 3 event and function call
	// 1
	$("#orderCode").keyup(function() {
		// 5 call function
		validate_orderCode();
	});

	// 2
	$("#shipmentMode").change(function() {
		// 5 call function
		validate_shipmentMode();
	});

	// 3
	$("#whcode").change(function() {
		// 5 call function
		validate_vendor();
	});

	// 4
	$("#refrenceNumber").keyup(function() {
		// 5 call function
		validate_referenceNumber();
	});
	
	//5
	$("input[type='radio'][name='qualityCheck']").click(function() {
		// 5 call the function
		validate_qualityCheck();
	});
	
	$("#description").keyup(function() {
		// 5 call function
		validate_description();
	});

////////////////////////////////////////////////////////////////////////////////////////	
	
	// 4 function declaration
	// 1
	function validate_orderCode() {
		var val = $("#orderCode").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#orderCodeError").show();
			$("#orderCodeError").html("ORDER-CODE<b> shuld not be empty</b>");
			$("#orderCodeError").css("color", "red");
			orderCodeError = false;
		} else if (!exp.test(val)) {
			$("#orderCodeError").show();
			$("#orderCodeError").html("ORDER-CODE<b> shuld 2-8 only</b>");
			$("#orderCodeError").css("color", "green");
			orderCodeError = false;
		} else {
			$("#orderCodeError").hide();
			orderCodeError = true;
		}
		return orderCodeError;
	}

	// 2
	function validate_shipmentMode() {
		var val = $("#shipmentMode").val();
		if (val == '') {
			$("#shipmentModeError").show();
			$("#shipmentModeError").html("SHIPMENT MODE<b> select one</b>");
			$("#shipmentModeError").css("color", "red");
			shipmentModeError = false;
		} else {
			$("#shipmentModeError").hide();
			shipmentModeError = true;
		}
		return shipmentModeError;
	}

	// 3
	function validate_vendor() {
		var val = $("#whcode").val();
		if (val == '') {
			$("#vendorError").show();
			$("#vendorError").html("VENDOR <b> select one</b>");
			$("#vendorError").css("color", "red");
			vendorError = false;
		} else {
			$("#vendorError").hide();
			vendorError = true;
		}
		return vendorError;
	}

	// 4
	function validate_referenceNumber() {
		var val = $("#refrenceNumber").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		digits: true
		if (val == '') {
			$("#referenceNumberError").show();
			$("#referenceNumberError").html("REFERENCE NUMBER<b> shuld not be empty</b>");
			$("#referenceNumberError").css("color", "red");
			referenceNumberError = false;
		} else if (!exp.test(val)) {
			$("#referenceNumberError").show();
			$("#referenceNumberError").html("REFERENCE NUMBER<b> shuld 2-8 only</b>");
			$("#referenceNumberError").css("color", "green");
			referenceNumberError = false;
		} else {
			$("#referenceNumberError").hide();
			referenceNumberError = true;
		}
		return referenceNumberError;
	}
	
	//5
	function validate_qualityCheck() {
		// count the length in selected radio button
		var val = $("input[type='radio'][name='qualityCheck']:checked").length;
		if (val == 0) {
			$("#qualityCheckError").show();
			$("#qualityCheckError").html("QUALITY CHECK <b>Please choose one</b>");
			$("#qualityCheckError").css("color", "red");
			qualityCheckError = false;
		} else {
			$("#qualityCheckError").hide();
			qualityCheckError = true;
		}
		return qualityCheckError;
	}
	
	// 6
	function validate_description() {
		var val = $("#description").val();
		var exp = /^[A-Za-z0-9\s-_=(),./{}!@#$%^&*+~`:;"'|?<>]{8,50}$/;
		if (val == '') {
			$("#descriptionError").show();
			$("#descriptionError").html("DESCRIPTION<b> shuld not be empty</b>");
			$("#descriptionError").css("color", "red");
			descriptionError = false;
		} else if (!exp.test(val)) {
			$("#descriptionError").show();
			$("#descriptionError").html("DESCRIPTION<b> shuld 8-50 only</b>");
			$("#descriptionError").css("color", "green");
			descriptionError = false;
		} else {
			$("#descriptionError").hide();
			descriptionError = true;
		}
		return descriptionError;
	}

//////////////////////////////////////////////////////////////////////////////////////	
	
	//6 submit all validation again
	$("#purchaseForm").submit(function() {
		orderCodeError = true;
		shipmentModeError = true;
		vendorError = true;
		referenceNumberError = true;
		qualityCheckError = true;
		descriptionError = true;

		validate_orderCode();
		validate_shipmentMode();
		validate_vendor();
		validate_referenceNumber();
		validate_qualityCheck();
		validate_description();

		if (orderCodeError && shipmentModeError && vendorError
				&& referenceNumberError && qualityCheckError && descriptionError) {
			return true;
		} else {
			return false;
		}

	});

});


