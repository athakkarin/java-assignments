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

		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");
		
		
		String emailValue = (String) request.getAttribute("emailValue");
		String passwordValue = (String) request.getAttribute("passwordValue");
		
		
%>
<form name="login" method="post" action="StudentCntlr" >
<table>
	
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
		<td colspan="2" align="center">
			<input type="submit" name="action" value="Login">
		</td>
	</tr>
</table>
</form>


</body>
</html>