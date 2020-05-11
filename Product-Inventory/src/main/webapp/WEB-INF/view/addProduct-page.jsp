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


	<h1 align="center">Please add your product here</h1>
	<hr>
 
	<form:form action="registration-success" method="post" modelAttribute="userReg">
	
	<div align="center">

		<label> Product Name :</label>
		<form:input path="productName" />
		<form:errors path="productName"/>
		
		
		<br/>
		
		<label>Product ID</label>
		<form:input path="productId" />

		<br />
		
		<label>Product price</label>
		<form:input path="price" />

		<br />
		
		

		<label>Manufacturer Name</label>
		<form:input path="productCompany" />


		<br />

		<label>Manufacturer's Country : </label>
		<form:select path="countryName">
			<form:option value="India" label="India"></form:option>
			<form:option value="USA" label="United State"></form:option>
			<form:option value="Pakistan" label="Pakistan"></form:option>
			<form:option value="Srilanka" label="Srilanka"></form:option>
		</form:select>

		<br />

		<label>Product's Features : </label>
		<form:radiobutton path="features" value="2gb ram" />2gb ram
		<form:radiobutton path="features" value="4gb ram" />4gb ram
	    <form:radiobutton path="features" value="6gb ram" />6gb ram
		<form:radiobutton path="features" value="8gb ram" />8gb ram
		
		<br />
		<br />
		<input type="submit" value="Add Product">
		
		</div>
	
	<br /> <a href="/Product-Inventory/index.jsp">   <-- Go back to HomePage</a> 
	
		
		


	</form:form>


	



</body>
</html>