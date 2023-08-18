<%@page import="com.bean.Address"%>
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
	Address a=(Address)request.getAttribute("a");
%>
<form name="address" method="post" action="StudentController">
	<table>
		<tr>
			<td><input type="hidden" name="addressId" value="<%=a.getAddressId()%>"></td>
		</tr>
		<tr>
			<td>Student Name</td>
			<td><input type="text" name="studentName" value="<%=a.getStudent().getStudentName()%>"></td>
		</tr>
		<tr>
			<td>Street</td>
			<td><input type="text" name="street" value="<%=a.getStreet()%>"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type="text" name="city" value="<%=a.getCity()%>"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type="text" name="state" value="<%=a.getState()%>"></td>
		</tr>
		<tr>
			<td>Zip Code</td>
			<td><input type="text" name="zipcode" value="<%=a.getZipcode()%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="Center">
				<input type="submit" name="action" value="Update STUD">
			</td>
		</tr>
	</table>
</form>

</body>
</html>