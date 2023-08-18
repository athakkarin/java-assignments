<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="cart" method="post" action="CartController">
	<table>
	<tr>
	<td>Select Cart</td>
			<td>
				<select name=cart>
					<option>-----Cart-----</option>
					<% 
						List<Cart> list=CartDao.getAllCart();    
						for(Cart c:list)
						{
					%>
							<option value="<%=c.getCartId()%>"><%=c.getName() %></option>
					<%		
						}
					%>
				</select>
			</td>
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
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert Item">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>