
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%> 
      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"  type="css/text"  href="/WebMvcJdbc/URLToReachResourcesFolder/Resources/CSS/my-style-sheet.css">
</head>
<body>
<h1 align="center">DETAILS ABOUT THE STUDENTS ARE:</h1>
<div  align="center">
<form  action= "/WebMvcJdbc/show">
<input type="submit"  value="ADD">
</form>
<table border="4">
<thead>
<tr>
   <th>ID</th>
    <th>NAME</th>
    <th>MOBILE</th>
     <th>COUNTRY</th>
 </tr>

<c:forEach  var="user" items="${userinfo}">
<tr>
    <td>  ${user.id} </td><br/>
    <td>  ${user.name}  </td> <br/>
    <td>  ${user.mobile} </td><br/>
    <td>  ${user.country}  </td><br/>
    <td><a  href="/WebMvcJdbc/updatestudent?userId=${user.id}">update</a>  </td><br/>
    <td><a  href="/WebMvcJdbc/deletestudent?userId=${user.id}">delete</a>  </td><br/>
 </tr>
   
</c:forEach>

</table>
</div>
</body>
</html>
