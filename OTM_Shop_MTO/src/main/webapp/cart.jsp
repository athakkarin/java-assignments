<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form name="cart" method="post" action="CartController">
	<table>
		<tr>
			<td>Cart Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Cart Total</td>
			<td><input type="text" name="total"></td>
		</tr>
		<tr>   
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert Cart">
			</td>
		</tr>
	</table>
</form>
</body>
</html>