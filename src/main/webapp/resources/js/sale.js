$(document).ready(function() {
	// 1 hide the error section
	$("#orderCodeError").hide();
	$("#shipmentModeError").hide();
	$("#customerError").hide();
	$("#refNumberError").hide();
	$("#stockModeError").hide();
	$("#stockSourceError").hide();
	$("#descriptionError").hide();

////////////////////////////////////////////////////////////////////////////////////////	
	
	// 2 create boolean variable
	var orderCodeError = true;
	var shipmentModeError = true;
	var customerError = true;
	var refNumberError = true;
	var stockModeError = true;
	var stockSourceError = true;
	var descriptionError = true;

////////////////////////////////////////////////////////////////////////////	
	
	

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
		validate_customer();
	});

	// 4
	$("#refNumber").keyup(function() {
		// 5 call function
		validate_refNumber();
	});
	
	//5
	$("input[type='radio'][name='stockMode']").click(function() {
		// 5 call the function
		validate_stockMode();
	});
	
	// 6
	$("#stockSource").change(function() {
		// 5 call function
		validate_stockSource();
	});
	
	
	//7
	$("#description").keyup(function() {
		// 5 call function
		validate_description();
	});

///////////////////////////////////////////////////////////////////////////////////
	
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
	function validate_customer() {
		var val = $("#whcode").val();
		if (val == '') {
			$("#customerError").show();
			$("#customerError").html("CUSTOMER <b> select one</b>");
			$("#customerError").css("color", "red");
			customerError = false;
		} else {
			$("#customerError").hide();
			customerError = true;
		}
		return customerError;
	}

	// 4
	function validate_refNumber() {
		var val = $("#refNumber").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#refNumberError").show();
			$("#refNumberError").html("REFERENCE NUMBER<b> shuld not be empty</b>");
			$("#refNumberError").css("color", "red");
			refNumberError = false;
		} else if (!exp.test(val)) {
			$("#refNumberError").show();
			$("#refNumberError").html("REFERENCE NUMBER<b> shuld 2-8 only</b>");
			$("#refNumberError").css("color", "green");
			refNumberError = false;
		} else {
			$("#refNumberError").hide();
			refNumberError = true;
		}
		return refNumberError;
	}
	
	//5
	function validate_stockMode() {
		// count the length in selected radio button
		var val = $("input[type='radio'][name='stockMode']:checked").length;
		if (val == 0) {
			$("#stockModeError").show();
			$("#stockModeError").html("STOCK MODE <b>Please choose one</b>");
			$("#stockModeError").css("color", "red");
			stockModeError = false;
		} else {
			$("#stockModeError").hide();
			stockModeError = true;
		}
		return stockModeError;
	}
	
	
	// 6
	function validate_stockSource() {
		var val = $("#stockSource").val();
		if (val == '') {
			$("#stockSourceError").show();
			$("#stockSourceError").html("STOCK SOURCE <b> select one</b>");
			$("#stockSourceError").css("color", "red");
			stockSourceError = false;
		} else {
			$("#stockSourceError").hide();
			stockSourceError = true;
		}
		return stockSourceError;
	}
	
	
	// 7
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

////////////////////////////////////////////////////////////////////////////////////////	
	
	//6 submit all validation again
	$("#saleForm").submit(function() {
		orderCodeError = true;
		shipmentModeError = true;
		customerError = true;
		refNumberError = true;
		stockModeError = true;
		stockSourceError = true;
		descriptionError = true;

		validate_orderCode();
		validate_shipmentMode();
		validate_customer();
		validate_refNumber();
		validate_stockMode();
		validate_stockSource();
		validate_description();

		if (orderCodeError && shipmentModeError && customerError
				&& refNumberError && stockModeError && stockSourceError && descriptionError) {
			return true;
		} else {
			return false;
		}

	});

});