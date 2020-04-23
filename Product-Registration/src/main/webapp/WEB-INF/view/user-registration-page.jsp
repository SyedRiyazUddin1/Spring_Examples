<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 align="center">Please register your product here</h1>
	<hr>

	<form:form action="registration-success" method="GET" modelAttribute="userReg">
	
	<div align="center">

		<label>Product Name</label>
		<form:input path="productName" />
		
		<br/>
		
		<label>Product price</label>
		<form:input path="price" />

		<br />

		<label>Manufacturer Name</label>
		<form:input path="productCompany" />


		<br />

		<label>Manufacturer's Country : </label>
		<form:select path="countryName">
			<form:option value="Ind" label="India"></form:option>
			<form:option value="Usa" label="United State"></form:option>
			<form:option value="Pak" label="Pakistan"></form:option>
			<form:option value="Sl" label="Srilanka"></form:option>
		</form:select>

		<br />

		<label>Product's Features : </label>
		2gb ram : <form:checkbox path="features" value="2gb ram" />
		4gb ram : <form:checkbox path="features" value="4gb ram" />
	6gb ram : <form:checkbox path="features" value="6gb ram" />
		8gb ram : <form:checkbox path="features" value="8gb ram" />
		
		<br />
		
		
		<input type="submit" value="register">
		
		</div>
		
		


	</form:form>






</body>
</html>