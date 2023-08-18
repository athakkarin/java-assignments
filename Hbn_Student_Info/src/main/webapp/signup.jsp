<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
tr, td {
	padding: 10px;
}

.error {
	color: red;
}
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<div class="container">
		<div class="row text-center" style="color: tomato;">
			<h2>User Registration with JSP, Servlet and Hibernate</h2>
		</div>
		<hr>
		<div class="row col-md-10 col-md-offset-3">

			<div class="card card-body">

				<h2>Student Register Form</h2>
				<div class="col-md-8 col-md-offset-3">
					<%
					String fnameError = (String) request.getAttribute("fnameError");
					String lnameError = (String) request.getAttribute("lnameError");
					String emailError = (String) request.getAttribute("emailError");
					String mobileError = (String) request.getAttribute("mobileError");
					String passwordError = (String) request.getAttribute("passwordError");
					String genderError = (String) request.getAttribute("genderError");

					String fnameValue = (String) request.getAttribute("fnameValue");
					String lnameValue = (String) request.getAttribute("lnameValue");
					String emailValue = (String) request.getAttribute("emailValue");
					String mobileValue = (String) request.getAttribute("mobileValue");
					String passwordValue = (String) request.getAttribute("passwordValue");
					String genderValue = (String) request.getAttribute("genderValue");
					%>

					<form name="frm" method="post" action="StudentCntlr">

						<table cellpadding="10px" cellspacing="10px">
							<tr>
								<td>First Name</td>
								<td><input type="text" name="fname"
									value="<%=fnameValue == null ? "" : fnameValue%>" /></td>
								<td><span class="error"><%=fnameError == null ? "" : fnameError%></span></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lname"
									value="<%=lnameValue == null ? "" : lnameValue%>" /></td>
								<td><span class="error"><%=lnameError == null ? "" : lnameError%></span></td>
							</tr>

							<tr>
								<td>Email</td>
								<td><input type="text" name="email"
									value="<%=emailValue == null ? "" : emailValue%>" /></td>
								<td><span class="error"><%=emailError == null ? "" : emailError%></span></td>
							</tr>
							<tr>
								<td>Mobile</td>
								<td><input type="text" name="mobile"
									value="<%=mobileValue == null ? "" : mobileValue%>" /></td>
								<td><span class="error"><%=mobileError == null ? "" : mobileError%></span></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="text" name="password"
									value="<%=passwordValue == null ? "" : passwordValue%>" /></td>
								<td><span class="error"><%=passwordError == null ? "" : passwordError%></span></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><input type="radio" name="gender" value="Male"
									<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />Male
									<input type="radio" name="gender" value="Female"
									<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />Female
									<span class="error"><%=genderError == null ? "" : genderError%></span>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									name="action" value="Signup" class="btn btn-primary"></td>
							</tr>
						</table>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>