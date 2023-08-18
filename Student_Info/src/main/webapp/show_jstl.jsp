<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%> 
<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>  
<head>  
<title>sql:query Tag</title>  
</head>  
<body>  
   
<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3307/ajava_assign"  
     user="root"  password=""/>  
  
<sql:query dataSource="${conn}" var="rs">  
SELECT * from Student;  
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
		<th>FIRST NAME</th>
		<th>LAST NAME</th>
		<th>EMAIL</th>
		<th>PASSWORD</th>
		<th>MOBILE</th>
		<th>GENDER</th> 
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.fname}"/></td>  
<td><c:out value="${table.lname}"/></td>  
<td><c:out value="${table.email}"/></td>  
<td><c:out value="${table.password}"/></td>
<td><c:out value="${table.mobile}"/></td>
<td><c:out value="${table.gender}"/></td>  
</tr>  
</c:forEach>  
</table>  
  
</body>  
</html>  