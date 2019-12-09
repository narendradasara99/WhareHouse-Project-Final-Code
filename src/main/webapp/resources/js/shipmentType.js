$(document).ready(function(){
            //1. hide error section
            $("#shipmentTypeModeError").hide();
            $("#shipmentTypeCodeError").hide();
             $("#enableShipmentTypeError").hide();
           	 $("#descriptionError").hide();
			$("#shipmentTypeGradeError").hide();
           	 //*********************************************

            //2.create flag variables
            var shipmentTypeModeError = true;
            var shipmentTypeCodeError = true;
            var enableShipmentTypeError = true;
            var descriptionError = true;
			var shipmentTypeGrade = true;
            //**************************************************

            //3. link event with input
            $("#shipmentTypeMode").change(function(){
             //5. call function
                validate_shipmentTypeMode();
            });
            
            $("#shipmentTypeCode").keyup(function(){
                //-start-convert data to upper case
                var val=$("#shipmentTypeCode").val();
                $("#shipmentTypeCode").val(val.toUpperCase());
                //--end--
                 //5. call function
                validate_shipmentTypeCode();
            });
           
            $("#enableShipmentType").change(function(){
                //5. call function
                validate_enableShipmentType();
            });
            
            $("#description").keyup(function(){
                //5. call function
                validate_description();
            });
			
			
				$('input[type="radio"][name="shipmentTypeGrade"]').click(function(){
		validate_shipmentTypeGrade();
	});


            
			//****************************************************
            //4. Define Validate Function
            function validate_shipmentTypeMode(){
                var val=$("#shipmentTypeMode").val();
                if(val==''){
                    $("#shipmentTypeModeError").show();
                    $("#shipmentTypeModeError").html("Please Choose <b>one option</b>");
                    $("#shipmentTypeModeError").css("color","red");

                    shipmentTypeModeError = false;
                }else{
                    $("#shipmentTypeModeError").hide();

                    shipmentTypeModeError = true;
                }
                return shipmentTypeModeError;
            }
            function validate_shipmentTypeCode(){
                var val = $("#shipmentTypeCode").val();
                var exp=/^[A-Z]{2,8}$/;
                if(val==''){
                    $("#shipmentTypeCodeError").show();
                    $("#shipmentTypeCodeError").html("Model <b>can not be empty</b>");
                    $("#shipmentTypeCodeError").css("color","red");

                    shipmentTypeCodeError = false;
                }
                else if(!exp.test(val)){
                    $("#shipmentTypeCodeError").show();
                    $("#shipmentTypeCodeError").html("Model <b>must be 2-8 chars only!!</b>");
                    $("#shipmentTypeCodeError").css("color","red");

                    shipmentTypeCodeError = false;
                }else{
                    $("#shipmentTypeCodeError").hide();

                    shipmentTypeCodeError = true;
                }
                return shipmentTypeCodeError;
            }
            
            function validate_enableShipmentType(){
                var val=$("#enableShipmentType").val();
                if(val==''){
                    $("#enableShipmentTypeError").show();
                    $("#enableShipmentTypeError").html("Please Choose <b>one option</b>");
                    $("#enableShipmentTypeError").css("color","red");

                    enableShipmentTypeError = false;
                }else{
                    $("#enableShipmentTypeError").hide();

                    enableShipmentTypeError = true;
                }
                return enableShipmentTypeError;
            }
                     	
            function validate_description(){
                var val = $("#description").val();
                var exp=/^[A-Za-z0-9\s]{10,50}$/;
                if(val==''){
                    $("#descriptionError").show();
                    $("#descriptionError").html("Description <b>can not be empty</b>");
                    $("#descriptionError").css("color","red");

                    descriptionError = false;
                }
                else if(!exp.test(val)){
                    $("#descriptionError").show();
                    $("#descriptionError").html("Description <b>must be 10-50 chars only!!</b>");
                    $("#descriptionError").css("color","red");

                    descriptionError = false;
                }else{
                    $("#descriptionError").hide();

                    descriptionError = true;
                }
                return descriptionError;
            }



		function validate_shipmentTypeGrade(){
		var val =  $('input[type="radio"][name="shipmentTypeGrade"]:checked').length;
		if(val == 0){
			$("#shipmentTypeGradeError").show();
			$("#shipmentTypeGradeError").html("Please Choose one option");
			$("#shipmentTypeGradeError").css("color","red");
			shipmentTypeGradeError = false;
		}else{
			$("#shipmentTypeGradeError").hide();
			shipmentTypeGradeError = true;
		}
		return shipmentTypeGradeError;

	}

            
        //***************************************************
            //on form submit call all validations
            $("#myForm").submit(function(){
                shipmentTypeModeError = true;
                shipmentTypeCodeError = true;
                enableShipmentTypeError = true;
                descriptionError = true;
				shipmentTypeGradeError = true;
                //true means valid, false means invalid
                validate_shipmentTypeCode
                validate_shipmentTypeMode();
                validate_enableShipmentType();
                validate_description();
				validate_shipmentTypeGrade();

                if(
					shipmentTypeModeError
					 && shipmentTypeCodeError 
					&& enableShipmentTypeError
 					&& descriptionError 
					&& shipmentTypeGradeError){
                    return true;
                }
                return false;
            });
        });
