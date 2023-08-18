<%@page import="com.bean.StudentB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script type="text/javascript" src="js/validations.js"></script>
<title>Insert</title>
<style type="text/css">
tr,td
{
	padding:10px;
}
.error{
		
		color : red;
	}
</style>

</head>
<body>
<%
		String fnameError = (String) request.getAttribute("fnameError");
		String lnameError = (String) request.getAttribute("lnameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");
		String mobileError = (String) request.getAttribute("mobileError");
		String genderError = (String) request.getAttribute("genderError");
		
		
		String fnameValue = (String) request.getAttribute("fnameValue");
		String lnameValue = (String) request.getAttribute("lnameValue");
		String emailValue = (String) request.getAttribute("emailValue");
		String passwordValue = (String) request.getAttribute("passwordValue");
		String mobileValue = (String) request.getAttribute("mobileValue");
		String genderValue = (String) request.getAttribute("genderValue");
		
		if(request.getAttribute("msg")!=null)
		{
			out.println(request.getAttribute("msg"));
		}
		StudentB s=(StudentB)request.getAttribute("s");
		
%>
<form name="insert" method="post" action="StudentController" onsubmit="return validate()">
<table>
	<tr>
		<td><input type="hidden" name="id" value="<%=s.getId()%>"></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="fname" value="<%=fnameValue==null? "" :fnameValue %>"/></td>
		<td><span class="error"><%=fnameError==null?"":fnameError%></span></td>	
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lname" value="<%=lnameValue==null? "" :lnameValue %>" /></td>
		<td><span class="error"><%=lnameError==null?"":lnameError%></span></td>	
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email" value="<%=emailValue==null? "" :emailValue %>" /></td>
		<td><span class="error"><%=emailError==null?"":emailError%></span></td>	
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password" value="<%=passwordValue==null? "" :passwordValue %>" /></td>
		<td><span class="error"><%=passwordError==null?"":passwordError%></span></td>	
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type="text" name="mobile" value="<%=mobileValue==null? "" :mobileValue %>" /></td>
		<td><span class="error"><%=mobileError==null?"":mobileError%></span></td>	
	</tr>
	<tr>
		<td>Gender</td>
		<td>
			<input type="radio" name="gender" value="Male" <%=genderValue!=null&&genderValue.equals("male")? "checked" : "" %> />Male
			<input type="radio" name="gender" value="Female" <%=genderValue!=null&&genderValue.equals("female")? "checked" : "" %>/>Female
			<span class="error"><%=genderError == null ? "" : genderError %></span>	
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" name="action" value="Update" class="btn btn-primary">
		</td>
	</tr>
</table>
</form>

</body>
</html>