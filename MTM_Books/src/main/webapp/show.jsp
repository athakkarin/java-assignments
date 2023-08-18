<%@page import="com.dao.SubscriptionDao"%>
<%@page import="com.bean.Reader"%>
<%@page import="java.util.List"%>
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
%>
<table border="5" width="100%">
	<tr>
		<th>ITEMID</th>
		<th>ITEMTOTAL</th>
		<th>QUANTITY</th>
		<th>CARTID</th>
		<th>NAME</th>
		<th>TOTAL</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	<%
		List<Reader> list=SubscriptionDao.getAllReader();
		for(Reader r:list) 
		{
	%>
	<tr>
		<td><%=r.getReaderId() %></td>
		<td><%=r.getFirstName() %></td>
		<td><%=r.getLastName() %></td> 
		<td><%=r.getEmail() %></td>
		<td><%=r.getSubscription().getClass() %></td>
		<td>
			<form name="edit" method="post" action="CartController">
				<input type="hidden" name="readerId" value="<%=r.getReaderId()%>">
				<input type="submit" name="action" value="EDIT" class="btn btn-primary">
			</form>
		</td>
		<td>
			<form name="delete" method="post" action="CartController">
				<input type="hidden" name="readerId" value="<%=r.getReaderId()%>">
				<input type="submit" name="action" value="DELETE" class="btn btn-danger">
			</form>
		</td>
	</tr>
	<%		
		}
	%>
</table>
<a href="Student.jsp">Add New Employee</a>
</body>
</html>