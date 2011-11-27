<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car List</title>
</head>
<body>
	<h1>Car List</h1>
	
	<c:forEach items="${carList}" var="car">
		${car.brand.name} ${car.model}: ${car.price }
		<br />
	</c:forEach>
	
</body>
</html>