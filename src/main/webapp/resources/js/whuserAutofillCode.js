$(document).ready(function() {
		$('input[type="radio"][name="whuserType"]').click(function(){
			var val=$('input[type="radio"][name="whuserType"]:checked').val();
			if(val=='Vendor'){
				$("#whuserFor").val('Purchase');
			}else if(val=='Customer'){
			$("#whuserFor").val('Sale');
		}
		
	});
		
		$("#whuserIdType").change(function(){
			var val =$("#whuserIdType").val();
				if(val=='OTHER'){
					$("whuserIdOther").removeAttr("readonly");
				}
				else{
					$("#whuserIdOther").attr("readonly","false");
					$("#whuserIdOther").val(' ');
				}
});
});