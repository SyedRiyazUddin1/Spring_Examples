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

	<h1>Products List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Product Name</th>
			<th>Product ID</th>
			<th>Product price</th>
			<th>Product Company</th>
			<th>Country Name</th>
			<th>Features</th>
			<th>Product Final price</th>

		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.productName}</td>
				<td>${product.productId}</td>
				<td>${product.price}</td>
				<td>${product.productCompany}</td>
				<td>${product.countryName}</td>
				<td>${product.features}</td>
				<td>${product.finalPrice}</td>
				
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>
