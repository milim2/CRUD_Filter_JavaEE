<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All</title>
</head>

<body>

     <form action="listStudentInProgram" method="post">
          <table>
          		 <tr>
                    <td><span> <font>${student.studentID}</font></span></td>
               </tr>
          		
          
               <tr>
                    <td><span> <font>${student.fname}</font></span></td>
               </tr>

               <tr>
                    <td><span><font>${student.lname}</font></span></td>
               </tr>

               <tr>
                    <td><span><font>${student.city}</font></span></td>
               </tr>

               <tr>
                    <td><span><font>${student.postalcode}</font></span></td>
               </tr>
               
               <tr>
                    <td><span><font>${student.gpa}</font></span></td>
               </tr>
                              
          </table>
     </form>
</body>
</html>
