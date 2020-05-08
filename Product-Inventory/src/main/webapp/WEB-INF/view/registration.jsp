<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Welcome to Registration Page</h3>

	<form action="register" method="get">
		<pre>
	    <strong>Register Here | <a href="login">Click here to Login</a></strong>
		
		User Id: <input type="text" name="userId" />
		
		Password: <input type="password" name="password" />
	
		<input type="submit" value="Register" />
	</pre>
	</form>

	${msg}
</body>
</html>