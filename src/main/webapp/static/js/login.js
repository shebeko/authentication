function validate_form() {
	var login = $("input[name=login]").val();
	var password = $("input[name=password]").val();
	var isValid = _checkField("login", login);
	isValid = _checkField("password", password) && isValid;	
	if (!isValid) {
		$("#validationMessage").html('* Fields are required');
		$("#serverValidationMessage").remove();
	}
	return isValid;	
}

function _checkField(fieldName, fieldValue) {
	
	if (($.trim(fieldValue) === '')){
		$("span[name="+fieldName+"]").html("*");
		return false;
	} else {
		$("span[name="+fieldName+"]").html("");
		return true;
	}
}
