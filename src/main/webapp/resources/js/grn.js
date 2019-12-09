$(document).ready(
		function() {
			// 1 hide the error section
			$("#grnCodeError").hide();
			$("#grnTypeError").hide();
			$("#grnModeError").hide();
			$("#descriptionError").hide();
			
			

/**************************************************************************************/
			
			// 2 create boolean variable
			var grnCodeError = true;
			var grnTypeError = true;
			var grnModeError = true;
			var descriptionError = true;

/*			************************************************************************************				
*/			// 3 event function call
			// 1
			$("#code").keyup(function() {
				// 5 call the function
				validate_grnCode();
			});

			// 2
			$("#grnType").keyup(function() {
				// 5 call the function
				validate_grnType();
			});

			// 3 select
			$("#purchase").change(function() {
				// 5 call the function
				validate_grnMode();
			});

			// 4
			$("#note").keyup(function() {
				// call the function
				validate_description();
			});

/*			************************************************************************************			
*/			// 4 create the function
			//1
			function validate_grnCode() {
				var val = $("#code").val();
				var exp = /^[A-Za-z0-9-_]{2,8}$/;
				if (val == '') {
					$("#grnCodeError").show();
					$("#grnCodeError").html(
							"GRN-CODE<b> shuld not be empty</b>");
					$("#grnCodeError").css("color", "red");
					grnCodeError = false;
				} else if (!exp.test(val)) {
					$("#grnCodeError").show();
					$("#grnCodeError").html(
							"GRN-CODE<b> shuld 2-8 char only</b>");
					$("#grnCodeError").css("color", "green");
					grnCodeError = false;
				} else {
					$("#grnCodeError").hide();
					grnCodeError = true;
				}
				return grnCodeError;
			}

			// 2
			function validate_grnType() {
				var val = $("#grnType").val();
				var exp = /^[A-Za-z0-9\s-_]{2,8}$/;
				if (val == '') {
					$("#grnTypeError").show();
					$("#grnTypeError").html(
							"GRN-TYPE<b> shuld not be empty</b>");
					$("#grnTypeError").css("color", "red");
					grnTypeError = false;
				} else if (!exp.test(val)) {
					$("#grnTypeError").show();
					$("#grnTypeError").html(
							"GRN-TYPE<b> shuld 2-8 char only</b>");
					$("#grnTypeError").css("color", "green");
					grnTypeError = false;
				} else {
					$("#grnTypeError").hide();
					grnTypeError = true;
				}
				return grnTypeError;
			}

			// 3 select
			function validate_grnMode() {
				var val = $("#purchase").val();
				if (val == '') {
					$("#grnModeError").show();
					$("#grnModeError").html(
							"GRN-MODE<b> please select one </b>");
					$("#grnModeError").css("color", "red");
					grnModeError = false;
				} else {
					$("#grnModeError").hide();
					grnModeError = true;
				}
				return grnModeError;
			}

			// 4
			function validate_description() {
				var val = $("#note").val();
				var exp = /^[A-Za-z0-9\s-_=(),./{}!@#$%^&*+~`:;"'|?<>]{8,50}$/;
				if (val == '') {
					$("#descriptionError").show();
					$("#descriptionError").html(
							"DESCRIPTION<b> shuld not be empty</b>");
					$("#descriptionError").css("color", "red");
					descriptionError = false;
				} else if (!exp.test(val)) {
					$("#descriptionError").show();
					$("#descriptionError").html(
							"DESCRIPTION<b> shuld 8-50 char only</b>");
					$("#descriptionError").css("color", "red");
					descriptionError = false;
				} else {
					$("#descriptionError").hide();
					descriptionError = true;
				}
				return descriptionError;
			}

/*			************************************************************************************			
*/			//6 submit form validation input again
			$("#grnForm").submit(
					function() {
						grnCodeError = true;
						grnTypeError = true;
						grnModeError = true;
						descriptionError = true;

						validate_grnCode();
						validate_grnType();
						validate_grnMode();
						validate_description();

						if (grnCodeError && grnTypeError && grnModeError
								&& descriptionError) {
							return true;
						} else {
							return false;
						}
					});

		});