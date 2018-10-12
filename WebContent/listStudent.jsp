<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Student data </title>

<style>
table, th, td {
     border: 1px solid black;
     border-collapse: collapse;
}

th, td {
     padding: 5px;
     text-align: left;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<h2 align="center">All Student's Information</h2>
<table align="center">
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
<td><c:out value="${student.studentID}" /></td>
<td><c:out value="${student.fname}" /></td>
<td><c:out value="${student.lname}" /></td>
<td><c:out value="${student.city}" /></td>
<td><c:out value="${student.province}" /></td>
<td><c:out value="${student.postalcode}" /></td>
<td><c:out value="${student.gpa}" /></td>
<td> <a
href="StudentController?action=edit&studentID=<c:out value="${student.studentID}" />">Update</a></td>
<td> <a
href="StudentController?action=delete&studentID=<c:out value="${student.studentID}" />">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>

<p align="center">
<a href="StudentController?action=insert">To Add Student  </a>
<a href="search.jsp">Search </a>
</p>
</body>
</html>