<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		StudentBean s = (StudentBean) request.getAttribute("s");
	%>
	<h2>User Detail</h2>
	UserId:
	<%=s.getId()%><br> FirstName:
	<%=s.getFname()%><br>LastName:<%=s.getLname()%><br>
	 Email:<%=s.getEmail()%>
	<br>Mobile:<%=s.getMobile()%>
	<br>Password:<%=s.getPassword()%><br>
	Gender:<%=s.getGender()%>
</body>
</html>