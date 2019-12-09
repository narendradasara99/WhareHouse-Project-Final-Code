$(document).ready(function() {
	// 1 hide the error section
	$("#shippingCodeError").hide();
	$("#shippingRefNumberError").hide();
	$("#courierRefNumberError").hide();
	$("#contactDetailsError").hide();
	$("#saleOrderCodeError").hide();
	$("#descriptionError").hide();
	$("#billToAddressError").hide();
	$("#shipToAddressError").hide();

//////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 2 create boolean variable
	var shippingCodeError = true;
	var shippingRefNumberError = true;
	var courierRefNumberError = true;
	var contactDetailsError = true;
	var saleOrderCodeError = true;
	var descriptionError = true;
	var billToAddressError = true;
	var shipToAddressError = true;

////////////////////////////////////////////////////////////////////////////////////////////
	
	// 3 event and function call
	// 1
	$("#shippingCode").keyup(function() {
		// 5 call function
		validate_shippingCode();
	});

	// 2
	$("#shippingRefNum").keyup(function() {
		// 5 call function
		validate_shippingRefNumber();
	});
    
	// 3
	$("#corierRefNum").keyup(function() {
		// 5 call function
		validate_courierRefNumber();
	});
	
	//4
	$("#contactDetails").keyup(function() {
		// 5 call function
		validate_contactDetails();
	});
	
	
	//5
	$("#saleOrder").keyup(function() {
		// 5 call function
		validate_saleOrderCode();
	});

	
	//6
	$("#description").keyup(function() {
		// 5 call function
		validate_description();
	});
	
	//7
	$("#billToaddress").keyup(function() {
		// 5 call function
		validate_billToAddress();
	});
	
	//8
	$("#shipToAddress").keyup(function() {
		// 5 call function
		validate_shipToAddress();
	});

////////////////////////////////////////////////////////////////////////////////////////////	
	// 4 function declaration
	//1
	function validate_shippingCode() {
		var val = $("#shippingCode").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#shippingCodeError").show();
			$("#shippingCodeError").html("Shipping<b> shuld not be empty</b>");
			$("#shippingCodeError").css("color", "red");
			shippingCodeError = false;
		} else if (!exp.test(val)) {
			$("#shippingCodeError").show();
			$("#shippingCodeError").html("Shipping<b> shuld 2-8 only</b>");
			$("#shippingCodeError").css("color", "green");
			shippingCodeError = false;
		} else {
			$("#shippingCodeError").hide();
			shippingCodeError = true;
		}
		return shippingCodeError;
	}
	
	//2
	function validate_shippingRefNumber() {
		var val = $("#shippingRefNum").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#shippingRefNumberError").show();
			$("#shippingRefNumberError").html("Shipping Ref Number<b> shuld not be empty</b>");
			$("#shippingRefNumberError").css("color", "red");
			shippingRefNumberError = false;
		} else if (!exp.test(val)) {
			$("#shippingRefNumberError").show();
			$("#shippingRefNumberError").html("Shipping Ref Number<b> shuld 2-8 only</b>");
			$("#shippingRefNumberError").css("color", "green");
			shippingRefNumberError = false;
		} else {
			$("#shippingRefNumberError").hide();
			shippingRefNumberError = true;
		}
		return shippingRefNumberError;
	}
	
	

	//3
	function validate_courierRefNumber() {
		var val = $("#corierRefNum").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#courierRefNumberError").show();
			$("#courierRefNumberError").html("Courier Ref Number<b> shuld not be empty</b>");
			$("#courierRefNumberError").css("color", "red");
			courierRefNumberError = false;
		} else if (!exp.test(val)) {
			$("#courierRefNumberError").show();
			$("#courierRefNumberError").html("Courier Ref Number<b> shuld 2-8 only</b>");
			$("#courierRefNumberError").css("color", "green");
			courierRefNumberError = false;
		} else {
			$("#courierRefNumberError").hide();
			courierRefNumberError = true;
		}
		return courierRefNumberError;
	}
    
	//4
	function validate_contactDetails() {
		var val = $("#contactDetails").val();
		var exp = /^[A-Za-z0-9_-\s]{8,50}$/;
		if (val == '') {
			$("#contactDetailsError").show();
			$("#contactDetailsError").html("Contact Details<b> shuld not be empty</b>");
			$("#contactDetailsError").css("color", "red");
			contactDetailsError = false;
		} else if (!exp.test(val)) {
			$("#contactDetailsError").show();
			$("#contactDetailsError").html("Contact Details<b> shuld 2-8 only</b>");
			$("#contactDetailsError").css("color", "green");
			contactDetailsError = false;
		} else {
			$("#contactDetailsError").hide();
			contactDetailsError = true;
		}
		return contactDetailsError;
	}
    
	
	//5
	function validate_saleOrderCode() {
		var val = $("#saleOrder").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#saleOrderCodeError").show();
			$("#saleOrderCodeError").html("Sale Order Code<b> shuld not be empty</b>");
			$("#saleOrderCodeError").css("color", "red");
			saleOrderCodeError = false;
		} else if (!exp.test(val)) {
			$("#saleOrderCodeError").show();
			$("#saleOrderCodeError").html("Select one <b> Sale Order Code</b>");
			$("#saleOrderCodeError").css("color", "green");
			saleOrderCodeError = false;
		} else {
			$("#saleOrderCodeError").hide();
			saleOrderCodeError = true;
		}
		return saleOrderCodeError;
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
	
	// 7
	function validate_billToAddress() {
		var val = $("#billToaddress").val();
		var exp = /^[A-Za-z0-9\s-_=(),./{}!@#$%^&*+~`:;"'|?<>]{8,50}$/;
		if (val == '') {
			$("#billToAddressError").show();
			$("#billToAddressError").html("Bill to Address<b> shuld not be empty</b>");
			$("#billToAddressError").css("color", "red");
			billToAddressError = false;
		} else if (!exp.test(val)) {
			$("#billToAddressError").show();
			$("#billToAddressError").html("Bill to Address<b> shuld 8-50 only</b>");
			$("#billToAddressError").css("color", "green");
			billToAddressError = false;
		} else {
			$("#billToAddressError").hide();
			billToAddressError = true;
		}
		return billToAddressError;
	}
	
	// 8
	function validate_shipToAddress() {
		var val = $("#shipToAddress").val();
		var exp = /^[A-Za-z0-9\s-_=(),./{}!@#$%^&*+~`:;"'|?<>]{8,50}$/;
		if (val == '') {
			$("#shipToAddressError").show();
			$("#shipToAddressError").html("Ship to Address<b> shuld not be empty</b>");
			$("#shipToAddressError").css("color", "red");
			shipToAddressError = false;
		} else if (!exp.test(val)) {
			$("#shipToAddressError").show();
			$("#shipToAddressError").html("Ship to Address<b> shuld 8-50 only</b>");
			$("#shipToAddressError").css("color", "green");
			shipToAddressError = false;
		} else {
			$("#shipToAddressError").hide();
			shipToAddressError = true;
		}
		return shipToAddressError;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////	
	//6 submit all validation again
	$("#shippingForm").submit(function() {
		shippingCodeError = true;
		shippingRefNumberError = true;
		courierRefNumberError = true;
		contactDetailsError = true;
		saleOrderCodeError = true;
		descriptionError = true;
		billToAddressError = true;
		shipToAddressError = true;

		validate_shippingCode();
		validate_shippingRefNumber();
		validate_courierRefNumber();
		validate_contactDetails();
		validate_saleOrderCode();
		validate_description();
		validate_billToAddress();
		validate_shipToAddress();

		if (shippingCodeError && shippingRefNumberError
				&& courierRefNumberError  && contactDetailsError
				&& saleOrderCodeError && descriptionError 
				&& billToAddressError && shipToAddressError) {
			return true;
		} else {
			return false;
		}

	});

});