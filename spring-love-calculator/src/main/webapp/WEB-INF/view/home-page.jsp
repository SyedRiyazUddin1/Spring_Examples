<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr/>


<!-- the below spring mvc form is binded to userInfo -->

<form:form action="process-homepage" method="get" modelAttribute="userInfo">
<div align="center">
<p>
<label for="yn" >Your Name :</label>
<form:input  id= "yn" path="userName"/>
</p>

<p>
<label for="cn" >Crush Name :</label>
<form:input id= "cn" path="crushName"/>
</p>

<input type="submit" value="calculate">
</div>
</form:form>


</body>
</html>