<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      
   </head>
   <body>
                  		<%
                  			if(request.getAttribute("msg")!=null)
                  			{
                  				out.println(request.getAttribute("msg"));
                  			}
                  		%>
                     <form action="UserController" method="post">
                        <fieldset>
                           <input type="text" name="email" value="<%=request.getAttribute("email")%>">
                           <input type="text" name="otp" value="<%=request.getAttribute("otp1")%>">
                           <input type="text" placeholder="Enter OTP" name="uotp" required />
                           <input type="submit" name="action" value="Verify OTP"/>       
                        </fieldset>
                     </form>
   </body>
</html>