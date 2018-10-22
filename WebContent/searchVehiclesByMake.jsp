<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Search for Students within a given City</title>
</head>
<body>
<form action="StudentController" method="get">
<fieldset>
<div>
	<label for="city">City</label>
	<input type="text" name="city" />
	<input type="hidden" name="action" value="searchstudentsbycity" />
</div>
<div>
	<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>