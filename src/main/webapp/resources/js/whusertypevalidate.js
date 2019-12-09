$(document).ready(function(){
            //1. hide error section
            $("#whuserCodeError").hide();
            $("#whuserContact").hide();
             $("#whuserIdTypeError").hide();
           	 
           	 //*********************************************

            //2.create flag variables
            var whuserCodeError = true;
            var whuserContactError = true;
            var whuserIdTypeError = true;
           
            //**************************************************

            //3. link event with input
            $("#whuserCode").keyup(function(){
            	//-start-convert data to upper case
                var val=$("#whuserCode").val();
                $("#whuserCode").val(val.toUpperCase());
                //--end--
             //5. call function
                validate_whuserCode();
            });
            
            $("#whuserContact").keyup(function(){
                
                 //5. call function
                validate_whuserContact();
            });
            
           
            $("#whuserIdType").change(function(){
                //5. call function
                validate_whuserIdType();
            });
            
			
			

            
			//****************************************************
            //4. Define Validate Function
            function validate_whuserIdType(){
                var val=$("#whuserIdType").val();
                if(val==''){
                    $("#whuserIdTypeError").show();
                    $("#whuserIdTypeError").html("Please Choose <b>one option</b>");
                    $("#whuserIdTypeError").css("color","red");

                    whuserIdTypeError = false;
                }else{
                    $("#whuserIdTypeError").hide();

                    whuserIdTypeError = true;
                }
                return whuserIdTypeError;
            }
            
            function validate_whuserCode(){
                var val = $("#whuserCode").val();
                var exp=/^[A-Z]{2,8}$/;
                if(val==''){
                    $("#whuserCodeError").show();
                    $("#whuserCodeError").html("Model <b>can not be empty</b>");
                    $("#whuserCodeError").css("color","red");

                    whuserCodeError = false;
                }
                else if(!exp.test(val)){
                    $("#whuserCodeError").show();
                    $("#whuserCodeError").html("Model <b>must be 2-8 chars only!!</b>");
                    $("#whuserCodeError").css("color","red");

                    whuserCodeError = false;
                }else{
                    $("#whuserCodeError").hide();

                    whuserCodeError = true;
                }
                return whuserCodeError;
            }
            
           
                     	
            function validate_whuserContact(){
                var val = $("#whuserContact").val();
                var exp=/^[0-9]$/;
                if(val==''){
                    $("#whuserContactError").show();
                    $("#whuserContactError").html("contact <b>can not be empty</b>");
                    $("#whuserContactError").css("color","red");

                    whuserContactError = false;
                }
                else if(!exp.test(val)){
                    $("#whuserContactError").show();
                    $("#whuserContactError").html("contact  <b>must 0-9 Number!!</b>");
                    $("#whuserContactError").css("color","red");

                    descriptionError = false;
                }else{
                    $("#whuserContactError").hide();

                    whuserContactError = true;
                }
                return whuserContactError;
            }



		

            
        //***************************************************
            //on form submit call all validations
            $("#myForm").submit(function(){
            	whuserCodeError = true;
            	whuserContactError = true;
            	whuserIdTypeError = true;
                //true means valid, false means invalid
                validate_whuserCodeError();
                validate_whuserContactError();
                validate_whuserIdTypeError();
                

                if(whuserCodeError && whuserContactError && whuserIdTypeError){
                    return true;
                }
                return false;
            });
        });
