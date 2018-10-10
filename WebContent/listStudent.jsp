<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Data </title>
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
<td><c:out value="${student.firstname}" /></td>
<td><c:out value="${student.lastname}" /></td>
<td><c:out value="${student.city}" /></td>
<td><c:out value="${student.province}" /></td>
<td><c:out value="${student.postalcode}" /></td>
<td><c:out value="${student.gpa}" /></td>
<td> <a
href="StudentController?action=edit&studentId=<c:out value="${student.studentId}" />">Update</a></td>
<td> <a
href="StudentController?action=delete&studentId=<c:out value="${student.studentId}" />">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>

<p>
<a href="StudentController?action=insert">Add </a>
<a href="search.jsp">Search </a>
</p>
</body>
</html>