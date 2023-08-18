<%@page import="com.dao.SubscriptionDao"%>
<%@page import="com.bean.Subscription"%>
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
	<form name="subscription" method="post" action="SubscriptionController">
	<table>
	<tr>
	<td>Select Subscription</td>
			<td>
				<select name=subscription>
					<option>-----Subscription-----</option>
					<%
						List<Subscription> list=SubscriptionDao.getAllSubscription();
						for(Subscription s:list)
						{
					%>
							<option value="<%=s.getSubscriptionId()%>"><%=s.getSubscriptionName() %></option>
					<%		
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td>Reader Id</td>
			<td><input type="text" name="readerId"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert Reader">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>