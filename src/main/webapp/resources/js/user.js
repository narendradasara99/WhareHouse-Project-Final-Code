$(document).ready(function(){
	//1. hide error section
	$("#userNameError").hide();
	$("#userPwdError").hide();
	//2.create variables
	var userNameError = true;
	var userPwdError = true;

	//3. link event with input
	$("#userName").keyup(function(){
		//5. call function
		validate_userName();
	});

	$("#userPwd").keyup(function(){
		//5. call function
		validate_userPwd();
	});

	//4. Define Validate Function
	function validate_userName(){
		var val = $("#userName").val();
		var exp=/^[A-Z]{2,16}$/;
		if(val==''){
			$("#userNameError").show();
			$("#userNameError").html("User <b>can not be empty</b>");
			$("#userNameError").css("color","red");

			userNameError = false;
		}
		else if(!exp.test(val)){
			$("#userNameError").show();
			$("#userNameError").html("User <b>must be 5-20 chars only!!</b>");
			$("#userNameError").css("color","red");

			userNameError = false;
		}else{
			$("#userNameError").hide();

			userNameError = true;
		}

		return userNameError;
	}



	function validate_userPwd(){
		var val = $("#userPwd").val();
		var exp=/^[A-Z]{2,16}$/;
		if(val==''){
			$("#userPwdError").show();
			$("#userPwdError").html("Password <b>can not be empty</b>");
			$("#userPwdError").css("color","red");

			userPwdError = false;
		}
		else if(!exp.test(val)){
			$("#userPwdError").show();
			$("#userPwdError").html("Password <b>must be 5-16 chars only!!</b>");
			$("#userPwdError").css("color","red");

			userPwdError=false;
		}else{

			$("#userPwdError").hide();

			userPwdError=true;
		}

		return userPwdError;
	}

	//on form submit call all validations
	$("#userForm1").submit(function(){
		userNameError = true;
		userPwdError = true;
		//true means valid, false means invalid
		validate_userName();
		validate_userPwd();

		if(userNameError && userPwdError){
			return true;
		}
		return false;
	});
});
