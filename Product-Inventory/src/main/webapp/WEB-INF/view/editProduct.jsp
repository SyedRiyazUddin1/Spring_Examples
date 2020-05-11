<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Edit Product details</h1>
	<form:form method="GET" action="/Product-Inventory/editProduct">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="productId" /></td>
			</tr>
			
			
			
			<tr>
				<td>Product Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Product Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Product Company :</td>
				<td><form:input path="productCompany" /></td>
			</tr>

			</tr>
			<tr>
				<td>Country Name :</td>
				<td><form:input path="countryName" /></td>
			</tr>

			</tr>
			<tr>
				<td>Features :</td>
				<td><form:input path="features" /></td>
			</tr>

			</tr>
			<tr>
				<td>Final Price :</td>
				<td><form:input path="finalPrice" /></td>

			</tr>
			
			<tr>
				<td></td>

				<td><input type="submit" value="Update Details" /></td>
			</tr>

			<tr>
				<td><a
					href="deleteProduct/${product.productId}">${product.productId}</a></td>
			</tr>
			
				
		</table>

		<br />
		<a href="/Product-Inventory/index.jsp"> <-- Go back to HomePage</a>

	</form:form>




</body>
</html>