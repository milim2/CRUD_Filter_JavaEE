<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>List All</title>
</head>

<body>
         <table>
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Province</th>
				<th>Postal Code</th>
				<th>GPA</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.studentid}" /></td>
					<td><c:out value="${student.fname}" /></td>
					<td><c:out value="${student.lname}" /></td>
					<td><c:out value="${student.city}" /></td>
					<td><c:out value="${student.province}" /></td>
					<td><c:out value="${student.postalcode}" /></td>
					<td><c:out value="${student.gpa}" /></td>
					<td><a
						href="StudentController?action=edit&studentId=<c:out value="${student.studentid }"/>">Update</a></td>
					<td><a
						href="StudentController?action=delete&studentId=<c:out value="${student.studentid }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="StudentController?action=insert">Add Student</a>
	</p>
</body>
</html>