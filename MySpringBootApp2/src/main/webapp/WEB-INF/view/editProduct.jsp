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
	<form:form method="GET" action="/myapp/editProduct">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			
			<tr>
				<td>Product Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Product Description :</td>
				<td><form:input path="description" /></td>
			</tr>
			
			
			<tr>
				<td></td>

				<td><input type="submit" value="Update Details" /></td>
			</tr>

			
				
		</table>


	</form:form>




</body>
</html>