$(document).ready(function() {
	// 1 hide the error section
	$("#codeError").hide();
	$("#widthError").hide();
	$("#lengthError").hide();
	$("#heigthError").hide();
	$("#basecostError").hide();
	$("#baseCurrencyError").hide();
	$("#uomError").hide();
	$("#orderMethodError").hide();
	$("#descriptionError").hide();

/*************************************************************************************	*/
	// 2 create boolean variable
	var codeError = true;
	var widthError = true;
	var lengthError = true;
	var heigthError = true;
	var basecostError = true;
	var baseCurrencyError = true;
	var uomError = true;
	var orderMethodError = true;
	var descriptionError = true;

	
	

	/*************************************************************************************	*/
	
	// 3 event and function call
	// 1
	$("#code").keyup(function() {
		// 5 call function
		validate_code();
	});
     
	//2
	$("#width").keyup(function() {
		// 5 call function
		validate_width();
	});
	
	//3
	$("#length").keyup(function() {
		// 5 call function
		validate_length();
	});
	
	//4
	$("#heigth").keyup(function() {
		// 5 call function
		validate_heigth();
	});
	
	//5
	$("#baseCost").keyup(function() {
		// 5 call function
		validate_basecost();
	});

	// 6
	$("#baseCurrency").change(function() {
		// 5 call function
		validate_baseCurrency();
	});

	// 7
	$("#uom").change(function() {
		// 5 call function
		validate_uom();
	});
	
	
	// 8
	$("#ordermethodSale").change(function() {
		// 5 call function
		validate_orderMethod();
	});
	
	
	// 9
	$("#omPurchase").change(function() {
		// 5 call function
		validate_orderMethod();
	});
	
	// 10
	$("#description").keyup(function() {
		// 5 call function
		validate_description();
	});

	/*************************************************************************************	*/
	
	// 4 function declaration
	// 1
	function validate_code() {
		var val = $("#code").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#codeError").show();
			$("#codeError").html("CODE<b> shuld not be empty</b>");
			$("#codeError").css("color", "red");
			codeError = false;
		} else if (!exp.test(val)) {
			$("#codeError").show();
			$("#codeError").html("CODE<b> shuld 2-8 only</b>");
			$("#codeError").css("color", "green");
			codeError = false;
		} else {
			$("#codeError").hide();
			codeError = true;
		}
		return codeError;
	}
    
	//2
	function validate_length() {
		var val = $("#length").val();
		var exp = /^[0-9]{1,8}$/;
		if (val == '') {
			$("#lengthError").show();
			$("#lengthError").html("LENGTH<b> shuld not be empty</b>");
			$("#lengthError").css("color", "red");
			lengthError = false;
		} else if (!exp.test(val)) {
			$("#lengthError").show();
			$("#lengthError").html("LENGTH<b> shuld 1-9 Number only</b>");
			$("#lengthError").css("color", "green");
			lengthError = false;
		} else {
			$("#lengthError").hide();
			lengthError = true;
		}
		return lengthError;
	}
	
	//3
	function validate_width() {
		var val = $("#width").val();
		var exp = /^[0-9]{1,8}$/;
		if (val == '') {
			$("#widthError").show();
			$("#widthError").html("WIDTH<b> shuld not be empty</b>");
			$("#widthError").css("color", "red");
			widthError = false;
		} else if (!exp.test(val)) {
			$("#widthError").show();
			$("#widthError").html("WIDTH<b> shuld 1-9 Number only</b>");
			$("#widthError").css("color", "green");
			widthError = false;
		} else {
			$("#widthError").hide();
			widthError = true;
		}
		return widthError;
	}
	
	//4
	function validate_heigth() {
		var val = $("#heigth").val();
		var exp = /^[0-9]{1,8}$/;
		if (val == '') {
			$("#heigthError").show();
			$("#heigthError").html("HEIGTH<b> shuld not be empty</b>");
			$("#heigthError").css("color", "red");
			heigthError = false;
		} else if (!exp.test(val)) {
			$("#heigthError").show();
			$("#heigthError").html("HEIGTH<b> shuld 1-9 Number only</b>");
			$("#heigthError").css("color", "green");
			heigthError = false;
		} else {
			$("#heigthError").hide();
			heigthError = true;
		}
		return heigthError;
	}
	
	
	//5
	function validate_basecost() {
		var val = $("#baseCost").val();
		var exp = /^[0-9]{2,9}$/;
		if (val == '') {
			$("#basecostError").show();
			$("#basecostError").html("Base Cost<b> shuld not be empty</b>");
			$("#basecostError").css("color", "red");
			basecostError = false;
		} else if (!exp.test(val)) {
			$("#basecostError").show();
			$("#basecostError").html("Base Cost<b> shuld 0-9 Number only</b>");
			$("#basecostError").css("color", "green");
			basecostError = false;
		} else {
			$("#basecostError").hide();
			basecostError = true;
		}
		return basecostError;
	}
	
	// 6
	function validate_baseCurrency() {
		var val = $("#baseCurrency").val();
		if (val == '') {
			$("#baseCurrencyError").show();
			$("#baseCurrencyError").html("Base Currency<b> select one</b>");
			$("#baseCurrencyError").css("color", "red");
			baseCurrencyError = false;
		} else {
			$("#baseCurrencyError").hide();
			baseCurrencyError = true;
		}
		return baseCurrencyError;
	}

	// 7
	function validate_uom() {
		var val = $("#uom.id").val();
		if (val == '') {
			$("#uomError").show();
			$("#uomError").html("UOM <b> select one</b>");
			$("#uomError").css("color", "red");
			uomError = false;
		} else {
			$("#uomError").hide();
			uomError = true;
		}
		return uomError;
	}
    
	// 8
	function validate_orderMethod() {
		var val = $("#ordermethodSale.id").val();
		if (val == '') {
			$("#orderMethodError").show();
			$("#orderMethodError").html("Order Method <b> select one</b>");
			$("#orderMethodError").css("color", "red");
			orderMethodError = false;
		} else {
			$("#orderMethodError").hide();
			orderMethodError = true;
		}
		return orderMethodError;
	}
	
	
	// 9
	function validate_orderMethod() {
		var val = $("#omPurchase.id").val();
		if (val == '') {
			$("#orderMethodError").show();
			$("#orderMethodError").html("Order Method <b> select one</b>");
			$("#orderMethodError").css("color", "red");
			orderMethodError = false;
		} else {
			$("#orderMethodError").hide();
			orderMethodError = true;
		}
		return orderMethodError;
	}

	
	// 10
	function validate_description() {
		var val = $("#description").val();
		var exp = /^[A-Za-z0-9\s-_=(),./{}!@#$%^&*+~`:;"'|?<>]{8,50}$/;
		if (val == '') {
			$("#descriptionError").show();
			$("#descriptionError").html("Description<b> shuld not be empty</b>");
			$("#descriptionError").css("color", "red");
			descriptionError = false;
		} else if (!exp.test(val)) {
			$("#descriptionError").show();
			$("#descriptionError").html("Description<b> shuld 2-8 only</b>");
			$("#descriptionError").css("color", "green");
			descriptionError = false;
		} else {
			$("#descriptionError").hide();
			descriptionError = true;
		}
		return descriptionError;
	}
	
	/*************************************************************************************	*/
	
	//6 submit all validation again
	$("#partForm").submit(function() {
		codeError = true;
		widthError = true;
		lengthError = true;
		heigthError = true;
		basecostError = true;
		baseCurrencyError = true;
		uomError = true;
		orderMethodError = true;
		descriptionError = true;

		validate_code();
		validate_width();
		validate_length();
		validate_heigth();
		validate_basecost();
		validate_baseCurrency();
		validate_uom();
		validate_orderMethod();
		validate_description();

		if (codeError && widthError && lengthError
				&& heigthError && basecostError && 
				baseCurrencyError && uomError && orderMethodError && descriptionError) {
			return true;
		} else {
			return false;
		}

	});

});