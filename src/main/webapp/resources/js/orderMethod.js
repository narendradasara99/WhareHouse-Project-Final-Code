$(document).ready(function(){
	//hide error section
	$("#orderCodeError").hide();
	$("#orderTypeError").hide();
	$("#descriptionError").hide();
	$("#orderModeError").hide();
	$("#orderAcceptError").hide();
	//**********************

	//flag variables
	var orderCodeError = true;
	var orderTypeError = true;
	var descriptionError = true;
	var orderModeError = true;
	var orderAcceptError = true;
	//-----------------------


	//event calls
	$("#orderCode").keyup(function(){
		var val = $("#orderCode").val();
		$("#orderCode").val(val.toUpperCase());
		validate_orderCode();
	}); 

	$("#orderType").change(function(){
		validate_orderType();
	});

	$("#description").keyup(function(){
		validate_description();
	});

	$('input[type="radio"][name="orderMode"]').click(function(){
		validate_orderMode();
	});
	$('input[type="checkbox"][name="orderAccept"]').click(function(){
		validate_orderAccept();
	});
	//++++++++++++++++++++++++++++++



	// function codes
	function validate_orderCode(){
		var val = $("#orderCode").val();
		var exp=/^[A-Z]{2,8}$/;
		if(val==''){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Order Code can not be empty");
			$("#orderCodeError").css("color","red");
			orderCodeError = false;
		}else if(!exp.test(val)){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Order Code Must be 2-8 Chars!");
			$("#orderCodeError").css("color","red");
			orderCodeError = false;
		} else{
			$("#orderCodeError").hide();
			orderCodeError = true;
		}
		return orderCodeError;
	}

	function validate_orderType(){
		var val = $("#orderType").val();
		if(val==''){
			$("#orderTypeError").show();
			$("#orderTypeError").html("Please Choose one option");
			$("#orderTypeError").css("color","red");
			orderTypeError = false;
		}else{
			$("#orderTypeError").hide();
			orderTypeError = true;
		}
		return orderTypeError;
	}
	function validate_description(){
		var val =  $("#description").val();
		if(val==''){
			$("#descriptionError").show();
			$("#descriptionError").html("Enter Few Characters!");
			$("#descriptionError").css("color","red");
			descriptionError = false;
		}else{
			$("#descriptionError").hide();
			descriptionError = true;
		}
		return descriptionError;

	}

	function validate_orderMode(){
		var val =  $('input[type="radio"][name="orderMode"]:checked').length;
		if(val == 0){
			$("#orderModeError").show();
			$("#orderModeError").html("Please Choose one option");
			$("#orderModeError").css("color","red");
			orderModeError = false;
		}else{
			$("#orderModeError").hide();
			orderModeError = true;
		}
		return orderModeError;

	}

	function validate_orderAccept(){
		var val = $('input[type="checkbox"][name="orderAccept"]:checked').length;
		if(val==0){
			$("#orderAcceptError").show();
			$("#orderAcceptError").html("Please choose at least one option");
			$("#orderAcceptError").css("color","red");
			orderAcceptError = false;
		}else{
			$("#orderAcceptError").hide();
			orderAcceptError = true;
		}
		return orderAcceptError;
	}
	//-/--/-/-/-/-/-/-/-/-/-/-/-/-/-



	//on submit
	$("#orderForm").submit(function(){

		//call all validate function
		validate_orderCode();
		validate_orderType();
		validate_description();
		validate_orderMode();
		validate_orderAccept();

		if(
				orderCodeError 
				&& orderTypeError 
				&& descriptionError
				&& orderModeError
				&& orderAcceptError
		){
			return true;
		}
		return false;
	});
});

