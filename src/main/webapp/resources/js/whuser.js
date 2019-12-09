$(document).ready(function() {
	// 1 hide the error section
	$("#utypeError").hide();
	$("#ucodeError").hide();
	$("#uemailError").hide();
	$("#ucontactError").hide();
	$("#uidtypeError").hide();
	//$("#ifotherError").hide();
	$("#idnoError").hide();
	

/************************************************************	
*/	// 2 create boolean variable
	var utypeError = true;
	var ucodeError = true;
	var uemailError = true;
	var ucontactError = true;
	var uidtypeError = true;
	//var ifotherError = true;
	var idnoError = true;
	
	
	
/*	************************************************************************		
*/	// 3 event and function call
	// 1
	$("input[type='radio'][name='whuserType']").click(function() {
		// 5 call the function
		validate_utype();
	});

	// 2
	$("#whuserCode").keyup(function() {
		// 5 call function
		validate_ucode();
	});
    
	// 3
	$("#whuserEmail").keyup(function() {
		// 5 call function
		validate_uemail();
	});
	
	//4
	$("#whuserContact").keyup(function() {
		// 5 call function
		validate_ucontact();
	});
	
	
	//5
	$("#whuserIdType").change(function() {
		// 5. call function
		validate_uidtype();
	});

	/*
	//6
	$("#ifother").keyup(function() {
		// 5 call function
		validate_ifother();
	});*/
	
	//7
	$("#whuserIdNumber").keyup(function() {
		// 5 call function
		validate_idno();
	});


/*************************************************************************	*/
	// 4 function declaration
	//1
	function validate_utype() {
		// count the length in selected radio button
		var val = $("input[type='radio'][name='whuserType']:checked").length;
		if (val == 0) {
			$("#utypeError").show();
			$("#utypeError").html("WH-USER <b>Please choose one</b>");
			$("#utypeError").css("color", "red");
			utypeError = false;
		} else {
			$("#utypeError").hide();
			utypeError = true;
		}
		return utypeError;
	}
	
/*	************************************************************************	
*/	//2
	function validate_ucode() {
		var val = $("#whuserCode").val();
		var exp = /^[A-Za-z0-9_-]{2,8}$/;
		if (val == '') {
			$("#ucodeError").show();
			$("#ucodeError").html("WH-User Code<b> shuld not be empty</b>");
			$("#ucodeError").css("color", "red");
			ucodeError = false;
		} else if (!exp.test(val)) {
			$("#ucodeError").show();
			$("#ucodeError").html("WH-User Code<b> shuld 2-8 only</b>");
			$("#ucodeError").css("color", "green");
			ucodeError = false;
		} else {
			$("#ucodeError").hide();
			ucodeError = true;
		}
		return ucodeError;
	}
	
/*	************************************************************************	
*/
	//3
	function validate_uemail() {
		var val = $("#whuserEmail").val();
		var exp = /^[A-Za-z0-9_-=(),./{}!@#$%^&*+~`:;"'|?<>]{4,50}$/;
		if (val == '') {
			$("#uemailError").show();
			$("#uemailError").html("WH-USER EMAIL<b> shuld not be empty</b>");
			$("#uemailError").css("color", "red");
			uemailError = false;
		} else if (!exp.test(val)) {
			$("#uemailError").show();
			$("#uemailError").html("WH-USER EMAIL<b> shuld 4-50 only</b>");
			$("#uemailError").css("color", "green");
			uemailError = false;
		} else {
			$("#uemailError").hide();
			uemailError = true;
		}
		return uemailError;
	}
/*	************************************************************************	
*/	//4
	function validate_ucontact() {
		var val = $("#whuserContact").val();
		var exp = /^[0-9]{6,15}$/;
		if (val == '') {
			$("#ucontactError").show();
			$("#ucontactError").html("WH-USER Contact<b> shuld not be empty</b>");
			$("#ucontactError").css("color", "red");
			ucontactError = false;
		} else if (!exp.test(val)) {
			$("#ucontactError").show();
			$("#ucontactError").html("WH-USER Contact<b> shuld 6-15 only</b>");
			$("#ucontactError").css("color", "green");
			ucontactError = false;
		} else {
			$("#ucontactError").hide();
			ucontactError = true;
		}
		return ucontactError;
	}
    
/*	************************************************************************	
*/	//5
	function validate_uidtype() {
		var val = $("#whuserIdType").val();
		if (val == '') {
			$("#uidtypeError").show();
			$("#uidtypeError").html("Please Choose <b>one option</b>");
			$("#uidtypeError").css("color", "red");

			uidtypeError = false;
		} else {
			$("#uidtypeError").hide();

			uidtypeError = true;
		}
		return uidtypeError;
	}
	
	/*//6
	function validate_ifother() {
		var val = $("#ifother").val();
		var exp = /^[A-Za-z0-9]{2,8}$/;
		if (val == '') {
			$("#ifotherError").show();
			$("#ifotherError").html("IF Other<b> shuld not be empty</b>");
			$("#ifotherError").css("color", "red");
			ifotherError = false;
		} else if (!exp.test(val)) {
			$("#ifotherError").show();
			$("#ifotherError").html("IF Other<b> shuld 2-8 only</b>");
			$("#ifotherError").css("color", "green");
			ifotherError = false;
		} else {
			$("#ifotherError").hide();
			ifotherError = true;
		}
		return ifotherError;
	}*/

/*	************************************************************************	
*/	// 7
	function validate_idno() {
		var val = $("#whuserIdNumber").val();
		var exp = /^[A-Za-z0-9_-]{2,20}$/;
		if (val == '') {
			$("#idnoError").show();
			$("#idnoError").html("ID NUMBER<b> shuld not be empty</b>");
			$("#idnoError").css("color", "red");
			idnoError = false;
		} else if (!exp.test(val)) {
			$("#idnoError").show();
			$("#idnoError").html("ID NUMBER<b> shuld 2-20 only</b>");
			$("#idnoError").css("color", "green");
			idnoError = false;
		} else {
			$("#idnoError").hide();
			idnoError = true;
		}
		return idnoError;
	}
	
/*************************************************************************
*///6 submit all validation again
	$("#whuserForm").submit(function() {
		utypeError = true;
		ucodeError = true;
		uemailError = true;
		ucontactError = true;
		uidtypeError = true;
		//ifotherError = true;
		idnoError = true;

		validate_utype();
		validate_ucode();
		validate_uemail();
		validate_ucontact();
		validate_uidtype();
		//validate_ifother();
		validate_idno();

		if (utypeError 
				&& ucodeError
				&& uemailError 
				&& ucontactError
				&& uidtypeError 
				&& idnoError) {
			return true;
		} else {
			return false;
		}

	});

	
/*	************************************************************************			
*/	
});