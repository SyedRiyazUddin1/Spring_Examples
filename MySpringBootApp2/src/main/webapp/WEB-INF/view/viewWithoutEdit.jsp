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
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product's Description</th>



		</tr>
		<c:forEach var="product" items="${list}">

			<tr>
				<td>{product.id }</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<br />
	<br />
	<a href="/login">Login to your Admin account to
		Edit/Add products in the inventory</a>


</body>
</html>