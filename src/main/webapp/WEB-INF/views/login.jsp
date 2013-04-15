<%@include file="/WEB-INF/views/includes.jsp"%>
<!doctype html>
<html>
<head>
	<title>Login page</title>
	<meta charset="utf-8">
	<script src="resources/static/js/jquery-1.9.1.js"></script>
	<script src="resources/static/js/login.js"></script>
	<link rel="stylesheet" href="resources/static/css/styles.css">
</head>
<body>
<div id="main">
	<c:if test="${exception ne null}">
	    <div id="serverValidationMessage" class="error">
	        ${exception.message}
	    </div>
	</c:if> 
	<div class="error">
		<span id="validationMessage"></span>
	</div>
	<form name="authenticationForm" method="post" action="<c:url value='/' />" onsubmit="return validate_form ( );">
		<table class="formTable">
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" value="" maxlength="10" size="10"/><span name="login" class="error"></span></td>
			</tr>
			<tr>	
				<td>Password</td>
				<td><input type="password" name="password" value="" maxlength="10" size="10"/><span name="password" class="error"></span></td>
			</tr>
			<tr>
				<td>
					Language
				</td>
				<td>
					<select  name="language">
						<option value="">--</option>
						<option value="en">en</option>
						<option value="by">by</option>
						<option value="ru" >ru</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="Log in" />	
</form>
</div>
</body>
</html>
