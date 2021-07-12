

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
        <h1  align="center">ADD STUDENT</h1>
	<form:form  action="save-student" modelAttribute="student"  method="post">
	<form:hidden path="id"/>
	
	<label for="name1">NAME: </label>
	<form:input path="name"  id="name1"/><br/><br/>
	
	<label for="mobile1">MOBILE: </label>
	<form:input path="mobile"  id="mobile1"/><br/><br/>
	
	
	<label for="country1">COUNTRY: </label>
	<form:input path="country"  id="country1"/><br/><br/>
	
	<input  type="submit"  value="ADD">
        </form:form>
	</div>

 </body>
</html>
