<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Your product is registered successfully !!</h1>

	<h2>The details of your product are :</h2>

	<br /> Product Name : ${userReg.productName}
	<br /> Product price : ${userReg.price}
	<br /> Product Company : ${userReg.productCompany}
	<br /> Country Name : ${userReg.countryName}
	<br /> Features : ${userReg.features}


</body>
</html>