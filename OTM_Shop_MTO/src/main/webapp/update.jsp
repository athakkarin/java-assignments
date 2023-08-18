<%@page import="com.bean.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
	Item i=(Item)request.getAttribute("i");
%>
<form name="item" method="post" action="CartController">
	<table>
		<tr>
			<td><input type="hidden" name="itemId" value="<%=i.getItemId()%>"></td>
		</tr>
		<tr>
			<td>Item Id</td>
			<td><input type="text" name="itemId"></td>
		</tr>
		<tr>
			<td>Item Total</td>
			<td><input type="text" name="itemTotal"></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="text" name="quantity"></td>
		</tr>
		<tr>
			<td>Cart Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Cart Total</td>
			<td><input type="text" name="total"></td>
		</tr>
		<tr>
			<td colspan="2" align="Center">
				<input type="submit" name="action" value="Update">
			</td>
		</tr>
	</table>
</form>

</body>
</html>