$(document).ready(function(){
            //1. hide error section
            $("#uomTypeError").hide();
            $("#uomModelError").hide();
            $("#descriptionError").hide();

            //2.create variables
            var uomTypeError = true;
            var uomModelError = true;
            var descriptionError = true;

            //3. link event with input
            $("#uomType").change(function(){
                //5. call function
                validate_uomType();
            });
            $("#uomModel").keyup(function(){
                //-start-convert data to upper case
                var val=$("#uomModel").val();
                $("#uomModel").val(val.toUpperCase());
                //--end--
                validate_uomModel();
            });
            $("#description").keyup(function(){
                //5. call function
                validate_description();
            });

            //4. Define Validate Function
            function validate_uomType(){
                var val=$("#uomType").val();
                if(val==''){
                    $("#uomTypeError").show();
                    $("#uomTypeError").html("Please Choose <b>one option</b>");
                    $("#uomTypeError").css("color","red");

                    uomTypeError = false;
                }else{
                    $("#uomTypeError").hide();

                    uomTypeError = true;
                }
                return uomTypeError;
            }

            function validate_uomModel(){
                var val = $("#uomModel").val();
                var exp=/^[A-Z]{2,8}$/;
                if(val==''){
                    $("#uomModelError").show();
                    $("#uomModelError").html("Model <b>can not be empty</b>");
                    $("#uomModelError").css("color","red");

                    uomModelError = false;
                }
                else if(!exp.test(val)){
                    $("#uomModelError").show();
                    $("#uomModelError").html("Model <b>must be 2-8 chars only!!</b>");
                    $("#uomModelError").css("color","red");

                    uomModelError = false;
                }else{
                    $("#uomModelError").hide();

                    uomModelError = true;
                }
                return uomModelError;
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

            //on form submit call all validations
            $("#myForm").submit(function(){
                uomTypeError = true;
                uomModelError = true;
                descriptionError = true;
                //true means valid, false means invalid
                validate_uomType();
                validate_uomModel();
                validate_description();

                if(uomTypeError && uomModelError && descriptionError){
                    return true;
                }
                return false;
            });
        });
