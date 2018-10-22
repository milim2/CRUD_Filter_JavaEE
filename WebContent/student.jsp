<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">

<title>Add New Student</title>
</head>
<body>
	<form action="StudentController" method="post">
		<fieldset>
			<!-- <div>
				<label for="studentID">Student ID</label>
					<input type="text" name="studentID" 
						value="<c:out value="${student.studentID }" />" readonly="readonly" />
			</div>
			
			<div> -->
				<label for="fname">First Name</label>
					<input type="text" name="fname" 
						value="<c:out value="${student.fname }" />"  />
			</div>
			
			<div>
				<label for="lname">Last Name</label>
					<input type="text" name="lname" 
						value="<c:out value="${student.lname }" />"  />
			</div>
			
			<div>
				<label for="city">City</label>
					<input type="text" name="city" 
						value="<c:out value="${student.city }" />" />
			</div>
			
			<div>
				<label for="province">Province</label>
					<input type="text" name="province" 
						value="<c:out value="${student.province }" />"  />
			</div>
			
			<div>
				<label for="postalcode">Postal Code</label>
					<input type="text" name="postalcode" 
						value="<c:out value="${student.postalcode }" />"  />
			</div>
			
			<div>
				<label for="gpa">GPA</label>
					<input type="text" name="gpa" 
						value="<c:out value="${student.gpa }" />" />
			</div>
			
			<div>
				<input type="submit" value="Submit" />
			</div>
						
		</fieldset>	
	</form>
</body>
</html>