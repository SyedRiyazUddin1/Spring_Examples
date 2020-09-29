<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="header.jsp"%>
<center>


	<!DOCTYPE html>
	<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">My CAFE</h1>
	<hr>

	<form action="processOrder">
		<div align="center">
			<label for="item_name">Item Name :</label> <input type="text"
				name="foodType" placeholder="food type ??" id="item_name"> <input
				type="submit" value="order now">
		</div>
	</form>
	<br><br><br>
	<a href="academicLibrary/headFirstBook">link to get
		Java Brains book</a>
	
<br><br><br><br><br><br><br><br><br><br>

</body>
	</html>
	
</center>
<%@ include file="footer.jsp"%>

