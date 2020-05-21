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

<br /> <a href="/Product-Inventory/index.jsp">   <-- Go back to HomePage</a> 
		

	<h1>Your product is added successfully !!</h1>

	<h2>The details of your product are :</h2>

	<br /> Product Name : ${userReg.name}
	<br /> Product ID : ${userReg.id}
	<br /> Product Description : ${userReg.description}

	<br />
	

</body>
</html>