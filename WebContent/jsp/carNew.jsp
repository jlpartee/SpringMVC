<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
 
<head>
  <title>New Sponsor</title>
  <style>
    .error {
    	color: red;
    }
  </style>  
</head>
 
<body>
	<h1>New Car</h1>
 
	<form:form method="post">
 
		Brand<br />
		<form:select path="brand">
		   <form:options items="${brandList}" itemLabel="name" itemValue="id" />
		</form:select>
		<br /><br />
 
		Model <form:errors path="model" cssClass="error"/><br />
		<form:input path="model"/><br /><br />
 
		Price <form:errors path="price" cssClass="error"/><br />
		<form:input path="price"/><br /><br />
 
		<input type="submit" value="Submit">
 
	</form:form>
</body>
</html>