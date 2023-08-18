<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
tr,td
{
	padding:10px;
}
</style>
</head>
<body>
<%
	if(request.getAttribute("msg")!=null)
	{
		out.println(request.getAttribute("msg"));
	}
%>
<form name="signup" method="post" action="UserController">
<select name="usertype">
	<option>---Select User Type---</option>
    <option value="user">User</option>
    <option value="admin">Admin</option>
</select>
<table>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName" required />
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName" required />
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email" required />
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type="text" name="mobile" required />
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password" required />
	</tr>
	<tr>
		<td>Gender</td>
		<td>
			<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female	
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" name="action" value="Insert" class="btn btn-primary">
		</td>
	</tr>
</table>
</form>
<a href="show.jsp">Show All Student</a>
</body>
</html>