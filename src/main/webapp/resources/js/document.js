$(document).ready(
		function() {
			// 1. hide error section
			$("#fIdError").hide();

			/************************************************************************************	*/	

			// 2.create variables
			var fIdError = true;
	

			/************************************************************************************	*/				
			// 3. link event with input
			//1
			$("#fid").keyup(function() {
				// 5. call function
				validate_fId();
			});
			
		

			/************************************************************************************	*/				
			// 4. Define Validate Function
			//2
			function validate_fId() {
				var val = $("#fid").val();
				var exp = /^[A-Za-z0-9\s]{2,8}$/;
				if (val == '') {
					$("#fIdError").show();
					$("#fIdError").html("File Id <b>can not be empty</b>");
					$("#fIdError").css("color", "red");

					fIdError = false;
				} else if (!exp.test(val)) {
					$("#fIdError").show();
					$("#fIdError").html("File Id <b>must be 2-8 chars or numbers only!!</b>");
					$("#fIdError").css("color", "green");

					fIdError = false;
				} else {
					$("#fIdError").hide();

					fIdError = true;
				}
				return fIdError;
			}

			

			/************************************************************************************	*/				
			//6 on form submit call all validations
			$("#documentForm").submit(function() {
				fIdError = true;
				
				// true means valid, false means invalid
				validate_fId();
				

				if (fIdError) {
					return true;
				}
				return false;
			});
		});