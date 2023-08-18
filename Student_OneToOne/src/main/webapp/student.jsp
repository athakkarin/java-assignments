<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<form name="address" method="post" action="StudentController">
	<table>
		<tr>
			<td>Student Name</td>
			<td><input type="text" name="studentName"></td>
		</tr>
		<tr>
			<td>Street</td>
			<td><input type="text" name="street"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type="text" name="state"></td>
		</tr>
		<tr>
			<td>Zip-Code</td>
			<td><input type="text" name="zipcode"></td>
		</tr>
		<tr>
			<td colspan="2" align="Center">
				<input type="submit" name="action" value="Insert STUD">
			</td>
		</tr>
	</table>
</form>
</body>
</html>