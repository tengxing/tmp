$(function(){
	var str;
	$("#all_application_of_testing input[type=text]").focus(function(){
		str=$(this).val();
		$(this).val("");
	});
	$("#all_application_of_testing input[type=text]").blur(function(){
		if($(this).val()==""){
			$(this).val(str);
		}
	});
});